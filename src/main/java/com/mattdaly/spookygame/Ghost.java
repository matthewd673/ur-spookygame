package com.mattdaly.spookygame;

public class Ghost extends Entity {

    float speed = 2;

    public Ghost(float x, float y) {
        super(Sprites.ghost, new Vector2(x, y), 8, 8);
    }

    public void update() {

        if(Main.keyboardManager.isKeyPressed('w'))
            pos.y -= speed;
        if(Main.keyboardManager.isKeyPressed('a'))
            pos.x -= speed;
        if(Main.keyboardManager.isKeyPressed('s'))
            pos.y += speed;
        if(Main.keyboardManager.isKeyPressed('d'))
            pos.x += speed;

        super.update();
    }

}
