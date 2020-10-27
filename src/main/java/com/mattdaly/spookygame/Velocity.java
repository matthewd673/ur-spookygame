package com.mattdaly.spookygame;

public class Velocity {

    float speed;
    float angle;

    public float vX = 0;
    public float vY = 0;

    public Velocity(float speed, float angle) {
        this.speed = speed;
        setAngle(angle);
    }

    public void setAngle(float angle) {
        this.angle = angle;
        this.vX = (float)Math.sin(angle) * speed;
        this.vY = (float)Math.cos(angle) * speed;
    }

    public static float calculateAngleBetweenPoints(Vector2 a, Vector2 b) {
        return (float)Math.atan2(a.y - b.y, a.x - b.x);
    }

}
