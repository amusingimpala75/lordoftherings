package com.github.amusingimpala75.lotr.tools;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

import java.util.Map;
/*
Wrapper for HoeItem
 */
public class ModHoe extends HoeItem {
    public final Map<Block, BlockState> TILLED_BLOCKS = HoeItem.TILLED_BLOCKS;
    public ModHoe(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }


}
