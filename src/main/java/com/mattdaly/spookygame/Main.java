package com.mattdaly.spookygame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.Skeleton;

public class Main {

    static JFrame frame;
    static RenderSurface renderSurface;
    static KeyboardManager keyboardManager;
    static MouseManager mouseManager;
    static EntityManager entityManager;

    static World world;

    public static void main(String args[]) {

        loadContent();

        createFrame("SpookyGame", 800, 600);
        entityManager = new EntityManager();

        //world generator
        world = new World(1000, 1000);
        world.switchLevel(World.level1);
        /*
        world.placeGrass(300);
        world.placeGraves(50);
         */

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
        Camera renderCam = new Camera(new Vector2(0, 0), w, h, 2);
        renderSurface = new RenderSurface(renderCam);
        frame.add(renderSurface);

        //set up input managers
        keyboardManager = new KeyboardManager();
        frame.addKeyListener(keyboardManager);
        mouseManager = new MouseManager();
        frame.addMouseListener(mouseManager);

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
