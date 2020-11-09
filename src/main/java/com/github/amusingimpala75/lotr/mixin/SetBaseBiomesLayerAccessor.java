package com.github.amusingimpala75.lotr.mixin;

import net.minecraft.world.biome.layer.SetBaseBiomesLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
/*
TODO: Check necessity
 */
@Mixin(SetBaseBiomesLayer.class)
public interface SetBaseBiomesLayerAccessor {
    @Accessor("TEMPERATE_BIOMES")
    public static int[] getTemperateBiomes() {
        throw new AssertionError();
    }

    @Accessor("TEMPERATE_BIOMES")
    public static void setTemperateBiomes(int[] biomes) {
        throw new AssertionError();
    }
}