package com.github.amusingimpala75.lotr.client;

import com.github.amusingimpala75.lotr.client.renderer.ModBoatRenderer;
import com.github.amusingimpala75.lotr.client.renderer.PlateBlockEntityRenderer;
import com.github.amusingimpala75.lotr.earlyrisers.LotrEarlyRisers;
import com.github.amusingimpala75.lotr.registry.ModBlockEntites;
import com.github.amusingimpala75.lotr.registry.ModEntities;
import com.github.amusingimpala75.lotr.registry.ModItems;
import com.github.amusingimpala75.lotr.resources.LotrThrowawayResource;
import com.github.amusingimpala75.lotr.resources.MetadataWrapper;
import com.swordglowsblue.artifice.api.Artifice;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.impl.resource.loader.ResourceManagerHelperImpl;
import net.fabricmc.loader.ModContainer;
import net.fabricmc.loader.api.metadata.ModEnvironment;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.fabricmc.loader.metadata.BuiltinModMetadata;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.resource.DirectoryResourcePack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.lwjgl.glfw.GLFW;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import static com.github.amusingimpala75.lotr.registry.ModBlocks.*;
import static com.github.amusingimpala75.lotr.Lotr.*;

@Environment(EnvType.CLIENT)
public class LotrClient implements ClientModInitializer {
    public static Block[] blocksForCutout = new Block[] {};
    //list of all slabs
    public static final String[][] slabStuff = {
            {"minecraft", "oak_slab", "oak_planks"},
            {"minecraft", "spruce_slab", "spruce_planks"},
            {"minecraft", "birch_slab", "birch_planks"},
            {"minecraft", "jungle_slab", "jungle_planks"},
            {"minecraft", "acacia_slab", "acacia_planks"},
            {"minecraft", "dark_oak_slab", "dark_oak_planks"},
            {"minecraft", "crimson_slab", "crimson_planks"},
            {"minecraft", "warped_slab", "warped_planks"},
            {"minecraft", "stone_slab", "stone"},
            {"minecraft", "smooth_stone_slab", "smooth_stone"},
            {"minecraft", "granite_slab", "granite"},
            {"minecraft", "polished_granite_slab", "polished_granite"},
            {"minecraft", "diorite_slab", "diorite"},
            {"minecraft", "polished_diorite_slab", "polished_diorite"},
            {"minecraft", "andesite_slab", "andesite"},
            {"minecraft", "polished_andesite_slab", "polished_andesite"},
            {"minecraft", "cobblestone_slab", "cobblestone"},
            {"minecraft", "mossy_cobblestone_slab", "mossy_cobblestone"},
            {"minecraft", "stone_brick_slab", "stone_bricks"},
            {"minecraft", "mossy_stone_brick_slab", "mossy_stone_bricks"},
            {"minecraft", "brick_slab", "bricks"},
            {"minecraft", "end_stone_brick_slab", "end_stone_bricks"},
            {"minecraft", "nether_brick_slab", "nether_bricks"},
            {"minecraft", "red_nether_brick_slab", "red_nether_bricks"},
            {"minecraft", "sandstone_slab", "sandstone"},
            {"minecraft", "cut_sandstone_slab", "cut_sandstone"},
            {"minecraft", "smooth_sandstone_slab", "smooth_sandstone"},
            {"minecraft", "red_sandstone_slab", "red_sandstone"},
            {"minecraft", "cut_red_sandstone_slab", "cut_red_sandstone"},
            {"minecraft", "smooth_red_sandstone_slab", "smooth_red_sandstone"},
            {"minecraft", "quartz_slab", "quartz_block"},
            {"minecraft", "smooth_quartz_slab", "smooth_quartz"},
            {"minecraft", "purpur_slab", "purpur_block"},
            {"minecraft", "prismarine_slab", "prismarine"},
            {"minecraft", "prismarine_brick_slab", "prismarine_bricks"},
            {"minecraft", "dark_prismarine_slab", "dark_prismarine"},
            {"minecraft", "petrified_oak_slab", "oak_planks"},
            {"minecraft", "blackstone_slab", "blackstone"},
            {"minecraft", "polished_blackstone_slab", "polished_blackstone"},
            {"minecraft", "polished_blackstone_brick_slab", "polished_blackstone_bricks"},
            {"lotr", "gondor_rock_slab", "gondor_rock"},
            {"lotr", "pine_slab", "pine_planks"},
            {"lotr", "mallorn_slab", "mallorn_planks"},
            {"lotr", "gondor_brick_slab", "gondor_brick"},
            {"lotr", "mordor_rock_slab", "mordor_rock"},
            {"lotr", "mordor_brick_slab", "mordor_brick"},
            {"lotr", "rohan_rock_slab", "rohan_rock"},
            {"lotr","rohan_brick_slab","rohan_brick"}};

    public static void addBlocksToRenderLayer(Block blockToAdd) {
        Block[] nextArray = new Block[blocksForCutout.length+1];
        System.arraycopy(blocksForCutout, 0, nextArray, 0, blocksForCutout.length);
        nextArray[blocksForCutout.length] = blockToAdd;
        blocksForCutout = nextArray;
    }

    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(FACTION_SCREEN, FactionScreen::new);
        ScreenRegistry.register(FORGE_SCREEN_HANDLER, ForgeScreen::new);
        EntityRendererRegistry.INSTANCE.register(ModEntities.PINE_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "pine")
        );
        EntityRendererRegistry.INSTANCE.register(ModEntities.MALLORN_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "mallorn")
        );
        EntityRendererRegistry.INSTANCE.register(ModEntities.MIRK_OAK_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "mirk_oak")
        );
        EntityRendererRegistry.INSTANCE.register(ModEntities.CHARRED_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "charred")
        );
        EntityRendererRegistry.INSTANCE.register(ModEntities.APPLE_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "apple")
        );
        EntityRendererRegistry.INSTANCE.register(ModEntities.PEAR_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "pear")
        );
        EntityRendererRegistry.INSTANCE.register(ModEntities.CHERRY_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "cherry")
        );
        EntityRendererRegistry.INSTANCE.register(ModEntities.LEBETHRON_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "lebethron")
        );
        EntityRendererRegistry.INSTANCE.register(ModEntities.BEECH_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "beech")
        );
        EntityRendererRegistry.INSTANCE.register(ModEntities.MAPLE_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "maple")
        );
        EntityRendererRegistry.INSTANCE.register(ModEntities.ASPEN_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "aspen")
        );
        EntityRendererRegistry.INSTANCE.register(ModEntities.LAIRELOSSE_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "lairelosse")
        );
        EntityRendererRegistry.INSTANCE.register(ModEntities.CEDAR_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "cedar")
        );
        EntityRendererRegistry.INSTANCE.register(ModEntities.FIR_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "fir")
        );
        EntityRendererRegistry.INSTANCE.register(ModEntities.LARCH_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "larch")
        );
        EntityRendererRegistry.INSTANCE.register(ModEntities.HOLLY_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "holly")
        );
        EntityRendererRegistry.INSTANCE.register(ModEntities.GREEN_OAK_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "green_oak")
        );
        EntityRendererRegistry.INSTANCE.register(ModEntities.CYPRESS_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "cypress")
        );
        EntityRendererRegistry.INSTANCE.register(ModEntities.ROTTEN_BOAT, (dispatcher, context) ->
                new ModBoatRenderer(dispatcher, "rotten")
        );

        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntites.PINE_SIGN, SignBlockEntityRenderer::new);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D),
                CLOVER,
                FOUR_CLOVER,
                NETTLES,
                THISTLES);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                MALLORN_LADDER,
                ASPEN_LEAVES,
                POTTED_ASPEN,
                ASPEN_SAPLING,
                BRONZE_LANTERN,
                CANDLE,
                ORC_TORCH,
                CLOVER,
                FOUR_CLOVER,
                HANGING_WEB,
                THISTLES,
                NETTLES,
                MIRK_OAK_LEAVES,
                ModItems.FLAX_CROP,
                ModItems.PIPEWEED_CROP,
                ModItems.LETTUCE_BLOCK);

        Artifice.registerAssetPack("lotr:slab_assets", pack -> {
            for (int i = 0; i < slabStuff.length; i++) {
                int finalI = i;
                pack.addBlockState(new Identifier(slabStuff[finalI][0], slabStuff[finalI][1]), state -> state
                        .variant("type=bottom", variant -> variant.model(new Identifier(slabStuff[finalI][0], "block/"+slabStuff[finalI][1])))
                        .variant("type=top", variant -> variant.model(new Identifier(slabStuff[finalI][0], "block/"+slabStuff[finalI][1]+"_top")))
                        .variant("type=double", variant -> variant.model(new Identifier(slabStuff[finalI][0], "block/"+slabStuff[finalI][2])))
                        .variant("type=north", variant -> variant.model(new Identifier(slabStuff[finalI][0], "block/"+slabStuff[finalI][1])).rotationX(270).uvlock(true))
                        .variant("type=south", variant -> variant.model(new Identifier(slabStuff[finalI][0], "block/"+slabStuff[finalI][1]+"_top")).rotationX(270).uvlock(true))
                        .variant("type=zdouble", variant -> variant.model(new Identifier(slabStuff[finalI][0], "block/"+slabStuff[finalI][2])).rotationX(270).uvlock(true))
                        .variant("type=east", variant -> variant.model(new Identifier(slabStuff[finalI][0], "block/"+slabStuff[finalI][1])).rotationX(90).rotationY(90).uvlock(true))
                        .variant("type=west", variant -> variant.model(new Identifier(slabStuff[finalI][0], "block/"+slabStuff[finalI][1]+"_top")).rotationX(90).rotationY(90).uvlock(true))
                        .variant("type=xdouble", variant -> variant.model(new Identifier(slabStuff[finalI][0], "block/"+slabStuff[finalI][2])).rotationX(90).rotationY(90).uvlock(true)));
            }
            pack.shouldOverwrite();
            pack.setDisplayName("Lord of the Rings Slab Assets");
            pack.setDescription("because we are lazy and this is easier");
        });
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntites.PLATE_ENTITY, PlateBlockEntityRenderer::new);
        String name = MinecraftClient.getInstance().getSession().getUsername();
        String[] quotes = {"The world is indeed full of peril and in it there are many dark places.", "It's a dangerous business, "+name+", going out your door. You step onto the road, and if you don't keep your feet, there's no knowing where you might be swept off to.", "Ash nazg durbatulûk, ash nazg gimbatul,\n" +
                "ash nazg thrakatulûk agh burzum-ishi krimpatul."};
        int randomQuote = (int)((Math.random() * quotes.length) - 1);
        LogManager.getLogger().info(quotes[randomQuote]);
        KeyBinding map = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.lotr.map",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_L,
                "category.lotr.things"
        ));
        ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {
            if (map.isPressed()) {
                //open map
                MinecraftClient.getInstance().openScreen(new MapScreen(minecraftClient.player));
                //new MapScreen(minecraftClient.player);
            }
        });
        System.out.println("Registering Assets");
        if (LotrThrowawayResource.RESOURCE_FILE == null) {
            try {
                throw new FileNotFoundException("LotR-Resources not loaded yet. Delete the version dir under .lotrResources/<version> and try again");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new NullPointerException();
            }
        }
        DirectoryResourcePack pack = new DirectoryResourcePack(LotrThrowawayResource.RESOURCE_FILE);
        ModMetadata metadata = new BuiltinModMetadata.Builder("lotr_resources", "1.0").setName("LotR-Resources").setEnvironment(ModEnvironment.UNIVERSAL).setDescription("Resources added by LotR extracted by throwaway loader").build();
        URL url;
        try {
            url = LotrThrowawayResource.RESOURCE_FILE.toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new NullPointerException();
        }
        ModContainer container = new ModContainer(new MetadataWrapper(metadata), url);
        try {
            Class klass = ModContainer.class;
            Method method = klass.getDeclaredMethod("setupRootPath");
            method.setAccessible(true);
            method.invoke(container);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        ResourceManagerHelper.registerBuiltinResourcePack(id("resources"), "", container, true);
    }

    @Environment(EnvType.CLIENT)
    public static void registerCutouts() {
        for (Block block : blocksForCutout) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutoutMipped());
        }
    }
}
