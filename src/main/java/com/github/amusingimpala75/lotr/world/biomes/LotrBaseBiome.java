package com.github.amusingimpala75.lotr.world.biomes;

import com.github.amusingimpala75.lotr.mixin.getSkyColorInvoker;
import net.fabricmc.fabric.mixin.biome.BuiltinBiomesAccessor;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import static com.github.amusingimpala75.lotr.Lotr.id;

public abstract class LotrBaseBiome {

    private final Biome.Precipitation precipType;
    private final Biome.Category category;
    private final int waterFogColor;
    private final int fogColor;
    private final float depth;
    private final float scale;
    private final float temp;
    private final float downfall;
    private int foliageColor = 8111137;
    private final int grassColor;
    private final Biome BIOME;

    protected LotrBaseBiome(Biome.Precipitation precipType, Biome.Category category, float depth, float scale, float temp, float downfall, int waterFogColor, int fogColor, int foliageColor, int grassColor) {
        this.precipType = precipType;
        this.category = category;
        this.waterFogColor = waterFogColor;
        this.fogColor = fogColor;
        this.depth = depth;
        this.scale = scale;
        this.temp = temp;
        this.downfall = downfall;
        if (foliageColor > 0) {
            this.foliageColor = foliageColor;
        }
        this.grassColor = grassColor;
        this.BIOME = createBiome();
    }

    public abstract String getName();
    public abstract BlockState getTop();
    public abstract BlockState getMiddle();
    public abstract BlockState getBottom();

    //private final Biome BIOME = createBiome();

    private final ConfiguredSurfaceBuilder<TernarySurfaceConfig> SURFACE_BUILDER = SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(
            getTop(),
            getMiddle(),
            getBottom()));

    protected abstract void addFeatures(GenerationSettings.Builder builder);

    protected abstract void addMobs(SpawnSettings.Builder builder);

    private static void addDefaultFeatures(GenerationSettings.Builder builder) {

    }

    private static void addDefaultMobs(SpawnSettings.Builder builder) {

    }

    private Biome createBiome() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        addDefaultMobs(spawnSettings);
        addMobs(spawnSettings);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(SURFACE_BUILDER);
        addDefaultFeatures(generationSettings);
        addFeatures(generationSettings);

        return (new Biome.Builder())
                .precipitation(precipType)
                .category(category)
                .depth(depth)
                .scale(scale)
                .temperature(temp)
                .downfall(downfall)
                .effects((new BiomeEffects.Builder())
                        .waterColor(16777215)
                        .waterFogColor(waterFogColor)
                        .skyColor(getSkyColorInvoker.invokeGetSkyColor(temp))
                        .fogColor(fogColor)
                        .foliageColor(foliageColor)
                        .grassColor(grassColor)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

    public RegistryKey<Biome> BIOME_KEY = RegistryKey.of(Registry.BIOME_KEY, id(getName()));

    public void register() {
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, id(getName()), SURFACE_BUILDER);
        Registry.register(BuiltinRegistries.BIOME, BIOME_KEY.getValue(), BIOME);
        BuiltinBiomesAccessor.getBY_RAW_ID().put(BuiltinRegistries.BIOME.getRawId(BIOME), BIOME_KEY);
    }
}

/*
TODO
    -Find actual sky, fog, foliage colors, fix waterColor
    -populate addDefaultFeatures and addDefaultMobs
 */
