package me.anselm.spiel.world;

import me.anselm.spiel.entities.ENTITYPE;
import me.anselm.spiel.entities.Entity;
import me.anselm.spiel.entities.enemy.Enemy;
import me.anselm.spiel.entities.entityMovement.Momentum;
import me.anselm.spiel.main.CrumbChaser;
import me.anselm.spiel.entities.player.Player;

import java.awt.*;
import java.util.ArrayList;

/**
 * The World object that holds all the enemies
 */

public class World {


    private ArrayList<Enemy> aliveEnemies = new ArrayList<>();
    private ArrayList<Entity> aliveEntities = new ArrayList<>();

    private int width, height;
    private CrumbChaser crumbChaser = CrumbChaser.getInstance();
    private Player player;

    /**
     * The relativePlayerPos is not the actual position of the player
     * its the position of the player relative to his spawn location
     */
    public float relativePlayerXPos;
    public float relativePlayerYPos;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        this.relativePlayerXPos = 0;
        this.relativePlayerYPos = 0;
        setUpPlayer();
        setUpEnemies();
    }

    /**
     * Spawns 1 player
     */
    public void setUpPlayer() {
        this.player = new Player(50,50, CrumbChaser.WIDTH / 2, CrumbChaser.HEIGHT / 2, Color.RED, new Momentum(0,0), ENTITYPE.PLAYER, 'n');
        this.setPlayer(this.player);
        this.aliveEntities.add(this.player);
    }

    /**
     * Spawns x enemies
     */
    public void setUpEnemies() {
        for(int i = 0; i < 3; i++) {
            int randomX = crumbChaser.getRandomHelper().randomInt(0, getWidth());
            int randomY = crumbChaser.getRandomHelper().randomInt(0,getHeight());
            Enemy enemy = new Enemy(50,50,randomX, randomY, Color.CYAN, new Momentum(0,0), ENTITYPE.NORMALENEMY, 'n');
            this.getAliveEnemies().add(enemy);
            this.getAliveEntities().add(enemy);

        }
    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Enemy> getAliveEnemies() {
        return aliveEnemies;
    }

    public ArrayList<Entity> getAliveEntities() {
        return aliveEntities;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
