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
        this.w = w;
        this.h = h;
    }

    public void update() {

    }

    public void render(Graphics g) {
        RenderSurface.drawSprite(g, sprite, new Rectangle((int)pos.x, (int)pos.y, w, h));
    }

}
