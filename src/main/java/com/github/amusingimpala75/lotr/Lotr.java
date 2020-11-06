package com.github.amusingimpala75.lotr;

import com.github.amusingimpala75.lotr.block.crafting.FactionCraftingScreenHandler;
import com.github.amusingimpala75.lotr.recipe.LotrCrafting;
import com.github.amusingimpala75.lotr.client.LotrClient;
import com.github.amusingimpala75.lotr.registry.*;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Lotr implements ModInitializer {
    public static final String MOD_ID = "lotr";
    public static final ScreenHandlerType<FactionCraftingScreenHandler> FACTION_SCREEN;
    static {
        FACTION_SCREEN = ScreenHandlerRegistry.registerSimple(id("faction_crafting"), FactionCraftingScreenHandler::new);
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
                                    System.out.println("Missing faction!");
                                    return 1;
                                })
                )
                .executes(context -> {
                    System.out.println("Missing what to do to player faction amount!");
                    return 1;
                })));
        ModEntities.registerEntities();
        LotrCrafting.registerCrafting();
        ModBiomes.registerBiomes();     //Gonna have to wait for artifice to support MultiNoise, as it requires unreachable keys for weirdness, alt, temp, humid
        /*ArtificeResourcePack lotrDataPack = Artifice.registerData(new Identifier("lotr", "dimensions"), (pack) -> {
            pack.setDisplayName("Lotr Dimensions");
            pack.setDescription("Dimensions added by the Lord of the Rings Mod");

            pack.addDimensionType(new Identifier("lotr", "middle_earth_classic"), dimensionTypeBuilder -> dimensionTypeBuilder
                    .hasRaids(false)
                    .ambientLight(0.5F)
                    .bedWorks(true)
                    .coordinate_scale(1)
                    .hasCeiling(false)
                    .hasEnderDragonFight(false)
                    .hasSkylight(true)
                    .infiniburn(BlockTags.INFINIBURN_OVERWORLD.getId())
                    .logicalHeight(256)
                    .natural(false)
                    .piglinSafe(false)
                    .respawnAnchorWorks(false)
                    .ultrawarm(false));
            pack.addDimension(new Identifier("lotr", "middle_earth_classic"), dimensionBuilder -> dimensionBuilder
                    .dimensionType(new Identifier("lotr", "middle_earth_classic"))
                    .noiseGenerator(noiseChunkGeneratorTypeBuilder -> {
                        noiseChunkGeneratorTypeBuilder.multiNoiseBiomeSource(multiNoiseBiomeSourceBuilder -> {
                            multiNoiseBiomeSourceBuilder
                            .addBiome(biomeBuilder -> {
                        biomeBuilder.biome("lotr:shire");
                        biomeBuilder.parameters(biomeParametersBuilder -> {
                            biomeParametersBuilder.altitude(0.0F);
                            biomeParametersBuilder.humidity(0.0F);
                            biomeParametersBuilder.offset(0.175F);
                            biomeParametersBuilder.temperature(-0.5F);
                            biomeParametersBuilder.weirdness(0.0F);
                        });
                    });
                            multiNoiseBiomeSourceBuilder.seed((int)(new Random().nextLong()));
                        })
                                .type("minecraft:multi_noise");
                        noiseChunkGeneratorTypeBuilder.seed((int)(new Random().nextLong()));
                        noiseChunkGeneratorTypeBuilder.noiseSettings("minecraft:overworld");
                        noiseChunkGeneratorTypeBuilder.type("minecraft:noise");
                    }));
            pack.shouldOverwrite();
        });
        lotrDataPack.isVisible();*/
        LotrClient.registerCutouts();

    }

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }
}
