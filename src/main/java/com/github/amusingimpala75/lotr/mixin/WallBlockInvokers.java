package com.github.amusingimpala75.lotr.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;
import net.minecraft.block.enums.WallShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Map;

@Mixin(WallBlock.class)
public interface WallBlockInvokers {
    @Invoker
    static boolean invokeMethod_24427(VoxelShape voxelShape, VoxelShape voxelShape2) {
        throw new AssertionError();
    }

    @Invoker
    BlockState invokeMethod_24425(BlockState blockState, boolean bl, boolean bl2, boolean bl3, boolean bl4, VoxelShape voxelShape);

    @Invoker
    boolean invokeShouldConnectTo(BlockState state, boolean faceFullSquare, Direction side);

    @Invoker
    BlockState invokeMethod_24422(WorldView worldView, BlockState blockState, BlockPos blockPos, BlockState blockState2, boolean bl, boolean bl2, boolean bl3, boolean bl4);

    @Invoker
    static VoxelShape invokeMethod_24426(VoxelShape voxelShape, WallShape wallShape, VoxelShape voxelShape2, VoxelShape voxelShape3) {
        throw new AssertionError();
    }
}
