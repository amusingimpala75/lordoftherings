package com.github.amusingimpala75.lotr.mixin;

import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoatEntityRenderer.class)
public class MixinBoatTexture {

    public Identifier lotrId(String type) {
        return new Identifier("lotr", "textures/entity/boat/"+type+".png");
    }

    @Inject(method = "getTexture", at = @At("HEAD"), cancellable = true)
    private void addLotrBoatTextures(BoatEntity boatEntity, CallbackInfoReturnable<Identifier> info) {
        Identifier[] TEXTURES = new Identifier[]{new Identifier("textures/entity/boat/oak.png"), new Identifier("textures/entity/boat/spruce.png"), new Identifier("textures/entity/boat/birch.png"), new Identifier("textures/entity/boat/jungle.png"), new Identifier("textures/entity/boat/acacia.png"), new Identifier("textures/entity/boat/dark_oak.png"), lotrId("pine"), lotrId("mallorn"), lotrId("mirk_oak"), lotrId("charred"), lotrId("apple"), lotrId("pear"), lotrId("cherry"), lotrId("lebethron"), lotrId("beech"), lotrId("maple"), lotrId("aspen"), lotrId("lairelosse"), lotrId("cedar"), lotrId("fir"), lotrId("larch"), lotrId("holly"), lotrId("green_oak")};
        info.setReturnValue(TEXTURES[boatEntity.getBoatType().ordinal()]);
    }
}
