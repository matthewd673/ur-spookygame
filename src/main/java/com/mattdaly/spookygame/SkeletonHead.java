package com.mattdaly.spookygame;

import java.awt.*;

public class SkeletonHead extends Entity {

    SkeletonBody lastBody;

    public SkeletonHead(SkeletonBody lastBody, float x, float y) {
        super(EntityType.SkeletonHead, Sprites.skeletonHead, new Vector2(x, y), 0, 0);
        this.lastBody = lastBody;
        setCollider(new Collider(4, 0, 10, 9, true));
    }

    public void update() {

        for(Entity e : Main.entityManager.entityList) {

            if(e.col == null)
                continue;

            if(Collider.detectCollision(col.x, col.y, col.w, col.h, e.col.x, e.col.y, e.col.w, e.col.h)) {
                switch(e.eType) {
                    case Grave:
                        lastBody.pickupHead(this);
                        break;
                }
            }

        }

        super.update();
    }

}
