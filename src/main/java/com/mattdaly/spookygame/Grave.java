package com.mattdaly.spookygame;

import java.awt.*;

public class Grave extends Entity {

    public Grave(float x, float y) {
        super(EntityType.Grave, Sprites.grave, new Vector2(x, y), 0, 0);

        //col = new Collider(new FRect(0, 0, w, h / 4), false, 0, 48);
        col = new Collider(0, 12, 18, 6, false);
    }

}
