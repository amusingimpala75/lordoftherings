package com.github.amusingimpala75.lotr.block;

import net.minecraft.util.StringIdentifiable;

public enum DripstoneTypes implements StringIdentifiable {
    C_DOUBLE_POINT("stalactite_double_point"),
    G_DOUBLE_POINT("stalagmite_double_point"),
    C_DOUBLE_BASE("stalactite_double_base"),
    G_DOUBLE_BASE("stalagmite_double_base"),
    C("stalactite"),
    G("stalagmite");

    private final String name;

    private DripstoneTypes(String name) {
        this.name = name;
    }

    public String asString() {
        return this.name;
    }
}
