package com.github.amusingimpala75.lotr.util;

import com.github.amusingimpala75.lotr.block.*;
import com.github.amusingimpala75.lotr.block.crafting.FactionCraftingTable;
import com.github.amusingimpala75.lotr.faction.Faction;
import com.github.amusingimpala75.lotr.registry.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.Material;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
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
        final Block SLAB = new ModSlabBlock(FabricBlockSettings.of(material));
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
        final Block FLOWER_POTTED = new ModFlowerPotted(FLOWER, FabricBlockSettings.of(material));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "potted_"+name), FLOWER_POTTED);
    }
    public static void food(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block FOOD = new ModFoodBlock(FabricBlockSettings.of(material));
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(FOOD, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), FOOD);
    }
//    public static void sapling(Material material, ItemGroup group, boolean blockItem, String name) {
//        final Block SAPLING = new ModSaplingBlock();
//    }
    public static void bars(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block BARS = new ModBarsBlock(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem) {
          Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(BARS, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), BARS);
    }
    public static void door(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block DOOR = new ModDoorBlock(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(DOOR, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), DOOR);
    }
    public static void trapdoor(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block TRAPDOOR = new ModTrapDoor(FabricBlockSettings.of(material).nonOpaque());
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(TRAPDOOR, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), TRAPDOOR);
    }
    public static void pressurePlate(Material material, ItemGroup group, boolean blockItem, String name) {
        final Block PRESSURE_PLATE = new ModPressurePlate(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(material).noCollision());
        if (blockItem) {
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(PRESSURE_PLATE, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), PRESSURE_PLATE);
    }
}
