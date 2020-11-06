package com.github.amusingimpala75.lotr.item;

import com.github.amusingimpala75.lotr.Lotr;
import com.google.common.collect.ImmutableList;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;

import java.util.Arrays;
import java.util.List;

public class VesselLiquidItem extends Item {
    private final float alcoholicity;
    private final int foodRestorePoints;
    private final float saturationRestorePoints;
    private final boolean isPotent;
    private final float damageAmount;
    private final List<StatusEffectInstance> effects;
    private static final ImmutableList<StatusEffectInstance> empty = ImmutableList.of();

    private VesselLiquidItem(float alc, int food, float sat, boolean hasPots, float dmg, List<StatusEffectInstance> effs) {
        super((new Item.Settings()).maxCount(1).group(Lotr.LOTR_FOOD));
        this.alcoholicity = alc;
        this.foodRestorePoints = food;
        this.saturationRestorePoints = sat;
        this.isPotent = hasPots;
        this.damageAmount = dmg;
        this.effects = effs;
    }
    public static VesselLiquidItem newAlcohol(float alc, int food, float sat) {
        return new VesselLiquidItem(alc, food, sat, true, 0.0F, empty);
    }
    public static VesselLiquidItem newBasic(int food, float sat) {
        return new VesselLiquidItem(0.0F, food, sat, false, 0.0F, empty);
    }
    public static VesselLiquidItem newEffects(int food, float sat, StatusEffectInstance... effs) {
        return new VesselLiquidItem(0.0F, food, sat, true, 0.0F, Arrays.asList(effs));
    }
    public static VesselLiquidItem newEffDmg(int food, float sat, float dmg, StatusEffectInstance... effs) {
        return new VesselLiquidItem(0.0F, food, sat, true, dmg, Arrays.asList(effs));
    }
    public static VesselLiquidItem newEffAlc(float alc, int food, float sat, StatusEffectInstance... effs) {
        return new VesselLiquidItem(alc, food, sat, true, 0.0F, Arrays.asList(effs));
    }

    public float getAlcoholicity() {
        return alcoholicity;
    }

    public int getFoodRestorePoints() {
        return foodRestorePoints;
    }

    public float getSaturationRestorePoints() {
        return saturationRestorePoints;
    }

    public boolean isPotent() {
        return isPotent;
    }

    public float getDamageAmount() {
        return damageAmount;
    }
    public List<StatusEffectInstance> getEffects() {
        return effects;
    }
}
