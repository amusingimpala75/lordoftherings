package com.github.amusingimpala75.lotr.mixin;

import com.github.amusingimpala75.lotr.block.ModCropBlock;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

import static net.minecraft.block.FarmlandBlock.setToDirt;

@Mixin(FarmlandBlock.class)
public abstract class MixinTextFarmland extends Block {
    @Shadow @Final public static IntProperty MOISTURE;

    public MixinTextFarmland(Settings settings) {
        super(settings);
        System.out.println("This will never be printed (hopefully)");
    }

    @Inject(at=@At("RETURN"), method = "getStateForNeighborUpdate", cancellable = true)
    public void getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom, CallbackInfoReturnable<BlockState> info) {
        if (world.getBlockState(posFrom).getBlock() instanceof ModCropBlock) {
            info.setReturnValue(Blocks.FARMLAND.getDefaultState().with(MOISTURE, 7));
        }
    }

    @Inject(at=@At("HEAD"), method = "scheduledTick", cancellable = true)
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo info) {
        BlockPos cropPos = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ());
        if (!state.canPlaceAt(world, pos)) {
            if (!(world.getChunk(pos).getBlockState(cropPos).getBlock() instanceof CropBlock)) {
                setToDirt(state, world, pos);
            }
        }
        info.cancel();
    }
}
