package com.github.amusingimpala75.lotr.mixin;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockEntityType.class)
public interface BlockEntityTypeCreateInvoker {
    @Invoker
    static <T extends BlockEntity> BlockEntityType<T> invokeCreate(String string, BlockEntityType.Builder<T> builder) {
        throw new AssertionError();
    }
}
