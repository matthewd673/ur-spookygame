package com.mattdaly.spookygame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager implements MouseListener {

    public boolean leftDown = false;
    public boolean rightDown = false;
    public boolean middleDown = false;

    int mOffX = 8;
    int mOffY = 30;

    public Vector2 getMousePos() {
        Point mousePoint = MouseInfo.getPointerInfo().getLocation();
        return new Vector2(mousePoint.x - Main.frame.getX() - mOffX, mousePoint.y - Main.frame.getY() - mOffY);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch(e.getButton()) {
            case MouseEvent.BUTTON1:
                leftDown = true;
                break;
            case MouseEvent.BUTTON2:
                rightDown = true;
                break;
            case MouseEvent.BUTTON3:
                middleDown = true;
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch(e.getButton()) {
            case MouseEvent.BUTTON1:
                leftDown = false;
                break;
            case MouseEvent.BUTTON2:
                rightDown = false;
                break;
            case MouseEvent.BUTTON3:
                middleDown = false;
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
