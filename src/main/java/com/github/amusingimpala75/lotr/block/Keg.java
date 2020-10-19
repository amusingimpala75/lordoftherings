package com.github.amusingimpala75.lotr.block;

import net.minecraft.block.Block;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.Direction;

public class Keg extends Block {
    public Keg(Settings settings) {
        super(settings);
    }
    public static final BooleanProperty UP = BooleanProperty.of("up");
    public static final DirectionProperty FACING = DirectionProperty.of("facing", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.UP, Direction.DOWN);
}
