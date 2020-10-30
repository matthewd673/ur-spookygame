package com.mattdaly.spookygame;

public class Dirt extends Entity{

    public Dirt(int x, int y) {
        super(EntityType.Dirt, Sprites.dirt, new Vector2(x, y), 32, 32);
        forceBackSort = true;
    }
}
