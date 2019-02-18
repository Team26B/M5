package com.example.tejasvedantham.spacetrader.model;

/**
 * Represents a player object for the game
 *
 * @author Byte Me
 * @version 1.0
 */
public class Player {

    private String name;
    private int pilotPoints;
    private int fighterPoints;
    private int traderPoints;
    private int engineerPoints;
    private int numCredits;
    private boolean isBountyHunter;
    private boolean isPirate;
    private Spaceship spaceship;

    /**
     * Creates a player object with a defualt name and spaceship and 4 skill points for each skill
     */
    public Player() {
        this("Byte Me", 4, 4, 4, 4, new Spaceship(SpaceshipType.GNAT));
    }

    /**
     * Creates a player object with a designated name and skill points
     *
     * @param name           the name of the player
     * @param pilotPoints    the number of pilot skill points
     * @param fighterPoints  the number of fighter skill points
     * @param traderPoints   the number of trader skill points
     * @param engineerPoints the number of engineer skill points
     */
    public Player(String name, int pilotPoints, int fighterPoints, int traderPoints,
                  int engineerPoints, Spaceship spaceship) {
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.fighterPoints = fighterPoints;
        this.traderPoints = traderPoints;
        this.engineerPoints = engineerPoints;
        this.numCredits = 1000;
        this.isBountyHunter = false;
        this.isPirate = false;
        this.spaceship = spaceship;
    }

    /**
     * Getter method for the name of the player
     *
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the pilot skill points
     *
     * @return the pilot skill points
     */
    public int getPilotPoints() {
        return pilotPoints;
    }

    /**
     * Getter method for the fighter skill points
     *
     * @return the fighter skill points
     */
    public int getFighterPoints() {
        return fighterPoints;
    }

    /**
     * Getter method for the trader skill points
     *
     * @return the trader skill points
     */
    public int getTraderPoints() {
        return traderPoints;
    }

    /**
     * Getter method for the engineer skill points
     *
     * @return the engineer skill points
     */
    public int getEngineerPoints() {
        return engineerPoints;
    }

    /**
     * Getter method for the number of credits
     *
     * @return the number of credits
     */
    public int getNumCredits() {
        return numCredits;
    }

    /**
     * Getter method for the spaceship
     *
     * @return the spaceship
     */
    public Spaceship getSpaceship() {
        return spaceship;
    }

    /**
     * Determines if the player is a bounty hunter
     *
     * @return whether or not the player is a bounty hunter
     */
    public boolean isBountyHunter() {
        return isBountyHunter;
    }

    /**
     * Determines if the player is a pirate
     *
     * @return whether or not the player is a pirate
     */
    public boolean isPirate() {
        return isPirate;
    }

    /**
     * Handles the player making a trade
     */
    public void trade() {
        //This method will be implemented in a later version
    }

    /**
     * Handles the player making a robbery
     */
    public void rob() {
        //This method will be implemented in a later version
    }

    public String toString() {
        StringBuilder toReturn = new StringBuilder("\n");
        toReturn.append("--------------------\n");
        toReturn.append("Player name: " + getName() + "\n");
        toReturn.append("Game difficulty: " + Game.getInstance().getDifficulty() + "\n");
        toReturn.append("Fighter Points: " + getFighterPoints() + "\n");
        toReturn.append("Engineer Points: " + getEngineerPoints() + "\n");
        toReturn.append("Trader Points: " + getTraderPoints() + "\n");
        toReturn.append("Pilot Points: " + getPilotPoints() + "\n");
        toReturn.append("Credits: " + getNumCredits() + "\n");
        toReturn.append("Spaceship Type: " + getSpaceship().getSpaceShipType() + "\n");
        toReturn.append("--------------------");

        return toReturn.toString();
    }

}
