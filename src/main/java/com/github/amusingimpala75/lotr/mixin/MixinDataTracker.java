package com.github.amusingimpala75.lotr.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DataTracker.class)
public class MixinDataTracker {

    @Shadow
    @Final
    @Mutable
    private Entity trackedEntity;

    @Shadow
    @Final
    @Mutable
    private boolean dirty;

    @Shadow
    @Final
    @Mutable
    private <T> DataTracker.Entry<T> getEntry(TrackedData<T> trackedData) {
        throw new AssertionError();
    }

    @Inject(at = @At("HEAD"), method = "set")
    public <T> void fixBoatNullError(TrackedData<T> key, T object, CallbackInfo info) {
        DataTracker.Entry<T> entry = getEntry(key);
        entry.set(object);
        trackedEntity.onTrackedDataSet(key);
        entry.setDirty(true);
        dirty = true;
    }
}
