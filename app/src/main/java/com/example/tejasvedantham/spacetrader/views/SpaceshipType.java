package com.example.tejasvedantham.spacetrader.views;

/**
 * Represents the various spaceship types
 *
 * @author Byte Me
 * @version 1.0
 */
public enum SpaceshipType {
    GNAT(0, 14, 0, 1, 1, 15, 0);

    private int size;
    private int travelDistance;
    private int hullStrength;
    private int numWeapons;
    private int numGadgets;
    private int numCargoBays;
    private int numCrewQuarters;

    /**
     * Initializes the values of a particular spaceship type
     *
     * @param size the size of the ship
     * @param travelDistance the distance the ship can travel
     * @param hullStrength the hull strength of the ship
     * @param numWeapons the number of weapons held by ship
     * @param numGadgets the number of gadgets held by ship
     * @param numCargoBays the number of cargo bays on ship
     * @param numCrewQuarters the number of crew quarters on ship
     */
    private SpaceshipType(int size, int travelDistance, int hullStrength, int numWeapons,
                          int numGadgets, int numCargoBays, int numCrewQuarters) {
        this.size = size;
        this.travelDistance = travelDistance;
        this.hullStrength = hullStrength;
        this.numWeapons = numWeapons;
        this.numGadgets = numGadgets;
        this.numCargoBays = numCargoBays;
        this.numCrewQuarters = numCrewQuarters;
    }
}
