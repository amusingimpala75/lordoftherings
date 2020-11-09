package com.github.amusingimpala75.lotr.world.features;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.placer.DoublePlantPlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.OptionalInt;

import static com.github.amusingimpala75.lotr.Lotr.*;

@SuppressWarnings("all")    //To remove all those unchecked assingment warnings for
                            //ConfiguredFeatures->ConfiguresFeatures<?,?>
/*
All features add by LotR
 */
public class Features {
    public static final ConfiguredFeature<?, ?> ORE_COPPER;
    public static final ConfiguredFeature<?, ?> ORE_TIN;
    public static final ConfiguredFeature<?, ?> ORE_COAL;
    public static final ConfiguredFeature<?, ?> ORE_IRON;
    public static final ConfiguredFeature<?, ?> ORE_GOLD;
    public static final ConfiguredFeature<?, ?> ORE_SILVER;
    public static final ConfiguredFeature<?, ?> ORE_SULFUR;
    public static final ConfiguredFeature<?, ?> ORE_NITER;
    public static final ConfiguredFeature<?, ?> ORE_SALT;
    public static final ConfiguredFeature<?, ?> GRASS_CLOVER;
    public static final ConfiguredFeature<?, ?> CLOVER_FOUR;
    public static final ConfiguredFeature<?, ?> THISTLES_FEATURE;
    public static final ConfiguredFeature<?, ?> NETTLES_FEATURE;
    public static final ConfiguredFeature<?, ?> POPPY_FEATURE;
    public static final ConfiguredFeature<?, ?> DANDELION_FEATURE;
    public static final ConfiguredFeature<?, ?> AZURE_BLUET_FEATURE;
    public static final ConfiguredFeature<?, ?> OXEYE_DAISY_FEATURE;
    public static final ConfiguredFeature<?, ?> CORNFLOWER_FEATURE;
    public static final ConfiguredFeature<?, ?> RED_TULIP_FEATURE;
    public static final ConfiguredFeature<?, ?> WHITE_TULIP_FEATURE;
    public static final ConfiguredFeature<?, ?> ORANGE_TULIP_FEATURE;
    public static final ConfiguredFeature<?, ?> PINK_TULIP_FEATURE;
    public static final ConfiguredFeature<?, ?> LAVENDER_FEATURE;
    public static final ConfiguredFeature<?, ?> BLUEBELL_FEATURE;
    public static final ConfiguredFeature<?, ?> MARIGOLD_FEATURE;
    public static final ConfiguredFeature<?, ?> PEONY_FEATURE;
    public static final ConfiguredFeature<?, ?> ROSE_BUSH_FEATURE;
    public static final ConfiguredFeature<?, ?> LILAC_FEATURE;
    public static final ConfiguredFeature<TreeFeatureConfig, ?> OAK_TREE;
    public static final ConfiguredFeature<TreeFeatureConfig, ?> FANCY_OAK;
    public static final ConfiguredFeature<TreeFeatureConfig, ?> OAK_BEES;
    public static final ConfiguredFeature<TreeFeatureConfig, ?> FANCY_OAK_BEES;
    public static final ConfiguredFeature<TreeFeatureConfig, ?> BIRCH_TREE;
    public static final ConfiguredFeature<TreeFeatureConfig, ?> BIRCH_BEES;
    public static final ConfiguredFeature<TreeFeatureConfig, ?> FANCY_BIRCH;
    public static final ConfiguredFeature<TreeFeatureConfig, ?> FANCY_BIRCH_BEES;
    public static final ConfiguredFeature<TreeFeatureConfig, ?> ASPEN_TREE;
    public static final ConfiguredFeature<?, ?> SHIRE_GRASS;


    public static final BlockState COPPER_ORE;
    public static final BlockState TIN_ORE;
    public static final BlockState COAL_ORE;
    public static final BlockState IRON_ORE;
    public static final BlockState GOLD_ORE;
    public static final BlockState SILVER_ORE;
    public static final BlockState SULFUR_ORE;
    public static final BlockState NITER_ORE;
    public static final BlockState SALT_ORE;
    public static final BlockState CLOVER_GRASS;
    public static final BlockState FOUR_CLOVER;
    public static final BlockState THISTLES;
    public static final BlockState NETTLES;
    public static final BlockState POPPY;
    public static final BlockState DANDELION;
    public static final BlockState AZURE_BLUET;
    public static final BlockState OXEYE_DAISY;
    public static final BlockState CORNFLOWER;
    public static final BlockState RED_TULIP;
    public static final BlockState WHITE_TULIP;
    public static final BlockState ORANGE_TULIP;
    public static final BlockState PINK_TULIP;
    public static final BlockState BLUEBELL;
    public static final BlockState MARIGOLD;
    public static final BlockState LAVENDER;
    public static final BlockState PEONY;
    public static final BlockState ROSE_BUSH;
    public static final BlockState LILAC;
    public static final BlockState OAK_LOG;
    public static final BlockState OAK_LEAVES;
    public static final BlockState BIRCH_LOG;
    public static final BlockState BIRCH_LEAVES;
    public static final BlockState ASPEN_LOG;
    public static final BlockState ASPEN_LEAVES;

    public static final TreeFeatureConfig OAK_CONFIG;
    public static final TreeFeatureConfig FANCY_OAK_CONFIG;
    public static final TreeFeatureConfig BIRCH_CONFIG;
    public static final TreeFeatureConfig FANCY_BIRCH_CONFIG;
    public static final TreeFeatureConfig ASPEN_CONFIG;

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        return (ConfiguredFeature<FC, ?>) Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id, configuredFeature);
    }

    static {
        COPPER_ORE = Registry.BLOCK.get(id("copper_ore")).getDefaultState();
        TIN_ORE = Registry.BLOCK.get(id("tin_ore")).getDefaultState();
        COAL_ORE = Blocks.COAL_ORE.getDefaultState();
        IRON_ORE = Blocks.IRON_ORE.getDefaultState();
        GOLD_ORE = Blocks.GOLD_ORE.getDefaultState();
        SILVER_ORE = Registry.BLOCK.get(id("silver_ore")).getDefaultState();
        SULFUR_ORE = Registry.BLOCK.get(id("sulfur_ore")).getDefaultState();
        NITER_ORE = Registry.BLOCK.get(id("niter_ore")).getDefaultState();
        SALT_ORE = Registry.BLOCK.get(id("salt_ore")).getDefaultState();
        CLOVER_GRASS = Registry.BLOCK.get(id("clover")).getDefaultState();
        FOUR_CLOVER = Registry.BLOCK.get(id("four_leaf_clover")).getDefaultState();
        THISTLES = Registry.BLOCK.get(id("thistle")).getDefaultState();
        NETTLES = Registry.BLOCK.get(id("nettles")).getDefaultState();
        POPPY = Blocks.POPPY.getDefaultState();
        DANDELION = Blocks.DANDELION.getDefaultState();
        AZURE_BLUET = Blocks.AZURE_BLUET.getDefaultState();
        OXEYE_DAISY = Blocks.OXEYE_DAISY.getDefaultState();
        CORNFLOWER = Blocks.CORNFLOWER.getDefaultState();
        RED_TULIP = Blocks.RED_TULIP.getDefaultState();
        WHITE_TULIP = Blocks.WHITE_TULIP.getDefaultState();
        ORANGE_TULIP = Blocks.ORANGE_TULIP.getDefaultState();
        PINK_TULIP = Blocks.PINK_TULIP.getDefaultState();
        LAVENDER = Registry.BLOCK.get(id("lavender")).getDefaultState();
        MARIGOLD = Registry.BLOCK.get(id("marigold")).getDefaultState();
        BLUEBELL = Registry.BLOCK.get(id("bluebell")).getDefaultState();
        PEONY = Blocks.PEONY.getDefaultState();
        ROSE_BUSH = Blocks.ROSE_BUSH.getDefaultState();
        LILAC = Blocks.LILAC.getDefaultState();
        OAK_LOG = Blocks.OAK_LOG.getDefaultState();
        OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState();
        BIRCH_LOG = Blocks.BIRCH_LOG.getDefaultState();
        BIRCH_LEAVES = Blocks.BIRCH_LEAVES.getDefaultState();
        ASPEN_LOG = Registry.BLOCK.get(id("aspen_log")).getDefaultState();
        ASPEN_LEAVES = Registry.BLOCK.get(id("aspen_leaves")).getDefaultState();
    }

    static {
        OAK_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build();
        FANCY_OAK_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new LargeOakFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(4), 4), new LargeOakTrunkPlacer(3, 11, 0), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build();
        BIRCH_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BIRCH_LOG), new SimpleBlockStateProvider(BIRCH_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(5, 2, 0), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build();
        FANCY_BIRCH_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BIRCH_LOG), new SimpleBlockStateProvider(BIRCH_LEAVES), new LargeOakFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(4), 4), new LargeOakTrunkPlacer(3, 11, 0), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build();
        ASPEN_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ASPEN_LOG), new SimpleBlockStateProvider(ASPEN_LEAVES), new SpruceFoliagePlacer(UniformIntDistribution.of(2,1), UniformIntDistribution.of(0,2), UniformIntDistribution.of(1,1)), new StraightTrunkPlacer(5, 2, 1), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());
    }

    static {
        ORE_COPPER = register("ore_copper", (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature) Feature.ORE
                .configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, COPPER_ORE, 9))
                .method_30377(128))
                .spreadHorizontally())
                .repeat(16));
        ORE_TIN = register("ore_tin", (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature) Feature.ORE
                .configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, TIN_ORE, 9))
                .method_30377(128))
                .spreadHorizontally())
                .repeat(16));
        ORE_COAL = register("ore_coal2", (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature) Feature.ORE
                .configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, COAL_ORE, 17))
                .method_30377(128))
                .spreadHorizontally())
                .repeat(20));
        ORE_IRON = register("ore_iron2", (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature) Feature.ORE
                .configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, IRON_ORE, 9))
                .method_30377(64))
                .spreadHorizontally())
                .repeat(20));
        ORE_GOLD = register("ore_gold2", (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature) Feature.ORE
                .configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, GOLD_ORE, 9))
                .method_30377(32))
                .spreadHorizontally())
                .repeat(2));
        ORE_SILVER = register("ore_silver", (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature) Feature.ORE
                .configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, SILVER_ORE, 9))
                .method_30377(32))
                .spreadHorizontally())
                .repeat(3));
        ORE_SULFUR = register("ore_sulfur", (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature) Feature.ORE
                .configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, SULFUR_ORE, 9))
                .method_30377(64))
                .spreadHorizontally())
                .repeat(2));
        ORE_NITER = register("ore_niter", (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature) Feature.ORE
                .configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, NITER_ORE, 9))
                .method_30377(64))
                .spreadHorizontally())
                .repeat(2));
        ORE_SALT = register("ore_salt", (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature) Feature.ORE
                .configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, SALT_ORE, 13))
                .method_30377(64))
                .spreadHorizontally())
                .repeat(2));
        GRASS_CLOVER = register("grass_clover", (ConfiguredFeature) ((ConfiguredFeature) ((ConfiguredFeature) Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(CLOVER_GRASS), SimpleBlockPlacer.INSTANCE))
                        .tries(6)
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE))));
        CLOVER_FOUR = register("grass_four_clover", Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(FOUR_CLOVER), SimpleBlockPlacer.INSTANCE))
                        .tries(1)
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE));
        THISTLES_FEATURE = register("thistles_feature", Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(THISTLES), SimpleBlockPlacer.INSTANCE))
                        .tries(6)
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE));
        NETTLES_FEATURE = register("nettles_feature", Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(NETTLES), SimpleBlockPlacer.INSTANCE))
                        .tries(6)
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE));
        POPPY_FEATURE = register("poppy_feature2", Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(POPPY), SimpleBlockPlacer.INSTANCE))
                        .tries(8)
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE));
        DANDELION_FEATURE = register("dandelion_feature2", Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(DANDELION), SimpleBlockPlacer.INSTANCE))
                        .tries(12)
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE));
        AZURE_BLUET_FEATURE = register("azure_bluet_feature2", Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(AZURE_BLUET), SimpleBlockPlacer.INSTANCE))
                        .tries(8)
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE));
        OXEYE_DAISY_FEATURE = register("oxeye_daisy_feature2", Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(OXEYE_DAISY), SimpleBlockPlacer.INSTANCE))
                        .tries(8)
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE));
        CORNFLOWER_FEATURE = register("cornflower_feature2", Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(CORNFLOWER), SimpleBlockPlacer.INSTANCE))
                        .tries(4)
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE));
        RED_TULIP_FEATURE = register("red_tulip_feature2", Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(RED_TULIP), SimpleBlockPlacer.INSTANCE))
                        .tries(3)
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE));
        WHITE_TULIP_FEATURE = register("white_tulip_feature2", Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(WHITE_TULIP), SimpleBlockPlacer.INSTANCE))
                        .tries(3)
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE));
        ORANGE_TULIP_FEATURE = register("orange_tulip_feature2", Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(ORANGE_TULIP), SimpleBlockPlacer.INSTANCE))
                        .tries(3)
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE));
        PINK_TULIP_FEATURE = register("pink_tulip_feature2", Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(PINK_TULIP), SimpleBlockPlacer.INSTANCE))
                        .tries(3)
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE));
        BLUEBELL_FEATURE = register("bluebell_feature",Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(BLUEBELL), SimpleBlockPlacer.INSTANCE))
                        .tries(3)
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE));
        MARIGOLD_FEATURE = register("marigold_feature", Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(MARIGOLD), SimpleBlockPlacer.INSTANCE))
                        .tries(6)
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE));
        LAVENDER_FEATURE = register("lavender_feature", Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(LAVENDER), SimpleBlockPlacer.INSTANCE))
                        .tries(3)
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE));
        PEONY_FEATURE = register("peony_feature2", (ConfiguredFeature)Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(PEONY), new DoublePlantPlacer()))
                        .tries(3)
                        .cannotProject()
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SPREAD_32_ABOVE)
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP));
        ROSE_BUSH_FEATURE = register("rose_feature2", (ConfiguredFeature)Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(ROSE_BUSH), new DoublePlantPlacer()))
                        .tries(3)
                        .cannotProject()
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SPREAD_32_ABOVE)
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP));
        LILAC_FEATURE = register("lilac_feature2", (ConfiguredFeature)Feature.RANDOM_PATCH
                .configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(LILAC), new DoublePlantPlacer()))
                        .tries(3)
                        .cannotProject()
                        .build())
                .decorate(ConfiguredFeatures.Decorators.SPREAD_32_ABOVE)
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP));
        OAK_TREE = register("oak_tree2", (ConfiguredFeature)Feature.TREE.configure(OAK_CONFIG));
        FANCY_OAK = register("fancy_oak2", Feature.TREE.configure(FANCY_OAK_CONFIG));
        OAK_BEES = register("oak_bees2", Feature.TREE
                .configure(((TreeFeatureConfig)OAK_TREE.getConfig())
                        .setTreeDecorators(ImmutableList
                                .of(ConfiguredFeatures.Decorators.REGULAR_BEEHIVES_TREES)
                        )
                ));
        FANCY_OAK_BEES = register("fancy_oak_bees2", Feature.TREE
                .configure(((TreeFeatureConfig)FANCY_OAK.getConfig())
                        .setTreeDecorators(ImmutableList
                                .of(ConfiguredFeatures.Decorators.REGULAR_BEEHIVES_TREES))
                ));
        BIRCH_TREE = register("birch_tree2", Feature.TREE.configure(BIRCH_CONFIG));
        BIRCH_BEES = register("birch_bees2", Feature.TREE
                .configure(((TreeFeatureConfig)BIRCH_TREE.getConfig())
                        .setTreeDecorators(ImmutableList
                                .of(ConfiguredFeatures.Decorators.REGULAR_BEEHIVES_TREES))
                ));
        FANCY_BIRCH = register("fancy_birch2", Feature.TREE.configure(FANCY_BIRCH_CONFIG));
        FANCY_BIRCH_BEES = register("fancy_birch_bees2", Feature.TREE
                .configure(((TreeFeatureConfig)FANCY_BIRCH.getConfig())
                        .setTreeDecorators(ImmutableList
                                .of(ConfiguredFeatures.Decorators.REGULAR_BEEHIVES_TREES))
                ));
        ASPEN_TREE = register("aspen_tree", Feature.TREE.configure(ASPEN_CONFIG));;
        SHIRE_GRASS = register("shire_grass", Feature.RANDOM_SELECTOR
                .configure(new RandomFeatureConfig(
                                ImmutableList.of(
                                        GRASS_CLOVER.withChance((float)249/430),
                                        CLOVER_FOUR.withChance((float)10/430),
                                        NETTLES_FEATURE.withChance((float)10/430),
                                        THISTLES_FEATURE.withChance((float)5/430)),
                                GRASS_CLOVER))
                .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP)
                .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(6, 0.1F, 1))
                ));

    }
}
