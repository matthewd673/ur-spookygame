package com.mattdaly.spookygame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static JFrame frame;
    static RenderSurface renderSurface;
    static KeyboardManager keyboardManager;
    static EntityManager entityManager;

    static Ghost ghost;

    public static void main(String args[]) {

        loadContent();

        createFrame("SpookyGame", 800, 600);
        entityManager = new EntityManager();

        ghost = new Ghost(50, 50);
        entityManager.addEntity(ghost);

        beginGameLoop();
    }

    static void loadContent() {
        Sprites.loadSprites();
    }

    static void createFrame(String title, int w, int h) {
        //set frame properties
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(w, h);
        frame.setResizable(false);

        //set up rendersurface
        Camera renderCam = new Camera(new Vector2(0, 0), w, h, 4);
        renderSurface = new RenderSurface(renderCam);
        frame.add(renderSurface);

        //set up inputmanager
        keyboardManager = new KeyboardManager();
        frame.addKeyListener(keyboardManager);

        //display
        frame.setVisible(true);
    }

    static void beginGameLoop() {
        int interval = 16; //60fps = 16.67

        ActionListener tickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) { update(); }
        };

        new Timer(interval, tickListener).start();
    }

    static void update() {
        entityManager.update();
        renderSurface.repaint();
    }

}
