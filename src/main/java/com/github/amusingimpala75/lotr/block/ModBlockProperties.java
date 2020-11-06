package com.github.amusingimpala75.lotr.block;

import net.minecraft.state.property.EnumProperty;
/*
Properties for custom walls to use, necessary b/c of changes fro 1.15 to 1.16
 */
public class ModBlockProperties {
    public static final EnumProperty<ModWallShape> EAST_WALL_SHAPE;
    public static final EnumProperty<ModWallShape> NORTH_WALL_SHAPE;
    public static final EnumProperty<ModWallShape> SOUTH_WALL_SHAPE;
    public static final EnumProperty<ModWallShape> WEST_WALL_SHAPE;
    static {
        EAST_WALL_SHAPE = EnumProperty.of("east", ModWallShape.class);
        NORTH_WALL_SHAPE = EnumProperty.of("north", ModWallShape.class);
        SOUTH_WALL_SHAPE = EnumProperty.of("south", ModWallShape.class);
        WEST_WALL_SHAPE = EnumProperty.of("west", ModWallShape.class);
    }
}
