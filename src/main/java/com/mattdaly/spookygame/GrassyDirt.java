package com.mattdaly.spookygame;

public class GrassyDirt extends Entity{

    public GrassyDirt(int x, int y){

        super(EntityType.GrassyDirt, Sprites.grassyDirt, new Vector2(x, y), 32, 32);
    }
}
