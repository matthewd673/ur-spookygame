package com.mattdaly.spookygame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static JFrame frame;
    static RenderSurface renderSurface;
    static InputManager inputManager;
    static EntityManager entityManager;

    public static void main(String args[]) {

        loadContent();

        createFrame("SpookyGame", 800, 600);
        entityManager = new EntityManager();

        beginGameLoop();
    }

    static void loadContent() {
        //load all content
    }

    static void createFrame(String title, int w, int h) {
        //set frame properties
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(w, h);
        frame.setResizable(false);

        //set up rendersurface
        renderSurface = new RenderSurface(w, h);
        frame.add(renderSurface);

        //set up inputmanager
        inputManager = new InputManager();
        frame.addKeyListener(inputManager);

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
        renderSurface.repaint();
    }

}
