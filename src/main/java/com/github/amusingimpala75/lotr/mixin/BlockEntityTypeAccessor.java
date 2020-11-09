package com.github.amusingimpala75.lotr.mixin;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
/*
TODO: check necessity
 */
@Mixin(BlockEntity.class)
public interface BlockEntityTypeAccessor {
    @Accessor("type")
    void setType(BlockEntityType<?> type);
}
