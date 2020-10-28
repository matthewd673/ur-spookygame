package com.mattdaly.spookygame;

import java.awt.Color;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ParticleSystem {

    Random rng;

    public ParticleSystem(float x, float y, int particleCt, Color particleColor) {

        rng = new Random();

        for(int i = 0; i < particleCt; i++) {
            float moveAngle = 8 * (ThreadLocalRandom.current().nextFloat() - 1f);

            Particle p = new Particle(x, y, particleColor, new Velocity(10, moveAngle));
            Main.entityManager.addEntity(p);

        }

    }

}
