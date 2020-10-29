package com.mattdaly.spookygame;

public class Pit extends Entity {

    public Pit(float x, float y) {
        super(EntityType.Pit, Sprites.pit, new Vector2(x, y), 32, 32);

        setCollider(new Collider(0, 0, 32, 32, false));
    }

}
