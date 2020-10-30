package com.mattdaly.spookygame;

import java.rmi.server.Skeleton;

public class End extends Entity {

    public End(float x, float y) {
        super(EntityType.End, Sprites.end, new Vector2(x, y), 32, 32);
        forceBackSort = true;

        col = new Collider(8, 8, 16, 16, true);
    }

    public void update() {

        for(Entity e : Main.entityManager.entityList) {
            if (e.col == null)
                continue;

            if (Collider.detectCollision(col.x, col.y, col.w, col.h, e.col.x, e.col.y, e.col.w, e.col.h)) {
                switch (e.eType) {
                    case SkeletonBody: //skeleton touched end, move to next level
                        SkeletonBody body = (SkeletonBody)e;

                        //THIS IS STUPID
                        //HOWEVER...
                        //it was triggering the collision as soon as the level was initialized
                        //so i added this check so that a body had to be controlled by the player
                        //before the collision would matter
                        //but its stupid that i even had to do that
                        if(!body.hasBeenControlled) //uncontrolled bodies can't press the button
                            break;

                        if(Main.world.currentLevel.nextLevel != null)
                            Main.world.switchLevel(Main.world.currentLevel.nextLevel);
                        break;
                    default:
                        break;
                }
            }
        }

        super.update();
    }

}
