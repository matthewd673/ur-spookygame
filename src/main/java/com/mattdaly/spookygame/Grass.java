package com.mattdaly.spookygame;

public class Grass extends Entity {

    public Grass(float x, float y) {

        super(EntityType.Grass, Sprites.grass, new Vector2(x, y), 0, 0);
    }

}
