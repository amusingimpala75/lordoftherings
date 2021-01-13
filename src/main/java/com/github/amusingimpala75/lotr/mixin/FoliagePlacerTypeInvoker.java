package com.github.amusingimpala75.lotr.mixin;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(FoliagePlacerType.class)
public interface FoliagePlacerTypeInvoker {
    @Invoker
    static <P extends FoliagePlacer> FoliagePlacerType<P> invokeRegister(String id, Codec<P> codec) {
        throw new AssertionError();
    }
}
