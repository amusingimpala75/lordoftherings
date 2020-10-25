package com.github.amusingimpala75.lotr.util;

import com.github.amusingimpala75.lotr.Lotr;
import com.github.amusingimpala75.lotr.block.*;
import com.github.amusingimpala75.lotr.registry.ModBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;

public class BlockReg {
    public static void block(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block BLOCK = new Block(FabricBlockSettings.of(material));
        if (blockItem){
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(BLOCK, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), BLOCK);
    }
    public static void stair(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block STAIR = new ModStairBlock(ModBlocks.GONDOR_ROCK.getDefaultState(), FabricBlockSettings.of(material));
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(STAIR, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), STAIR);
    }
    public static void slab(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block SLAB = new SlabBlock(FabricBlockSettings.of(material));
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(SLAB, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), SLAB);
    }
    public static void flower(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block FLOWER = new FlowerBlock(StatusEffects.GLOWING, 1, FabricBlockSettings.of(material).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(FLOWER, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), FLOWER);
        final Block FLOWER_POTTED = new FlowerPotBlock(FLOWER, FabricBlockSettings.of(material));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "potted_"+name), FLOWER_POTTED);
        BlockRenderLayerMap.INSTANCE.putBlock(FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FLOWER_POTTED, RenderLayer.getCutout());
    }
    public static void food(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block FOOD = new ModFoodBlock(FabricBlockSettings.of(material));
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(FOOD, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), FOOD);
    }
    public static void bars(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block BARS = new ModBarsBlock(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem) {
          Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(BARS, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), BARS);
        BlockRenderLayerMap.INSTANCE.putBlock(BARS, RenderLayer.getCutout());
    }
    public static void door(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block DOOR = new ModDoorBlock(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(DOOR, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), DOOR);
        BlockRenderLayerMap.INSTANCE.putBlock(DOOR, RenderLayer.getCutout());
    }
    public static void trapdoor(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block TRAPDOOR = new ModTrapDoor(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(TRAPDOOR, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), TRAPDOOR);
        BlockRenderLayerMap.INSTANCE.putBlock(TRAPDOOR, RenderLayer.getCutout());
    }
    public static void pressurePlate(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block PRESSURE_PLATE = new ModPressurePlate(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(material).noCollision());
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(PRESSURE_PLATE, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), PRESSURE_PLATE);
    }
    public static void wall(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block WALL = new WallBlock(FabricBlockSettings.of(material));
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(WALL, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), WALL);
    }
    public static void fence(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block FENCE = new FenceBlock(FabricBlockSettings.of(material));
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(FENCE, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), FENCE);
    }
    public static void fenceGate(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block FENCE_GATE = new FenceGateBlock(FabricBlockSettings.of(material));
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(FENCE_GATE, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), FENCE_GATE);
    }
    public static void log(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block LOG = new PillarBlock(FabricBlockSettings.of(Material.WOOD, (blockState) -> {
        return blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.BROWN : MaterialColor.BROWN;
    }).strength(2.0F).sounds(BlockSoundGroup.WOOD));
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(LOG, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), LOG);
    }
    public static void wood(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block WOOD = new PillarBlock(FabricBlockSettings.of(Material.WOOD, (blockState) -> {
            return blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.BROWN : MaterialColor.BROWN;
        }).strength(2.0F).sounds(BlockSoundGroup.WOOD));
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(WOOD, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), WOOD);
    }
    public static void button(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block BUTTON = new ModButtonBlock(FabricBlockSettings.of(material).noCollision());
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(BUTTON, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), BUTTON);
    }
    public static void pillar(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block PILLAR = new PillarBlock(FabricBlockSettings.of(Material.WOOD, (blockState) -> {
            return blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.BROWN : MaterialColor.BROWN;
        }).strength(2.0F).sounds(BlockSoundGroup.WOOD));
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(PILLAR, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), PILLAR);
    }
    public static void beam(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block BEAM = new PillarBlock(FabricBlockSettings.of(Material.WOOD, (blockState) -> {
            return blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.BROWN : MaterialColor.BROWN;
        }).strength(2.0F).sounds(BlockSoundGroup.WOOD));
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(BEAM, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), BEAM);
    }
    public static void leaves(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block LEAVES = new LeavesBlock(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem){
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(LEAVES, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlock(LEAVES, RenderLayer.getCutoutMipped());
    }
    public static void sign(Material material, ItemGroup group, boolean blockItem, String name, SignType type) {
        final Block SIGN = new SignBlock(FabricBlockSettings.of(material), type);
        if (blockItem){
            Registry.register(Registry.ITEM, new Identifier("lotr", name+"_sign"), new BlockItem(SIGN, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name+"_sign"), SIGN);
        final Block WALL_SIGN = new WallSignBlock(FabricBlockSettings.of(material), type);
        Registry.register(Registry.BLOCK, new Identifier("lotr", name+"_wall_sign"), WALL_SIGN);
        //BlockRenderLayerMap.INSTANCE.putBlock(LEAVES, RenderLayer.getCutoutMipped());
    }
    public static void gravity(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block GRAVITY = new GravelBlock(FabricBlockSettings.of(material));
        if (blockItem){
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(GRAVITY, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), GRAVITY);
    }
    public static void torch(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block TORCH = new ModTorch(AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().breakInstantly().luminance((state) -> {
            return 14;
        }).sounds(BlockSoundGroup.WOOD), ParticleTypes.FLAME);
        Registry.register(Registry.BLOCK, new Identifier("lotr", name+"_torch"), TORCH);
        final Block WALL_TORCH = new ModWallTorch(AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().breakInstantly().luminance((state) -> {
            return 14;
        }).sounds(BlockSoundGroup.WOOD).dropsLike(TORCH), ParticleTypes.FLAME);
        Registry.register(Registry.BLOCK, new Identifier("lotr", name+"_wall_torch"), WALL_TORCH);
        Registry.register(Registry.ITEM, new Identifier("lotr", name+"_torch"), new BlockItem(TORCH, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), TORCH, WALL_TORCH);
    }
    public static void pile(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block PILE = new ModPileBlock(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem){
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(PILE, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), PILE);
        BlockRenderLayerMap.INSTANCE.putBlock(PILE, RenderLayer.getCutout());
    }
    public static void chandelier(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block CHANDELIER = new Block(FabricBlockSettings.of(material).nonOpaque().luminance((state) -> {
            return 14;
        }));
        if (blockItem){
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(CHANDELIER, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), CHANDELIER);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), CHANDELIER);
    }
    public static void pillar2(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block PILLAR = new ModPillarBlock(FabricBlockSettings.of(material));
        if (blockItem){
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(PILLAR, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), PILLAR);
    }
    public static void flowerTall(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block FLOWER = new TallPlantBlock(FabricBlockSettings.of(material).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(FLOWER, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), FLOWER);
        final Block FLOWER_POTTED = new FlowerPotBlock(FLOWER, FabricBlockSettings.of(material));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "potted_"+name), FLOWER_POTTED);
        BlockRenderLayerMap.INSTANCE.putBlock(FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FLOWER_POTTED, RenderLayer.getCutout());
    }
    //public static void crop(Material material, ItemGroup group, boolean blockItem, String name) {
    //    final Block BLOCK = new ModCropBlock(FabricBlockSettings.of(material));
    //    if (blockItem){
    //        Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(BLOCK, new Item.Settings().group(group)));
    //    }
    //    Registry.register(Registry.BLOCK, new Identifier("lotr", name), BLOCK);
    //}
    public static void directional(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block BLOCK = new CrystalBlock(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem){
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(BLOCK, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), BLOCK);
    }
    public static void flowerTall(Material material, ItemGroup group, boolean blockItem, String name, boolean notPotted) {
        final Block FLOWER = new TallPlantBlock(FabricBlockSettings.of(material).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(FLOWER, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), FLOWER);
        BlockRenderLayerMap.INSTANCE.putBlock(FLOWER, RenderLayer.getCutout());
    }
    public static void flower(Material material, ItemGroup group, boolean blockItem, String name, boolean notPotted) {
        final Block FLOWER = new FlowerBlock(StatusEffects.GLOWING, 1, FabricBlockSettings.of(material).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(FLOWER, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), FLOWER);
        BlockRenderLayerMap.INSTANCE.putBlock(FLOWER, RenderLayer.getCutout());
    }
    public static void dripstone(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block BLOCK = new Dripstone(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem){
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(BLOCK, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), BLOCK);
    }
    public static void dolAmroth(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block BLOCK = new DolAmrothBrick(FabricBlockSettings.of(material));
        if (blockItem){
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(BLOCK, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), BLOCK);
    }
    public static void plate(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block BLOCK = new Plate(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem){
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(BLOCK, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), BLOCK);
    }
}
