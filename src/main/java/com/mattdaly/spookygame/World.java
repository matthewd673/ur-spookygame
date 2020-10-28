/**
 * World.java
 * 10/28/20
 * creates board by adding visual items to entity manager
 */

package com.mattdaly.spookygame;

import java.util.Random;

public class World {

    int w;
    int h;

    Random rng;

    //load levels here
    private Level level1;
    private Level level2;
    public World(int w, int h) {
        this.w = w;
        this.h = h;

        rng = new Random();

        level1 = new Level("level1.txt");
        level2 = new Level("level2.txt");
    }

    public void placeGrass(int grassCt) {
        for(int i = 0; i < grassCt; i++) {
            float gX = rng.nextFloat() * w;
            float gY = rng.nextFloat() * h;
            Grass grass = new Grass(gX, gY);
            Main.entityManager.addEntity(grass);
        }
    }

    public void placeGraves(int graveCt) {
        for(int i = 0; i < graveCt; i++) {
            float gX = rng.nextFloat() * w;
            float gY = rng.nextFloat() * h;
            Grave grave = new Grave(gX, gY);
            Main.entityManager.addEntity(grave);
        }
    }

    //this method adds tiles to the entity manager from a text file
    public void tileWorld(){

        int x = 0;
        int y = 0;
        for(int i = 0; i < level1.rows.size(); i++) {
            for(int j = 0; j < level1.rows.get(i).length; j++) {


                switch (level1.rows.get(i)[j]) {
                    //add board tiles here
                    case "d":
                        Dirt dirt = new Dirt(x, y);
                        Main.entityManager.addEntity(dirt);
                        break;
                    case "g":
                        GrassyDirt gd = new GrassyDirt(x, y);
                        Main.entityManager.addEntity(gd);
                        break;
                    case "t":
                        TopFence topFence = new TopFence(x, y);
                        Main.entityManager.addEntity(topFence);
                        break;
                    default:
                        System.out.println("invalid board tile");
                }

                x += 32;
            }
            y += 32;
            x = 0;
        }
    }

}
