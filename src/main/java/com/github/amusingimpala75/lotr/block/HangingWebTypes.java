package com.github.amusingimpala75.lotr.block;

import net.minecraft.util.StringIdentifiable;

public enum HangingWebTypes implements StringIdentifiable {
    DOUBLE_TOP("double_top"),
    SINGLE("single"),
    DOUBLE_BOTTOM("double_bottom");

    private final String name;

    private HangingWebTypes(String name) {
        this.name = name;
    }

    public String asString() {
        return this.name;
    }

}
