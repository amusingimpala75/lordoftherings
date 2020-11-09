package com.github.amusingimpala75.lotr.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*
Attempts to add ability to climb ladder
TODO: actually make it work
 */
@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity extends Entity {

    @Shadow
    public boolean isClimbing() {
        throw new AssertionError();
    }

    @Unique
    public BlockState getBlockState() { return this.world.getBlockState(this.getBlockPos()); }

    @Unique
    public boolean isHoldingOntoLadder() { return this.isSneaking(); }


    public MixinLivingEntity(EntityType<?> type, World world) {
        super(type, world);
        System.out.println("This will never be called");
    }

    @Inject(at=@At("HEAD"), method = "canEnterTrapdoor", cancellable = true)
    public void canEnterTrapdoor(BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> info) {
        if ((Boolean)state.get(TrapdoorBlock.OPEN)) {
            BlockState blockState = this.world.getBlockState(pos.down());
            if (blockState.isOf(Blocks.LADDER) && blockState.get(LadderBlock.FACING) == state.get(TrapdoorBlock.FACING)) {
                info.setReturnValue(true);
            }
        }

        info.setReturnValue(false);
    }

    @Inject(at=@At("HEAD"), method = "applyClimbingSpeed", cancellable = true)
    public void applyClimbingSpeed(Vec3d motion, CallbackInfoReturnable<Vec3d> info) {
        if (this.isClimbing()) {
            this.fallDistance = 0.0F;
            float f = 0.15F;
            double d = MathHelper.clamp(motion.x, -0.15000000596046448D, 0.15000000596046448D);
            double e = MathHelper.clamp(motion.z, -0.15000000596046448D, 0.15000000596046448D);
            double g = Math.max(motion.y, -0.15000000596046448D);
            //if (g < 0.0D && !this.getBlockState().isOf(Blocks.SCAFFOLDING) && this.isHoldingOntoLadder() && this instanceof PlayerEntity) {
            //    g = 0.0D;
            //}
            motion = new Vec3d(d, g, e);
        }
        info.setReturnValue(motion);
    }
}
