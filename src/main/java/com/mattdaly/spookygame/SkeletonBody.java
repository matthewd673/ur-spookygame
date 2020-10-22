package com.mattdaly.spookygame;

public class SkeletonBody extends Entity {

    float speed = 2f;

    boolean hasHead = false;
    SkeletonHead head;

    public SkeletonBody(float x, float y, boolean hasHead) {
        super(Sprites.skeletonBody, new Vector2(x, y), 12, 32);

        //initialize head
        this.hasHead = hasHead;
        if(hasHead) {
            head = new SkeletonHead(x, y);
            Main.entityManager.addEntity(head);
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

        //camera follow
        Main.renderSurface.cam.lockToEntity(this);

        super.update();
    }

}
