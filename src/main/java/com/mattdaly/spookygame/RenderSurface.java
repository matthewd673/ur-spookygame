package com.mattdaly.spookygame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RenderSurface extends JComponent {

    Camera cam;

    int w;
    int h;

    boolean drawColliders = false;

    Comparator<Entity> compareByZIndex = (Entity o1, Entity o2) ->
            o1.zIndex.compareTo(o2.zIndex);

    public RenderSurface(Camera cam) {
        this.cam = cam;
        w = cam.w;
        h = cam.h;
    }

    public void paint(Graphics g) {
        //begin draw calls
        //draw clear color
        fillRectangle(g, new Rectangle(0, 0, w, h), Color.WHITE);

        Collections.sort(Main.entityManager.entityList, compareByZIndex);

        for(Entity e : Main.entityManager.entityList) {
            e.render(g);
            if(drawColliders)
                e.renderCollider(g);
        }

        //DEBUG OUTPUT
        g.setColor(Color.BLACK);
        g.drawString("entities: " + String.valueOf(Main.entityManager.entityList.size()), 0, 10);

        //end draw calls
        super.paint(g);
    }

    public static void drawSprite(Graphics g, BufferedImage image, Rectangle rect) {
        g.drawImage(
                image,
                rect.x,
                rect.y,
                rect.x + rect.width,
                rect.y + rect.height,
                0,
                0,
                image.getWidth(),
                image.getHeight(),
                null
        );
    }

    public static void fillRectangle(Graphics g, Rectangle rect, Color color) {
        g.setColor(color);
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
    }

    public static void drawRectangle(Graphics g, Rectangle rect, Color color) {
        g.setColor(color);
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
    }

}
