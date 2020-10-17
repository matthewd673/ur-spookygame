package com.mattdaly.spookygame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class RenderSurface extends JComponent {

    int w;
    int h;

    public RenderSurface(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public void paint(Graphics g) {
        //begin draw calls
        for(Entity e : Main.entityManager.entityList)
            e.render(g);

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

}
