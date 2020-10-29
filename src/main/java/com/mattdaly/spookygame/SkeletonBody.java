package com.mattdaly.spookygame;

import java.awt.*;

public class SkeletonBody extends Entity {

    float speed = 2f;

    boolean hasHead = false;
    SkeletonHead head;

    Collider walkCollider;

    public SkeletonBody(float x, float y, SkeletonHead head) {
        super(EntityType.SkeletonBody, Sprites.skeletonBody, new Vector2(x, y), 0, 0);

        //create collider
        //col = new Collider(new FRect(0, 0, w, h / 2), false, 0, 84);
        col = new Collider(0, 0, 18, 42, true);
        walkCollider = new Collider(0, 34, 18, 8, false);

        //initialize head
        if(head != null) {
            pickupHead(head);
        }
        else {
            hasHead = false;
            this.head = null;
        }
    }

    public void update() {

        //handle keyboard input (if has head)
        if(hasHead) {
            //update walk collider
            walkCollider.x = pos.x + walkCollider.offX;
            walkCollider.y = pos.y + walkCollider.offY;
            handleKeyboardInput();
        }

        //mouse input
        if(Main.mouseManager.leftDown) {
            //throw head
            if(hasHead && head != null) {
                float angleToMouse = Velocity.calculateAngleBetweenPoints(head.pos, Main.renderSurface.cam.getMouseToWorldPoint(Main.mouseManager.getMousePos()));
                head.v = new Velocity(5, angleToMouse);
                dropHead();
            }
        }

        //lock head to body (if its supposed to be attached)
        if(hasHead)
            head.pos = pos;

        //camera follow
        if(hasHead)
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
        head.lastBody = this;
        head.v = new Velocity(0, 0);
        head.timeInAir = 0;
    }

    void handleKeyboardInput() {
        //keyboard input
        if(Main.keyboardManager.isKeyPressed('w'))
            move(pos.x, pos.y - speed, walkCollider);
        if(Main.keyboardManager.isKeyPressed('a'))
            move(pos.x - speed, pos.y, walkCollider);
        if(Main.keyboardManager.isKeyPressed('s'))
            move(pos.x, pos.y + speed, walkCollider);
        if(Main.keyboardManager.isKeyPressed('d'))
            move(pos.x + speed, pos.y, walkCollider);
    }

}
