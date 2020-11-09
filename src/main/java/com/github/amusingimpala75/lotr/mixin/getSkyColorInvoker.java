package com.github.amusingimpala75.lotr.mixin;

import net.minecraft.world.biome.DefaultBiomeCreator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
/*
Mixins for DefaultBiomeCreator
*/
@Mixin(DefaultBiomeCreator.class)
public interface getSkyColorInvoker {
    //Used to determine SkyColor based on temperature of biome
    @Invoker
    static int invokeGetSkyColor(float temperature) {
        throw new AssertionError();
    }
}
