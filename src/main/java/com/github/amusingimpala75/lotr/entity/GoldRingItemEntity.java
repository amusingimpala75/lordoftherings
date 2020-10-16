package com.github.amusingimpala75.lotr.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@SuppressWarnings("all")
public class GoldRingItemEntity extends ItemEntity {
    public GoldRingItemEntity(EntityType<? extends ItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public GoldRingItemEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public GoldRingItemEntity(World world, double x, double y, double z, ItemStack stack) {
        super(world, x, y, z, stack);
    }
}
