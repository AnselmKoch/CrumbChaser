package me.anselm.spiel.entities.entityMovement;

import me.anselm.spiel.entities.Entity;
import me.anselm.spiel.world.location.Location;

public interface Movable {

    public void addMomentum(Momentum momentum, Entity entity);
    public void setMomentum(Momentum momentum, Entity entity);
    public void updatePos(Momentum momentum, Entity entity);
    public void move(Location location, Entity entity);
}
