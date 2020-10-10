package com.github.amusingimpala75.lotr.util;

import com.github.amusingimpala75.lotr.block.*;
import com.github.amusingimpala75.lotr.registry.ModBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;

public class BlockReg {
    public static void block(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block BLOCK = new Block(FabricBlockSettings.of(material));
        if (blockItem){
            Registry.register(Registry.BLOCK, new Identifier("lotr", name), BLOCK);
        }

        Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(BLOCK, new Item.Settings().group(group)));
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
        final Block WALL = /*new WallBlock(FabricBlockSettings.of(material));*/ new FenceBlock(FabricBlockSettings.of(material));
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
        final Block BUTTON = new ModPressurePlate(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(material).noCollision());
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
}
