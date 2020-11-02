package com.github.amusingimpala75.lotr.util;

import com.github.amusingimpala75.lotr.Lotr;
import com.github.amusingimpala75.lotr.block.*;
import com.github.amusingimpala75.lotr.registry.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.SignType;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;

import static com.github.amusingimpala75.lotr.Lotr.*;
import static com.github.amusingimpala75.lotr.client.LotrClient.*;

public class BlockReg {
    public static void block(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block BLOCK = new Block(FabricBlockSettings.of(material));
        if (blockItem){
            Registry.register(Registry.ITEM, id(name), new BlockItem(BLOCK, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), BLOCK);
    }
    public static void stair(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block STAIR = new ModStairBlock(ModBlocks.GONDOR_ROCK.getDefaultState(), FabricBlockSettings.of(material));
        if (blockItem) {
            Registry.register(Registry.ITEM, id(name), new BlockItem(STAIR, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), STAIR);
    }
    public static void slab(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block SLAB = new SlabBlock(FabricBlockSettings.of(material));
        if (blockItem) {
            Registry.register(Registry.ITEM, id(name), new BlockItem(SLAB, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), SLAB);
    }
    public static void flower(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block FLOWER = new FlowerBlock(StatusEffects.GLOWING, 1, FabricBlockSettings.of(material).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
        if (blockItem) {
            Registry.register(Registry.ITEM, id(name), new BlockItem(FLOWER, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), FLOWER);
        final Block FLOWER_POTTED = new FlowerPotBlock(FLOWER, FabricBlockSettings.of(material));
        Registry.register(Registry.BLOCK, id("potted_"+name), FLOWER_POTTED);
        addBlocksToRenderLayer(FLOWER);
        addBlocksToRenderLayer(FLOWER_POTTED);
    }
    public static void food(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block FOOD = new ModFoodBlock(FabricBlockSettings.of(material));
        if (blockItem) {
            Registry.register(Registry.ITEM, id(name), new BlockItem(FOOD, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), FOOD);
    }
    public static void bars(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block BARS = new ModBarsBlock(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem) {
          Registry.register(Registry.ITEM, id(name), new BlockItem(BARS, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), BARS);
        addBlocksToRenderLayer(BARS);
    }
    public static void door(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block DOOR = new ModDoorBlock(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem) {
            Registry.register(Registry.ITEM, id(name), new BlockItem(DOOR, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), DOOR);
        addBlocksToRenderLayer(DOOR);
    }
    public static void trapdoor(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block TRAPDOOR = new ModTrapDoor(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem) {
            Registry.register(Registry.ITEM, id(name), new BlockItem(TRAPDOOR, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), TRAPDOOR);
        addBlocksToRenderLayer(TRAPDOOR);
    }
    public static void pressurePlate(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block PRESSURE_PLATE = new ModPressurePlate(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(material).noCollision());
        if (blockItem) {
            Registry.register(Registry.ITEM, id(name), new BlockItem(PRESSURE_PLATE, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), PRESSURE_PLATE);
    }
    public static void wall(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block WALL = new WallBlock(FabricBlockSettings.of(material));
        if (blockItem) {
            Registry.register(Registry.ITEM, id(name), new BlockItem(WALL, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), WALL);
    }
    public static void fence(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block FENCE = new FenceBlock(FabricBlockSettings.of(material));
        if (blockItem) {
            Registry.register(Registry.ITEM, id(name), new BlockItem(FENCE, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), FENCE);
    }
    public static void fenceGate(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block FENCE_GATE = new FenceGateBlock(FabricBlockSettings.of(material));
        if (blockItem) {
            Registry.register(Registry.ITEM, id(name), new BlockItem(FENCE_GATE, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), FENCE_GATE);
    }
    public static void log(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block LOG = new PillarBlock(FabricBlockSettings.of(Material.WOOD, (blockState) ->
                blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.BROWN : MaterialColor.BROWN).strength(2.0F).sounds(BlockSoundGroup.WOOD));
        if (blockItem) {
            Registry.register(Registry.ITEM, id(name), new BlockItem(LOG, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), LOG);
    }
    public static void wood(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block WOOD = new PillarBlock(FabricBlockSettings.of(Material.WOOD, (blockState) ->
                blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.BROWN : MaterialColor.BROWN).strength(2.0F).sounds(BlockSoundGroup.WOOD));
        if (blockItem) {
            Registry.register(Registry.ITEM, id(name), new BlockItem(WOOD, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), WOOD);
    }
    public static void button(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block BUTTON = new ModButtonBlock(FabricBlockSettings.of(material).noCollision());
        if (blockItem) {
            Registry.register(Registry.ITEM, id(name), new BlockItem(BUTTON, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), BUTTON);
    }
    public static void pillar(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block PILLAR = new PillarBlock(FabricBlockSettings.of(Material.WOOD, (blockState) ->
                blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.BROWN : MaterialColor.BROWN).strength(2.0F).sounds(BlockSoundGroup.WOOD));
        if (blockItem) {
            Registry.register(Registry.ITEM, id(name), new BlockItem(PILLAR, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), PILLAR);
    }
    public static void beam(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block BEAM = new PillarBlock(FabricBlockSettings.of(Material.WOOD, (blockState) ->
                blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.BROWN : MaterialColor.BROWN).strength(2.0F).sounds(BlockSoundGroup.WOOD));
        if (blockItem) {
            Registry.register(Registry.ITEM, id(name), new BlockItem(BEAM, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), BEAM);
    }
    public static void leaves(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block LEAVES = new LeavesBlock(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem){
            Registry.register(Registry.ITEM, id(name), new BlockItem(LEAVES, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), LEAVES);
        addBlocksToRenderLayer(LEAVES);
    }
    public static void sign(Material material, ItemGroup group, boolean blockItem, String name, SignType type) {
        final Block SIGN = new SignBlock(FabricBlockSettings.of(material), type);
        if (blockItem){
            Registry.register(Registry.ITEM, id(name+"_sign"), new BlockItem(SIGN, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name+"_sign"), SIGN);
        final Block WALL_SIGN = new WallSignBlock(FabricBlockSettings.of(material), type);
        Registry.register(Registry.BLOCK, id(name+"_wall_sign"), WALL_SIGN);
    }
    public static void gravity(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block GRAVITY = new GravelBlock(FabricBlockSettings.of(material));
        if (blockItem){
            Registry.register(Registry.ITEM, id(name), new BlockItem(GRAVITY, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), GRAVITY);
    }
    public static void torch(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block TORCH = new ModTorch(AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().breakInstantly().luminance((state) -> 14).sounds(BlockSoundGroup.WOOD), ParticleTypes.FLAME);
        Registry.register(Registry.BLOCK, id(name+"_torch"), TORCH);
        final Block WALL_TORCH = new ModWallTorch(AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().breakInstantly().luminance((state) -> 14).sounds(BlockSoundGroup.WOOD).dropsLike(TORCH), ParticleTypes.FLAME);
        Registry.register(Registry.BLOCK, id(name+"_wall_torch"), WALL_TORCH);
        Registry.register(Registry.ITEM, id(name+"_torch"), new BlockItem(TORCH, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        addBlocksToRenderLayer(TORCH);
        addBlocksToRenderLayer(WALL_TORCH);
    }
    public static void pile(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block PILE = new ModPileBlock(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem){
            Registry.register(Registry.ITEM, id(name), new BlockItem(PILE, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), PILE);
        addBlocksToRenderLayer(PILE);
    }
    public static void chandelier(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block CHANDELIER = new Block(FabricBlockSettings.of(material).nonOpaque().luminance((state) -> 14));
        if (blockItem){
            Registry.register(Registry.ITEM, id(name), new BlockItem(CHANDELIER, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), CHANDELIER);
        addBlocksToRenderLayer(CHANDELIER);
    }
    public static void pillar2(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block PILLAR = new ModPillarBlock(FabricBlockSettings.of(material));
        if (blockItem){
            Registry.register(Registry.ITEM, id(name), new BlockItem(PILLAR, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), PILLAR);
    }
    public static void flowerTall(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block FLOWER = new TallPlantBlock(FabricBlockSettings.of(material).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
        if (blockItem) {
            Registry.register(Registry.ITEM, id(name), new BlockItem(FLOWER, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), FLOWER);
        final Block FLOWER_POTTED = new FlowerPotBlock(FLOWER, FabricBlockSettings.of(material));
        Registry.register(Registry.BLOCK, id("potted_"+name), FLOWER_POTTED);
        addBlocksToRenderLayer(FLOWER);
        addBlocksToRenderLayer(FLOWER_POTTED);
    }
    public static void directional(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block BLOCK = new CrystalBlock(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem){
            Registry.register(Registry.ITEM, id(name), new BlockItem(BLOCK, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), BLOCK);
    }
    public static void flowerTall(Material material, ItemGroup group, boolean blockItem, String name, boolean notPotted) {
        final Block FLOWER = new TallPlantBlock(FabricBlockSettings.of(material).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
        if (blockItem) {
            Registry.register(Registry.ITEM, id(name), new BlockItem(FLOWER, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), FLOWER);
        addBlocksToRenderLayer(FLOWER);
    }
    public static void flower(Material material, ItemGroup group, boolean blockItem, String name, boolean notPotted) {
        final Block FLOWER = new FlowerBlock(StatusEffects.GLOWING, 1, FabricBlockSettings.of(material).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
        if (blockItem) {
            Registry.register(Registry.ITEM, id(name), new BlockItem(FLOWER, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), FLOWER);
        addBlocksToRenderLayer(FLOWER);
    }
    public static void dripstone(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block BLOCK = new Dripstone(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem){
            Registry.register(Registry.ITEM, id(name), new BlockItem(BLOCK, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), BLOCK);
    }
    public static void dolAmroth(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block BLOCK = new DolAmrothBrick(FabricBlockSettings.of(material));
        if (blockItem){
            Registry.register(Registry.ITEM, id(name), new BlockItem(BLOCK, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), BLOCK);
    }
    public static void plate(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block BLOCK = new Plate(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem){
            Registry.register(Registry.ITEM, id(name), new BlockItem(BLOCK, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, id(name), BLOCK);
    }
}
