package com.github.amusingimpala75.lotr.mixin;

import com.github.amusingimpala75.lotr.registry.ModItems;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*
Add functionality to create explosion/portal when destroying GoldRing
TODO: add portal creation
 */
@Mixin(AbstractFireBlock.class)
public class MixinAbstractFireBlock {

    public boolean equalsGoldRing(ItemEntity item) {
        return item.getStack().getItem().equals(ModItems.GOLD_RING);
    }

    @Inject(at = @At("HEAD"), method = "onEntityCollision")
    public void goldRingFireCollision(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo info) {
        if (entity.getClass() == ItemEntity.class) {
            if (equalsGoldRing((ItemEntity) entity)) {
                System.out.println("DESTROYING GOLD RING!! from mixined fire");
                world.createExplosion(null, entity.getX(), entity.getY(), entity.getZ(), 1.0F, Explosion.DestructionType.DESTROY);
            }
        }
    }
}
