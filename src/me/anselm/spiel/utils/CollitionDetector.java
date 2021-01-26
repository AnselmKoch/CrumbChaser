package me.anselm.spiel.utils;

import me.anselm.spiel.entities.enemy.Enemy;
import me.anselm.spiel.entities.player.Player;
import me.anselm.spiel.main.CrumbChaser;
import me.anselm.spiel.world.World;
import me.anselm.spiel.world.location.Location;

import java.io.IOException;

/**
 * Checks if an entity collided with the Player by comparing every Location of the players and the entitiesborders
 * if one of the players Location is contained in the entities border it means they collided
 */

public class CollitionDetector {

    private GameReload gameReload = new GameReload();
    private CrumbChaser crumbChaser = CrumbChaser.getInstance();

    public void checkCollition(Player player) throws IOException {
        World world = crumbChaser.getWorld();

        for(Enemy enemy : world.getAliveEnemies()) {
                Location[] enemyBorder = enemy.getBorder();

                for (Location locationEnemy : enemyBorder) {
                    Location[] playerBorder = player.getBorder();

                    for(Location locationPlayer : playerBorder) {
                        if (((int)locationEnemy.getxCoordinate() == (int)locationPlayer.getxCoordinate()) &&
                                ((int)locationEnemy.getyCoordinate() == (int)locationPlayer.getyCoordinate())) {
                            gameReload.restartGame();
                        }
                    }
            }
        }
    }
}
