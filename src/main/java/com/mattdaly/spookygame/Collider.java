package com.mattdaly.spookygame;

import java.awt.*;

public class Collider {

    public FRect hitbox;
    public boolean trigger;

    public float offX;
    public float offY;

    public Collider(FRect hitbox, boolean trigger, float offX, float offY) {
        this.hitbox = hitbox;
        this.trigger = trigger;

        this.offX = offX;
        this.offY = offY;
    }

    public static boolean detectCollision(FRect a, FRect b) {
        int scale = Main.renderSurface.cam.scale;
        return (a.x < b.x + b.width &&
                a.x + a.width > b.x &&
                a.y < b.y + b.height &&
                a.y + a.height > b.y);
    }

}
