package me.anselm.spiel.utils.math;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Objects to get random Integers;
 */

public class RandomHelper {

    public int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min,max);
    }
}
