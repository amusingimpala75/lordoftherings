package com.github.amusingimpala75.lotr.client.renderer;

import com.github.amusingimpala75.lotr.entity.PlateBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.item.ItemStack;

public class PlateBlockEntityRenderer extends BlockEntityRenderer<PlateBlockEntity> {

    public PlateBlockEntityRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(PlateBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemStack items = entity.getFood();
        for (int i = 0; i < items.getCount(); i++) {
            matrices.push();
            matrices.translate(0.5, 0.5+((double) i /10), 0.5);
            matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(90.0F));
            matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(45.0F*(float)i));
            matrices.scale(0.5F, 0.5F, 0.5F);
            MinecraftClient.getInstance().getItemRenderer().renderItem(items, ModelTransformation.Mode.FIXED, light, overlay, matrices, vertexConsumers);
            matrices.pop();
        }
    }
}
