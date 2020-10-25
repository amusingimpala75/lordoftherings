package com.github.amusingimpala75.lotr.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class MordorRock extends Block {
    public int mossy;
    public static final BooleanProperty MOSSY = BooleanProperty.of("mossy");


    public MordorRock(Settings settings) {
        super(settings);
        this.setDefaultState(getStateManager().getDefaultState().with(MOSSY, false));
        mossy = 0;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(MOSSY);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState();
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        mossy++;
        if (mossy >= 5) {
            mossy = 0;
            world.setBlockState(pos, getDefaultState().with(MOSSY, true));
        }
        super.randomTick(state, world, pos, random);
    }
}
