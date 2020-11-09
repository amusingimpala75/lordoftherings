package com.github.amusingimpala75.lotr.materials;

import com.github.amusingimpala75.lotr.registry.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial {
    /*
    ME Armour Types
    TODO: remove BLUER_DWARVEN
     */
    MITHRIL("mithril", Math.round(2400*0.06F), new int[] {3,8,6,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.MITHRIL_INGOT);
    }),
    BRONZE("bronze", Math.round(230*0.06F), new int[] {2,5,4,2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.BRONZE_INGOT);
    }),
    MORDOR("mordor", Math.round(400*0.06F), new int[] {2,6,5,2}, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.ORC_STEEL_INGOT);
    }),
    GONDOR("gondor", Math.round(450*0.06F), new int[] {2,6,5,2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),
    ROHAN("rohan", Math.round(300*0.06F), new int[] {2,5,4,2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),
    DWARVEN("dwarven", Math.round(700*0.06F), new int[] {2,7,6,2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.DWARVEN_STEEL_INGOT);
    }),
    BLUE_DWARVEN("blue_dwarven", Math.round(650*0.06F), new int[] {2,7,6,2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.DWARVEN_STEEL_INGOT);
    }),
    LINDON("lindon", Math.round(700*0.06F), new int[] {2,6,5,2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.ELVEN_STEEL_INGOT);
    }),
    RIVENDELL("rivendell", Math.round(700*0.06F), new int[] {2,6,5,2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.ELVEN_STEEL_INGOT);
    }),
    GALADHRIM("galadhrim", Math.round(600*0.06F), new int[] {2,6,5,2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.ELVEN_STEEL_INGOT);
    }),
    WOOD_ELVEN("wood_elven", Math.round(500*0.06F), new int[] {2,6,5,2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.ELVEN_STEEL_INGOT);
    }),
    HARAD("harad", Math.round(300*0.06F), new int[] {2,5,4,2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.BRONZE_INGOT);
    }),
    HARAD_WARLORD("harad_warlord_helmet", Math.round(300*0.06F), new int[] {2,5,4,2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.BRONZE_INGOT);
    }),
    UMBAR("umbar", Math.round(450*0.06F), new int[] {2,6,5,2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),
    URUK("uruk", Math.round(550*0.06F), new int[] {2,7,6,2}, 5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.URUK_STEEL_INGOT);
    }),
    URUK_CHIEFTAIN("uruk_chieftain", Math.round(550*0.06F), new int[] {2,7,6,2}, 5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.URUK_STEEL_INGOT);
    }),
    //BLUER_DWARVEN("blue_dwarven", Math.round(650*0.06F), new int[] {1,1,1,1}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
    //    return Ingredient.ofItems(ModItems.DWARVEN_STEEL_INGOT);
    //}),
    FUR("fur", Math.round(230*0.06F), new int[] {1,4,3,1}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.FUR);
    });


    private static final int[] BASE_DURABILITY = {13, 15, 16, 11};
    private final int durabilityMultiplier;
    private final String name;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredient;


    ModArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchatability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchatability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    public int getProtectionAmount(EquipmentSlot slot) { return protectionAmounts[slot.getEntitySlotId()]; }

    public int getEnchantability() { return this.enchantability; }

    public SoundEvent getEquipSound() { return this.equipSound; }

    public Ingredient getRepairIngredient() { return this.repairIngredient.get(); }

    @Environment(EnvType.CLIENT)
    public String getName() { return this.name; }

    public float getToughness() { return this.toughness; }

    public float getKnockbackResistance() { return this.knockbackResistance; }
}
