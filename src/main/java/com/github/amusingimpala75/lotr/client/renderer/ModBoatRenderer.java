package com.github.amusingimpala75.lotr.client.renderer;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;
/*
Renderer for boats
 */
public class ModBoatRenderer extends EntityRenderer<BoatEntity> {

    public final String type;

    public ModBoatRenderer(EntityRenderDispatcher entityRenderDispatcher, String type) {
        super(entityRenderDispatcher);
        this.type = type;
    }

    @Override
    public Identifier getTexture(BoatEntity entity) {
        return new Identifier("lotr", "textures/entity/boat/"+type+".png");
    }

    //@Override
    public Identifier getTexture(ModBoatRenderer entity) {
        return new Identifier("lotr", "textures/entity/boat/"+type+".png");
    }
}