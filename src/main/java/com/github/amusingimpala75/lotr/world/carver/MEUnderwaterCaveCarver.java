package com.github.amusingimpala75.lotr.world.carver;

import com.github.amusingimpala75.lotr.world.ModCarvers;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.UnderwaterCaveCarver;

public class MEUnderwaterCaveCarver extends UnderwaterCaveCarver {
    public MEUnderwaterCaveCarver(Codec<ProbabilityConfig> codec) {
        super(codec);
        this.alwaysCarvableBlocks = ModCarvers.listUnderwaterCarvableBlocks();
    }
}
