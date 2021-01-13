package com.github.amusingimpala75.lotr.mixin;

import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(NoiseChunkGenerator.class)
public interface NoiseChunkGeneratorInvokers {
    @Invoker
    void invokeSampleNoiseColumn(double[] buffer, int x, int z);

}
