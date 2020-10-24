package com.mattdaly.spookygame;

public class SkeletonBody extends Entity {

    float speed = 2f;

    boolean hasHead = false;
    SkeletonHead head;

    public SkeletonBody(float x, float y, SkeletonHead head) {
        super(Sprites.skeletonBody, new Vector2(x, y), 12, 32);

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
            pos.y -= speed;
        if(Main.keyboardManager.isKeyPressed('a'))
            pos.x -= speed;
        if(Main.keyboardManager.isKeyPressed('s'))
            pos.y += speed;
        if(Main.keyboardManager.isKeyPressed('d'))
            pos.x += speed;
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
