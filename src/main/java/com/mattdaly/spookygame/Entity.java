package com.mattdaly.spookygame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Comparator;

public class Entity {

    public BufferedImage sprite;

    public Vector2 pos;
    public int w;
    public int h;

    public Collider col;

    public Velocity v;

    public boolean activated;

    public enum EntityType {
        SkeletonBody,
        SkeletonHead,
        Fence,
        Grass,
        Grave,
        Particle,
        Dirt,
        GrassyDirt,
        TopFence,
        Pit,
        End,
        Button,
    }

    public EntityType eType;

    public boolean forceBackSort = false;
    public Integer zIndex = 0;

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

        calculateZIndex();
    }
    //entity constructor for switch
    public Entity(EntityType eType, BufferedImage sprite, Vector2 pos, int w, int h, boolean activated) {
        this.eType = eType;
        this.sprite = sprite;
        this.pos = pos;
        this.activated = activated;

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

        calculateZIndex();
    }

    public void calculateZIndex() {
        if(!forceBackSort)
            zIndex = (int)(pos.y + h);
        else
            zIndex = -9999;
    }

    public boolean move(float newX, float newY, Collider c) {
        if(c == null || c.trigger) {
            pos = new Vector2(newX, newY);
            return true;
        }

        int intersectingCt = 0;

        for(Entity e : Main.entityManager.entityList) {
            //if(e.col == null || e == this || e.col.trigger)
                //continue;
            //check if switch is activated
            if(e.eType == EntityType.Button){
                if (e.activated = false && Collider.detectCollision(newX + c.offX, newY + c.offY, c.w, c.h, e.col.x, e.col.y, e.col.w, e.col.h))
                    e.activated = true;
                else
                    e.activated = false;
            }
            else if(e.col != null && e != this && !e.col.trigger) {
                if (Collider.detectCollision(newX + c.offX, newY + c.offY, c.w, c.h, e.col.x, e.col.y, e.col.w, e.col.h))
                    intersectingCt++;
            }
        }

        if(intersectingCt < 1) {
            pos = new Vector2(newX, newY);
            return true;
        }

        return false;

    }
    public boolean move(float newX, float newY) {
        return move(newX, newY, col);
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
