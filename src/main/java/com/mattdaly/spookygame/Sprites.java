package com.mattdaly.spookygame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprites {

    public static BufferedImage ghost;

    public static void loadSprites() {

        try {

            ghost = ImageIO.read(new File("res/ghost.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static BufferedImage readImage(String path) throws IOException {
        return ImageIO.read(new File("res/" + path + ".png"));
    }

}
