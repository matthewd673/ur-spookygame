package com.mattdaly.spookygame;

import java.awt.*;

public class Ghost extends Entity {

    float speed = 2;

    public Ghost(float x, float y) {
        super(Sprites.ghost, new Vector2(x, y), 8, 8);
    }

    public void update() {

        if(Main.inputManager.isKeyPressed('w'))
            pos.y -= speed;
        if(Main.inputManager.isKeyPressed('a'))
            pos.x -= speed;
        if(Main.inputManager.isKeyPressed('s'))
            pos.y += speed;
        if(Main.inputManager.isKeyPressed('d'))
            pos.x += speed;

        super.update();
    }

}
