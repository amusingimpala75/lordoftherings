package com.github.amusingimpala75.lotr.world.biomes;

import com.github.amusingimpala75.lotr.mixin.getSkyColorInvoker;
import com.github.amusingimpala75.lotr.registry.ModBiomes;
import com.github.amusingimpala75.lotr.registry.ModDimensions;
import com.github.amusingimpala75.lotr.world.MESurfaceBuilder;
import com.github.amusingimpala75.lotr.world.MESurfaceConfig;
import com.github.amusingimpala75.lotr.world.features.ModDefaultBiomeFeatures;
import com.github.amusingimpala75.lotr.world.features.WeightedRandomFeatureConfig;
import net.fabricmc.fabric.mixin.biome.BuiltinBiomesAccessor;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import org.apache.logging.log4j.LogManager;

import java.util.List;
import java.util.Random;

import static com.github.amusingimpala75.lotr.Lotr.id;
/*
superclass for all biomes added by LotR
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
    private Biome BIOME;
    private final int mapColor;
    private int waterColor = 16777215;
    private float biomeTreeAmount;
    private WeightedRandomFeatureConfig grassBonemealGenerator;

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
        this.mapColor = mapColor;
    }

    public abstract String getName();
    public abstract BlockState getTop();
    public abstract BlockState getMiddle();
    public abstract BlockState getBottom();

    private MESurfaceConfig CONFIG = new MESurfaceConfig(getTop(), getMiddle(), getBottom());

    protected void modifyConfig(MESurfaceConfig config) {}

    private ConfiguredSurfaceBuilder<MESurfaceConfig> SURFACE_BUILDER;

    protected void addFeatures(GenerationSettings.Builder builder) {
        this.addCarvers(builder);
        this.addLakes(builder);
        this.addDirtGravel(builder);
        this.addStoneVariants(builder);
        this.addOres(builder);
        this.addDripstones(builder);
        this.addCobwebs(builder);
        this.addSedimentDisks(builder);
        this.addBoulders(builder);
        this.addVegetation(builder);
        ModDefaultBiomeFeatures.addMushrooms(builder);
        this.addReeds(builder);
        this.addPumpkins(builder);
        this.addLiquidSprings(builder);
        ModDefaultBiomeFeatures.addFreezeTopLayer(builder);
        this.addStructures(builder);
    }

    protected void addMobs(SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SHEEP, 24, 4, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PIG, 20, 4, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.CHICKEN, 20, 4, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.COW, 16, 4, 4));
        builder.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.BAT, 10, 8, 8));
        this.addDeer(builder);
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

    public LotrBaseBiome register() {
        modifyConfig(CONFIG);
        SURFACE_BUILDER = ModDimensions.ME_SURFACE_CONFIG.withConfig(CONFIG);
        this.BIOME = createBiome();
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, id(getName()), SURFACE_BUILDER);
        Registry.register(BuiltinRegistries.BIOME, BIOME_KEY.getValue(), BIOME);
        BuiltinBiomesAccessor.getBY_RAW_ID().put(BuiltinRegistries.BIOME.getRawId(BIOME), BIOME_KEY);
        ModBiomes.addMapColor(id(getName()), getMapColor());
        ModBiomes.addBiome(this);
        return this;
    }
    public final float getBiomeTreeAmount() {
        return this.biomeTreeAmount;
    }

    public final void updateBiomeTreeAmount(float f) {
        this.biomeTreeAmount = Math.max(this.biomeTreeAmount, f);
    }

    public int getMapColor() {
        return mapColor;
    }

    public List<SpawnSettings.SpawnEntry> getSpawnsAtLocation(SpawnGroup type) {
        return BIOME.getSpawnSettings().getSpawnEntry(type);
    }

    public boolean isRiver() {
        return false;
    }

    public float getBiomeScaleSignificanceForChunkGen() {
        return 0.9F;
    }

    public double getHorizontalNoiseScale() {
        return 400.0D;
    }

    protected void addCarvers(GenerationSettings.Builder builder) {
        ModDefaultBiomeFeatures.addCarvers(builder);
    }

    protected void addLakes(GenerationSettings.Builder builder) {
        ModDefaultBiomeFeatures.addLakes(builder);
    }

    protected void addDirtGravel(GenerationSettings.Builder builder) {
        ModDefaultBiomeFeatures.addDirtGravel(builder);
    }

    protected void addStoneVariants(GenerationSettings.Builder builder) {
        ModDefaultBiomeFeatures.addGranite(builder);
    }

    protected void addOres(GenerationSettings.Builder builder) {
        ModDefaultBiomeFeatures.addOres(builder);
    }

    protected void addDripstones(GenerationSettings.Builder builder) {
        ModDefaultBiomeFeatures.addDripstones(builder);
    }

    protected void addCobwebs(GenerationSettings.Builder builder) {
        ModDefaultBiomeFeatures.addCobwebs(builder);
    }

    protected void addSedimentDisks(GenerationSettings.Builder builder) {
        this.addBiomeSandSediments(builder);
        ModDefaultBiomeFeatures.addClayGravelSediments(builder);
    }

    protected void addBiomeSandSediments(GenerationSettings.Builder builder) {
        ModDefaultBiomeFeatures.addSandSediments(builder);
    }

    protected void addBoulders(GenerationSettings.Builder builder) {
    }

    protected void addVegetation(GenerationSettings.Builder builder) {
    }

    public void setGrassBonemealGenerator(WeightedRandomFeatureConfig config) {
        this.grassBonemealGenerator = config;
    }

    public WeightedRandomFeatureConfig getGrassBonemealGenerator() {
        return this.grassBonemealGenerator;
    }

    public BlockState getGrassForBonemeal(Random rand, BlockPos pos) {
        if (this.grassBonemealGenerator != null) {
            ConfiguredFeature feature = this.grassBonemealGenerator.getRandomFeature(rand);
            if (feature.config instanceof RandomPatchFeatureConfig) {
                return ((RandomPatchFeatureConfig)feature.config).stateProvider.getBlockState(rand, pos);
            }

            LogManager.getLogger().warn("DEVELOPMENT ERROR: Biome (%s) grass bonemeal generator contains a FeatureConfig of invalid type - should be BlockClusterFeatureConfig, but is %s", new Object[]{getName(), "Bonemeal grass Feature"});
        }

        return Blocks.GRASS.getDefaultState();
    }

    protected void addReeds(GenerationSettings.Builder builder) {
        ModDefaultBiomeFeatures.addReeds(builder);
    }

    protected void addPumpkins(GenerationSettings.Builder builder) {
        ModDefaultBiomeFeatures.addPumpkins(builder);
    }

    protected void addLiquidSprings(GenerationSettings.Builder builder) {
        ModDefaultBiomeFeatures.addWaterLavaSprings(builder);
    }

    protected void addAnimals(SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SHEEP, 24, 4, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PIG, 20, 4, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.CHICKEN, 20, 4, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.COW, 16, 4, 4));
        builder.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.BAT, 10, 8, 8));
        this.addDeer(builder);
    }

    protected void addExtraSheep(int mul, SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SHEEP, 24 * mul, 4, 4));
    }

    protected void addHorsesDonkeys(SpawnSettings.Builder builder) {
        this.addHorsesDonkeys(1, builder);
    }

    protected void addHorsesDonkeys(int mul, SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.HORSE, 10 * mul, 2, 6));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.DONKEY, 1 * mul, 1, 3));
    }

    protected void addWolves(SpawnSettings.Builder builder) {
        this.addWolves(1, builder);
    }

    protected void addWolves(int mul, SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 10 * mul, 4, 8));
    }

    protected void addFoxes(SpawnSettings.Builder builder) {
        this.addFoxes(1, builder);
    }

    protected void addFoxes(int mul, SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 16 * mul, 2, 4));
    }

    protected void addDeer(SpawnSettings.Builder builder) {
        this.addDeer(1, builder);
    }

    protected void addDeer(int mul, SpawnSettings.Builder builder) {

    }

    protected void addBoars(SpawnSettings.Builder builder) {
        this.addBoars(1, builder);
    }

    protected void addBoars(int mul, SpawnSettings.Builder builder) {
    }

    protected void addBears(SpawnSettings.Builder builder) {
        this.addBears(1, builder);
    }

    protected void addBears(int mul, SpawnSettings.Builder builder) {
    }

    protected void addElk(SpawnSettings.Builder builder) {
        this.addElk(1, builder);
    }

    protected void addElk(int mul, SpawnSettings.Builder builder) {
    }

    protected void addStructures(GenerationSettings.Builder builder) {
    }

}

/*
TODO
    -Find actual sky, fog, foliage colors, fix waterColor
    -populate addDefaultFeatures and addDefaultMobs
 */
