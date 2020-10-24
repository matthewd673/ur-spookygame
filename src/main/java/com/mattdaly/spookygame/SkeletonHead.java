package com.mattdaly.spookygame;

public class SkeletonHead extends Entity {

    public SkeletonHead(float x, float y) {
        super(Sprites.skeletonHead, new Vector2(x, y), 0, 0);
    }

    public void update() {
        Main.frame.setTitle(pos.x + ", " + pos.y);
    }
}
