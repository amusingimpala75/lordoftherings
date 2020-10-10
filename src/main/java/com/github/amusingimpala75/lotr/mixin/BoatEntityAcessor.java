package com.github.amusingimpala75.lotr.mixin;

import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.vehicle.BoatEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BoatEntity.class)
public interface BoatEntityAcessor {

    @Accessor("DAMAGE_WOBBLE_TICKS")
    public static TrackedData<Integer> getDAMAGE_WOBBLE_TICKS() {throw new AssertionError();}

    @Accessor("DAMAGE_WOBBLE_SIDE")
    public static TrackedData<Integer> getDAMAGE_WOBBLE_SIDE() {throw new AssertionError();}

    @Accessor("DAMAGE_WOBBLE_STRENGTH")
    public static TrackedData<Float> getDAMAGE_WOBBLE_STRENGTH() {throw new AssertionError();}

    @Accessor("LEFT_PADDLE_MOVING")
    public static TrackedData<Boolean> getLEFT_PADDLE_MOVING() {throw new AssertionError();}

    @Accessor("RIGHT_PADDLE_MOVING")
    public static TrackedData<Boolean> getRIGHT_PADDLE_MOVING() {throw new AssertionError();}

    @Accessor("BUBBLE_WOBBLE_TICKS")
    public static TrackedData<Integer> getBUBBLE_WOBBLE_TICKS() {throw new AssertionError();}



}
