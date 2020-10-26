package com.mattdaly.spookygame;

import java.awt.*;

public class Collider {

    public boolean trigger;

    public float x;
    public float y;
    public int w;
    public int h;

    public float offX;
    public float offY;

    public Collider(float offX, float offY, int w, int h, boolean trigger) {
        this.offX = offX;
        this.offY = offY;
        this.w = w;
        this.h = h;

        this.trigger = trigger;
    }

    public static boolean detectCollision(float aX, float aY, int aW, int aH, float bX, float bY, int bW, int bH) {
        return (aX < bX + bW && aX + aW > bX && aY < bY + bH && aY + aH > bY);
    }

}
