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
/*
Class for pillars that are "connected textures"
 */
public class ModPillarBlock extends Block {
    public ModPillarBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, true));
    }
    /*
    Property for whether there is a block above/ahead or below/behind
     */
    public static final BooleanProperty ABOVE = BooleanProperty.of("above");
    public static final BooleanProperty BELOW = BooleanProperty.of("below");

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(AXIS, ABOVE, BELOW);
    }


    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos pos = ctx.getBlockPos();
        World world = ctx.getWorld();
        Direction.Axis direction;
        //Get Player facing
        if (ctx.getPlayer().getHorizontalFacing() == null) {
            direction = Direction.Axis.X;
        } else {
            direction = ctx.getPlayer().getHorizontalFacing().getAxis();
        }

        boolean UP = false;
        boolean DOWN = false;
        BlockPos up;
        BlockPos down;
        //Determine whether to take above and below, or ahead and behind
        if (!ctx.getPlayer().isSneaking()) {    //Vertical
            down = pos.down(1);
            up = pos.up(1);
            if (world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, false)) {
                UP = true;
            }
            if (world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, false)) {
                DOWN = true;
            }
            return this.getDefaultState().with(ABOVE, UP).with(BELOW, DOWN).with(AXIS, Direction.Axis.Y);
        } else {        //Horizontal
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
            //Check if block ahead/above, and behind/below
            //TODO: Remove if alt works
            //if (world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, true).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, true).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, false).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, false).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, true).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, true).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, false).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, false).with(BELOW, false)) {
            //    UP = true;
            //}
            //if (world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, true).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, true).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, false).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, false).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, true).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, true).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, false).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, false).with(BELOW, false)) {
            //    DOWN = true;
            //}
            if (world.getBlockState(up).getBlock() instanceof ModPillarBlock) {
                UP = true;
            }
            if (world.getBlockState(down).getBlock() instanceof ModPillarBlock) {
                DOWN = true;
            }
            return this.getDefaultState().with(ABOVE, UP).with(BELOW, DOWN).with(AXIS, direction);
        }

    }

    /*
    TODO: Fix bugged sideways updating
     */
    /*
    Check if pillar above/ahead/behind/below when updated
     */
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        Direction.Axis axis = state.get(AXIS);
        boolean UP = false;
        boolean DOWN = false;
        BlockPos up;
        BlockPos down;
        //Determine facing
        switch (axis) {
            case Z:
                up = pos.north(1);
                down = pos.south(1);
                break;
            case Y:
                up = pos.up(1);
                down = pos.down(1);
                break;
            default:
                up = pos.east(1);
                down = pos.west(1);
                break;
        }
        //TODO: for removal
        //if (world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, true).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, true).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, false).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, false).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, true).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, true).with(BELOW, false) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, false).with(BELOW, true) || world.getBlockState(up) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, false).with(BELOW, false)) {
        //    UP = true;
        //}
        //if (world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, true).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Y).with(ABOVE, false).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, true).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, true).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, false).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.X).with(ABOVE, false).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, true).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, true).with(BELOW, false) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, false).with(BELOW, true) || world.getBlockState(down) == getDefaultState().with(AXIS, Direction.Axis.Z).with(ABOVE, false).with(BELOW, false)) {
        //    DOWN = true;
        //}
        if (world.getBlockState(up).getBlock() instanceof ModPillarBlock) {
            UP = true;
        }
        if (world.getBlockState(down).getBlock() instanceof ModPillarBlock) {
            DOWN = true;
        }
        return this.getDefaultState().with(ABOVE, UP).with(BELOW, DOWN).with(AXIS, axis);
    }
}
