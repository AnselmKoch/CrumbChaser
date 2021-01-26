package me.anselm.spiel.world.location;

import me.anselm.spiel.entities.Entity;

/**
 * Not used yet but is used to represent an Area
 */

public class Area {
    int[][]locations;
    int aCorner, bCorner, cCorner, dCorner;

    public Area(int aCorner, int bCorner,int cCorner, int dCorner) {
        this.aCorner = aCorner;
        this.bCorner = bCorner;
        this.cCorner = cCorner;
        this.dCorner = dCorner;
    }


    public int[][] addLocations(Entity entity) {
        return null;
    }
}
