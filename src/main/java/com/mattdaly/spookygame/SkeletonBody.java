package com.mattdaly.spookygame;

import java.awt.*;

public class SkeletonBody extends Entity {

    float speed = 2f;

    boolean hasHead = false;
    SkeletonHead head;

    public SkeletonBody(float x, float y, SkeletonHead head) {
        super(Sprites.skeletonBody, new Vector2(x, y), 0, 0);

        //create collider
        //col = new Collider(new FRect(0, 0, w, h / 2), false, 0, 84);
        col = new Collider(0, 34, 18, 8, false);

        //initialize head
        if(head != null) {
            hasHead = true;
            this.head = head;
        }
        else {
            hasHead = false;
            this.head = null;
        }
    }

    public void update() {


        if(Main.keyboardManager.isKeyPressed('w'))
            move(pos.x, pos.y - speed);
        if(Main.keyboardManager.isKeyPressed('a'))
            move(pos.x - speed, pos.y);
        if(Main.keyboardManager.isKeyPressed('s'))
            move(pos.x, pos.y + speed);
        if(Main.keyboardManager.isKeyPressed('d'))
            move(pos.x + speed, pos.y);
        if(Main.keyboardManager.isKeyPressed('e'))
            dropHead();

        //lock head to body (if its supposed to be attached)
        if(hasHead)
            head.pos = pos;

        //camera follow
        Main.renderSurface.cam.lockToEntity(this);

        super.update();
    }

    public void dropHead() {
        hasHead = false;
        head = null;
    }

    public void pickupHead(SkeletonHead newHead) {
        hasHead = true;
        head = newHead;
    }

}
