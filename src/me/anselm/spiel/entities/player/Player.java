package me.anselm.spiel.entities.player;

import me.anselm.spiel.entities.Entity;
import me.anselm.spiel.entities.ENTITYPE;
import me.anselm.spiel.entities.entityMovement.Momentum;

import java.awt.*;

public class Player extends Entity {

    public Player(int height, int width, float xPos, float yPos, Color color, Momentum momentum, ENTITYPE entityType, char facing) {
        super(height, width, xPos, yPos, color, momentum, entityType, facing);
    }


}
