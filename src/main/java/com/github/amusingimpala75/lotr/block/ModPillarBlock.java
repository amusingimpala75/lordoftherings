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


import static net.minecraft.state.property.Properties.AXIS;

public class ModPillarBlock extends Block {
    public ModPillarBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, true));
    }
    public static final BooleanProperty ABOVE = BooleanProperty.of("above");
    public static final BooleanProperty BELOW = BooleanProperty.of("below");

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(AXIS, ABOVE, BELOW);
    }


    /*
    TODO: Add Horizontality
     */
    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos pos = ctx.getBlockPos();
        World world = ctx.getWorld();
        Direction.Axis direction = ctx.getPlayer().getHorizontalFacing().getAxis();

        boolean UP = false;
        boolean DOWN = false;
        BlockPos up;
        BlockPos down;
        if (!ctx.getPlayer().isSneaking()) {
            down = pos.down(1);
            up = pos.up(1);
            if (world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, false)) {
                UP = true;
            }
            if (world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, false)) {
                DOWN = true;
            }
            return this.getDefaultState().with(ABOVE, UP).with(BELOW, DOWN).with(AXIS, Direction.Axis.Y);
        } else {
            switch (ctx.getPlayer().getHorizontalFacing()) {
                case NORTH:
                    up = pos.south(1);
                    down = pos.north(1);
                    break;
                case SOUTH:
                    up = pos.north(1);
                    down = pos.south(1);
                    break;
                case EAST:
                    up = pos.west(1);
                    down = pos.east(1);
                    break;
                default:
                    up = pos.east(1);
                    down = pos.west(1);
                    break;
            }
            //If anyone knows a better way, please make a pull request or let me know
            if (world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, true).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, true).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, false).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, false).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, true).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, true).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, false).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, false).with(BELOW, false)) {
                UP = true;
            }
            if (world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, true).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, true).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, false).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, false).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, true).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, true).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, false).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, false).with(BELOW, false)) {
                DOWN = true;
            }
            return this.getDefaultState().with(ABOVE, UP).with(BELOW, DOWN).with(AXIS, direction);
        }

    }

    /*
    TODO: Add updatablity so that when pillar placed nearby type gets updated
     */
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        //boolean UP = false;
        //boolean DOWN = false;
        //BlockPos up;
        //BlockPos down;
        //if (!player.isSneaking()) {
        //    down = pos.down(1);
        //    up = pos.up(1);
        //    if (world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, false)) {
        //        UP = true;
        //    }
        //    if (world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, false)) {
        //        DOWN = true;
        //   }
        //    return this.getDefaultState().with(ABOVE, UP).with(BELOW, DOWN).with(AXIS, Direction.Axis.Y);
        //} else {
        //    switch (ctx.getPlayer().getHorizontalFacing()) {
        //        case NORTH:
        //            up = pos.north(1);
        //            down = pos.south(1);
        //            break;
        //        case SOUTH:
        //            up = pos.south(1);
        //            down = pos.north(1);
        //            break;
        //        case EAST:
        //            up = pos.east(1);
        //            down = pos.west(1);
        //            break;
        //        default:
        //            up = pos.west(1);
        //            down = pos.east(1);
        //            break;
        //    }
        //    //If anyone knows a better way, please make a pull request or let me know
        //    if (world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, true).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, true).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, false).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, false).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, true).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, true).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, false).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, false).with(BELOW, false)) {
        //        UP = true;
        //    }
        //    if (world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, true).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, true).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, false).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, false).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, true).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, true).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, false).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, false).with(BELOW, false))) {
        //        DOWN = true;
        //    }
        //    return this.getDefaultState().with(ABOVE, UP).with(BELOW, DOWN).with(AXIS, direction);
        //}
        //ItemPlacementContext context = new ItemPlacementContext();
        return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }
}
