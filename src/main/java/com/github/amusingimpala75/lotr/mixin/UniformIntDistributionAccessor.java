package com.github.amusingimpala75.lotr.mixin;

import net.minecraft.world.gen.UniformIntDistribution;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(UniformIntDistribution.class)
public interface UniformIntDistributionAccessor {
    @Accessor
    int getBase();

    @Accessor
    int getSpread();
}
