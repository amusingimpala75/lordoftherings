package com.github.amusingimpala75.lotr.client;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.TranslatableText;

public class MapScreen extends Screen {

    PlayerEntity player;
    
    public MapScreen(PlayerEntity player) {
        super(new TranslatableText("lotr.map.title"));
        this.player = player;
    }
}
