package com.github.amusingimpala75.lotr.mixin;

import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(DataTracker.class)
@SuppressWarnings("all")
public interface DataTrackerInvoker {

   // @Invoker
   // static <T> DataTracker.Entry<T> getEntry(TrackedData<T> trackedData) {
   //     throw new AssertionError();
   // }
}
