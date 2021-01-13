package com.github.amusingimpala75.lotr.registry;

import com.github.amusingimpala75.lotr.world.MiddleEarthBiomeSource;
import com.github.amusingimpala75.lotr.world.biomes.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static com.github.amusingimpala75.lotr.Lotr.*;

/*
Registry for biomes
TODO: finish adding biomes, add features/mobs, fix MEWorldConfig/surfaces and ChunkGenerator
 */
public class ModBiomes {
    public static BufferedImage mapImage;
    static Map<Integer, Identifier> mapColors = new HashMap<>();
    public static List<LotrBaseBiome> biomes = new ArrayList<>();

    public static void addMapColor(Identifier biome, int color) {
        mapColors.put(color, biome);
    }

    public static void addBiome(LotrBaseBiome biome) {
        biomes.add(biome);
    }

    //TODO: Why null?
    public static boolean isLotrBiome(Biome biome) {
        Set<Map.Entry<RegistryKey<Biome>, Biome>> biomeReg = BuiltinRegistries.BIOME.getEntries();
        Iterator<Map.Entry<RegistryKey<Biome>, Biome>> biomeReg2 = biomeReg.iterator();
        for (int i = 0; i < biomeReg.size(); i++) {
            Map.Entry<RegistryKey<Biome>, Biome> biomeReg3 = biomeReg2.next();
            if (biomeReg3.getValue().equals(biome)) {
                if (biomeReg3.getKey().getValue().getNamespace().equals("lotr")) {
                    return true;
                }
            }
        }
        //if (id.isPresent()) {
        //    for (LotrBaseBiome lotrBaseBiome : biomes) {
        //        if (id.get().getValue().getNamespace().equals(lotrBaseBiome.getName())) {
        //           return true;
        //        }
        //    }
        //}
        return false;
    }

    public static LotrBaseBiome asLotrBiome(Biome biome) {
        Set<Map.Entry<RegistryKey<Biome>, Biome>> biomeReg = BuiltinRegistries.BIOME.getEntries();
        Iterator<Map.Entry<RegistryKey<Biome>, Biome>> biomeReg2 = biomeReg.iterator();
        for (int i = 0; i < biomeReg.size(); i++) {
            Map.Entry<RegistryKey<Biome>, Biome> biomeReg3 = biomeReg2.next();
            if (biomeReg3.getValue().equals(biome)) {
                for (LotrBaseBiome biome2 : biomes) {
                    if (biomeReg3.getKey().getValue().getPath().equals(biome2.getName())) {
                        return biome2;
                    }
                }
            }
        }
        return null;
    }

    public static void registerBiomes() {
        (new ShireBiome()).register();
        (new MordorBiome()).register();
        (new RohanBiome()).register();
        (new MistyMountainsBiome()).register();
        (new MistyMountainsBiome.FootHills()).register();
        (new ShireWoodlandsBiome()).register();
        (new RiverBiome()).register();
        (new TrollshawsBiome()).register();
        (new BlueMountainsBiome()).register();
        (new BlueMountainsBiome.Foothills()).register();
        (new EriadorBiome()).register();
        (new LoneLandsBiome()).register();
        (new IthilienBiome()).register();
        (new BrownLandsBiome()).register();
        (new LothlorienBiome()).register();
        (new IronHillsBiome()).register();
        (new DunlandBiome()).register();
        (new EmynMuilBiome()).register();
        (new LindonBiome()).register();
        (new SouthronCoastsBiome()).register();
        (new NanCurunirBiome()).register();
        (new ForodwaithBiome()).register();
        (new EregionBiome()).register();
        (new MirkwoodBiome()).register();
        (new GreyMountainsBiome()).register();
        /*
        white mountains
        fangorn
        woodland realm

        dale
        angmar
        harandor
        enedwaith
        vales of anduin
        anduin hills
        wilderland
        old forest
        bree land
        chetwood
        grey foothills
        white foothills
        mordor mnt
        forodwatih mnt
        angmar mnt
        nurn
        umbar
        harad desert
        lindon woodlands
        eriador downs
        lone lands hills
        north lands
        northlands forest
        sea
        island
        beach
        tolfalas
        lake
        nurnen
        dol en ernil
        emyn en ernil
        western isles
        coldfells
        ettenmoors
        harnennor
        dagorland
        white beach
        dorwinion
        emyn winion
        wold
        minhiriath
        wryn vorn
        druwiath iaur
        andrast
        lossarnach
        lebennin
        pelagir
        lamedon
        lamedon hills
        blackroot vales
        pinnath gelin
        anfalas
        northern wilderland
        northern dale
        rivendell
        rivendell hills
        western gondor
        shire moors
        white downs
        midgewater
        swanfleet
        gladden fields
        long marshes
        nindalf
        dead marshes
        mouths of entwash
        ethir anduin
        shire marshes
        nurn marshes
        Anorien
        */
        InputStream mapStream = ModBiomes.class.getResourceAsStream("/data/lotr/map/middle_earth.png");
        try {
            mapImage = ImageIO.read(mapStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Registry.register(Registry.BIOME_SOURCE, id("middle_earth"), MiddleEarthBiomeSource.CODEC);
    }
    public static Identifier fromMapColor(int color) {
        return mapColors.getOrDefault(color, new Identifier("minecraft", "warped_forest"));
    }
}
