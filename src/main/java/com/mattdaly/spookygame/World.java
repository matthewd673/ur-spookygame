/**
 * World.java
 * 10/28/20
 * creates board by adding visual items to entity manager
 */

package com.mattdaly.spookygame;

import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class World {

    int w;
    int h;

    Random rng;

    //load levels here
    public static Level level1;
    public static Level level2;

    public Level currentLevel = null;

    public World(int w, int h) {
        this.w = w;
        this.h = h;

        rng = new Random();

        level1 = new Level("level1.txt");
        level2 = new Level("level2.txt");

        level1.nextLevel = level2;
    }

    public void placeGrass(int grassCt) {
        for(int i = 0; i < grassCt; i++) {
            float gX = rng.nextFloat() * w;
            float gY = rng.nextFloat() * h;
            Grass grass = new Grass(gX, gY);
            Main.entityManager.addEntity(grass);
        }
    }

    public void placeGrass(int grassCt, int x, int y, int w, int h) {
        for(int i = 0; i < grassCt; i++) {
            float gX = (ThreadLocalRandom.current().nextFloat() * w) + x;
            float gY = (ThreadLocalRandom.current().nextFloat() * h) + y;
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
    public void tileWorld(Level level){

        int x = 0;
        int y = 0;
        for(int i = 0; i < level.rows.size(); i++) {
            for(int j = 0; j < level.rows.get(i).length; j++) {

                String currentTile = level.rows.get(i)[j];

                switch (currentTile) {
                    //add board tiles here
                    case "d": //DIRT
                        Dirt dirt = new Dirt(x, y);
                        Main.entityManager.addEntity(dirt);
                        placeGrass(8, x, y, 24, 23);
                        break;
                    case "g": //GRASS
                        //GrassyDirt gd = new GrassyDirt(x, y);
                        //Main.entityManager.addEntity(gd);
                        Dirt d = new Dirt(x, y);
                        Main.entityManager.addEntity(d);
                        placeGrass(18, x, y, 24, 23);
                        break;
                    case "t": //TOP FENCE
                        TopFence topFence = new TopFence(x, y);
                        Main.entityManager.addEntity(topFence);
                        Dirt topFenceDirt = new Dirt(x, y);
                        Main.entityManager.addEntity(topFenceDirt);
                        break;
                    case "p": //PIT
                        Pit pit = new Pit(x, y);
                        Main.entityManager.addEntity(pit);
                        break;
                    case "S": //button/switch
                        //Dirt switchDirt = new Dirt(x, y);
                        //Main.entityManager.addEntity(switchDirt);
                        Switch switchy = new Switch(x, y);
                        Main.entityManager.addEntity(switchy);
                        break;
                    case "H": //BODY WITH HEAD
                        SkeletonHead head = new SkeletonHead(null, x, y);
                        SkeletonBody bodyWithHead = new SkeletonBody(x, y, head);
                        Main.entityManager.addEntity(head);
                        Main.entityManager.addEntity(bodyWithHead);
                        //spawn backing dirt
                        Dirt hBackDirt = new Dirt(x, y);
                        Main.entityManager.addEntity(hBackDirt);
                        break;
                    case "B": //BODY
                        SkeletonBody body = new SkeletonBody(x, y, null);
                        Main.entityManager.addEntity(body);
                        //spawn backing dirt
                        Dirt bBackDirt = new Dirt(x, y);
                        Main.entityManager.addEntity(bBackDirt);
                        break;
                    case "E": //END
                        Dirt endDirt = new Dirt(x, y);
                        Main.entityManager.addEntity(endDirt);
                        End end = new End(x, y);
                        Main.entityManager.addEntity(end);
                        break;
                    default:
                        System.out.println("Invalid board tile: " + currentTile);
                }

                x += 32;
            }
            y += 32;
            x = 0;
        }
    }

    public void switchLevel(Level nextLevel) {
        currentLevel = nextLevel;
        //clear current entities and repopulate
        Main.entityManager.clearEntities();
        tileWorld(currentLevel);
    }

}
