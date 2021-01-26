package me.anselm.spiel.entities;

import me.anselm.spiel.main.CrumbChaser;

import me.anselm.spiel.world.World;
import me.anselm.spiel.world.location.Location;


/**
 * Not used yet
 */
public class EntityDirection {

    private CrumbChaser crumbChaser = CrumbChaser.getInstance();
    private World world = crumbChaser.getWorld();

    public void getDirection() {
        for(Entity entity : world.getAliveEntities()) {
            Location location = CrumbChaser.getInstance().getPlayer().getLocation();

        }
    }
}
