package com.mattdaly.spookygame;

import java.awt.*;

public class Camera {

    public Vector2 pos;
    public int w;
    public int h;

    public int scaledW;
    public int scaledH;

    public int scale;

    public Camera(Vector2 pos, int w, int h, int scale) {
        this.pos = pos;
        this.w = w;
        this.h = h;

        this.scaledW = w / scale;
        this.scaledH = h / scale;

        this.scale = scale;
    }

    public void lockToEntity(Entity e) {
        //get center point
        float eCX = e.pos.x + (e.w / 2);
        float eCY = e.pos.y + (e.h / 2);

        pos.x = eCX - (scaledW / 2);
        pos.y = eCY - (scaledH / 2);
    }

    public Rectangle getRenderRect(float x, float y, int w, int h) {
        return new Rectangle((int)(x - pos.x) * scale, (int)(y - pos.y) * scale, w * scale, h * scale);
    }
    public Rectangle getRenderRect(Entity e) {
        return getRenderRect(e.pos.x, e.pos.y, e.w, e.h);
    }
    public Rectangle getRenderRect(Rectangle r) {
        return getRenderRect(r.x, r.y, r.width, r.height);
    }

    public Vector2 getMouseToWorldPoint(float x, float y) {
        return new Vector2((x / scale) + pos.x, (y / scale) + pos.y);
    }
    public Vector2 getMouseToWorldPoint(Vector2 pos) {
        return getMouseToWorldPoint(pos.x, pos.y);
    }
    public Vector2 getMouseToWorldPoint(Point point) {
        return getMouseToWorldPoint(point.x, point.y);
    }

}
