package com.github.amusingimpala75.lotr;

import com.github.amusingimpala75.lotr.registry.ModBiomes;
import com.github.amusingimpala75.lotr.registry.ModEntities;
import com.github.amusingimpala75.lotr.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import com.github.amusingimpala75.lotr.registry.ModBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class Lotr implements ModInitializer {
    /*
    Item Groups
     */
    public static final ItemGroup LOTR_MATERIALS = FabricItemGroupBuilder.build(
            new Identifier("lotr", "materials"),
            () -> new ItemStack(ModItems.MITHRIL_INGOT)
    );
    public static final ItemGroup LOTR_MISC = FabricItemGroupBuilder.build(
            new Identifier("lotr", "misc"),
            () -> new ItemStack(ModItems.GOLD_RING)
    );
    public static final ItemGroup LOTR_FOOD = FabricItemGroupBuilder.build(
            new Identifier("lotr", "food"),
            () -> new ItemStack(ModItems.LEMBAS)
    );
    public static final ItemGroup LOTR_COMBAT = FabricItemGroupBuilder.build(
            new Identifier("lotr", "combat"),
            () -> new ItemStack(ModItems.MITHRIL_HELMET)
    );
    public static final ItemGroup LOTR_TOOLS = FabricItemGroupBuilder.build(
            new Identifier("lotr", "tools"),
            () -> new ItemStack(ModItems.MITHRIL_PICKAXE)
    );
    public static final ItemGroup LOTR_BLOCKS = FabricItemGroupBuilder.build(
            new Identifier("lotr", "blocks"),
            () -> new ItemStack(Items.ITEM_FRAME)
    );

    @Override
    public void onInitialize() {
        ModBlocks.registerBlocks();
        ModItems.registerItems();
        ModEntities.registerEntities();
        ModBiomes.registerBiomes();
    }
}
