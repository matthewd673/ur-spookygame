package com.mattdaly.spookygame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprites {

    public static BufferedImage ghost;
    public static BufferedImage skeletonBody;
    public static BufferedImage skeletonHead;
    public static BufferedImage grass;
    public static BufferedImage grave;

    public static void loadSprites() {

        try {

            ghost = ImageIO.read(new File("res/ghost.png"));
            skeletonBody = ImageIO.read(new File("res/skeleton-body.png"));
            skeletonHead = ImageIO.read(new File("res/skeleton-head.png"));
            grass = ImageIO.read(new File("res/grass.png"));
            grave = ImageIO.read(new File("res/grave.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
