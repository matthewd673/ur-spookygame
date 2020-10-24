package com.mattdaly.spookygame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public BufferedImage sprite;

    public Vector2 pos;
    public int w;
    public int h;

    public Entity(BufferedImage sprite, Vector2 pos, int w, int h) {
        this.sprite = sprite;
        this.pos = pos;

        if(w == 0)
            this.w = sprite.getWidth();
        else
            this.w = w;
        if(h == 0)
            this.h = sprite.getHeight();
        else
            this.h = h;
    }

    public void update() {

    }

    public void render(Graphics g) {
        //RenderSurface.drawSprite(g, sprite, new Rectangle((int)pos.x, (int)pos.y, w, h));
        RenderSurface.drawSprite(g, sprite, Main.renderSurface.cam.getRenderRect(this));
    }

}
