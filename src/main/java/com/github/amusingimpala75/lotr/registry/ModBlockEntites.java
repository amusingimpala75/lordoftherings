package com.github.amusingimpala75.lotr.registry;

import com.github.amusingimpala75.lotr.Lotr;
import com.github.amusingimpala75.lotr.block.ForgeBlock;
import com.github.amusingimpala75.lotr.block.OvenBlock;
import com.github.amusingimpala75.lotr.block.Plate;
import com.github.amusingimpala75.lotr.entity.ForgeBlockEntity;
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

import static com.github.amusingimpala75.lotr.Lotr.id;

/*
Registry for BlockEntities and related blocks
 */
public class ModBlockEntites {
    public static final Block WOODEN_PLATE = new Plate(FabricBlockSettings.of(Material.WOOD).nonOpaque().noCollision());
    public static final Block FINE_PLATE = new Plate(FabricBlockSettings.of(Material.STONE).noCollision().nonOpaque());
    public static final Block STONEWARE_PLATE = new Plate(FabricBlockSettings.of(Material.STONE).nonOpaque().noCollision());
    public static final Block ALLOY_FORGE = new ForgeBlock(FabricBlockSettings.of(Material.STONE));
    public static final Block DWARVEN_FORGE = new ForgeBlock(FabricBlockSettings.of(Material.STONE));
    public static final Block ELVEN_FORGE = new ForgeBlock(FabricBlockSettings.of(Material.STONE));
    public static final Block ORC_FORGE = new ForgeBlock(FabricBlockSettings.of(Material.STONE));
    public static final Block HOBBIT_OVEN = new OvenBlock(FabricBlockSettings.of(Material.STONE));
    public static BlockEntityType<PlateBlockEntity> PLATE_ENTITY;
    public static BlockEntityType<ForgeBlockEntity> FORGE_ENTITY;
    public static final BlockEntityType<SignBlockEntity> PINE_SIGN = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("lotr", "pine_sign"), BlockEntityType.Builder.create(SignBlockEntity::new, ModBlocks.PINE_SIGN).build(null));

    public static void registerBlockEntities() {
        Registry.register(Registry.BLOCK, new Identifier("lotr", "fine_plate"), FINE_PLATE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "fine_plate"), new BlockItem(FINE_PLATE, new Item.Settings().group(Lotr.LOTR_FOOD)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "stoneware_plate"), STONEWARE_PLATE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "stoneware_plate"), new BlockItem(STONEWARE_PLATE, new Item.Settings().group(Lotr.LOTR_FOOD)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "wooden_plate"), WOODEN_PLATE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "wooden_plate"), new BlockItem(WOODEN_PLATE, new Item.Settings().group(Lotr.LOTR_FOOD)));
        /*
        Forges and Ovens - need functionality
         */
        Registry.register(Registry.BLOCK, id("alloy_forge"), ALLOY_FORGE);
        Registry.register(Registry.ITEM, id("alloy_forge"), new BlockItem(ALLOY_FORGE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, id("dwarven_forge"), DWARVEN_FORGE);
        Registry.register(Registry.ITEM, id("dwarven_forge"), new BlockItem(DWARVEN_FORGE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, id("elven_forge"), ELVEN_FORGE);
        Registry.register(Registry.ITEM, id("elven_forge"), new BlockItem(ELVEN_FORGE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, id("orc_forge"), ORC_FORGE);
        Registry.register(Registry.ITEM, id("orc_forge"), new BlockItem(ORC_FORGE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, id("hobbit_oven"), HOBBIT_OVEN);
        Registry.register(Registry.ITEM, id("hobbit_oven"), new BlockItem(HOBBIT_OVEN, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        PLATE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("lotr", "wooden_plate"), BlockEntityType.Builder.create(PlateBlockEntity::new, ModBlockEntites.WOODEN_PLATE, FINE_PLATE, STONEWARE_PLATE).build(null));
        FORGE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("lotr", "forge_entity"), BlockEntityType.Builder.create(ForgeBlockEntity::new, DWARVEN_FORGE, ELVEN_FORGE, ORC_FORGE, ALLOY_FORGE).build(null));
    }
}
