package com.github.amusingimpala75.lotr.block;

import net.minecraft.util.StringIdentifiable;

public enum ModWallShape implements StringIdentifiable {
    NONE("none"),
    TRUE("true");

    private final String name;

    private ModWallShape(String name) {
        this.name = name;
    }

    public String toString() {
        return this.asString();
    }

    public String asString() {
        return this.name;
    }
}
