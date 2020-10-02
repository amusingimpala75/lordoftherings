package com.github.amusingimpala75.lotr.block;

import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffect;

public class ModFlowerBlock extends FlowerBlock {
    public ModFlowerBlock(StatusEffect effect, int duration, Settings settings) {
        super(effect, duration, settings);
    }
}
