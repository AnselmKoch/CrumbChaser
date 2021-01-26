package me.anselm.spiel.entities;

import me.anselm.spiel.entities.entityMovement.Momentum;
import me.anselm.spiel.entities.player.Player;
import me.anselm.spiel.main.CrumbChaser;
import me.anselm.spiel.utils.AreaDetector;
import me.anselm.spiel.world.World;
import me.anselm.spiel.world.location.Location;

import java.awt.*;

/**
 * The Entity class
 */

public class Entity {


    private int height, width;
    private float xPos, yPos;
    private CrumbChaser crumbChaser = CrumbChaser.getInstance();
    private Color color;
    private AreaDetector areaDetector = new AreaDetector();
    private Location[] border;
    private Location location;


    private ENTITYPE entityType;
    private Momentum momentum;
    private char facing;

    public Entity(int height, int width, float xPos, float yPos, Color color, Momentum momentum, ENTITYPE entityType, char facing) {
        this.height = height;
        this.width = width;
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
        this.momentum = momentum;
        this.entityType = entityType;
        this.facing = facing;
        this.location = new Location(xPos,yPos);
        this.border = areaDetector.getBorder(this.xPos, this.yPos, this.width, this.height);
    }

    public Location[] getBorder() {
       return this.border;
    }

    public void updateLocation(Momentum momentum) {
        World world = crumbChaser.getWorld();
        float newX = momentum.getxMomentum();
        float newY = momentum.getyMomentum();

        if(this instanceof Player) {
            world.relativePlayerXPos += newX;
            world.relativePlayerYPos += newY;
        }
        this.location = new Location(this.location.getxCoordinate() + newX, this.location.getyCoordinate() + newY);
        this.border = areaDetector.getBorder(this.location.getxCoordinate(), this.location.getyCoordinate(), this.width, this.height);
    }

    public ENTITYPE getEntityType() {
        return entityType;
    }

    public Color getColor() {
        return color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public float getXpos() {
        return xPos;
    }

    public void setXpos(int xpos) {
        this.xPos = xpos;
    }

    public float getYpos() {
        return yPos;
    }

    public void setYpos(int ypos) {
        this.yPos = ypos;
    }

    public void setBorder(Location[] border) {
        this.border = border;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Momentum getMomentum() {
        return momentum;
    }

    public void setMomentum(Momentum momentum) {
        this.momentum = momentum;
    }
}
