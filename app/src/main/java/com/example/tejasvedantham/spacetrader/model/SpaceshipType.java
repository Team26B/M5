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

// --Commented out by Inspection START (4/14/19, 9:45 PM):
// --Commented out by Inspection START (4/14/19, 9:45 PM):
////    public int getSize() {
////        return size;
////    }
//// --Commented out by Inspection STOP (4/14/19, 9:45 PM)
// --Commented out by Inspection STOP (4/14/19, 9:45 PM)

    public void setSize(int size) {
        this.size = size;
    }

    public int getTravelDistance() {
        return travelDistance;
    }

    public void setTravelDistance(int travelDistance) {
// --Commented out by Inspection START (4/14/19, 9:45 PM):
//        this.travelDistance = travelDistance;
//    }
//
// --Commented out by Inspection START (4/14/19, 9:45 PM):
////// --Commented out by Inspection START (4/14/19, 9:45 PM):
//// --Commented out by Inspection STOP (4/14/19, 9:45 PM)
////    public int getHullStrength() {
// --Commented out by Inspection STOP (4/14/19, 9:45 PM)
//        return hullStrength;
//    }
// --Commented out by Inspection START (4/14/19, 9:45 PM):
//// --Commented out by Inspection START (4/14/19, 9:45 PM):
////// --Commented out by Inspection STOP (4/14/19, 9:45 PM)
// --Commented out by Inspection STOP (4/14/19, 9:45 PM)
//
//    public void setHullStrength(int hullStrength) {
// --Commented out by Inspection START (4/14/19, 9:45 PM):
//// --Commented out by Inspection STOP (4/14/19, 9:45 PM)
//        this.hullStrength = hullStrength;
//    }
//
// --Commented out by Inspection START (4/14/19, 9:45 PM):
//// --Commented out by Inspection STOP (4/14/19, 9:45 PM)
//    public int getNumWeapons() {
//// --Commented out by Inspection START (4/14/19, 9:45 PM):
// --Commented out by Inspection STOP (4/14/19, 9:45 PM)
//        return numWeapons;
//    }
//
//    public void setNumWeapons(int numWeapons) {
// --Commented out by Inspection STOP (4/14/19, 9:45 PM)
        this.numWeapons = numWeapons;
    }

    public int getNumGadgets() {
        return numGadgets;
    }

    public void setNumGadgets(int numGadgets) {
        this.numGadgets = numGadgets;
    }

    public int getNumCargoBays() {
// --Commented out by Inspection START (4/14/19, 9:45 PM):
//        return numCargoBays;
//    }
//
//    public void setNumCargoBays(int numCargoBays) {
//        this.numCargoBays = numCargoBays;
// --Commented out by Inspection STOP (4/14/19, 9:45 PM)
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
