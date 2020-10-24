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
        world = new World(3000, 3000);
        world.placeGrass(100);
        world.placeGraves(50);

        //make skeleton
        SkeletonHead skeletonHead = new SkeletonHead(50, 50);
        SkeletonBody skeletonBody = new SkeletonBody(50, 50, skeletonHead);
        entityManager.addEntity(skeletonBody);
        entityManager.addEntity(skeletonHead);

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
