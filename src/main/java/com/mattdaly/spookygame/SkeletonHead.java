package com.mattdaly.spookygame;

import java.awt.*;

public class SkeletonHead extends Entity {

    public SkeletonHead(float x, float y) {
        super(Sprites.skeletonHead, new Vector2(x, y), 0, 0);
    }

    public void update() {
        pos = Main.renderSurface.cam.getMouseToWorldPoint(Main.mouseManager.getMousePos());
    }

    public void render(Graphics g) {

        RenderSurface.drawRectangle(g, Main.renderSurface.cam.getRenderRect(new Rectangle((int)pos.x, (int)pos.y, w, h)), Color.BLACK);

        super.render(g);
    }
}
