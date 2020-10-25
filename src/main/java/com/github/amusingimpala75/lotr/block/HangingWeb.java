package com.github.amusingimpala75.lotr.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CobwebBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import org.jetbrains.annotations.Nullable;

public class HangingWeb extends CobwebBlock {
    public HangingWeb(Settings settings) {
        super(settings);
        this.setDefaultState(getStateManager().getDefaultState().with(TYPE, HangingWebTypes.SINGLE));
    }

    public static final EnumProperty<HangingWebTypes> TYPE = EnumProperty.of("type", HangingWebTypes.class);

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TYPE);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(TYPE, HangingWebTypes.SINGLE);
    }
}
