package com.mattdaly.spookygame;

import java.awt.*;

public class SkeletonHead extends Entity {

    SkeletonBody lastBody;

    int timeInAir = 0;
    int maxTimeInAir = 120;

    public SkeletonHead(SkeletonBody lastBody, float x, float y) {
        super(EntityType.SkeletonHead, Sprites.skeletonHead, new Vector2(x, y), 0, 0);
        this.lastBody = lastBody;
        setCollider(new Collider(4, 0, 10, 9, true));
    }

    public void update() {

        if(!lastBody.hasHead) {
            timeInAir++;
            Main.renderSurface.cam.lockToEntity(this);
        }

        if(timeInAir > maxTimeInAir)
            breakHead();

        //check collisions if head off body
        if(!lastBody.hasHead) {
            for (Entity e : Main.entityManager.entityList) {

                if (e.col == null)
                    continue;

                if (Collider.detectCollision(col.x, col.y, col.w, col.h, e.col.x, e.col.y, e.col.w, e.col.h)) {
                    switch (e.eType) {
                        case Grave: //hit a grave and explode
                        case Fence:
                        case TopFence:
                            breakHead();
                            break;
                        case SkeletonBody: //hit a body and get picked up
                            SkeletonBody contactBody = (SkeletonBody)e;
                            if(contactBody != lastBody) //make sure its a new body
                                contactBody.pickupHead(this);
                            break;
                    }
                }

            }
        }

        super.update();
    }

    public void breakHead() {
        ParticleSystem headParticles = new ParticleSystem(col.x + 4, col.y + 4, 200, new Color(239, 105, 47));

        lastBody.pickupHead(this);
    }

}
