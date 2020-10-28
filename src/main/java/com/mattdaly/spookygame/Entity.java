package com.mattdaly.spookygame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public BufferedImage sprite;

    public Vector2 pos;
    public int w;
    public int h;

    public Collider col;

    public Velocity v;

    public enum EntityType {
        SkeletonBody,
        SkeletonHead,
        Fence,
        Grass,
        Grave,
    }

    public EntityType eType;

    public Entity(EntityType eType, BufferedImage sprite, Vector2 pos, int w, int h) {
        this.eType = eType;
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

        Velocity v = new Velocity(0, 0);
    }

    public void setCollider(Collider col) {
        this.col = col;
    }

    public void update() {
        //apply velocity
        if(v != null)
            move(pos.x + v.vX, pos.y + v.vY);

        //update collider position
        if(col != null) {
            col.x = pos.x + col.offX;
            col.y = pos.y + col.offY;
        }
    }

    public boolean move(float newX, float newY) {
        if(col == null || col.trigger) {
            pos = new Vector2(newX, newY);
            return true;
        }

        int intersectingCt = 0;

        for(Entity e : Main.entityManager.entityList) {
            //if(e.col == null || e == this || e.col.trigger)
                //continue;
            if(e.col != null && e != this && !e.col.trigger) {
                if (Collider.detectCollision(newX + col.offX, newY + col.offY, col.w, col.h, e.col.x, e.col.y, e.col.w, e.col.h))
                    intersectingCt++;
            }
        }

        if(intersectingCt < 1) {
            pos = new Vector2(newX, newY);
            return true;
        }

        return false;

    }

    public void render(Graphics g) {
        RenderSurface.drawSprite(g, sprite, Main.renderSurface.cam.getRenderRect(this));
    }

    public void renderCollider(Graphics g) {
        if(col == null)
            return;

        Color drawColor = Color.GREEN;
        if(col.trigger)
            drawColor = Color.YELLOW;

        RenderSurface.drawRectangle(g, Main.renderSurface.cam.getRenderRect(col.x, col.y, col.w, col.h), drawColor);
    }

}
