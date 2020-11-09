package com.github.amusingimpala75.lotr.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.github.amusingimpala75.lotr.Lotr.*;
/*
Registry for entities
 */
public class ModEntities {
    public static final EntityType<BoatEntity> PINE_BOAT = Registry.register(Registry.ENTITY_TYPE, id("pine_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> MALLORN_BOAT = Registry.register(Registry.ENTITY_TYPE, id("mallorn_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> MIRK_OAK_BOAT = Registry.register(Registry.ENTITY_TYPE, id("mirk_oak_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> CHARRED_BOAT = Registry.register(Registry.ENTITY_TYPE, id("charred_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> APPLE_BOAT = Registry.register(Registry.ENTITY_TYPE, id("apple_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> PEAR_BOAT = Registry.register(Registry.ENTITY_TYPE, id("pear_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> CHERRY_BOAT = Registry.register(Registry.ENTITY_TYPE, id("cherry_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> LEBETHRON_BOAT = Registry.register(Registry.ENTITY_TYPE, id("lebethron_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> BEECH_BOAT = Registry.register(Registry.ENTITY_TYPE, id("beech_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> MAPLE_BOAT = Registry.register(Registry.ENTITY_TYPE, id("maple_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> ASPEN_BOAT = Registry.register(Registry.ENTITY_TYPE, id("aspen_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> LAIRELOSSE_BOAT = Registry.register(Registry.ENTITY_TYPE, id("larielosse_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> CEDAR_BOAT = Registry.register(Registry.ENTITY_TYPE, id("cedar_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> FIR_BOAT = Registry.register(Registry.ENTITY_TYPE, id("fir_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> LARCH_BOAT = Registry.register(Registry.ENTITY_TYPE, id("larch_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> GREEN_OAK_BOAT = Registry.register(Registry.ENTITY_TYPE, id("green_oak_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> HOLLY_BOAT = Registry.register(Registry.ENTITY_TYPE, id("holly_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> CYPRESS_BOAT = Registry.register(Registry.ENTITY_TYPE, id("cypress_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> ROTTEN_BOAT = Registry.register(Registry.ENTITY_TYPE, id("rotten_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());



    public static void registerEntities() {
    }
}
