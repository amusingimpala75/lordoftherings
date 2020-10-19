package com.github.amusingimpala75.lotr.client;

import com.github.amusingimpala75.lotr.client.renderer.ModBoatRenderer;
import com.github.amusingimpala75.lotr.registry.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.EntityType;

import static com.github.amusingimpala75.lotr.registry.ModBlocks.*;

@Environment(EnvType.CLIENT)
public class LotrClient implements ClientModInitializer {
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

        // SIGNS BlockEntityRendererRegistry.INSTANCE.register();
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), MALLORN_LADDER, ASPEN_LEAVES, POTTED_ASPEN, ASPEN_SAPLING, BRONZE_LANTERN, CANDLE, ORC_TORCH);
    }
}
