package com.github.amusingimpala75.lotr.item;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.world.explosion.Explosion;
/*
Item for gold ring
 */
public class GoldRingItem extends Item {
    public GoldRingItem(Settings settings) {
        super(settings);
    }

    //TODO: add portal creation
    @Override
    public boolean damage(DamageSource source) {
        if (source.isFire()) {
            System.out.println("DESTROYING GOLD RING!! from GoldRingItem");
        }
        return super.damage(source);
    }

}
