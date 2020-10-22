package com.mattdaly.spookygame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager implements MouseListener {

    public boolean leftDown = false;
    public boolean rightDown = false;
    public boolean middleDown = false;

    public Vector2 getMousePos() {
        return new Vector2(Main.frame.getMousePosition().x, Main.frame.getMousePosition().y);
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
