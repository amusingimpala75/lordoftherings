package com.github.amusingimpala75.lotr.util;

import com.github.amusingimpala75.lotr.block.ModStairBlock;
import com.github.amusingimpala75.lotr.registry.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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
        final Block BLOCK = new ModStairBlock(ModBlocks.GONDOR_ROCK.getDefaultState(), FabricBlockSettings.of(material));
        if (blockItem){
            Registry.register(Registry.ITEM, new Identifier("lotr", name), new BlockItem(BLOCK, new Item.Settings().group(group)));
        }
        Registry.register(Registry.BLOCK, new Identifier("lotr", name), BLOCK);
    }
}
