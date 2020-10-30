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

        //by splitting the entities into 2 queues we can do cheap z-sorting
        //this is hardly a permanent solution
        //but it kinda works and im kinda lazy so...
        ArrayList<Entity> priorityEntities = new ArrayList<Entity>(); //ADD FOREGROUND ENTITIES HERE
        ArrayList<Entity> backgroundEntities = new ArrayList<Entity>();

        int x = 0;
        int y = 0;
        for(int i = 0; i < level.rows.size(); i++) {
            for(int j = 0; j < level.rows.get(i).length; j++) {

                String currentTile = level.rows.get(i)[j];

                switch (currentTile) {
                    //add board tiles here
                    case "d": //DIRT
                        Dirt dirt = new Dirt(x, y);
                        backgroundEntities.add(dirt);
                        placeGrass(6, x, y, 32, 32);
                        break;
                    case "g": //GRASS
                        GrassyDirt gd = new GrassyDirt(x, y);
                        backgroundEntities.add(gd);
                        break;
                    case "t": //TOP FENCE
                        TopFence topFence = new TopFence(x, y);
                        backgroundEntities.add(topFence);
                        break;
                    case "p": //PIT
                        Pit pit = new Pit(x, y);
                        backgroundEntities.add(pit);
                        break;
                    case "H": //BODY WITH HEAD
                        SkeletonHead head = new SkeletonHead(null, x, y);
                        SkeletonBody bodyWithHead = new SkeletonBody(x, y, head);
                        priorityEntities.add(head);
                        priorityEntities.add(bodyWithHead);
                        //spawn backing dirt
                        Dirt hBackDirt = new Dirt(x, y);
                        backgroundEntities.add(hBackDirt);
                        break;
                    case "B": //BODY
                        SkeletonBody body = new SkeletonBody(x, y, null);
                        priorityEntities.add(body);
                        //spawn backing dirt
                        Dirt bBackDirt = new Dirt(x, y);
                        backgroundEntities.add(bBackDirt);
                        break;
                    case "E": //END
                        End end = new End(x, y);
                        backgroundEntities.add(end);
                        break;
                    default:
                        System.out.println("Invalid board tile: " + currentTile);
                }

                x += 32;
            }
            y += 32;
            x = 0;
        }

        //add entities from queues
        for(Entity e : backgroundEntities) //background first so they get sorted back
            Main.entityManager.addEntity(e);
        for(Entity e : priorityEntities) //priority is now foreground
            Main.entityManager.addEntity(e);
    }

    public void switchLevel(Level nextLevel) {
        currentLevel = nextLevel;
        //clear current entities and repopulate
        Main.entityManager.clearEntities();
        tileWorld(currentLevel);
    }

}
