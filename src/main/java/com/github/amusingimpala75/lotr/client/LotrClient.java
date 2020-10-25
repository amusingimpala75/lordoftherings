package com.github.amusingimpala75.lotr.client;

import com.github.amusingimpala75.lotr.client.renderer.ModBoatRenderer;
import com.github.amusingimpala75.lotr.client.renderer.PlateBlockEntityRenderer;
import com.github.amusingimpala75.lotr.registry.ModBlockEntites;
import com.github.amusingimpala75.lotr.registry.ModBlocks;
import com.github.amusingimpala75.lotr.registry.ModEntities;
import com.github.amusingimpala75.lotr.registry.ModItems;
import com.swordglowsblue.artifice.api.Artifice;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;

import static com.github.amusingimpala75.lotr.registry.ModBlocks.*;

@Environment(EnvType.CLIENT)
public class LotrClient implements ClientModInitializer {
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
            {"minecraft", "diorite_slab", "doirite"},
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
            {"minecraft", "quartz_slab", "quartz"},
            {"minecraft", "smooth_quartz_slab", "smooth_quartz"},
            {"minecraft", "purpur_slab", "purpur_block"},
            {"minecraft", "prismarine_slab", "prismarine"},
            {"minecraft", "prismarine_brick_slab", "prismarine_bricks"},
            {"minecraft", "dark_prismarine_slab", "dark_prismarine"},
            {"minecraft", "pertrified_oak_slab", "oak_planks"},
            {"minecraft", "blackstone_slab", "blackstone"},
            {"minecraft", "polished_blackstone_slab", "polished_blackstone"},
            {"minecraft", "polished_blackstone_brick_slab", "polished_blackstone_bricks"},
            {"lotr", "gondor_rock_slab", "gondor_rock"},
            {"lotr", "pine_slab", "pine_planks"},
            {"lotr", "mallorn_slab", "mallorn_planks"},
            {"lotr", "gondor_brick_slab", "gondor_bricks"},
            {"lotr", "mordor_rock_slab", "mordor_rock"},
            {"lotr", "mordor_brick_slab", "mordor_bricks"},
            {"lotr", ""}};
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register((EntityType<?>) ModEntities.PINE_BOAT, (dispatcher, context) -> {
            return new ModBoatRenderer(dispatcher, "pine");
        });
        EntityRendererRegistry.INSTANCE.register((EntityType<?>) ModEntities.MALLORN_BOAT, (dispatcher, context) -> {
            return new ModBoatRenderer(dispatcher, "mallorn");
        });
        EntityRendererRegistry.INSTANCE.register((EntityType<?>) ModEntities.MIRK_OAK_BOAT, (dispatcher, context) -> {
            return new ModBoatRenderer(dispatcher, "mirk_oak");
        });
        EntityRendererRegistry.INSTANCE.register((EntityType<?>) ModEntities.CHARRED_BOAT, (dispatcher, context) -> {
            return new ModBoatRenderer(dispatcher, "charred");
        });
        EntityRendererRegistry.INSTANCE.register((EntityType<?>) ModEntities.APPLE_BOAT, (dispatcher, context) -> {
            return new ModBoatRenderer(dispatcher, "apple");
        });
        EntityRendererRegistry.INSTANCE.register((EntityType<?>) ModEntities.PEAR_BOAT, (dispatcher, context) -> {
            return new ModBoatRenderer(dispatcher, "pear");
        });
        EntityRendererRegistry.INSTANCE.register((EntityType<?>) ModEntities.CHERRY_BOAT, (dispatcher, context) -> {
            return new ModBoatRenderer(dispatcher, "cherry");
        });
        EntityRendererRegistry.INSTANCE.register((EntityType<?>) ModEntities.LEBETHRON_BOAT, (dispatcher, context) -> {
            return new ModBoatRenderer(dispatcher, "lebethron");
        });
        EntityRendererRegistry.INSTANCE.register((EntityType<?>) ModEntities.BEECH_BOAT, (dispatcher, context) -> {
            return new ModBoatRenderer(dispatcher, "beech");
        });
        EntityRendererRegistry.INSTANCE.register((EntityType<?>) ModEntities.MAPLE_BOAT, (dispatcher, context) -> {
            return new ModBoatRenderer(dispatcher, "maple");
        });
        EntityRendererRegistry.INSTANCE.register((EntityType<?>) ModEntities.ASPEN_BOAT, (dispatcher, context) -> {
            return new ModBoatRenderer(dispatcher, "aspen");
        });
        EntityRendererRegistry.INSTANCE.register((EntityType<?>) ModEntities.LAIRELOSSE_BOAT, (dispatcher, context) -> {
            return new ModBoatRenderer(dispatcher, "laireloss");
        });
        EntityRendererRegistry.INSTANCE.register((EntityType<?>) ModEntities.CEDAR_BOAT, (dispatcher, context) -> {
            return new ModBoatRenderer(dispatcher, "cedar");
        });
        EntityRendererRegistry.INSTANCE.register((EntityType<?>) ModEntities.FIR_BOAT, (dispatcher, context) -> {
            return new ModBoatRenderer(dispatcher, "fir");
        });
        EntityRendererRegistry.INSTANCE.register((EntityType<?>) ModEntities.LARCH_BOAT, (dispatcher, context) -> {
            return new ModBoatRenderer(dispatcher, "larch");
        });
        EntityRendererRegistry.INSTANCE.register((EntityType<?>) ModEntities.HOLLY_BOAT, (dispatcher, context) -> {
            return new ModBoatRenderer(dispatcher, "holly");
        });
        EntityRendererRegistry.INSTANCE.register((EntityType<?>) ModEntities.GREEN_OAK_BOAT, (dispatcher, context) -> {
            return new ModBoatRenderer(dispatcher, "green_oak");
        });
        EntityRendererRegistry.INSTANCE.register((EntityType<?>) ModEntities.CYPRESS_BOAT, (dispatcher, context) -> {
            return new ModBoatRenderer(dispatcher, "cypress");
        });

        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntites.PINE_SIGN, SignBlockEntityRenderer::new);

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

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
                    return view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D);
        },
                CLOVER,
                FOUR_CLOVER,
                NETTLES,
                THISTLES);

        ArtificeResourcePack resourcePack = Artifice.registerAssets("lotr:slab_assets", pack -> {
            for (int i = 0; i < slabStuff.length; i++) {
                int finalI = i;
                pack.addBlockState(new Identifier(slabStuff[finalI][0], slabStuff[finalI][1]), state -> state
                        .variant("type=bottom", variant -> variant.model(new Identifier(slabStuff[finalI][0], "block/"+slabStuff[finalI][1])))
                        .variant("type=top", variant -> variant.model(new Identifier(slabStuff[finalI][0], "block/"+slabStuff[finalI][1]+"_top")))
                        .variant("type=double", variant -> variant.model(new Identifier(slabStuff[finalI][0], "block/"+slabStuff[finalI][2])))
                        .variant("type=north", variant -> variant.model(new Identifier(slabStuff[finalI][0], "block/"+slabStuff[finalI][1])).rotationX(270).uvlock(true))
                        .variant("type=south", variant -> variant.model(new Identifier(slabStuff[finalI][0], "block/"+slabStuff[finalI][1]+"_top")).rotationX(270).uvlock(true))
                        .variant("type=east", variant -> variant.model(new Identifier(slabStuff[finalI][0], "block/"+slabStuff[finalI][1])).rotationX(90).rotationY(90).uvlock(true))
                        .variant("type=west", variant -> variant.model(new Identifier(slabStuff[finalI][0], "block/"+slabStuff[finalI][1]+"_top")).rotationX(90).rotationY(90).uvlock(true)));
            }
            pack.shouldOverwrite();
            pack.setDisplayName("Lord of the Rings Slab Assets");
            pack.setDescription("because we are lazy and this is easier");
        });
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntites.PLATE_ENTITY, PlateBlockEntityRenderer::new);
    }
}
