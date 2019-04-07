package com.example.tejasvedantham.spacetrader.model;

/**
 * Represents the various spaceship types
 *
 * @author Byte Me
 * @version 1.0
 */
public enum SpaceshipType {
    GNAT(0, 1000, 0, 1, 1, 15, 0);

    private int size;
    private int travelDistance;
    private int hullStrength;
    private int numWeapons;
    private int numGadgets;
    private int numCargoBays;
    private int numCrewQuarters;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTravelDistance() {
        return travelDistance;
    }

    public void setTravelDistance(int travelDistance) {
        this.travelDistance = travelDistance;
    }

    public int getHullStrength() {
        return hullStrength;
    }

    public void setHullStrength(int hullStrength) {
        this.hullStrength = hullStrength;
    }

    public int getNumWeapons() {
        return numWeapons;
    }

    public void setNumWeapons(int numWeapons) {
        this.numWeapons = numWeapons;
    }

    public int getNumGadgets() {
        return numGadgets;
    }

    public void setNumGadgets(int numGadgets) {
        this.numGadgets = numGadgets;
    }

    public int getNumCargoBays() {
        return numCargoBays;
    }

    public void setNumCargoBays(int numCargoBays) {
        this.numCargoBays = numCargoBays;
    }

    public int getNumCrewQuarters() {
        return numCrewQuarters;
    }

    public void setNumCrewQuarters(int numCrewQuarters) {
        this.numCrewQuarters = numCrewQuarters;
    }

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
