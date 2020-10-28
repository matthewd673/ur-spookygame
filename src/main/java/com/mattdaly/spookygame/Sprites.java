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
    public static BufferedImage dirt;
    public static BufferedImage grassyDirt;
    public static BufferedImage topFence;


    public static void loadSprites() {

        try {

            ghost = ImageIO.read(new File("res/ghost.png"));
            skeletonBody = ImageIO.read(new File("res/skeleton-body.png"));
            skeletonHead = ImageIO.read(new File("res/skeleton-head.png"));
            grass = ImageIO.read(new File("res/grass.png"));
            grave = ImageIO.read(new File("res/grave.png"));
            dirt = ImageIO.read(new File("res/dirt.png"));
            grassyDirt = ImageIO.read(new File("res/grassyDirt.png"));
            topFence = ImageIO.read(new File("res/topFence.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
