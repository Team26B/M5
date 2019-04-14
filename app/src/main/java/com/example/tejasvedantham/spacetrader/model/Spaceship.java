package com.example.tejasvedantham.spacetrader.model;

import java.io.Serializable;

/**
 * Represents a spaceship object for the game
 *
 * @author Byte Me
 * @version 1.0
 */
public class Spaceship {

    private SpaceshipType spaceshipType;
    int cargoNum;
    int fuelLeft;
    /**
     * Creates a spaceship object with a designated name and skill points
     *
     * @param spaceshipType the type of spaceship
     */
    public Spaceship(SpaceshipType spaceshipType) {
        this.spaceshipType = spaceshipType;
        cargoNum = 10;
        fuelLeft = 1000;
    }

    public Spaceship() {}

    public int getCargoNum() {
        return cargoNum;
    }

    public int getFuelLeft() {
        return this.fuelLeft;
    }

    public void setFuelLeft(int fl) {
        this.fuelLeft = fl;
    }

    public void setCargoNum(int cargoNum) {
        this.cargoNum = cargoNum;
    }

    /**
     * Getter method for the spaceship type
     * @return the spaceship type
     */
    public SpaceshipType getSpaceShipType() {
        return spaceshipType;
    }

}
