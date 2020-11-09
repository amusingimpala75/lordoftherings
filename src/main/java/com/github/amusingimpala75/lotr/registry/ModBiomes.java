package com.github.amusingimpala75.lotr.registry;

import com.github.amusingimpala75.lotr.world.MiddleEarthBiomeSource;
import com.github.amusingimpala75.lotr.world.biomes.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static com.github.amusingimpala75.lotr.Lotr.*;

/*
Registry for biomes
TODO: finish adding biomes, add features/mobs, fix MEWorldConfig and ChunkGenerator
 */
public class ModBiomes {
    public static BufferedImage mapImage;
    public static File mapImageFile = new File("data/lotr/map/middle_earth.png");
    static Map<Integer, Identifier> mapColors = new HashMap<>();

    public static void addMapColor(Identifier biome, int color) {
        mapColors.put(color, biome);
        Color color1 = new Color(color, true);
        System.out.println(color1.getRGB()+": "+biome.getNamespace()+":"+biome.getPath());
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
        /*
        lindon
        sounthron coasts
        nan curunir
        forodwaith
        eregion
        mirkwood
        grey mountains
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
        String basePath = (new File(".")).getAbsolutePath();
        basePath = basePath.substring(0, basePath.length()-1);
        InputStream mapStream = ModBiomes.class.getResourceAsStream("/data/lotr/map/middle_earth.png");
        try {
            mapImage = ImageIO.read(mapStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Registry.register(Registry.BIOME_SOURCE, id("middle_earth"), MiddleEarthBiomeSource.CODEC);
    }
    public static Identifier fromMapColor(int color) {
        Identifier id = mapColors.getOrDefault(color, id("river"));
        return id;
    }
}
