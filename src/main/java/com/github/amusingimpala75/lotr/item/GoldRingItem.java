package com.github.amusingimpala75.lotr.item;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.world.explosion.Explosion;

public class GoldRingItem extends Item {
    public GoldRingItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean damage(DamageSource source) {
        if (source.isFire()) {
            //double x = source.getSource().getX();
            //double y = source.getSource().getY();
            //double z = source.getSource().getZ();
            System.out.println("DESTROYING GOLD RING!! from GoldRingItem");
            //source.getSource().world.createExplosion(null, x, y, z, 1.0F, Explosion.DestructionType.DESTROY);
        }
        return super.damage(source);
    }

}
