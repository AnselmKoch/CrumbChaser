package me.anselm.spiel.utils.math;

import me.anselm.spiel.entities.Entity;
import me.anselm.spiel.entities.entityMovement.EntityMove;
import me.anselm.spiel.entities.entityMovement.Momentum;
import me.anselm.spiel.entities.player.Player;
import me.anselm.spiel.main.CrumbChaser;
import me.anselm.spiel.world.location.Location;

/**
 * The DirectionHelper is used to determine the Direction
 * an Entity needs to have in order to reach a ceratin X/Y-Coordinate
 *
 * Right now it sets the Momentum to reach the players coordinate
 * this will be done in other objects in the future
 */

public class DirectionHelper {


    private CrumbChaser crumbChaser = CrumbChaser.getInstance();

    /**
     * Changes the momentum of the Entity in the parameter so that the entity will reach the player
     *
     * @param entity The Entity of which the momentum will be changed
     * @return Returns the correct momentum
     */
    public Momentum changeMomentum(Entity entity) {
        Player player = crumbChaser.getWorld().getPlayer();
        Location entityLocation = entity.getLocation();
        Location playerLocation = player.getLocation();

        Momentum returnMomentum = new Momentum(0, 0);


        /**
         * If the entities X-Coordinate is equal to the players X-Coordinate
         */
        if ((int) playerLocation.getxCoordinate() == (int) entityLocation.getxCoordinate()) {
            /**
             * If the players Y-Coordinate is lower than the entities Y-Coordinate (means the player is higher on the screen)
             */
            if (playerLocation.getyCoordinate() < entityLocation.getyCoordinate()) {
                if (entity.getMomentum().getyMomentum() > -6.3F) {
                    returnMomentum.addMomentum(0, -3.15F);
                }
            } else {
                if (entity.getMomentum().getyMomentum() < 6.3F) {
                    returnMomentum.addMomentum(0, 3.15F);
                }
            }
        }

        /**
         * If the entities Y-Coordinate is equal to the players Y-Coordinate
         */
        if ((int) playerLocation.getyCoordinate() == (int) entityLocation.getyCoordinate()) {
            /**
             * If the players X-Coordinate is lower than the entities X-Coordinate (means the player is more on the left on the screen)
             */
            if (playerLocation.getxCoordinate() < entityLocation.getxCoordinate()) {
                if (entity.getMomentum().getxMomentum() > -6.3F) {
                    returnMomentum.addMomentum(-1.5F, 0);
                }
            } else {
                if (entity.getMomentum().getxMomentum() < 6.3F) {
                    returnMomentum.addMomentum(1.5F, 0);
                }
            }
        }

        /**
         * If players X-Coordinate is higher then the entities one (entite is left to the player)
         */
        if (playerLocation.getxCoordinate() > entityLocation.getxCoordinate()) {
            if (entity.getMomentum().getxMomentum() < 6.3F) {
                returnMomentum.addMomentum(0.15F, 0);
            }
        } else {
            if (entity.getMomentum().getxMomentum() > -6.3F) {
                returnMomentum.addMomentum(-0.15F, 0);
            }

            /**
             * If players Y-Coordinate is lower than the entities one (entity is below player)
             */
            if (playerLocation.getyCoordinate() < entityLocation.getyCoordinate()) {
                if (entity.getMomentum().getyMomentum() > -6.3F) {
                    returnMomentum.addMomentum(0, -0.15F);
                }
            } else {
                if (entity.getMomentum().getyMomentum() < 6.3F) {
                    returnMomentum.addMomentum(0, 0.15F);
                }

            }
        }
        return returnMomentum;
    }
}
