package com.mattdaly.spookygame;

import java.util.Random;

public class World {

    int w;
    int h;

    Random rng;

    public World(int w, int h) {
        this.w = w;
        this.h = h;

        rng = new Random();
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

}
