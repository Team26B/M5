package com.example.tejasvedantham.spacetrader.model;

/**
 * Represents a spaceship object for the game
 *
 * @author Byte Me
 * @version 1.0
 */
public class Spaceship {

    private SpaceshipType spaceshipType;
    int cargoNum;
    /**
     * Creates a spaceship object with a designated name and skill points
     *
     * @param spaceshipType the type of spaceship
     */
    public Spaceship(SpaceshipType spaceshipType) {
        this.spaceshipType = spaceshipType;
        cargoNum = 10;
    }

    public int getCargoNum() {
        return cargoNum;
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
