package com.github.amusingimpala75.lotr.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class MirkOakLeaves extends Block {

    public static final BooleanProperty DOWN = BooleanProperty.of("down");

    public MirkOakLeaves(Settings settings) {
        super(settings);
        this.setDefaultState(getStateManager().getDefaultState().with(DOWN, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(DOWN);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(DOWN, false);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState newState, WorldAccess world, BlockPos currentPos, BlockPos facingPos) {
        state = super.getStateForNeighborUpdate(state, facing, newState, world, currentPos, facingPos);
        if (facing == Direction.DOWN) {
            state = (BlockState)state.with(DOWN, this.hasDownState(world, currentPos));
        }

        return state;
    }
    private boolean hasDownState(WorldAccess world, BlockPos pos) {
        BlockPos belowPos = pos.down();
        BlockState belowState = world.getBlockState(belowPos);
        return Block.isFaceFullSquare(belowState.getCollisionShape(world, belowPos), Direction.UP) || belowState.getBlock() instanceof HangingWeb;
    }
}
