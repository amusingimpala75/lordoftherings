package com.github.amusingimpala75.lotr.resources;

import com.github.amusingimpala75.lotr.Lotr;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Pair;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class LotrThrowawayResource implements Runnable {
    public static String[] deletions = {
            "lotr-transformer-general.js",
            "META-INF",
            "lotr/common",
            "lotr/client",
            "data",
            "blockstates/gold_treasure_pile.json",
            "blockstates/silver_treasure_pile.json",
            "blockstates/copper_treasure_pile.json",
            "blockstates/candle.json",
            "pack.mcmeta"
    };
    public static List<Pair<String, String>> movers = new ArrayList<>();
    static {
        movers.add(new Pair<>("assets/lotr/textures/models/armor", "assets/minecraft/textures/models/armor"));
        movers.add(new Pair<>("assets/minecraft/textures/entity/signs/lotr","assets/minecraft/textures/entity/signs"));
    }
    public static List<Pair<String, String>> renames = new ArrayList<>();
    static {
        renames.add(new Pair<>("renewed_logo.png", "pack.png"));
    }
    public static File RESOURCE_FILE = null;

    @Override
    public void run() {
        System.out.println("Acquiring LotR resources from Official Mod!");
        File mainDir = FabricLoader.getInstance().getGameDir().toFile();
        File outputDir = new File(mainDir, ".lotrResources");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }
        File[] mods = (new File(mainDir, "mods")).listFiles();

        //Obtain official mod
        File officialMod = null;
        if (mods != null) {
            for (File mod : mods) {
                if (mod.isDirectory()) {
                    continue;
                }
                if (officialMod != null) {
                    continue;
                }
                System.out.println(mod.getName());
                System.out.println(mod.getAbsolutePath());
                if (/*"jar".equals(FilenameUtils.getExtension(mod.getName()))*/mod.getName().contains(".jar")) {
                    if (mod.getName().contains("lotr-1.15-renewed") && !mod.getName().contains("FABRIC") && mod.getName().contains(Lotr.OFFIC_VER)) {
                        if (officialMod != null) {
                            System.out.println("Duplicate Copy of Lotr Official Mod!");
                            throw new NullPointerException("Actually, too many Lotr Mods exist!");
                        }
                        officialMod = mod;
                    } else {
                        System.out.println("Could not find Official LotrMod Jar for resources");
                        throw new NullPointerException("Actually FileNotFound for the Official LotrMod jar");
                    }
                }
            }

        }

        //Find / create output dir
        File versionDir = new File(outputDir, Lotr.OFFIC_VER);
        if (!versionDir.exists()) {
            versionDir.mkdirs();
        }

        //Only run if not already resources
        if (versionDir.isDirectory() && versionDir.list().length == 0) {
            try (java.util.zip.ZipFile zipFile = new ZipFile(officialMod)) {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry entry = entries.nextElement();
                    File entryDestination = new File(versionDir, entry.getName());
                    if (isInDeleted(entry.getName())) {

                    } else {
                        if (entry.isDirectory()) {
                            entryDestination.mkdirs();
                        } else {
                            entryDestination.getParentFile().mkdirs();
                            try (InputStream in = zipFile.getInputStream(entry);
                                 OutputStream out = new FileOutputStream(entryDestination)) {
                                IOUtils.copy(in, out);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            RESOURCE_FILE = versionDir;

            //Remove certain unneeded files
            /*for (String deletion : deletions) {
                File file = new File(versionDir, deletion);
                if (file.isDirectory()) {
                    try {
                        FileUtils.deleteDirectory(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    file.delete();
                }
            }*/

            //Remove pesky slab blockstates
            File blockstatesDir = new File(versionDir, "assets/lotr/blockstates");
            File[] blockstates = blockstatesDir.listFiles();
            for (File file : blockstates) {
                if (file.getName().contains("slab")) {
                    file.delete();
                    //System.out.println("deleting: "+file.getName());
                }
            }

            //Move certain files
            for (Pair<String, String> mover : movers) {
                File from = new File(versionDir, mover.getLeft());
                File to = new File(versionDir, mover.getRight());
                try {
                    if (mover.getLeft().contains("armor")) {
                        FileUtils.moveDirectory(from, to);
                    } else if (mover.getLeft().contains("signs")) {
                        for (File file : from.listFiles()) {
                            FileUtils.moveFile(new File(from, file.getName()), new File(to, file.getName()));
                        }
                        /*File temp = new File(versionDir, "temp/"+mover.getLeft());
                        FileUtils.moveDirectoryToDirectory(from, temp, true);
                        FileUtils.deleteDirectory(new File(versionDir, "assets/minecraft/textures/entity/signs"));
                        FileUtils.moveDirectoryToDirectory(temp, to, true);*/
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            for (Pair<String, String> rename : renames) {
                (new File(versionDir, rename.getLeft())).renameTo(new File(versionDir, rename.getRight()));
            }
        } else {
            RESOURCE_FILE = versionDir;
        }

    }

    public static File newFile(File outputDir, ZipEntry zip) throws IOException {
        File outputFile = new File(outputDir, zip.getName());

        String outputPath = outputDir.getCanonicalPath();
        String outputFilePath = outputFile.getCanonicalPath();

        if (!outputFilePath.startsWith(outputPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zip.getName());
        }
        return outputFile;
    }

    public static boolean isInDeleted(String name) {
        for (String file : deletions) {
            if (name.contains(file)) {
                return true;
            }
        }
        return false;
    }
}
