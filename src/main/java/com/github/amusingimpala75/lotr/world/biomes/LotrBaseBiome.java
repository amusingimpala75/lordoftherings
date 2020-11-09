package com.github.amusingimpala75.lotr.world.biomes;

import com.github.amusingimpala75.lotr.mixin.getSkyColorInvoker;
import com.github.amusingimpala75.lotr.registry.ModBiomes;
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
/*
SuperClass for all biomes added by LotR
 */
public abstract class LotrBaseBiome {

    private final Biome.Precipitation precipType;
    private final Biome.Category category;
    private int waterFogColor;
    private int fogColor;
    private final float depth;
    private final float scale;
    private final float temp;
    private final float downfall;
    private int foliageColor = 8111137;
    private int grassColor;
    private final Biome BIOME;
    private final int mapColor;
    private int waterColor = 16777215;

    protected LotrBaseBiome(Biome.Precipitation precipType, Biome.Category category, float depth, float scale, float temp, float downfall, int waterFogColor, int fogColor, int foliageColor, int grassColor, int mapColor) {
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
        if (grassColor == -1) {
            this.grassColor = 8111137;
        }
        if (fogColor == -1) {
            this.fogColor = 12638463;
        }
        if (waterFogColor == -1) {
            this.waterFogColor = 329011;
        }
        this.BIOME = createBiome();
        this.mapColor = mapColor;
    }

    public abstract String getName();
    public abstract BlockState getTop();
    public abstract BlockState getMiddle();
    public abstract BlockState getBottom();

    private final ConfiguredSurfaceBuilder<TernarySurfaceConfig> SURFACE_BUILDER = SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(
            getTop(),
            getMiddle(),
            getBottom()));

    protected void addFeatures(GenerationSettings.Builder builder) {

    }

    protected void addMobs(SpawnSettings.Builder builder) {

    }
    protected int getWaterColor() {
        return waterColor;
    }
    protected int getSkyColor() {
        return getSkyColorInvoker.invokeGetSkyColor(temp);
    }

    private Biome createBiome() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        addMobs(spawnSettings);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(SURFACE_BUILDER);
        addFeatures(generationSettings);

        return (new Biome.Builder())
                .precipitation(precipType)
                .category(category)
                .depth(depth)
                .scale(scale)
                .temperature(temp)
                .downfall(downfall)
                .effects((new BiomeEffects.Builder())
                        .waterColor(getWaterColor())
                        .waterFogColor(waterFogColor)
                        .skyColor(getSkyColor())
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
        ModBiomes.addMapColor(id(getName()), getMapColor());
    }

    public int getMapColor() {
        return mapColor;
    }
}

/*
TODO
    -Find actual sky, fog, foliage colors, fix waterColor
    -populate addDefaultFeatures and addDefaultMobs
 */
