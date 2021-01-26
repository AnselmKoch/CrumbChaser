package me.anselm.spiel.utils;

import me.anselm.spiel.main.CrumbChaser;
import me.anselm.spiel.world.World;

import java.io.IOException;

/**
 * Reloads the game
 * Not fully usable yet but will be improved soon
 */

public class GameReload {

    private CrumbChaser crumbChaser = CrumbChaser.getInstance();
    private World world = crumbChaser.getWorld();

    public void restartGame() throws IOException {
        crumbChaser.killPlayer();
        crumbChaser.setMainPanelNull();
        crumbChaser.getMainFrame().dispose();
        world.getAliveEntities().clear();
        world.getAliveEnemies().clear();
        crumbChaser.killPlayer();

    }
}
