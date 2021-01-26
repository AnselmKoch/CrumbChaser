package me.anselm.spiel.entities.entityMovement;

/**
 * The Momentum class is responsible for the acceleration an entity has
 */

public class Momentum {

    private float xMomentum, yMomentum;

    public Momentum(float xMomentum, float yMomentum) {
        this.xMomentum = xMomentum;
        this.yMomentum = yMomentum;
    }


    public String toString() {
        return this.xMomentum + " | " + this.yMomentum;
    }

    public void addMomentum(float newX, float newY) {
        this.xMomentum += newX;
        this.yMomentum += newY;
    }
    public float getxMomentum() {
        return this.xMomentum;
    }

    public void setxMomentum(int xMomentum) {
        this.xMomentum = xMomentum;
    }

    public float getyMomentum() {
        return this.yMomentum;
    }

    public void setyMomentum(int yMomentum) {
        this.yMomentum = yMomentum;
    }
}
