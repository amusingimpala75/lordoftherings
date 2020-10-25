package com.github.amusingimpala75.lotr.registry;

import com.github.amusingimpala75.lotr.Lotr;
import com.github.amusingimpala75.lotr.block.Plate;
import com.github.amusingimpala75.lotr.entity.PlateBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntites {
    public static final Block WOODEN_PLATE = new Plate(FabricBlockSettings.of(Material.WOOD).nonOpaque().noCollision());
    public static final Block FINE_PLATE = new Plate(FabricBlockSettings.of(Material.STONE).noCollision().nonOpaque());
    public static final Block STONEWARE_PLATE = new Plate(FabricBlockSettings.of(Material.STONE).nonOpaque().noCollision());
    public static BlockEntityType<PlateBlockEntity> PLATE_ENTITY;
    public static final BlockEntityType<SignBlockEntity> PINE_SIGN = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("lotr", "pine_sign"), BlockEntityType.Builder.create(SignBlockEntity::new, ModBlocks.PINE_SIGN).build(null));

    public static void registerBlockEntities() {
        Registry.register(Registry.BLOCK, new Identifier("lotr", "fine_plate"), FINE_PLATE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "fine_plate"), new BlockItem(FINE_PLATE, new Item.Settings().group(Lotr.LOTR_FOOD)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "stoneware_plate"), STONEWARE_PLATE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "stoneware_plate"), new BlockItem(STONEWARE_PLATE, new Item.Settings().group(Lotr.LOTR_FOOD)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "wooden_plate"), WOODEN_PLATE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "wooden_plate"), new BlockItem(WOODEN_PLATE, new Item.Settings().group(Lotr.LOTR_FOOD)));
        PLATE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("lotr", "wooden_plate"), BlockEntityType.Builder.create(PlateBlockEntity::new, ModBlockEntites.WOODEN_PLATE, FINE_PLATE, STONEWARE_PLATE).build(null));
    }
}
