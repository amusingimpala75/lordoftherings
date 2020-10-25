package com.github.amusingimpala75.lotr.registry;

import com.github.amusingimpala75.lotr.entity.PlateBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<BoatEntity> PINE_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("lotr", "pine_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> MALLORN_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("lotr", "mallorn_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> MIRK_OAK_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("lotr", "mirk_oak_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> CHARRED_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("lotr", "charred_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> APPLE_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("lotr", "apple_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> PEAR_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("lotr", "pear_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> CHERRY_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("lotr", "cherry_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> LEBETHRON_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("lotr", "lebethron_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> BEECH_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("lotr", "beech_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> MAPLE_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("lotr", "maple_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> ASPEN_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("lotr", "aspen_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> LAIRELOSSE_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("lotr", "larielosse_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> CEDAR_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("lotr", "cedar_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> FIR_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("lotr", "fir_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> LARCH_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("lotr", "larch_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> GREEN_OAK_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("lotr", "green_oak_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> HOLLY_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("lotr", "holly_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    public static final EntityType<BoatEntity> CYPRESS_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("lotr", "cypress_boat"), FabricEntityTypeBuilder.<BoatEntity>create(SpawnGroup.MISC, BoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());



    public static void registerEntities() {
    }
}
