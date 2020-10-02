package com.github.amusingimpala75.lotr.block;

import net.minecraft.util.StringIdentifiable;

public enum ModSlabType implements StringIdentifiable {
    TOP("top"),
    BOTTOM("bottom"),
    DOUBLE("double"),
    NORTH("north"),
    EAST("east"),
    SOUTH("south"),
    WEST("west");

    private final String name;

    private ModSlabType(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}