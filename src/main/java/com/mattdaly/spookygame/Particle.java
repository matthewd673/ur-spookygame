package com.mattdaly.spookygame;

import java.awt.*;

public class Particle extends Entity {

    Color col;
    int lifetime = 5;

    public Particle(float x, float y, Color col, Velocity v, int size) {
        super(EntityType.Particle, Sprites.skeletonHead, new Vector2(x, y), size, size);

        this.col = col;
        this.v = v;

    }

    public void update() {

        if(lifetime > 0)
            lifetime--;
        else
            Main.entityManager.removeEntity(this);

        super.update();
    }

    public void render(Graphics g) {
        RenderSurface.fillRectangle(g, Main.renderSurface.cam.getRenderRect(new Rectangle((int)pos.x, (int)pos.y, w, h)), col);
    }

}
