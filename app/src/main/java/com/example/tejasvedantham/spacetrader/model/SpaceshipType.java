package com.example.tejasvedantham.spacetrader.model;

/**
 * Represents the various spaceship types
 *
 * @author Byte Me
 * @version 1.0
 */
public enum SpaceshipType {
    GNAT();

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
     */
    SpaceshipType() {
        this.size = 0;
        this.travelDistance = 1000;
        this.hullStrength = 0;
        this.numWeapons = 1;
        this.numGadgets = 1;
        this.numCargoBays = 15;
        this.numCrewQuarters = 0;
    }
}
