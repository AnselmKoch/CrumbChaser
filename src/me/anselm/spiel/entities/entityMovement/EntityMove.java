package me.anselm.spiel.entities.entityMovement;

import me.anselm.spiel.entities.Entity;
import me.anselm.spiel.entities.player.Player;
import me.anselm.spiel.main.CrumbChaser;
import me.anselm.spiel.utils.AreaDetector;
import me.anselm.spiel.world.World;
import me.anselm.spiel.world.location.Location;

/**
 * Object thats responsible for moving entities
 */

public class EntityMove implements Movable {

    private CrumbChaser crumbChaser = CrumbChaser.getInstance();
    private AreaDetector areaDetector = crumbChaser.getAreaDetector();

    /**
     * Adds a value to the current momentum of the Entity
     * @param momentum The Momentum that is supposed to be added to the current Momentum
     * @param entity The entity on which  the momentum will be added
     */
    @Override
    public void addMomentum(Momentum momentum, Entity entity) {
        Momentum entityMomentum = entity.getMomentum();

        entity.setMomentum(new Momentum(entityMomentum.getxMomentum() + momentum.getxMomentum(),
                entityMomentum.getyMomentum() + momentum.getyMomentum()));

    }

    /**
     * Sets a new Momentum instead of adding something to the momentum
     * @param momentum The momentum that will override the current momentum
     * @param entity The Entity which momentum will be overriden
     */

    @Override
    public void setMomentum(Momentum momentum, Entity entity) {
        entity.setMomentum(momentum);
    }


    /**
     * Updates the Location of a entity by adding the current momentum of the Entity to the currents Location
     * @param momentum the current Momentum which will be added to the current Location
     * @param entity the entity of which the Entities Location will be changed
     */
    @Override
    public void updatePos(Momentum momentum, Entity entity) {
        World world = crumbChaser.getWorld();
        float newX = momentum.getxMomentum();
        float newY = momentum.getyMomentum();

        if(entity instanceof Player) {
            world.relativePlayerXPos += newX;
            world.relativePlayerYPos += newY;
        }
        entity.setLocation(new Location(entity.getLocation().getxCoordinate() + newX, entity.getLocation().getyCoordinate() + newY));
        entity.setBorder(areaDetector.getBorder(entity.getLocation().getxCoordinate(), entity.getLocation().getyCoordinate(), entity.getWidth(), entity.getHeight()));
    }


    /**
     * Moves the entity to a new Location
     * @param location the Location on which the entity should be moved
     * @param entity the entity of which the location will be changed
     */
    @Override
    public void move(Location location, Entity entity) {
        entity.setLocation(location);
    }
}
