package com.mattdaly.spookygame;

import java.util.ArrayList;

public class EntityManager {

    ArrayList<Entity> entityList = new ArrayList<Entity>();

    private ArrayList<Entity> addQueue = new ArrayList<Entity>();
    private ArrayList<Entity> removeQueue = new ArrayList<Entity>();

    private boolean clearNext = false;

    public void addEntity(Entity e) {
        addQueue.add(e);
    }

    public void removeEntity(Entity e) {
        removeQueue.add(e);
    }

    public void clearEntities() { clearNext = true; }

    public void update() {
        for(Entity e : entityList) {
            e.update();
        }

        if(clearNext) {
            entityList.clear();
            clearNext = false;
        }

        entityList.removeAll(removeQueue);
        removeQueue.clear();

        entityList.addAll(addQueue);
        addQueue.clear();

    }

}
