package me.anselm.spiel.main;

import me.anselm.spiel.entities.ENTITYPE;
import me.anselm.spiel.entities.entityMovement.EntityMove;
import me.anselm.spiel.frame.MainFrame;
import me.anselm.spiel.frame.MainPanel;
import me.anselm.spiel.entities.player.Player;
import me.anselm.spiel.game.MainThread;
import me.anselm.spiel.utils.AreaDetector;
import me.anselm.spiel.utils.CollitionDetector;
import me.anselm.spiel.utils.KeyInputHandler;
import me.anselm.spiel.utils.math.DirectionHelper;
import me.anselm.spiel.utils.math.RandomHelper;
import me.anselm.spiel.world.World;

import java.awt.*;
import java.io.IOException;

public class CrumbChaser {


    /**
     * Variables to store informationen about the Display of the game
     */
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final String gameName = "CrumbChaser";
    public static final int HEIGHT = screenSize.height, WIDTH = screenSize.width;
    public static final int WORLDHEIGHT = 10000, WORLDWIDTH = 10000;


    /**
     * Setting up variables so every instance can be called from the CrumbChaser.java class
     * The instances will  be created later on
     */
    private Player player;
    private Thread mainThread;
    private static CrumbChaser crumbChaserClass;
    private static boolean firstStart = true;
    private static boolean running;
    private ENTITYPE ENTITYPE;
    private DirectionHelper directionHelper;
    private RandomHelper randomHelper;

    private AreaDetector areaDetector;
    private KeyInputHandler keyInputHandler;
    private CollitionDetector collitionDetector;
    private EntityMove entityMove;
    private MainFrame mainFrame;
    private MainPanel mainPanel;
    private World world;


    /**
     * start
     */
    public void start() throws IOException {
        setupInstances();
        setUpDisplay();
        initiate();
    }

    /**
     * Assigning new Instances to every variable
     * -And by creating a World instane I define the Width and Height of the world, not the Window
     */
    private static void setupInstances() {
        crumbChaserClass = new CrumbChaser();
        getInstance().directionHelper = new DirectionHelper();
        getInstance().randomHelper = new RandomHelper();
        getInstance().areaDetector = new AreaDetector();
        getInstance().entityMove = new EntityMove();
        getInstance().collitionDetector = new CollitionDetector();
        getInstance().world = new World(WORLDWIDTH, WORLDHEIGHT);
        getInstance().player = getInstance().getWorld().getPlayer();;
        getInstance().keyInputHandler = new KeyInputHandler();
    }


    /**
     *Starting the Display of the game
     */
    private static void setUpDisplay() throws IOException {
        getInstance().mainPanel = new MainPanel();
        getInstance().mainFrame = new MainFrame();
        getInstance().mainFrame.setJPanel();
    }


    /**
     *Starting the Game by starting the Thread which processes informatione, repaints the Display etc.
     */
    private static void initiate() throws IOException {
        crumbChaserClass.setMainThread(new MainThread());
        crumbChaserClass.getMainThread().run();
        firstStart = false;

    }

    /**
     * Bunch of getters and setters
     */

    public KeyInputHandler getKeyInputHandler() {
        return keyInputHandler;
    }
    public CollitionDetector getCollitionDetector() {
        return collitionDetector;
    }
    public EntityMove getEntityMove() {
        return entityMove;
    }
    public static CrumbChaser getInstance() {
        return crumbChaserClass;
    }
    public static boolean isFirstStart() {
        return firstStart;
    }
    public static void setFirstStart(boolean firstStart) {
        CrumbChaser.firstStart = firstStart;
    }
    public static boolean isRunning() {
        return running;
    }
    public static void setRunning(boolean running) {
        CrumbChaser.running = running;
    }
    public void registerMainFrame() {
            mainFrame = new MainFrame();
    }
    public World getWorld() {
        return world;
    }
    public MainFrame getMainFrame() {
        return mainFrame;
    }
    public MainPanel getMainPanel() {
        return mainPanel;
    }
    public Thread getMainThread() {
        return this.mainThread;
    }
    public Player getPlayer() {
        return player;
    }
    public void setMainPanelNull() {
        mainPanel = null;
    }
    public void killPlayer() {
        player = null;
    }

    public void setMainThread(Thread mainThread) {
        this.mainThread = mainThread;
    }
    public ENTITYPE getEntityTypes() {
        return ENTITYPE;
    }
    public DirectionHelper getEnemyDirectionHelper() {
        return directionHelper;
    }
    public RandomHelper getRandomHelper() {
        return randomHelper;
    }
    public AreaDetector getAreaDetector() {
        return areaDetector;
    }
}
