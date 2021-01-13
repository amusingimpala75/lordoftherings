package com.github.amusingimpala75.lotr.world.features;

import com.github.amusingimpala75.lotr.block.CloverBlock;
import com.github.amusingimpala75.lotr.block.Dripstone;
import com.github.amusingimpala75.lotr.mixin.FoliagePlacerTypeInvoker;
import com.github.amusingimpala75.lotr.mixin.TreeDecoratorTypeInvoker;
import com.github.amusingimpala75.lotr.world.ModCarvers;
import com.github.amusingimpala75.lotr.world.biomes.LotrBaseBiome;
import com.github.amusingimpala75.lotr.world.features.config.*;
import com.github.amusingimpala75.lotr.world.features.foliagePlacers.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.placer.ColumnPlacer;
import net.minecraft.world.gen.placer.DoublePlantPlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.tree.BeehiveTreeDecorator;
import net.minecraft.world.gen.tree.LeaveVineTreeDecorator;
import net.minecraft.world.gen.tree.TreeDecoratorType;
import net.minecraft.world.gen.tree.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.*;

import static com.github.amusingimpala75.lotr.Lotr.*;
/*
Feature clumping for biomes
TODO: Check that *100 for chance works properly
 */
@SuppressWarnings("unused")
public class ModDefaultBiomeFeatures {
    static Set<Block> springStoneSet = ImmutableSet.of(Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, getBlock("gondor_rock"), getBlock("mordor_rock"), getBlock("rohan_rock"), getBlock("blue_rock"), getBlock("red_rock"), getBlock("chalk"), getBlock("dirty_chalk"));

    public static BlockState COPPER_ORE = getBlockState("copper_ore");
    public static BlockState TIN_ORE = getBlockState("tin_ore");
    public static BlockState COAL_ORE = Blocks.COAL_ORE.getDefaultState();
    public static BlockState IRON_ORE = Blocks.IRON_ORE.getDefaultState();
    public static BlockState GOLD_ORE = Blocks.GOLD_ORE.getDefaultState();
    public static BlockState SILVER_ORE = getBlockState("silver_ore");
    public static BlockState SULFUR_ORE = getBlockState("sulfur_ore");
    public static BlockState NITER_ORE = getBlockState("niter_ore");
    public static BlockState SALT_ORE = getBlockState("salt_ore");
    public static BlockState WATER = Blocks.WATER.getDefaultState();
    public static BlockState LAVA = Blocks.LAVA.getDefaultState();
    public static BlockState DIRT = Blocks.DIRT.getDefaultState();
    public static BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
    public static BlockState GRANITE = Blocks.GRANITE.getDefaultState();
    public static BlockState SAND = Blocks.SAND.getDefaultState();
    public static BlockState COBWEB = Blocks.COBWEB.getDefaultState();
    public static BlockState WHITE_SAND = getBlockState("white_sand");
    public static BlockState RED_MUSHROOM = Blocks.RED_MUSHROOM.getDefaultState();
    public static BlockState BROWN_MUSHROOM = Blocks.BROWN_MUSHROOM.getDefaultState();
    public static BlockState PUMPKIN = Blocks.PUMPKIN.getDefaultState();
    public static BlockState GRASS_BLOCK = Blocks.GRASS_BLOCK.getDefaultState();
    public static BlockState SUGAR_CANE = Blocks.SUGAR_CANE.getDefaultState();
    public static BlockState CLAY = Blocks.CLAY.getDefaultState();
    public static BlockState COARSE_DIRT = Blocks.COARSE_DIRT.getDefaultState();
    public static BlockState GRASS = Blocks.GRASS.getDefaultState();
    public static BlockState FERN = Blocks.FERN.getDefaultState();
    public static BlockState SHORT_GRASS = getBlockState("short_grass");
    public static BlockState WHEATGRASS = getBlockState("wheatgrass");
    public static BlockState FLOWERY_GRASS = getBlockState("flowery_grass");
    public static BlockState PURPLE_MOOR_GRASS = getBlockState("purple_moor_grass");
    public static BlockState RED_MOOR_GRASS = getBlockState("red_moor_grass");
    public static BlockState THISTLE = getBlockState("thistle");
    public static BlockState NETTLES = getBlockState("nettles");
    public static BlockState FERNSPROUT = getBlockState("fernsprout");
    public static BlockState WILD_FLAX = getBlockState("wild_flax");
    public static BlockState ARID_GRASS = getBlockState("arid_grass");
    public static BlockState CLOVER = getBlockState("clover").with(CloverBlock.CLOVERS, 1);
    public static BlockState CLOVER_2 = getBlockState("clover").with(CloverBlock.CLOVERS, 2);
    public static BlockState CLOVER_3 = getBlockState("clover").with(CloverBlock.CLOVERS, 3);
    public static BlockState CLOVER_4 = getBlockState("clover").with(CloverBlock.CLOVERS, 4);
    public static BlockState FOUR_LEAF_CLOVER = getBlockState("four_leaf_clover");
    public static BlockState SIMBELMYNE = getBlockState("simbelmyne");
    public static BlockState SUNFLOWER = Blocks.SUNFLOWER.getDefaultState();
    public static BlockState WILD_PIPEWEED = getBlockState("wild_pipeweed");
    public static BlockState OAK_LOG = Blocks.OAK_LOG.getDefaultState();
    public static BlockState OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState();
    public static BlockState CYPRESS_LOG = getBlockState("cypress_log");
    public static BlockState GREEN_OAK_LOG = getBlockState("green_oak_log");
    public static BlockState HOLLY_LOG = getBlockState("holly_log");
    public static BlockState LARCH_LOG = getBlockState("larch_log");
    public static BlockState FIR_LOG = getBlockState("fir_log");
    public static BlockState LAIRELOSSE_LOG = getBlockState("lairelosse_log");
    public static BlockState ASPEN_LOG = getBlockState("aspen_log");
    public static BlockState MAPLE_LOG = getBlockState("maple_log");
    public static BlockState LEBETHRON_LOG = getBlockState("lebethron_log");
    public static BlockState APPLE_LOG = getBlockState("apple_log");
    public static BlockState PEAR_LOG = getBlockState("pear_log");
    public static BlockState CHERRY_LOG = getBlockState("cherry_log");
    public static BlockState BEECH_LOG = getBlockState("beech_log");
    public static BlockState MALLORN_LOG = getBlockState("mallorn_log");
    public static BlockState PINE_LOG = getBlockState("pine_log");
    public static BlockState BIRCH_LOG = Blocks.BIRCH_LOG.getDefaultState();
    public static BlockState SPRUCE_LOG = Blocks.SPRUCE_LOG.getDefaultState();
    public static BlockState BIRCH_LEAVES = Blocks.BIRCH_LEAVES.getDefaultState();
    public static BlockState PINE_LEAVES = getBlockState("pine_leaves");
    public static BlockState MALLORN_LEAVES = getBlockState("mallorn_leaves");
    public static BlockState BEECH_LEAVES = getBlockState("beech_leaves");
    public static BlockState LEBETHRON_LEAVES = getBlockState("lebethron_leaves");
    public static BlockState MAPLE_LEAVES = getBlockState("maple_leaves");
    public static BlockState APPLE_LEAVES = getBlockState("apple_leaves");
    public static BlockState APPLE_LEAVES_RED = getBlockState("apple_leaves_red");
    public static BlockState APPLE_LEAVES_GREEN = getBlockState("apple_leaves_green");
    public static BlockState PEAR_LEAVES = getBlockState("pear_leaves");
    public static BlockState PEAR_LEAVES_FRUIT = getBlockState("pear_leaves_fruit");
    public static BlockState CHERRY_LEAVES_FRUIT = getBlockState("cherry_leaves_fruit");
    public static BlockState CHERRY_LEAVES = getBlockState("cherry_leaves");
    public static BlockState ASPEN_LEAVES = getBlockState("aspen_leaves");
    public static BlockState LARCH_LEAVES = getBlockState("larch_leaves");
    public static BlockState FIR_LEAVES = getBlockState("fir_leaves");
    public static BlockState HOLLY_LEAVES = getBlockState("holly_leaves");
    public static BlockState CYPRESS_LEAVES = getBlockState("cypress_leaves");
    public static BlockState RED_OAK_LEAVES = getBlockState("red_oak_leaves");
    public static BlockState GREEN_OAK_LEAVES = getBlockState("green_oak_leaves");
    public static BlockState CEDAR_LEAVES = getBlockState("cedar_leaves");
    public static BlockState MIRK_OAK_LEAVES = getBlockState("mirk_oak_leaves");
    public static BlockState GREEN_OAK_WOOD = getBlockState("green_oak_wood");
    public static BlockState CEDAR_WOOD = getBlockState("cedar_wood");
    public static BlockState MIRK_OAK_LOG = getBlockState("mirk_oak_log");
    public static BlockState CEDAR_LOG = getBlockState("cedar_log");
    public static BlockState LAIRELOSSE_LEAVES = getBlockState("lairelosse_log");
    public static BlockState BEECH_WOOD = getBlockState("beech_wood");
    public static BlockState OAK_WOOD = Blocks.OAK_WOOD.getDefaultState();
    public static BlockState SPRUCE_WOOD = Blocks.SPRUCE_WOOD.getDefaultState();
    public static BlockState BIRCH_WOOD = Blocks.BIRCH_WOOD.getDefaultState();
    public static BlockState CHARRED_LOG = getBlockState("charred_log");
    public static BlockState CHARRED_WOOD = getBlockState("charred_wood");
    public static BlockState MALLORN_WOOD = getBlockState("mallorn_wood");
    public static BlockState MIRK_OAK_WOOD = getBlockState("mirk_oak_wood");
    public static BlockState OAK_STRIPPED_LOG = Blocks.STRIPPED_OAK_LOG.getDefaultState();
    public static BlockState BEECH_STRIPPED_LOG = getBlockState("stripped_beech_log");

    public static FoliagePlacerType<AspenFoliagePlacer> ASPEN_FOLIAGE = FoliagePlacerTypeInvoker.invokeRegister("lotr:aspen_foliage", AspenFoliagePlacer.CODEC);
    public static FoliagePlacerType<FirFoliagePlacer> FIR_FOLIAGE = FoliagePlacerTypeInvoker.invokeRegister("lotr:fir_foliage", FirFoliagePlacer.CODEC);
    public static FoliagePlacerType<LOTRPineFoliagePlacer> LOTR_PINE_FOLIAGE = FoliagePlacerTypeInvoker.invokeRegister("lotr:lotr_pine_foliage", LOTRPineFoliagePlacer.CODEC);
    public static FoliagePlacerType<ShirePineFoliagePlacer> SHIRE_PINE_FOLIAGE = FoliagePlacerTypeInvoker.invokeRegister("lotr:shire_pine_foliage", ShirePineFoliagePlacer.CODEC);
    public static FoliagePlacerType<LairelosseFoliagePlacer> LAIRELOSSE_FOLIAGE = FoliagePlacerTypeInvoker.invokeRegister("lotr:lairelosse_foliage", LairelosseFoliagePlacer.CODEC);
    public static FoliagePlacerType<HollyFoliagePlacer> HOLLY_FOLIAGE = FoliagePlacerTypeInvoker.invokeRegister("lotr:holly_foliage", HollyFoliagePlacer.CODEC);
    public static FoliagePlacerType<CypressFoliagePlacer> CYPRESS_FOLIAGE = FoliagePlacerTypeInvoker.invokeRegister("lotr:cypress_foliage", CypressFoliagePlacer.CODEC);

    public static TreeDecoratorType<PineBranchDecorator> PINE_BRANCH = TreeDecoratorTypeInvoker.invokeRegister("lotr:pine_branch_decorator", PineBranchDecorator.CODEC);
    public static TreeDecoratorType<PineStripDecorator> PINE_STRIP = TreeDecoratorTypeInvoker.invokeRegister("lotr:pine_strip_decorator", PineStripDecorator.CODEC);
    public static TreeDecoratorType<MirkOakWebsDecorator> MIRK_WEBS = TreeDecoratorTypeInvoker.invokeRegister("lotr:mirk_webs_decorator", MirkOakWebsDecorator.CODEC);

    public static RandomPatchFeatureConfig RED_MUSHROOM_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(RED_MUSHROOM), new SimpleBlockPlacer())).tries(64).cannotProject().build();
    public static RandomPatchFeatureConfig BROWN_MUSHROOM_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(BROWN_MUSHROOM), new SimpleBlockPlacer())).tries(64).cannotProject().build();
    public static SpringFeatureConfig WATER_SPRING_CONFIG = new SpringFeatureConfig(Fluids.WATER.getDefaultState(), true, 4, 1, springStoneSet);
    public static SpringFeatureConfig LAVA_SPRING_CONFIG = new SpringFeatureConfig(Fluids.LAVA.getDefaultState(), true, 4, 1, springStoneSet);
    public static RandomPatchFeatureConfig PUMPKIN_PATCH_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(PUMPKIN), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(GRASS_BLOCK.getBlock())).cannotProject().build();
    public static RandomPatchFeatureConfig SUGAR_CANE_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(SUGAR_CANE), new ColumnPlacer(2, 2))).tries(20).spreadX(4).spreadY(0).spreadZ(4).cannotProject().needsWater().build();
    public static RandomPatchFeatureConfig GRASS_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(GRASS), new SimpleBlockPlacer())).tries(32).build();
    public static RandomPatchFeatureConfig FERN_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(FERN), new SimpleBlockPlacer())).tries(32).build();
    public static RandomPatchFeatureConfig SHORT_GRASS_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(SHORT_GRASS), new SimpleBlockPlacer())).tries(32).build();
    public static RandomPatchFeatureConfig WHEATGRASS_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(WHEATGRASS), new SimpleBlockPlacer())).tries(32).build();
    public static RandomPatchFeatureConfig FLOWERY_GRASS_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(FLOWERY_GRASS), new SimpleBlockPlacer())).tries(32).build();
    public static RandomPatchFeatureConfig PURPLE_MOOR_GRASS_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(PURPLE_MOOR_GRASS), new SimpleBlockPlacer())).tries(100).build();
    public static RandomPatchFeatureConfig RED_MOOR_GRASS_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(RED_MOOR_GRASS), new SimpleBlockPlacer())).tries(100).build();
    public static RandomPatchFeatureConfig THISTLE_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(THISTLE), new SimpleBlockPlacer())).tries(32).build();
    public static RandomPatchFeatureConfig NETTLES_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(NETTLES), new SimpleBlockPlacer())).tries(32).build();
    public static RandomPatchFeatureConfig FERNSPROUT_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(FERNSPROUT), new SimpleBlockPlacer())).tries(32).build();
    public static RandomPatchFeatureConfig WILD_FLAX_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(WILD_FLAX), new SimpleBlockPlacer())).tries(32).build();
    public static RandomPatchFeatureConfig ARID_GRASS_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(ARID_GRASS), new SimpleBlockPlacer())).tries(32).build();
    public static RandomPatchFeatureConfig CLOVER_CONFIG = (new RandomPatchFeatureConfig.Builder((new WeightedBlockStateProvider()).addState(CLOVER, 1250).addState(CLOVER_2, 1250).addState(CLOVER_3, 1250).addState(CLOVER_4, 1250).addState(FOUR_LEAF_CLOVER, 1), new SimpleBlockPlacer())).tries(32).build();
    public static RandomPatchFeatureConfig SHIRE_CLOVER_CONFIG = (new RandomPatchFeatureConfig.Builder((new WeightedBlockStateProvider()).addState(CLOVER, 1250).addState(CLOVER_2, 1250).addState(CLOVER_3, 1250).addState (CLOVER_4, 1250).addState(FOUR_LEAF_CLOVER, 10), new SimpleBlockPlacer())).tries(32).build();
    public static RandomPatchFeatureConfig SIMBELMYNE_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(SIMBELMYNE), new SimpleBlockPlacer())).tries(64).build();
    public static RandomPatchFeatureConfig SUNFLOWER_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(SUNFLOWER), new DoublePlantPlacer())).tries(64).cannotProject().build();
    public static RandomPatchFeatureConfig WILD_PIPEWEED_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(WILD_PIPEWEED), new SimpleBlockPlacer())).tries(64).build();

    //TODO: Check foliage placer changes, FEATURE SIZE, add sapling gen (also with mixins for vanilla)
    //Dead Tree
    public static TreeFeatureConfig OAK_DEAD = (new DeadTreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_WOOD), new BlobFoliagePlacer(UniformIntDistribution.of(0), UniformIntDistribution.of(0), 0), new StraightTrunkPlacer(2,4,0), new TwoLayersFeatureSize(1,0,1), new SimpleBlockStateProvider(OAK_WOOD))).build();
    public static TreeFeatureConfig SPRUCE_DEAD = (new DeadTreeFeatureConfig.Builder(new SimpleBlockStateProvider(SPRUCE_LOG), new SimpleBlockStateProvider(SPRUCE_WOOD), new BlobFoliagePlacer(UniformIntDistribution.of(0), UniformIntDistribution.of(0), 0), new StraightTrunkPlacer(2,4,0), new TwoLayersFeatureSize(1,0,1), new SimpleBlockStateProvider(SPRUCE_WOOD))).build();
    public static TreeFeatureConfig BIRCH_DEAD = (new DeadTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BIRCH_LOG), new SimpleBlockStateProvider(BIRCH_WOOD), new BlobFoliagePlacer(UniformIntDistribution.of(0), UniformIntDistribution.of(0), 0), new StraightTrunkPlacer(2,4,0), new TwoLayersFeatureSize(1,0,1), new SimpleBlockStateProvider(BIRCH_WOOD))).build();
    public static TreeFeatureConfig CHARRED_TREE = (new DeadTreeFeatureConfig.Builder(new SimpleBlockStateProvider(CHARRED_LOG), new SimpleBlockStateProvider(CHARRED_WOOD), new BlobFoliagePlacer(UniformIntDistribution.of(0), UniformIntDistribution.of(0), 0), new StraightTrunkPlacer(2,4,0), new TwoLayersFeatureSize(1,0,1), new SimpleBlockStateProvider(CHARRED_WOOD))).build();
    public static TreeFeatureConfig BEECH_DEAD = (new DeadTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BEECH_LOG), new SimpleBlockStateProvider(BEECH_WOOD), new BlobFoliagePlacer(UniformIntDistribution.of(0), UniformIntDistribution.of(0), 0), new StraightTrunkPlacer(2,4,0), new TwoLayersFeatureSize(1,0,1), new SimpleBlockStateProvider(BEECH_WOOD))).build();
    //State Pools
    public static BlockStateProvider APPLE_LEAVES_RED_POOL = (new WeightedBlockStateProvider()).addState(APPLE_LEAVES, 15).addState(APPLE_LEAVES_RED, 1);
    public static BlockStateProvider APPLE_LEAVES_GREEN_POOL = (new WeightedBlockStateProvider()).addState(APPLE_LEAVES, 15).addState(APPLE_LEAVES_GREEN, 1);
    public static BlockStateProvider APPLE_LEAVES_MIX_POOL = (new WeightedBlockStateProvider()).addState(APPLE_LEAVES, 30).addState(APPLE_LEAVES_RED, 1).addState(APPLE_LEAVES_GREEN, 1);
    public static BlockStateProvider PEAR_LEAVES_POOL = (new WeightedBlockStateProvider()).addState(PEAR_LEAVES, 15).addState(PEAR_LEAVES_FRUIT, 1);
    public static BlockStateProvider CHERRY_LEAVES_POOL = (new WeightedBlockStateProvider()).addState(CHERRY_LEAVES, 7).addState(CHERRY_LEAVES_FRUIT, 1);
    //Oak Sapling
    public static TreeFeatureConfig OAK_TREE_TALL = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(7,5,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().build();
    public static TreeFeatureConfig OAK_TREE_TALL_BEES = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(7,5,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    public static TreeFeatureConfig OAK_DESERT = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(3,2,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().build();
    public static TreeFeatureConfig OAK_DESERT_BEES = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(3,2,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    public static TreeFeatureConfig OAK_FANGORN = (new ExtendedTreeConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(10,0,0), new TwoLayersFeatureSize(1,0,1))).strippedLog(new SimpleBlockStateProvider(OAK_STRIPPED_LOG)).woodProvider(new SimpleBlockStateProvider(OAK_WOOD)).ignoreVines().decorators(ImmutableList.of(new TrunkVineTreeDecorator(), new LeaveVineTreeDecorator())).build();
    public static TreeFeatureConfig OAK_SHRUB = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(1), UniformIntDistribution.of(1), 1), new StraightTrunkPlacer(4,0,0), new TwoLayersFeatureSize(1,0,1))).build();
    //Birch Sapling
    public static TreeFeatureConfig BIRCH_TREE_FANCY = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BIRCH_LOG), new SimpleBlockStateProvider(BIRCH_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(0), UniformIntDistribution.of(0), 0), new StraightTrunkPlacer(1,0,0), new TwoLayersFeatureSize(1,0,1))).build();
    public static TreeFeatureConfig BIRCH_TREE_FANCY_BEES = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BIRCH_LOG), new SimpleBlockStateProvider(BIRCH_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(0), UniformIntDistribution.of(0), 0), new StraightTrunkPlacer(1,0,0), new TwoLayersFeatureSize(1,0,1))).decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    public static TreeFeatureConfig BIRCH_TREE_ALT = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BIRCH_LOG), new SimpleBlockStateProvider(BIRCH_LEAVES), new AspenFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0)), new StraightTrunkPlacer(8,8,0), new TwoLayersFeatureSize(1,0,1)))/*.trunkTopOffset(2).trunkHeight(2).trunkHeightRandom(2)*/.ignoreVines().build();
    public static TreeFeatureConfig BIRCH_TREE_ALT_BEES = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BIRCH_LOG), new SimpleBlockStateProvider(BIRCH_LEAVES), new AspenFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0)), new StraightTrunkPlacer(8,8,0), new TwoLayersFeatureSize(1,0,1)))/*.trunkTopOffset(2).trunkHeight(2).trunkHeightRandom(2)*/.ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    //Pine Sapling
    public static TreeFeatureConfig PINE_TREE = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(PINE_LOG), new SimpleBlockStateProvider(PINE_LEAVES), new LOTRPineFoliagePlacer(UniformIntDistribution.of(3), UniformIntDistribution.of(0)), new StraightTrunkPlacer(12,12,0), new TwoLayersFeatureSize(1,0,1)))/*.trunkTopOffset(1).foliageHeight(6).foliageHeightRandom(6)*/.ignoreVines().decorators(ImmutableList.of(new PineBranchDecorator(PINE_LOG, 0.33F), new PineStripDecorator(0.1F, 0.3F, 0.7F))).build();
    public static TreeFeatureConfig SHIRE_PINE_TREE = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(PINE_LOG), new SimpleBlockStateProvider(PINE_LEAVES), new ShirePineFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(1)), new StraightTrunkPlacer(10,10,0), new TwoLayersFeatureSize(1,0,1)))/*.trunkTopOffset(1).foliageHeight(6).foliageHeightRandom(3)*/.ignoreVines().decorators(ImmutableList.of(new PineBranchDecorator(PINE_LOG, 0.33F), new PineStripDecorator(0.1F, 0.3F, 0.7F))).build();
    public static TreeFeatureConfig PINE_SHRUB = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(PINE_LOG), new SimpleBlockStateProvider(PINE_LEAVES),new BlobFoliagePlacer(UniformIntDistribution.of(0), UniformIntDistribution.of(0), 0) , new StraightTrunkPlacer(4,0,0), new TwoLayersFeatureSize(1,0,1))).build();
    //Mallorn Sapling       TODO: Check Boughs if really needs Forking trunk placer
    public static TreeFeatureConfig MALLORN_TREE = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(MALLORN_LOG), new SimpleBlockStateProvider(MALLORN_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(6,3,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().build();
    public static TreeFeatureConfig MALLORN_TREE_BEES = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(MALLORN_LOG), new SimpleBlockStateProvider(MALLORN_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(6,3,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    public static TreeFeatureConfig MALLORN_TREE_BOUGHS = (new ExtendedTreeConfig.Builder(new SimpleBlockStateProvider(MALLORN_LOG), new SimpleBlockStateProvider(MALLORN_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 0), new ForkingTrunkPlacer(10,4,0), new TwoLayersFeatureSize(1,0,1))).woodProvider(new SimpleBlockStateProvider(MALLORN_WOOD)).ignoreVines().build();
    //Mirk Oak Sapling      TODO: Check trunk placer
    public static TreeFeatureConfig MIRK_OAK_TREE = (new ExtendedTreeConfig.Builder(new SimpleBlockStateProvider(MIRK_OAK_LOG), new SimpleBlockStateProvider(MIRK_OAK_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 0), new StraightTrunkPlacer(4,5,0), new TwoLayersFeatureSize(1,0,1))).woodProvider(new SimpleBlockStateProvider(MIRK_OAK_WOOD)).isMirky(true).ignoreVines().decorators(ImmutableList.of(new MirkOakWebsDecorator(true, 0.25F, 0.1F, 0.15F), new MirkOakWebsDecorator(true, 0.05F, 0.35F, 0.2F), new LeaveVineTreeDecorator())).build();
    //Apple Sapling
    public static TreeFeatureConfig APPLE_TREE_RED = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(APPLE_LOG), APPLE_LEAVES_RED_POOL, new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(4,3,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().build();
    public static TreeFeatureConfig APPLE_TREE_RED_BEES = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(APPLE_LOG), APPLE_LEAVES_RED_POOL, new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(4,3,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    public static TreeFeatureConfig APPLE_TREE_GREEN = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(APPLE_LOG), APPLE_LEAVES_GREEN_POOL, new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(4,3,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().build();
    public static TreeFeatureConfig APPLE_TREE_GREEN_BEES = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(APPLE_LOG), APPLE_LEAVES_GREEN_POOL, new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(4,3,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    public static TreeFeatureConfig APPLE_TREE_MIX = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(APPLE_LOG), APPLE_LEAVES_MIX_POOL, new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(4,3,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().build();
    public static TreeFeatureConfig APPLE_TREE_MIX_BEES = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(APPLE_LOG), APPLE_LEAVES_MIX_POOL, new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(4,3,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    //Pear Sapling
    public static TreeFeatureConfig PEAR_TREE = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(PEAR_LOG), PEAR_LEAVES_POOL, new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(4,1,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().build();
    public static TreeFeatureConfig PEAR_TREE_BEES = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(PEAR_LOG), PEAR_LEAVES_POOL, new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(4,1,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    //Cherry Sapling
    public static TreeFeatureConfig CHERRY_TREE = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CHERRY_LOG), CHERRY_LEAVES_POOL, new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(4,4,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().build();
    public static TreeFeatureConfig CHERRY_TREE_BEES = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CHERRY_LOG), CHERRY_LEAVES_POOL, new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(4,4,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    //Lebethron Sapling
    public static TreeFeatureConfig LEBETHRON_TREE = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(LEBETHRON_LOG), new SimpleBlockStateProvider(LEBETHRON_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(5,4,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().build();
    public static TreeFeatureConfig LEBETHRON_TREE_BEES = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(LEBETHRON_LOG), new SimpleBlockStateProvider(LEBETHRON_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(5,4,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    public static TreeFeatureConfig LEBETHRON_TREE_FANCY = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(LEBETHRON_LOG), new SimpleBlockStateProvider(LEBETHRON_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(0), UniformIntDistribution.of(0), 0), new StraightTrunkPlacer(1,0,0), new TwoLayersFeatureSize(1,0,1))).build();
    public static TreeFeatureConfig LEBETHRON_TREE_FANCY_BEES = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(LEBETHRON_LOG), new SimpleBlockStateProvider(LEBETHRON_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(0), UniformIntDistribution.of(0), 0), new StraightTrunkPlacer(1,0,0), new TwoLayersFeatureSize(1,0,1))).decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    //Beech Sapling
    public static TreeFeatureConfig BEECH_TREE = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BEECH_LOG), new SimpleBlockStateProvider(BEECH_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(5,4,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().build();
    public static TreeFeatureConfig BEECH_TREE_BEES = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BEECH_LOG), new SimpleBlockStateProvider(BEECH_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(5,4,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    public static TreeFeatureConfig BEECH_TREE_FANCY = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BEECH_LOG), new SimpleBlockStateProvider(BEECH_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(0), UniformIntDistribution.of(0), 0), new StraightTrunkPlacer(1,0,0), new TwoLayersFeatureSize(1,0,1))).build();
    public static TreeFeatureConfig BEECH_TREE_FANCY_BEES = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BEECH_LOG), new SimpleBlockStateProvider(BEECH_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(0), UniformIntDistribution.of(0), 0), new StraightTrunkPlacer(1,0,0), new TwoLayersFeatureSize(1,0,1))).decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    public static TreeFeatureConfig BEECH_FANGORN = (new ExtendedTreeConfig.Builder(new SimpleBlockStateProvider(BEECH_LOG), new SimpleBlockStateProvider(BEECH_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0),0), new StraightTrunkPlacer(1,0,0), new TwoLayersFeatureSize(1,0,1))).woodProvider(new SimpleBlockStateProvider(BEECH_WOOD)).strippedLog(new SimpleBlockStateProvider(BEECH_STRIPPED_LOG)).ignoreVines().decorators(ImmutableList.of(new TrunkVineTreeDecorator(), new LeaveVineTreeDecorator())).build();
    //Maple Sapling
    public static TreeFeatureConfig MAPLE_TREE = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(MAPLE_LOG), new SimpleBlockStateProvider(MAPLE_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(4,4,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().build();
    public static TreeFeatureConfig MAPLE_TREE_BEES = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(MAPLE_LOG), new SimpleBlockStateProvider(MAPLE_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(4,4,0), new TwoLayersFeatureSize(1,0,1))).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    public static TreeFeatureConfig MAPLE_TREE_FANCY = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(MAPLE_LOG), new SimpleBlockStateProvider(MAPLE_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(0), UniformIntDistribution.of(0), 0), new StraightTrunkPlacer(1,0,0), new TwoLayersFeatureSize(1,0,1))).build();
    public static TreeFeatureConfig MAPLE_TREE_FANCY_BEES = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(MAPLE_LOG), new SimpleBlockStateProvider(MAPLE_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(0), UniformIntDistribution.of(0), 0), new StraightTrunkPlacer(1,0,0), new TwoLayersFeatureSize(1,0,1))).decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    //Aspen Sapling
    public static TreeFeatureConfig ASPEN_TREE = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ASPEN_LOG), new SimpleBlockStateProvider(ASPEN_LEAVES), new AspenFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0)), new StraightTrunkPlacer(8,7,0), new TwoLayersFeatureSize(1,0,1)))/*.trunkTopOffset(2).trunkHeight(2).trunkHeightRandom(2)*/.ignoreVines().build();
    //Lairelosse Sapling
    public static TreeFeatureConfig LAIRELOSSE_TREE = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(LAIRELOSSE_LOG), new SimpleBlockStateProvider(LAIRELOSSE_LEAVES), new LairelosseFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0)), new StraightTrunkPlacer(5,3,0), new TwoLayersFeatureSize(1,0,1)))/*.trunkTopOffset(1).trunkHeight(1).trunkHeightRandom(2)*/.ignoreVines().build();
    //Cedar Sapling
    public static TreeFeatureConfig CEDAR_TREE = (new ExtendedTreeConfig.Builder(new SimpleBlockStateProvider(CEDAR_LOG), new SimpleBlockStateProvider(CEDAR_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 0), new ForkingTrunkPlacer(10,6,0), new TwoLayersFeatureSize(1,0,1))).woodProvider(new SimpleBlockStateProvider(CEDAR_WOOD)).ignoreVines().build();
    public static TreeFeatureConfig CEDAR_TREE_LARGE = (new ExtendedTreeConfig.Builder(new SimpleBlockStateProvider(CEDAR_LOG), new SimpleBlockStateProvider(CEDAR_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 0), new ForkingTrunkPlacer(15,15,0), new TwoLayersFeatureSize(1,0,1))).woodProvider(new SimpleBlockStateProvider(CEDAR_WOOD)).ignoreVines().build();
    //Fir Sapling
    public static TreeFeatureConfig FIR_TREE = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(FIR_LOG), new SimpleBlockStateProvider(FIR_LEAVES), new FirFoliagePlacer(UniformIntDistribution.of(3), UniformIntDistribution.of(0)), new StraightTrunkPlacer(6,7,0), new TwoLayersFeatureSize(1,0,1)))/*.trunkTopOffset(2).foliageHeight(7).foliageHeightRandom(4)*/.ignoreVines().build();
    //Larch Sapling
    public static TreeFeatureConfig LARCH_TREE = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(LARCH_LOG), new SimpleBlockStateProvider(LARCH_LEAVES), new SpruceFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(1), UniformIntDistribution.of(8)), new StraightTrunkPlacer(8,8,0), new TwoLayersFeatureSize(1,0,1)))/*.trunkTopHeightOffset(2).trunkHeight(2).trunkHeightRandom(1)*/.ignoreVines().build();
    //Holly Sapling
    public static TreeFeatureConfig HOLLY_TREE = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(HOLLY_LOG), new SimpleBlockStateProvider(HOLLY_LEAVES), new HollyFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0)), new StraightTrunkPlacer(9,5,0), new TwoLayersFeatureSize(1,0,1)))/*.trunkTopOffset(0).trunkHeight(1).trunkHeightRandom(2)*/.ignoreVines().build();
    public static TreeFeatureConfig HOLLY_TREE_BEES = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(HOLLY_LOG), new SimpleBlockStateProvider(HOLLY_LEAVES), new HollyFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0)), new StraightTrunkPlacer(9,5,0), new TwoLayersFeatureSize(1,0,1)))/*.trunkTopOffset(0).trunkHeight(1).trunkHeightRandom(2)*/.ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    //Green Oak Sapling
    public static TreeFeatureConfig GREEN_OAK_TREE = (new ExtendedTreeConfig.Builder(new SimpleBlockStateProvider(GREEN_OAK_LOG), new SimpleBlockStateProvider(GREEN_OAK_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 0), new StraightTrunkPlacer(4,4,0), new TwoLayersFeatureSize(1,0,1))).woodProvider(new SimpleBlockStateProvider(GREEN_OAK_WOOD)).ignoreVines().build();
    public static TreeFeatureConfig GREEN_OAK_TREE_BEES = (new ExtendedTreeConfig.Builder(new SimpleBlockStateProvider(GREEN_OAK_LOG), new SimpleBlockStateProvider(GREEN_OAK_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 0), new StraightTrunkPlacer(4,4,0), new TwoLayersFeatureSize(1,0,1))).woodProvider(new SimpleBlockStateProvider(GREEN_OAK_WOOD)).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    //Red Oak Sapling
    public static TreeFeatureConfig RED_OAK_TREE = (new ExtendedTreeConfig.Builder(new SimpleBlockStateProvider(GREEN_OAK_LOG), new SimpleBlockStateProvider(RED_OAK_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 0), new StraightTrunkPlacer(6,3,0), new TwoLayersFeatureSize(1,0,1))).woodProvider(new SimpleBlockStateProvider(GREEN_OAK_WOOD)).ignoreVines().build();
    public static TreeFeatureConfig RED_OAK_TREE_BEES = (new ExtendedTreeConfig.Builder(new SimpleBlockStateProvider(GREEN_OAK_LOG), new SimpleBlockStateProvider(RED_OAK_LEAVES), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 0), new StraightTrunkPlacer(6,3,0), new TwoLayersFeatureSize(1,0,1))).woodProvider(new SimpleBlockStateProvider(GREEN_OAK_WOOD)).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).build();
    //Cypress Sapling
    public static TreeFeatureConfig CYPRESS_TREE = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CYPRESS_LOG), new SimpleBlockStateProvider(CYPRESS_LEAVES), new CypressFoliagePlacer(UniformIntDistribution.of(1), UniformIntDistribution.of(0)), new StraightTrunkPlacer(8,5,0), new TwoLayersFeatureSize(1,0,1)))/*.trunkTopOffset(1).trunkHeight(3).trunkHeightRandom(1)*/.ignoreVines().build();

    public static void addOres(GenerationSettings.Builder builder) {
        ConfiguredFeature<?,?> f1 = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, COAL_ORE, 17)).method_30377(128).repeat(20);
        if (!isRegistered("f1_addOres")) {
            registerFeature("f1_addOres", f1);
        } else {
            f1 = getFeature("f1_addOres");
        }
        ConfiguredFeature<?,?> f2 = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, IRON_ORE, 9)).method_30377(64).repeat(20);
        if (!isRegistered("f2_addOres")) {
            registerFeature("f2_addOres", f2);
        } else {
            f2 = getFeature("f2_addOres");
        }
        ConfiguredFeature<?,?> f3 = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, COPPER_ORE, 9)).method_30377(128).repeat(16);
        if (!isRegistered("f3_addOres")) {
            registerFeature("f3_addOres", f3);
        } else {
            f3 = getFeature("f3_addOres");
        }
        ConfiguredFeature<?,?> f4 = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, TIN_ORE, 9)).method_30377(128).repeat(16);
        if (!isRegistered("f4_addOres")) {
            registerFeature("f4_addOres", f4);
        } else {
            f4 = getFeature("f4_addOres");
        }
        ConfiguredFeature<?,?> f5 = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, GOLD_ORE, 9)).method_30377(32).repeat(2);
        if (!isRegistered("f5_addOres")) {
            registerFeature("f5_addOres", f5);
        } else {
            f5 = getFeature("f5_addOres");
        }
        ConfiguredFeature<?,?> f6 = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, SILVER_ORE, 9)).method_30377(32).repeat(3);
        if (!isRegistered("f6_addOres")) {
            registerFeature("f6_addOres", f6);
        } else {
            f6 = getFeature("f6_addOres");
        }
        ConfiguredFeature<?,?> f7 = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, SULFUR_ORE, 9)).method_30377(64).repeat(2);
        if (!isRegistered("f7_addOres")) {
            registerFeature("f7_addOres", f7);
        } else {
            f7 = getFeature("f7_addOres");
        }
        ConfiguredFeature<?,?> f8 = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, NITER_ORE, 9)).method_30377(64).repeat(2);
        if (!isRegistered("f8_addOres")) {
            registerFeature("f8_addOres", f8);
        } else {
            f8 = getFeature("f8_addOres");
        }
        ConfiguredFeature<?,?> f9 = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, SALT_ORE, 13)).method_30377(64).repeat(2);
        if (!isRegistered("f9_addOres")) {
            registerFeature("f9_addOres", f9);
        } else {
            f9 = getFeature("f9_addOres");
        }
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, f1);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, f2);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, f3);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, f4);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, f5);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, f6);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, f7);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, f8);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, f9);
    }

    /*public static void addAnimals(SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SHEEP, 24, 4, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PIG, 20, 4, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.CHICKEN, 20, 4, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.COW, 16, 4, 4));
        builder.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.BAT, 10, 8, 8));
    }
    public static void addShireGrass(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.SHIRE_GRASS);
    }
    public static void addPlainsFlowers(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.POPPY_FEATURE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.DANDELION_FEATURE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.AZURE_BLUET_FEATURE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.OXEYE_DAISY_FEATURE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.CORNFLOWER_FEATURE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.RED_TULIP_FEATURE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.WHITE_TULIP_FEATURE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.ORANGE_TULIP_FEATURE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.PINK_TULIP_FEATURE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.BLUEBELL_FEATURE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.LAVENDER_FEATURE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.MARIGOLD_FEATURE);
    }
    public static void addDoubleFLowers(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.LILAC_FEATURE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.ROSE_BUSH_FEATURE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.PEONY_FEATURE);
    }
    public static void addTrees(GenerationSettings.Builder builder, Object... trees) {
        for (Object tree : trees) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, (ConfiguredFeature<?, ?>) tree);
        }
    }*/
    public static void addCarvers(GenerationSettings.Builder builder) {
        builder.carver(GenerationStep.Carver.AIR, ModCarvers.CAVE.method_28614(new ProbabilityConfig(0.14285715F)));
        builder.carver(GenerationStep.Carver.AIR, ModCarvers.CANYON.method_28614(new ProbabilityConfig(0.02F)));
    }
    public static void addMushrooms(GenerationSettings.Builder builder) {
        ConfiguredFeature<?,?> f1 = Feature.RANDOM_PATCH.configure(BROWN_MUSHROOM_CONFIG).decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(4)));
        if (!isRegistered("f1_addMushrooms")) {
            registerFeature("f1_addMushrooms", f1);
        } else {
            f1 = getFeature("f1_addMushrooms");
        }
        ConfiguredFeature<?,?> f2 = Feature.RANDOM_PATCH.configure(RED_MUSHROOM_CONFIG).decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(8)));
        if (!isRegistered("f2_addMushrooms")) {
            registerFeature("f2_addMushrooms", f2);
        } else {
            f2 = getFeature("f2_addMushrooms");
        }
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, f1);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, f2);
    }
    public static void addFreezeTopLayer(GenerationSettings.Builder builder) {
        ConfiguredFeature<?,?> f1 = Feature.FREEZE_TOP_LAYER.configure(FeatureConfig.DEFAULT).decorate(Decorator.NOPE.configure(DecoratorConfig.DEFAULT));
        if (!isRegistered("f1_addFreezeTopLayer")) {
            registerFeature("f1_addMushrooms", f1);
        } else {
            f1 = getFeature("f1_addFreezeTopLayer");
        }
        builder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, f1);
    }
    public static void addLakes(GenerationSettings.Builder builder) {   //TODO: Finish
        float waterProb = 0.25F;
        waterProb /= 2.0F;
        float lavaProb = 0.125F;
        lavaProb /= 2.0F;
        ConfiguredFeature<?,?> f1 = Feature.LAKE.configure(new SingleStateFeatureConfig(WATER)).applyChance((int)(waterProb*100)).method_30377(62);
        if (!isRegistered("f1_addLakes")) {
            registerFeature("f1_addLakes", f1);
        } else {
            f1 = getFeature("f1_addLakes");
        }
        ConfiguredFeature<?,?> f2 = Feature.LAKE.configure(new SingleStateFeatureConfig(LAVA)).applyChance((int)(lavaProb*100)).decorate(Decorator.RANGE_VERY_BIASED.configure(new RangeDecoratorConfig(8, 8, 62)));
        if (!isRegistered("f2_addLakes")) {
            registerFeature("f2_addLakes", f2);
        } else {
            f2 = getFeature("f2_addLakes");
        }
        builder.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, f1);
        builder.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, f2);
    }
    public static void addDirtGravel(GenerationSettings.Builder builder) {
        ConfiguredFeature<?,?> f1 = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, DIRT, 33)).method_30377(256).repeat(10);
        if (!isRegistered("f1_addDirtGravel")) {
            registerFeature("f1_addDirtGravel", f1);
        } else {
            f1 = getFeature("f1_addDirtGravel");
        }
        ConfiguredFeature<?,?> f2 = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, GRAVEL, 33)).method_30377(256).repeat(8);
        if (!isRegistered("f2_addDirtGravel")) {
            registerFeature("f2_addDirtGravel", f2);
        } else {
            f2 = getFeature("f2_addDirtGravel");
        }
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, f1);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, f2);
    }
    public static void addGranite(GenerationSettings.Builder builder) {
        addStoneVariety(builder, GRANITE, 5, 80);
    }
    private static void addStoneVariety(GenerationSettings.Builder builder, BlockState stone, int freq, int height) {
        ConfiguredFeature<?,?> f1 = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, stone, 61)).method_30377(height).repeat(freq);
        if (!isRegistered("f1_addStoneVariety_"+stone.getBlock().toString()+"_"+freq+"_"+height)) {
            registerFeature("f1_addStoneVariety_"+stone.getBlock().toString()+"_"+freq+"_"+height, f1);
        } else {
            f1 = getFeature("f1_addStoneVariety_"+stone.getBlock().toString()+"_"+freq+"_"+height);
        }
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, f1);
    }
    public static void addDripstones(GenerationSettings.Builder builder) {
        addDripstones(builder, null);
    }
    public static void addDripstones(GenerationSettings.Builder builder, Dripstone block) {
        addDripstones(builder, null, 3);
    }
    //TODO: FIX CODEC
    public static void addDripstones(GenerationSettings.Builder builder, Dripstone block, int freq) {
        DripstoneFeatureConfig config = new DripstoneFeatureConfig(64, 8, 4, 8, 0.33F, block == null ? Blocks.BEDROCK.getDefaultState() : block.getDefaultState());
        ConfiguredFeature<?,?> f1 = dripstone().configure(config).method_30377(60).repeat(freq);
        if (!isRegistered("f1_addDripstones_"+(block == null ? "null" : block.toString())+"_"+freq)) {
            registerFeature("f1_addDripstones_"+(block == null ? "null" : block.toString())+"_"+freq, f1);
        } else {
            f1 = getFeature("f1_addDripstones_"+(block == null ? "null" : block.toString())+"_"+freq);
        }
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, f1);
    }
    public static void addCobwebs(GenerationSettings.Builder builder) {
        addCobwebs(builder, 0.5F, COBWEB);
    }

    public static void addCobwebs(GenerationSettings.Builder builder, float chance, BlockState webBlock) {      //TODO: Finish
        CobwebFeatureConfig config = new CobwebFeatureConfig(64, 6, 4, 6, new SimpleBlockStateProvider(webBlock));
        ConfiguredFeature<?,?> f1 = cobwebs().configure(config).method_30377(60).decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig((int)(chance*100))));
        if (!isRegistered("f1_addCobwebs_"+chance+"_"+webBlock.getBlock().toString())) {
            registerFeature("f1_addCobwebs_"+chance+"_"+webBlock.getBlock().toString(), f1);
        } else {
            f1 = getFeature("f1_addCobwebs_"+chance+"_"+webBlock.getBlock().toString());
        }
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, f1);
    }
    public static void addClayGravelSediments(GenerationSettings.Builder builder) {
        ConfiguredFeature<?,?> f1 = Feature.DISK.configure(new DiskFeatureConfig(CLAY, UniformIntDistribution.of(4), 1, Lists.newArrayList(DIRT, COARSE_DIRT, CLAY))).repeat(1).decorate(ConfiguredFeatures.Decorators.SQUARE_TOP_SOLID_HEIGHTMAP);
        if (!isRegistered("f1_addClayGravelSediments")) {
            registerFeature("f1_addClayGravelSediments", f1);
        } else {
            f1 = getFeature("f1_addClayGravelSediments");
        }
        ConfiguredFeature<?,?> f2 = Feature.DISK.configure(new DiskFeatureConfig(GRAVEL, UniformIntDistribution.of(6), 2, Lists.newArrayList(DIRT, COARSE_DIRT, GRASS_BLOCK))).repeat(1).decorate(ConfiguredFeatures.Decorators.SQUARE_TOP_SOLID_HEIGHTMAP);
        if (!isRegistered("f2_addClayGravelSediments")) {
            registerFeature("f2_addClayGravelSediments", f2);
        } else {
            f2 = getFeature("f2_addClayGravelSediments");
        }
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, f1);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, f2);
    }
    public static void addSandSediments(GenerationSettings.Builder builder) {
        addSandSediments(builder, SAND);
    }
    public static void addWhiteSandSediments(GenerationSettings.Builder builder) {
        addSandSediments(builder, WHITE_SAND);
    }
    public static void addSandSediments(GenerationSettings.Builder builder, BlockState sandBlock) {
        int freq = 3;
        ConfiguredFeature<?,?> f1 = Feature.DISK.configure(new DiskFeatureConfig(sandBlock, UniformIntDistribution.of(7), 2, Lists.newArrayList(DIRT, COARSE_DIRT, GRASS_BLOCK))).repeat(freq);
        if (!isRegistered("f1_addSandSediments_"+sandBlock.getBlock().toString())) {
            registerFeature("f1_addSandSediments_"+sandBlock.getBlock().toString(), f1);
        } else {
            f1 = getFeature("f1_addSandSediments_"+sandBlock.getBlock().toString());
        }
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, f1);
    }
    public static void addReeds(GenerationSettings.Builder builder) {
        addReedsMultiplier(builder, 1);
    }
    public static void addMoreReeds(GenerationSettings.Builder builder) {
        addReedsMultiplier(builder, 2);
    }
    public static void addReedsMultiplier(GenerationSettings.Builder builder, int freqMul) {
        int freq = 10 * freqMul;
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(SUGAR_CANE_CONFIG).decorate(ConfiguredFeatures.Decorators.HEIGHTMAP_SPREAD_DOUBLE).repeat(freq));
    }
    public static void addPumpkins(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(PUMPKIN_PATCH_CONFIG).decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(32))));
    }
    public static void addWaterSprings(GenerationSettings.Builder builder) {
        addWaterSprings(builder, 50);
    }
    public static void addWaterSprings(GenerationSettings.Builder builder, int freq) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SPRING_FEATURE.configure(WATER_SPRING_CONFIG).decorate(Decorator.RANGE_VERY_BIASED.configure(new RangeDecoratorConfig(8, 8, 256)).repeat(freq)));
    }
    public static void addLavaSprings(GenerationSettings.Builder builder) {
        addLavaSprings(builder, 20);
    }
    public static void addLavaSprings(GenerationSettings.Builder builder, int freq) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SPRING_FEATURE.configure(LAVA_SPRING_CONFIG).decorate(Decorator.RANGE_VERY_BIASED.configure(new RangeDecoratorConfig(8, 16, 256))).spreadHorizontally().repeat(freq));
    }
    public static void addWaterLavaSprings(GenerationSettings.Builder builder) {
        addWaterSprings(builder);
        addLavaSprings(builder);
    }
    public static Block getBlock(String name) {
        return Registry.BLOCK.get(id(name));
    }
    public static DripstoneFeature dripstone() {
        return new DripstoneFeature(DripstoneFeatureConfig.CODEC);
    }
    public static CobwebFeature cobwebs() {
        return new CobwebFeature(CobwebFeatureConfig.CODEC);
    }
    public static void addCommonGranite(GenerationSettings.Builder builder) {
        addStoneVariety(builder, GRANITE, 12, 96);
    }
    public static void addTrees(GenerationSettings.Builder builder, int count, float increaseChance, LotrBaseBiome biome, Object... weightedTrees) {
        addTreesIncrease(builder, count, increaseChance, 1, biome, weightedTrees);
    }

    public static void addTreesWithClusters(GenerationSettings.Builder builder, int count, float increaseChance, TreeCluster cluster, LotrBaseBiome biome, Object... weightedTrees) {
        addTreesIncreaseWithClusters(builder, count, increaseChance, 1, cluster, biome, weightedTrees);
    }

    public static void addTreesIncrease(GenerationSettings.Builder builder, int count, float increaseChance, int increaseAmount, LotrBaseBiome biome, Object... weightedTrees) {
        ConfiguredDecorator<?> placement = treeClusters().configure(TreeClustersConfig.noClusters(count, increaseChance, increaseAmount));
        addTreesWithPlacement(builder, placement, weightedTrees);
        biome.updateBiomeTreeAmount((float)count + increaseChance * (float)increaseAmount);
        addLeafBushesWithPlacement(builder, treeClusters().configure(TreeClustersConfig.noClusters(count / 2, increaseChance, increaseAmount)));
    }

    public static void addTreesIncreaseWithClusters(GenerationSettings.Builder builder, int count, float increaseChance, int increaseAmount, TreeCluster cluster, LotrBaseBiome biome, Object... weightedTrees) {
        ConfiguredDecorator<?> placement = treeClusters().configure(TreeClustersConfig.withNormalClusters(count, increaseChance, increaseAmount, cluster.scale, cluster.chance));
        addTreesWithPlacement(builder, placement, weightedTrees);
        biome.updateBiomeTreeAmount((float)count + increaseChance * (float)increaseAmount);
        addLeafBushesWithPlacement(builder, treeClusters().configure(TreeClustersConfig.noClusters(count / 2, increaseChance, increaseAmount)));
    }
    public static void addTreesBelowTreeline(GenerationSettings.Builder builder, int count, float increaseChance, int treeline, LotrBaseBiome biome, Object... weightedTrees) {
        addTreesBelowTreelineIncrease(builder, count, increaseChance, 1, treeline, biome, weightedTrees);
    }
    public static void addTreesBelowTreelineIncrease(GenerationSettings.Builder builder, int count, float increaseChance, int increaseAmount, int treeline, LotrBaseBiome biome, Object... weightedTrees) {
        ConfiguredDecorator<?> placement = treeClusters().configure(TreeClustersConfig.belowTreelineNoClusters(count, increaseChance, increaseAmount, treeline));
        addTreesWithPlacement(builder, placement, weightedTrees);
        biome.updateBiomeTreeAmount((float)count + increaseChance * (float)increaseAmount);
        addLeafBushesWithPlacement(builder, treeClusters().configure(TreeClustersConfig.belowTreelineNoClusters(count / 2, increaseChance, increaseAmount, treeline)));
    }
    public static void addTreesAboveTreeline(GenerationSettings.Builder builder, int count, float increaseChance, int treeline, Object... weightedTrees) {
        addTreesAboveTreelineIncrease(builder, count, increaseChance, 1, treeline, weightedTrees);
    }
    public static void addTreesAboveTreelineIncrease(GenerationSettings.Builder builder, int count, float increaseChance, int increaseAmount, int treeline, Object... weightedTrees) {
        ConfiguredDecorator<?> placement = treeClusters().configure(TreeClustersConfig.aboveTreelineNoClusters(count, increaseChance, increaseAmount, treeline));
        addTreesWithPlacement(builder, placement, weightedTrees);
        addLeafBushesWithPlacement(builder, treeClusters().configure(TreeClustersConfig.aboveTreelineNoClusters(count / 2, increaseChance, increaseAmount, treeline)));
    }
    public static void addTreesWithPlacement(GenerationSettings.Builder builder, ConfiguredDecorator<?> placement, Object... weightedTrees) {
        WeightedRandomFeatureConfig wrConfig = WeightedRandomFeatureConfig.fromEntries(weightedTrees);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, weightedRandom().configure(wrConfig).decorate(placement));
    }
    private static void addLeafBushesWithPlacement(GenerationSettings.Builder builder, ConfiguredDecorator<?> placement) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, leafBushes().configure(FeatureConfig.DEFAULT).decorate(placement));
    }
    public static TreeClusters treeClusters() {
        return new TreeClusters(TreeClustersConfig.CODEC);
    }
    public static WeightedRandomFeature weightedRandom() {
        return new WeightedRandomFeature(WeightedRandomFeatureConfig.CODEC);
    }
    public static LeafBushesFeature leafBushes() {
        return new LeafBushesFeature(DefaultFeatureConfig.CODEC);
    }
    public static void addGrass(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq) {
        addGrass(builder, biome, freq, (new GrassTypesHolder()).ferns(false).fernsprouts(false).clovers(true).extra4LeafClovers(false).prettyTypes(true).moor(false).arid(false).thistles(true).nettles(true));
    }
    public static void addShireGrass(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq) {
        addGrass(builder, biome, freq, (new GrassTypesHolder()).ferns(false).fernsprouts(false).clovers(true).extra4LeafClovers(true).prettyTypes(true).moor(false).arid(false).thistles(true).nettles(true));
    }
    public static void addGrassWithFerns(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq) {
        addGrass(builder, biome, freq, (new GrassTypesHolder()).ferns(true).fernsprouts(false).clovers(true).extra4LeafClovers(false).prettyTypes(true).moor(false).arid(false).thistles(true).nettles(true));
    }
    public static void addShireGrassWithFerns(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq) {
        addGrass(builder, biome, freq, (new GrassTypesHolder()).ferns(true).fernsprouts(false).clovers(true).extra4LeafClovers(true).prettyTypes(true).moor(false).arid(false).thistles(true).nettles(true));
    }
    public static void addGrassWithFernsAndSprouts(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq) {
        addGrass(builder, biome, freq, (new GrassTypesHolder()).ferns(true).fernsprouts(true).clovers(true).extra4LeafClovers(false).prettyTypes(true).moor(false).arid(false).thistles(true).nettles(true));
    }
    public static void addMoorsGrass(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq) {
        addGrass(builder, biome, freq, (new GrassTypesHolder()).ferns(false).fernsprouts(false).clovers(true).extra4LeafClovers(false).prettyTypes(false).moor(true).arid(false).thistles(true).nettles(true));
    }
    public static void addShireMoorsGrass(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq) {
        addGrass(builder, biome, freq, (new GrassTypesHolder()).ferns(false).fernsprouts(false).clovers(true).extra4LeafClovers(true).prettyTypes(false).moor(true).arid(false).thistles(true).nettles(true));
    }
    public static void addMoorsGrassWithFerns(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq) {
        addGrass(builder, biome, freq, (new GrassTypesHolder()).ferns(true).fernsprouts(false).clovers(true).extra4LeafClovers(false).prettyTypes(false).moor(true).arid(false).thistles(true).nettles(true));
    }
    public static void addGrassWithArid(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq) {
        addGrass(builder, biome, freq, (new GrassTypesHolder()).ferns(false).fernsprouts(false).clovers(true).extra4LeafClovers(false).prettyTypes(true).moor(false).arid(true).thistles(true).nettles(true));
    }
    public static void addGrassBasic(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq) {
        addGrass(builder, biome, freq, (new GrassTypesHolder()).ferns(false).fernsprouts(false).clovers(false).extra4LeafClovers(false).prettyTypes(false).moor(false).arid(false).thistles(false).nettles(false));
    }
    public static void addGrassWithoutPrettyTypes(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq) {
        addGrass(builder, biome, freq, (new GrassTypesHolder()).ferns(false).fernsprouts(false).clovers(true).extra4LeafClovers(false).prettyTypes(false).moor(false).arid(false).thistles(true).nettles(true));
    }
    public static void addGrassWithFernsWithoutPrettyTypes(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq) {
        addGrass(builder, biome, freq, (new GrassTypesHolder()).ferns(true).fernsprouts(false).clovers(true).extra4LeafClovers(false).prettyTypes(false).moor(false).arid(false).thistles(true).nettles(true));
    }
    public static void addFlowers(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq, Object... weightedFlowers) {
        try {
            WeightedBlockStateProvider stateProvider = new WeightedBlockStateProvider();

            for(int i = 0; i < weightedFlowers.length; i += 2) {
                Object obj1 = weightedFlowers[i];
                BlockState state;
                if (obj1 instanceof BlockState) {
                    state = (BlockState)obj1;
                } else {
                    state = ((Block)obj1).getDefaultState();
                }

                int weight = (Integer)weightedFlowers[i + 1];
                stateProvider.addState(state, weight);
            }

            RandomPatchFeatureConfig flowerConfig = (new RandomPatchFeatureConfig.Builder(stateProvider, new SimpleBlockPlacer())).tries(64).build();
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.FLOWER.configure(flowerConfig).repeat(freq));
        } catch (ArrayIndexOutOfBoundsException | ClassCastException var8) {
            throw new IllegalArgumentException("Error adding biome flowers! A list of (blockstate1, weight1), (blockstate2, weight2)... is required", var8);
        }
    }
    public static void addDefaultFlowers(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq, Object... extraFlowers) {
        Object[] defaultFlowers = new Object[]{Blocks.POPPY, 1, Blocks.DANDELION, 2};
        addFlowers(builder, biome, freq, combineVarargs(defaultFlowers, extraFlowers));
    }
    public static void addPlainsFlowers(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq, Object... extraFlowers) {
        Object[] plainsFlowers = new Object[]{Blocks.POPPY, 20, Blocks.DANDELION, 30, Blocks.AZURE_BLUET, 20, Blocks.OXEYE_DAISY, 20, Blocks.CORNFLOWER, 5, Blocks.ORANGE_TULIP, 3, Blocks.RED_TULIP, 3, Blocks.PINK_TULIP, 3, Blocks.WHITE_TULIP, 3, getBlock("bluebell"), 5, getBlock("marigold"), 10, getBlock("lavender"), 5};
        addFlowers(builder, biome, freq, combineVarargs(plainsFlowers, extraFlowers));
    }
    public static void addForestFlowers(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq, Object... extraFlowers) {
        Object[] forestFlowers = new Object[]{Blocks.POPPY, 10, Blocks.DANDELION, 20, Blocks.LILY_OF_THE_VALLEY, 2, getBlock("bluebell"), 5, getBlock("marigold"), 10};
        addFlowers(builder, biome, freq, combineVarargs(forestFlowers, extraFlowers));
    }
    public static void addMountainsFlowers(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq, Object... extraFlowers) {
        Object[] mountainsFlowers = new Object[]{Blocks.POPPY, 10, Blocks.DANDELION, 20, Blocks.BLUE_ORCHID, 10, getBlock("bluebell"), 5};
        addFlowers(builder, biome, freq, combineVarargs(mountainsFlowers, extraFlowers));
    }
    public static void addBorealFlowers(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq, Object... extraFlowers) {
        Object[] borealFlowers = new Object[]{Blocks.POPPY, 10, Blocks.DANDELION, 20, Blocks.BLUE_ORCHID, 10, getBlock("bluebell"), 5};
        addFlowers(builder, biome, freq, combineVarargs(borealFlowers, extraFlowers));
    }
    public static void addSwampFlowers(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq, Object... extraFlowers) {
        addDefaultFlowers(builder, biome, freq, extraFlowers);
    }
    public static void addHaradFlowers(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq, Object... extraFlowers) {
        Object[] haradFlowers = new Object[]{getBlock("red_sand_gem"), 5, getBlock("yellow_sand_gem"), 10, getBlock("harad_daisy"), 5, getBlock("southbell"), 5};
        addFlowers(builder, biome, freq, combineVarargs(haradFlowers, extraFlowers));
    }
    public static void addRhunPlainsFlowers(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq, Object... extraFlowers) {
        Object[] rhunFlowers = new Object[]{getBlock("marigold"), 10, getBlock("white_chrysanthemum"), 10, getBlock("yellow_chrysanthemum"), 10, getBlock("pink_chrysanthemum"), 10, getBlock("red_chrysanthemum"), 10, getBlock("orange_chrysanthemum"), 10};
        addPlainsFlowers(builder, biome, freq, combineVarargs(rhunFlowers, extraFlowers));
    }
    public static void addRhunForestFlowers(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq, Object... extraFlowers) {
        Object[] rhunFlowers = new Object[]{getBlock("marigold"), 10, getBlock("white_chrysanthemum"), 10, getBlock("yellow_chrysanthemum"), 10, getBlock("pink_chrysanthemum"), 10, getBlock("red_chrysanthemum"), 10, getBlock("orange_chrysanthemum"), 10};
        addForestFlowers(builder, biome, freq, combineVarargs(rhunFlowers, extraFlowers));
    }
    public static void addSimbelmyneChance(GenerationSettings.Builder builder, LotrBaseBiome biome, int chance) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.FLOWER.configure(SIMBELMYNE_CONFIG).applyChance(chance));
    }
    /*public static <T> T[] combineVarargs(T[] array1, T... array2) {     //TODO: Check if works
        List<T> combined = new ArrayList();
        combined.addAll(Arrays.asList(array1));
        combined.addAll(Arrays.asList(array2));
        return (T[]) combined.toArray();
    }*/
    public static Object[] combineVarargs(Object[] array1, Object... array2) {
        List<Object> combined = new ArrayList<>();
        combined.addAll(Arrays.asList(array1));
        combined.addAll(Arrays.asList(array2));
        return combined.toArray();
    }
    public static void addGrass(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq, GrassTypesHolder types) {
        boolean ferns = types.ferns;
        boolean fernsprouts = types.fernsprouts;
        boolean clovers = types.clovers;
        boolean fourLeafClovers = types.extra4LeafClovers;
        boolean prettyTypes = types.prettyTypes;
        boolean moor = types.moor;
        boolean arid = types.arid;
        boolean thistles = types.thistles;
        boolean nettles = types.nettles;
        List<WeightedFeature<?>> weightedGrassTypes = new ArrayList<>();
        weightedGrassTypes.add(WeightedFeature.make(Feature.RANDOM_PATCH.configure(GRASS_CONFIG), 500));
        weightedGrassTypes.add(WeightedFeature.make(Feature.RANDOM_PATCH.configure(SHORT_GRASS_CONFIG), 100));
        if (clovers) {
            weightedGrassTypes.add(WeightedFeature.make(Feature.RANDOM_PATCH.configure(fourLeafClovers ? SHIRE_CLOVER_CONFIG : CLOVER_CONFIG), 250));
        }

        if (nettles) {
            weightedGrassTypes.add(WeightedFeature.make(Feature.RANDOM_PATCH.configure(NETTLES_CONFIG), 10));
        }

        if (prettyTypes) {
            weightedGrassTypes.add(WeightedFeature.make(Feature.RANDOM_PATCH.configure(WHEATGRASS_CONFIG), 100));
            weightedGrassTypes.add(WeightedFeature.make(Feature.RANDOM_PATCH.configure(FLOWERY_GRASS_CONFIG), 65));
            boolean flax = true;
            if (flax) {
                weightedGrassTypes.add(WeightedFeature.make(Feature.RANDOM_PATCH.configure(WILD_FLAX_CONFIG), 2));
            }
        }

        if (moor) {
            weightedGrassTypes.add(WeightedFeature.make(Feature.RANDOM_PATCH.configure(PURPLE_MOOR_GRASS_CONFIG), 200));
            weightedGrassTypes.add(WeightedFeature.make(Feature.RANDOM_PATCH.configure(RED_MOOR_GRASS_CONFIG), 120));
        }

        if (thistles) {
            weightedGrassTypes.add(WeightedFeature.make(Feature.RANDOM_PATCH.configure(THISTLE_CONFIG), 5));
        }

        if (ferns) {
            weightedGrassTypes.add(WeightedFeature.make(Feature.RANDOM_PATCH.configure(FERN_CONFIG), 500));
        }

        if (fernsprouts) {
            weightedGrassTypes.add(WeightedFeature.make(Feature.RANDOM_PATCH.configure(FERNSPROUT_CONFIG), 500));
        }

        if (arid) {
            weightedGrassTypes.add(WeightedFeature.make(Feature.RANDOM_PATCH.configure(ARID_GRASS_CONFIG), 550));
        }

        WeightedRandomFeatureConfig wrConfig = new WeightedRandomFeatureConfig(weightedGrassTypes);
        ConfiguredDecorator<?> placement = Decorator.COUNT.configure(new CountConfig(freq));
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, weightedRandom().configure(wrConfig).decorate(placement));
        biome.setGrassBonemealGenerator(wrConfig);
    }
    public static void addDoubleFlowers(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq, Object... weightedFlowers) {
        try {
            List<WeightedFeature<?>> weightedDoubleFlowerFeatures = new ArrayList<>();

            for(int i = 0; i < weightedFlowers.length; i += 2) {
                Object obj1 = weightedFlowers[i];
                BlockState state;
                if (obj1 instanceof BlockState) {
                    state = (BlockState)obj1;
                } else {
                    state = ((Block)obj1).getDefaultState();
                }

                int weight = (Integer)weightedFlowers[i + 1];
                RandomPatchFeatureConfig.Builder flowerConfigBuilder = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(state), new DoublePlantPlacer())).tries(64).cannotProject();
                if (state.getBlock() instanceof Waterloggable) {
                    flowerConfigBuilder.canReplace();
                }

                weightedDoubleFlowerFeatures.add(WeightedFeature.make(Feature.RANDOM_PATCH.configure(flowerConfigBuilder.build()), weight));
            }

            ConfiguredFeature<?, ?> doubleFlowerFeature = weightedRandom().configure(new WeightedRandomFeatureConfig(weightedDoubleFlowerFeatures));
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, doubleFlowerFeature.repeat(freq));
        } catch (ArrayIndexOutOfBoundsException | ClassCastException var9) {
            throw new IllegalArgumentException("Error adding biome double flowers! A list of (blockstate1, weight1), (blockstate2, weight2)... is required", var9);
        }
    }
    public static void addDefaultDoubleFlowers(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq, Object... extraFlowers) {
        Object[] defaultFlowers = new Object[]{Blocks.LILAC, 10, Blocks.ROSE_BUSH, 10, Blocks.PEONY, 10};
        addDoubleFlowers(builder, biome, freq, combineVarargs(defaultFlowers, extraFlowers));
    }
    public static void addHaradDoubleFlowers(GenerationSettings.Builder builder, LotrBaseBiome biome, int freq, Object... extraFlowers) {
        Object[] haradFlowers = new Object[]{getBlock("hibiscus"), 10, getBlock("flame_of_harad"), 2};
        addDoubleFlowers(builder, biome, freq, combineVarargs(haradFlowers, extraFlowers));
    }
    public static void addSunflowers(GenerationSettings.Builder builder, LotrBaseBiome biome, int chance) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(SUNFLOWER_CONFIG).applyChance(chance));
    }
    public static void addWildPipeweedChance(GenerationSettings.Builder builder, int chance) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.FLOWER.configure(WILD_PIPEWEED_CONFIG).applyChance(chance));
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> oak() {
        return Feature.TREE.configure(ConfiguredFeatures.OAK.config);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> oakBees() {
        return Feature.TREE.configure(ConfiguredFeatures.OAK_BEES_005.getConfig());
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> oakTall() {
        return Feature.TREE.configure(OAK_TREE_TALL);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> oakTallBees() {
        return Feature.TREE.configure(OAK_TREE_TALL_BEES);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> oakFancy() {
        return Feature.TREE.configure(ConfiguredFeatures.FANCY_OAK.getConfig());
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> oakFancyBees() {
        return Feature.TREE.configure(ConfiguredFeatures.FANCY_OAK_BEES_005.getConfig());
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> oakSwamp() {
        return Feature.TREE.configure((TreeFeatureConfig) ConfiguredFeatures.SWAMP_TREE.getConfig());
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> oakDesert() {
        return desertTree().configure(OAK_DESERT);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> oakDesertBees() {
        return desertTree().configure(OAK_DESERT_BEES);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> oakDead() {
        return deadTree().configure(OAK_DEAD);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> oakFangorn() {
        return fangornTree().configure(OAK_FANGORN);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> oakShrub() {
        return Feature.TREE.configure(OAK_SHRUB);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> spruce() {
        return Feature.TREE.configure(ConfiguredFeatures.SPRUCE.getConfig());
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> spruceThin() {
        return Feature.TREE.configure(ConfiguredFeatures.PINE.getConfig());
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> spruceMega() {
        return Feature.TREE.configure(ConfiguredFeatures.MEGA_SPRUCE.getConfig());
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> spruceThinMega() {
        return Feature.TREE.configure(ConfiguredFeatures.MEGA_PINE.getConfig());
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> spruceDead() {
        return deadTree().configure(SPRUCE_DEAD);
    }
    public static ConfiguredFeature<WeightedRandomFeatureConfig, ?> birch() {
        return weightedRandom().configure(WeightedRandomFeatureConfig.fromEntries(Feature.TREE.configure(ConfiguredFeatures.BIRCH.getConfig()), 1, Feature.TREE.configure(BIRCH_TREE_ALT), 2));
    }
    public static ConfiguredFeature<WeightedRandomFeatureConfig, ?> birchBees() {
        return weightedRandom().configure(WeightedRandomFeatureConfig.fromEntries(Feature.TREE.configure(ConfiguredFeatures.BIRCH_BEES_005.getConfig()), 1, Feature.TREE.configure(BIRCH_TREE_ALT_BEES), 2));
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> birchFancy() {
        return Feature.TREE.configure(BIRCH_TREE_FANCY);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> birchFancyBees() {
        return Feature.TREE.configure(BIRCH_TREE_FANCY_BEES);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> birchDead() {
        return deadTree().configure(BIRCH_DEAD);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> jungle() {
        return Feature.TREE.configure(ConfiguredFeatures.JUNGLE_TREE.getConfig());
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> jungleMega() {
        return Feature.TREE.configure(ConfiguredFeatures.MEGA_JUNGLE_TREE.getConfig());
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> jungleBush() {
        return Feature.TREE.configure((TreeFeatureConfig) ConfiguredFeatures.JUNGLE_BUSH.getConfig());
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> acacia() {
        return Feature.TREE.configure(ConfiguredFeatures.ACACIA.getConfig());
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> darkOak() {
        return Feature.TREE.configure(ConfiguredFeatures.DARK_OAK.getConfig());
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> pine() {
        return Feature.TREE.configure(PINE_TREE);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> shirePine() {
        return Feature.TREE.configure(SHIRE_PINE_TREE);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> pineShrub() {
        return Feature.TREE.configure(PINE_SHRUB);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> mallorn() {
        return Feature.TREE.configure(MALLORN_TREE);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> mallornBees() {
        return Feature.TREE.configure(MALLORN_TREE_BEES);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> mallornBoughs() {
        return boughsTree().configure(MALLORN_TREE_BOUGHS);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> mirkOak() {
        return mirkOakTree().configure(MIRK_OAK_TREE);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> charred() {
        return deadTree().configure(CHARRED_TREE);
    }
    public static ConfiguredFeature<WeightedRandomFeatureConfig, ?> apple() {
        return weightedRandom().configure(WeightedRandomFeatureConfig.fromEntries(Feature.TREE.configure(APPLE_TREE_RED), 19, Feature.TREE.configure(APPLE_TREE_GREEN), 19, Feature.TREE.configure(APPLE_TREE_MIX), 2));
    }
    public static ConfiguredFeature<WeightedRandomFeatureConfig, ?> appleBees() {
        return weightedRandom().configure(WeightedRandomFeatureConfig.fromEntries(Feature.TREE.configure(APPLE_TREE_RED_BEES), 19, Feature.TREE.configure(APPLE_TREE_GREEN_BEES), 19, Feature.TREE.configure(APPLE_TREE_MIX_BEES), 2));
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> pear() {
        return Feature.TREE.configure(PEAR_TREE);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> pearBees() {
        return Feature.TREE.configure(PEAR_TREE_BEES);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> cherry() {
        return Feature.TREE.configure(CHERRY_TREE);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> cherryBees() {
        return Feature.TREE.configure(CHERRY_TREE_BEES);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> lebethron() {
        return Feature.TREE.configure(LEBETHRON_TREE);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> lebethronBees() {
        return Feature.TREE.configure(LEBETHRON_TREE_BEES);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> lebethronFancy() {
        return Feature.TREE.configure(LEBETHRON_TREE_FANCY);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> lebethronFancyBees() {
        return Feature.TREE.configure(LEBETHRON_TREE_FANCY_BEES);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> beech() {
        return Feature.TREE.configure(BEECH_TREE);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> beechBees() {
        return Feature.TREE.configure(BEECH_TREE_BEES);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> beechFancy() {
        return Feature.TREE.configure(BEECH_TREE_FANCY);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> beechFancyBees() {
        return Feature.TREE.configure(BEECH_TREE_FANCY_BEES);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> beechFangorn() {
        return fangornTree().configure(BEECH_FANGORN);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> beechDead() {
        return deadTree().configure(BEECH_DEAD);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> maple() {
        return Feature.TREE.configure(MAPLE_TREE);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> mapleBees() {
        return Feature.TREE.configure(MAPLE_TREE_BEES);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> mapleFancy() {
        return Feature.TREE.configure(MAPLE_TREE_FANCY);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> mapleFancyBees() {
        return Feature.TREE.configure(MAPLE_TREE_FANCY_BEES);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> aspen() {
        return Feature.TREE.configure(ASPEN_TREE);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> aspenLarge() {
        return aspen();
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> lairelosse() {
        return Feature.TREE.configure(LAIRELOSSE_TREE);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> cedar() {
        return cedarTree().configure(CEDAR_TREE);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> cedarLarge() {
        return cedarTree().configure(CEDAR_TREE_LARGE);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> fir() {
        return Feature.TREE.configure(FIR_TREE);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> larch() {
        return Feature.TREE.configure(LARCH_TREE);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> holly() {
        return Feature.TREE.configure(HOLLY_TREE);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> hollyBees() {
        return Feature.TREE.configure(HOLLY_TREE_BEES);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> greenOak() {
        return mirkOakTree().configure(GREEN_OAK_TREE);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> greenOakBees() {
        return mirkOakTree().configure(GREEN_OAK_TREE_BEES);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> redOak() {
        return mirkOakTree().configure(RED_OAK_TREE);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> redOakBees() {
        return mirkOakTree().configure(RED_OAK_TREE_BEES);
    }
    public static ConfiguredFeature<TreeFeatureConfig, ?> cypress() {
        return Feature.TREE.configure(CYPRESS_TREE);
    }
    public static MirkOakTreeFeature mirkOakTree() {
        return new MirkOakTreeFeature(ExtendedTreeConfig.CODEC);
    }
    public static CedarTreeFeature cedarTree() {
        return new CedarTreeFeature(ExtendedTreeConfig.CODEC);
    }
    public static FangornTreeFeature fangornTree() {
        return new FangornTreeFeature(ExtendedTreeConfig.CODEC);
    }
    public static DeadTreeFeature deadTree() {
        return new DeadTreeFeature(ExtendedTreeConfig.CODEC);
    }
    public static DesertTreeFeature desertTree() {
        return new DesertTreeFeature(ExtendedTreeConfig.CODEC);
    }
    public static BoughsTreeFeature boughsTree() {
        return new BoughsTreeFeature(ExtendedTreeConfig.CODEC);
    }
    private static class GrassTypesHolder {
        public boolean ferns;
        public boolean fernsprouts;
        public boolean clovers;
        public boolean extra4LeafClovers;
        public boolean prettyTypes;
        public boolean moor;
        public boolean arid;
        public boolean thistles;
        public boolean nettles;

        public GrassTypesHolder() {
        }

        public GrassTypesHolder ferns(boolean flag) {
            this.ferns = flag;
            return this;
        }

        public GrassTypesHolder fernsprouts(boolean flag) {
            this.fernsprouts = flag;
            return this;
        }

        public GrassTypesHolder clovers(boolean flag) {
            this.clovers = flag;
            return this;
        }

        public GrassTypesHolder extra4LeafClovers(boolean flag) {
            this.extra4LeafClovers = flag;
            return this;
        }

        public GrassTypesHolder prettyTypes(boolean flag) {
            this.prettyTypes = flag;
            return this;
        }

        public GrassTypesHolder moor(boolean flag) {
            this.moor = flag;
            return this;
        }

        public GrassTypesHolder arid(boolean flag) {
            this.arid = flag;
            return this;
        }

        public GrassTypesHolder thistles(boolean flag) {
            this.thistles = flag;
            return this;
        }

        public GrassTypesHolder nettles(boolean flag) {
            this.nettles = flag;
            return this;
        }
    }
    public static BlockState getBlockState(String name) {
        return getBlock(name).getDefaultState();
    }
    public static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> registerFeature(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        RegistryKey<ConfiguredFeature<?, ?>> feature = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, id(id));
        return (ConfiguredFeature<FC, ?>) Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, feature.getValue(), configuredFeature);
    }
    public static boolean isRegistered(String name) {
        Set<Map.Entry<RegistryKey<ConfiguredFeature<?,?>>, ConfiguredFeature<?,?>>> biomeReg = BuiltinRegistries.CONFIGURED_FEATURE.getEntries();
        Iterator<Map.Entry<RegistryKey<ConfiguredFeature<?,?>>, ConfiguredFeature<?,?>>> biomeReg2 = biomeReg.iterator();
        for (int i = 0; i < biomeReg.size(); i++) {
            Map.Entry<RegistryKey<ConfiguredFeature<?,?>>, ConfiguredFeature<?,?>> biomeReg3 = biomeReg2.next();
            if (biomeReg3.getKey().getValue().equals(id(name))) {
                return true;
            }
        }
        return false;
    }
    public static ConfiguredFeature<?,?> getFeature(String name) {
        Set<Map.Entry<RegistryKey<ConfiguredFeature<?,?>>, ConfiguredFeature<?,?>>> biomeReg = BuiltinRegistries.CONFIGURED_FEATURE.getEntries();
        Iterator<Map.Entry<RegistryKey<ConfiguredFeature<?,?>>, ConfiguredFeature<?,?>>> biomeReg2 = biomeReg.iterator();
        for (int i = 0; i < biomeReg.size(); i++) {
            Map.Entry<RegistryKey<ConfiguredFeature<?,?>>, ConfiguredFeature<?,?>> biomeReg3 = biomeReg2.next();
            if (biomeReg3.getKey().getValue().equals(id(name))) {
                return biomeReg3.getValue();
            }
        }
        return null;
    }
}
