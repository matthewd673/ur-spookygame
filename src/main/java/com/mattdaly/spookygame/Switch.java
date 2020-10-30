package com.mattdaly.spookygame;

public class Switch extends Entity {

    public Switch(int x, int y) {
        super(EntityType.Button, Sprites.button, new Vector2(x, y), 32, 32, false);
        forceBackSort = true;

        col = new Collider(8, 7, 17, 17, false);
    }

    public void update() {

        // skeleton touch indicator
        boolean skeletonIsTouching = false;

        for(Entity e : Main.entityManager.entityList) {
            if(col == null || e.col == null)
                continue;

            if(Collider.detectCollision(col.x, col.y, col.w, col.h, e.col.x, e.col.y, e.col.w, e.col.h)) {
                switch(e.eType) {
                    case SkeletonBody:
                        activated = true;
                        skeletonIsTouching = true;
                        break;
                }
            }
        }

        //turn off button if skeleton not touching
        if(!skeletonIsTouching)
            activated = false;

        if(!activated)
            sprite = Sprites.button;
        else
            sprite = Sprites.buttonActivated;

        super.update();
    }

}