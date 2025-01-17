package com.github.amusingimpala75.lotr.materials;

import com.github.amusingimpala75.lotr.registry.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;
/*
ME tool types
 */
public enum ModToolMaterial implements ToolMaterial {
    MITHRIL("mithril", 2400, 9.0F, 8.0F, 4, 10, () -> {
        return Ingredient.ofItems(ModItems.MITHRIL_INGOT);
    }),
    BRONZE("bronze", 230, 5.0F, 4.5F, 2, 10, () -> {
        return Ingredient.ofItems(ModItems.BRONZE_INGOT);
    }),
    MORDOR("mordor", 400, 6.0F, 5.5F, 2, 7, () -> {
        return Ingredient.ofItems(ModItems.ORC_STEEL_INGOT);
    }),
    GONDOR("gondor", 450, 6.0F, 5.5F, 2, 10, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),
    ROHAN("rohan", 300, 6.0F, 5.5F, 2, 10, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),
    DWARVEN("dwarven", 700, 7.0F, 6.0F, 3, 10, () -> {
        return Ingredient.ofItems(ModItems.DWARVEN_STEEL_INGOT);
    }),
    LINDON("lindon", 700, 8.0F, 6.0F, 2, 15, () -> {
        return Ingredient.ofItems(ModItems.ELVEN_STEEL_INGOT);
    }),
    RIVENDELL("rivendell", 700, 8.0F, 6.0F, 2, 15, () -> {
        return Ingredient.ofItems(ModItems.ELVEN_STEEL_INGOT);
    }),
    GALADHIRM("galadhrim", 600, 7.0F, 6.0F, 2, 15, () -> {
        return Ingredient.ofItems(ModItems.ELVEN_STEEL_INGOT);
    }),
    WOOD_ELVEN("wood_elven", 500, 9.0F, 6.0F, 2, 15, () -> {
        return Ingredient.ofItems(ModItems.ELVEN_STEEL_INGOT);
    }),
    HARAD("harad", 300, 6.0F, 5.5F, 2, 10, () -> {
        return Ingredient.ofItems(ModItems.BRONZE_INGOT);
    }),
    URUK("uruk", 550, 6.0F, 6.0F, 2, 5, () -> {
        return Ingredient.ofItems(ModItems.URUK_STEEL_INGOT);
    }),
    UMBAR("umbar",400, 6.0F, 5.5F, 2, 10, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),
    BLUE_DWARVEN("blue_dwarven", 650, 7.0F, 6.0F, 3, 12, () -> {
        return Ingredient.ofItems(ModItems.DWARVEN_STEEL_INGOT);
    });


    private final String name;
    private final int durability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int miningLevel;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    ModToolMaterial(String name, int durability, float miningSpeed, float attackDamage, int miningLevel, int enchantablilty, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.miningLevel = miningLevel;
        this.enchantability = enchantablilty;
        this.repairIngredient = new Lazy(repairIngredient);
    }



    @Override
    public int getDurability() { return this.durability; }

    @Override
    public float getMiningSpeedMultiplier() { return this.miningSpeed; }

    @Override
    public float getAttackDamage() { return this.attackDamage; }

    @Override
    public int getMiningLevel() { return this.miningLevel; }

    @Override
    public int getEnchantability() { return this.enchantability; }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
    @Environment(EnvType.CLIENT)
    public String getName() { return this.name; }
}
