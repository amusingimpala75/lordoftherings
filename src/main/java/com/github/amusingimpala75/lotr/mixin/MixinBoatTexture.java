package com.github.amusingimpala75.lotr.mixin;

import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*
TODO: check necessity
 */
@Mixin(BoatEntityRenderer.class)
public class MixinBoatTexture {

    public Identifier lotrId(String type) {
        return new Identifier("lotr", "textures/entity/boat/"+type+".png");
    }

    @Inject(method = "getTexture", at = @At("HEAD"), cancellable = true)
    private void addLotrBoatTextures(BoatEntity boatEntity, CallbackInfoReturnable<Identifier> info) {
        if ((boatEntity.getBoatType() != BoatEntity.Type.ACACIA) && (boatEntity.getBoatType() != BoatEntity.Type.BIRCH) && (boatEntity.getBoatType() != BoatEntity.Type.DARK_OAK) && (boatEntity.getBoatType() != BoatEntity.Type.JUNGLE) && (boatEntity.getBoatType() != BoatEntity.Type.OAK) && (boatEntity.getBoatType() != BoatEntity.Type.SPRUCE)) {
            info.setReturnValue(new Identifier("lotr", "textures/entity/boat/"+boatEntity.getBoatType().getName()+".png"));
        } else {
            info.setReturnValue(new Identifier("minecraft", "textures/entity/boat/"+boatEntity.getBoatType().getName()+".png"));
        }
    }
}
