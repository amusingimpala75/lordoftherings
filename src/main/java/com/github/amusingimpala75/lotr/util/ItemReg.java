package com.github.amusingimpala75.lotr.util;

import com.github.amusingimpala75.lotr.materials.ModToolMaterial;
import com.github.amusingimpala75.lotr.tools.ModAxe;
import com.github.amusingimpala75.lotr.tools.ModHoe;
import com.github.amusingimpala75.lotr.tools.ModPickaxe;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.github.amusingimpala75.lotr.Lotr.*;

public class ItemReg {
    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registry.ITEM, new Identifier("lotr", name), item);
    }
    public static void food(String name) {
        Registry.register(Registry.ITEM, new Identifier("lotr", name), new Item(new Item.Settings().group(LOTR_FOOD)));
    }
    public static void misc(String name) {
        Registry.register(Registry.ITEM, new Identifier("lotr", name), new Item(new Item.Settings().group(LOTR_MISC)));
    }
    public static void material(String name) {
        Registry.register(Registry.ITEM, new Identifier("lotr", name), new Item(new Item.Settings().group(LOTR_MATERIALS)));
    }
    public static void helmet(String name, ArmorMaterial material) {
        Registry.register(Registry.ITEM, new Identifier("lotr", name), new ArmorItem(material, EquipmentSlot.HEAD, (new Item.Settings().group(LOTR_COMBAT))));
    }
    public static void chestplate(String name, ArmorMaterial material) {
        Registry.register(Registry.ITEM, new Identifier("lotr", name), new ArmorItem(material, EquipmentSlot.CHEST, (new Item.Settings().group(LOTR_COMBAT))));
    }
    public static void leggings(String name, ArmorMaterial material) {
        Registry.register(Registry.ITEM, new Identifier("lotr", name), new ArmorItem(material, EquipmentSlot.LEGS, (new Item.Settings().group(LOTR_COMBAT))));
    }
    public static void boots(String name, ArmorMaterial material) {
        Registry.register(Registry.ITEM, new Identifier("lotr", name), new ArmorItem(material, EquipmentSlot.FEET, (new Item.Settings().group(LOTR_COMBAT))));
    }
    public static void armourSet(String type, ArmorMaterial material) {
        helmet(type+"_helmet", material);
        chestplate(type+"_chestplate", material);
        leggings(type+"_leggings", material);
        boots(type+"_boots", material);
    }
    public static void sword(String name, ToolMaterial material, int attackDamage,  float attackSpeed) {
        Registry.register(Registry.ITEM, new Identifier("lotr", name), new SwordItem(material, attackDamage, attackSpeed, new Item.Settings().group(LOTR_COMBAT)));
    }
    public static void shovel(String name, ToolMaterial material, float attackDamage, float attackSpeed) {
        Registry.register(Registry.ITEM, new Identifier("lotr", name), new ShovelItem(material, attackDamage, attackSpeed, new Item.Settings().group(LOTR_TOOLS)));
    }
    public static void pickaxe(String name, ToolMaterial material, int attackDamage, float attackSpeed) {
        Registry.register(Registry.ITEM, new Identifier("lotr", name), new ModPickaxe(material, attackDamage, attackSpeed, new Item.Settings().group(LOTR_TOOLS)));
    }
    public static void axe(String name, ToolMaterial material, float attackDamage, float attackSpeed) {
        Registry.register(Registry.ITEM, new Identifier("lotr", name), new ModAxe(material, attackDamage, attackSpeed, new Item.Settings().group(LOTR_TOOLS)));
    }
    public static void hoe(String name, ToolMaterial material, int attackDamage, float attackSpeed) {
        Registry.register(Registry.ITEM, new Identifier("lotr", name), new ModHoe(material, attackDamage, attackSpeed, new Item.Settings().group(LOTR_TOOLS)));
    }
    public static void toolSet(String type, String name, ModToolMaterial material, float axeAS, int hoeAD, float hoeAS, float pickaxeAS, float shovelAS, float swordAS) {
        axe(type+"_axe", material, 0.0F, axeAS);
        hoe(type+"_hoe", material, Math.round(hoeAD), hoeAS);
        pickaxe(type+"_pickaxe", material, -1, pickaxeAS);
        shovel(type+"_shovel", material, -2.0F, shovelAS);
        sword(type+"_"+name, material, 1, swordAS);
    }
}
