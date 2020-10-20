package com.mattdaly.spookygame;

import java.awt.*;

public class Camera {

    public Vector2 pos;
    public int w;
    public int h;

    public int scale;

    public Camera(Vector2 pos, int w, int h, int scale) {
        this.pos = pos;
        this.w = w;
        this.h = h;

        this.scale = scale;
    }

    public void lockToEntity(Entity e) {
        //get center point
        float eCX = e.pos.x + (e.w / 2);
        float eCY = e.pos.y + (e.h / 2);

        pos.x = eCX - (w / 2);
        pos.y = eCY - (h / 2);
    }

    public Rectangle getRenderRect(Entity e) {
        return new Rectangle((int)(e.pos.x - pos.x), (int)(e.pos.y - pos.y), e.w * scale, e.h * scale);
    }

}
