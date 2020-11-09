package com.github.amusingimpala75.lotr;

import com.github.amusingimpala75.lotr.block.ForgeScreenHandler;
import com.github.amusingimpala75.lotr.block.crafting.FactionCraftingScreenHandler;
import com.github.amusingimpala75.lotr.recipe.LotrCrafting;
import com.github.amusingimpala75.lotr.client.LotrClient;
import com.github.amusingimpala75.lotr.registry.*;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.swordglowsblue.artifice.api.Artifice;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.resource.ResourcePack;
import net.minecraft.resource.ResourceType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.lwjgl.glfw.GLFW;

import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Random;

/*
Main Class for LotRMod Fabric
 */
public class Lotr implements ModInitializer {
    public static final String MOD_ID = "lotr";
    public static final ScreenHandlerType<FactionCraftingScreenHandler> FACTION_SCREEN;
    public static final ScreenHandlerType<ForgeScreenHandler> FORGE_SCREEN_HANDLER;
    static {
        FACTION_SCREEN = ScreenHandlerRegistry.registerSimple(id("faction_crafting"), FactionCraftingScreenHandler::new);
        FORGE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(id("alloy_forge"), ForgeScreenHandler::new);
    }
    /*
    Item Groups
     */
    public static final ItemGroup LOTR_MATERIALS = FabricItemGroupBuilder.build(
            id("materials"),
            () -> new ItemStack(Registry.ITEM.get(id("mithril_ingot")))
    );
    public static final ItemGroup LOTR_MISC = FabricItemGroupBuilder.build(
            id("misc"),
            () -> new ItemStack(Registry.ITEM.get(id("gold_ring")))
    );
    public static final ItemGroup LOTR_FOOD = FabricItemGroupBuilder.build(
            id("food"),
            () -> new ItemStack(ModItems.LEMBAS)
    );
    public static final ItemGroup LOTR_COMBAT = FabricItemGroupBuilder.build(
            id("combat"),
            () -> new ItemStack(ModItems.MITHRIL_HELMET)
    );
    public static final ItemGroup LOTR_TOOLS = FabricItemGroupBuilder.build(
            id("tools"),
            () -> new ItemStack(ModItems.MITHRIL_PICKAXE)
    );
    public static final ItemGroup LOTR_BLOCKS = FabricItemGroupBuilder.build(
            id("blocks"),
            () -> new ItemStack(Items.ITEM_FRAME)
    );

    @Override
    public void onInitialize() {
        ModSounds.registerSounds();
        ModBlocks.registerBlocks();
        ModItems.registerItems();
        ModBlockEntites.registerBlockEntities();
        CommandRegistrationCallback.EVENT.register((commandDispatcher, isDedicated) ->
                commandDispatcher.register(CommandManager.literal("faction")
                .then(
                        CommandManager.literal("set")
                                .then(
                                        CommandManager.argument("type", StringArgumentType.string())
                                                .then(
                                                        CommandManager.argument("amount", IntegerArgumentType.integer())
                                                                                .executes(context -> {
                                                                                    String factionToBeSet = StringArgumentType.getString(context, "type");
                                                                                    Integer factionAmount = IntegerArgumentType.getInteger(context, "amount");
                                                                                    PlayerEntity player = context.getSource().getPlayer();
                                                                                    System.out.println("Setting faction "+factionToBeSet+" to "+factionAmount);
                                                                                    return 1;
                                                                                })
                                                                )
                                                                .executes(context -> {
                                                                    System.out.println("Missing Faction Amount!");
                                                                    return 1;
                                                                })
                                )
                                .executes(context -> {
                                    System.out.println("Missing Faction Type!");
                                    return 1;
                                })
                )
                .executes(context -> {
                    System.out.println("Missing what to do to player faction amount!");
                    return 1;
                })));
        ModEntities.registerEntities();
        LotrCrafting.registerCrafting();
        ModBiomes.registerBiomes();
        ModDimensions.registerDimensions();
        LotrClient.registerCutouts();

    }

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }

}
