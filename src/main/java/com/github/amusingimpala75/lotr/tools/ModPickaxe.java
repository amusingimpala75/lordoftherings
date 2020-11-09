package com.github.amusingimpala75.lotr.tools;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
/*
Wrapper for PickaxeItem
 */
public class ModPickaxe extends PickaxeItem {
    public ModPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

}
