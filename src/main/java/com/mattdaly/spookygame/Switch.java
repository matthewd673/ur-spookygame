package com.mattdaly.spookygame;

public class Switch extends Entity {


    public Switch(int x, int y) {
        super(EntityType.Button, Sprites.button, new Vector2(x, y), 32, 32, false);

        col = new Collider(0, 0, 32, 32, false);
    }

}