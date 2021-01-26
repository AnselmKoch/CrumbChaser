package me.anselm.spiel.game;


import me.anselm.spiel.entities.Entity;
import me.anselm.spiel.entities.entityMovement.EntityMove;
import me.anselm.spiel.entities.player.Player;
import me.anselm.spiel.frame.MainPanel;
import me.anselm.spiel.main.CrumbChaser;
import me.anselm.spiel.utils.CollitionDetector;
import me.anselm.spiel.utils.KeyInputHandler;
import me.anselm.spiel.utils.math.DirectionHelper;
import me.anselm.spiel.world.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Responsible for everything that should be processed per Tick
 */

public class GameTime extends Timer {

    public static final int TICK_DELAY = 10;
    private long fps = 0, fpsLastSecond = 0;
    private long secondsPassed = 0;
    private long ticksPassed = 0;
    private long milSeconds = 0;
    private Timer timer;
    private KeyInputHandler keyInputHandler = CrumbChaser.getInstance().getKeyInputHandler();

    public GameTime(int delay, ActionListener actionListener) throws IOException {
        super(delay, actionListener);
        this.timer = new Timer(TICK_DELAY, actionListener);
        this.timer.setRepeats(true);
        this.timer.setCoalesce(true);
        this.timer.start();
    }


    /**
     * This method is run every TICK_DELAY amount of milliseconds
     * @throws IOException
     */
    public synchronized void doGameTick() throws IOException {
        World world = CrumbChaser.getInstance().getWorld();
        EntityMove entityMove = CrumbChaser.getInstance().getEntityMove();
        CollitionDetector collitionDetector = CrumbChaser.getInstance().getCollitionDetector();
        DirectionHelper directionHelper = CrumbChaser.getInstance().getEnemyDirectionHelper();
        MainPanel mainPanel = CrumbChaser.getInstance().getMainPanel();
        setTicksPassed(getTicksPassed() + 1);
        if(getTicksPassed() % (1000 / TICK_DELAY) == 0) {
            setSecondsPassed(getSecondsPassed() + 1);
            fpsLastSecond = fps;
            fps = 0;
        }

        for(Entity entity : world.getAliveEntities()) {
            if(!(entity instanceof Player)) {
                entityMove.addMomentum(directionHelper.changeMomentum(entity), entity);
            }


            keyInputHandler.handleKeyInput();
            entityMove.updatePos(entity.getMomentum(), entity);
        }


        collitionDetector.checkCollition(world.getPlayer());
        if(mainPanel != null) {
            fps++;
            mainPanel.repaint();
        }
    }

    public long getFpsLastSecond() {
        return fpsLastSecond;
    }

    public long getFps() {
        return fps;
    }

    public void setFPS(long newFPS) {
        fps = newFPS;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public long getSecondsPassed() {
        return secondsPassed;
    }

    public void setSecondsPassed(long secondsPassed) {
        this.secondsPassed = secondsPassed;
    }

    public long getTicksPassed() {
        return ticksPassed;
    }

    public void setTicksPassed(long ticksPassed) {
        this.ticksPassed = ticksPassed;
    }

    public long getMilSeconds() {
        return milSeconds;
    }

    public void setMilSeconds(long milSeconds) {
        this.milSeconds = milSeconds;
    }
}
