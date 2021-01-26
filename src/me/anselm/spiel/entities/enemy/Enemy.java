package me.anselm.spiel.entities.enemy;

import me.anselm.spiel.entities.Entity;
import me.anselm.spiel.entities.ENTITYPE;
import me.anselm.spiel.entities.entityMovement.Momentum;

import java.awt.*;

public class Enemy extends Entity {
    public Enemy(int height, int width, float xPos, float yPos, Color color, Momentum momentum, ENTITYPE entityType, char facing) {
        super(height, width, xPos, yPos, color, momentum, entityType, facing);
    }
}
