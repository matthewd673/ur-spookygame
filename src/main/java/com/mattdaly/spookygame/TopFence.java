package com.mattdaly.spookygame;

public class TopFence extends Entity{

    public TopFence(int x, int y){
        super(EntityType.TopFence, Sprites.topFence, new Vector2(x, y), 32, 32);
    }

}
