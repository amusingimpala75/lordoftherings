package com.github.amusingimpala75.lotr.entity;

import net.minecraft.entity.damage.DamageSource;

public class ModDamageSources extends DamageSource {
    public static final DamageSource STALAGMITE = new ModDamageSources("lotr.stalagmite").setBypassesArmor();
    public ModDamageSources(String name) {
        super(name);
    }
}
