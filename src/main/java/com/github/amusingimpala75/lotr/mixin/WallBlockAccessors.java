package com.github.amusingimpala75.lotr.mixin;

import net.minecraft.block.WallBlock;
import net.minecraft.util.shape.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
/*
TODO: Check necessity
 */
@Mixin(WallBlock.class)
public interface WallBlockAccessors {
    @Accessor
    static VoxelShape getTALL_POST_SHAPE() {
        throw new AssertionError();
    }
    @Accessor
    static VoxelShape getTALL_NORTH_SHAPE() {
        throw new AssertionError();
    }
    @Accessor
    static VoxelShape getTALL_SOUTH_SHAPE() {
        throw new AssertionError();
    }
    @Accessor
    static VoxelShape getTALL_EAST_SHAPE() {
        throw new AssertionError();
    }
    @Accessor
    static VoxelShape getTALL_WEST_SHAPE() {
        throw new AssertionError();
    }
}
