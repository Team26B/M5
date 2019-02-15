package com.example.tejasvedantham.spacetrader.views;

/**
 * Represents the game being played
 *
 * @author Byte Me
 * @version 1.0
 */
public class Game {

    private Player player;

    /**
     * Creates an instance of the game with a player and the game difficulty
     *
     * @param player the player of the game
     */
    public Game(Player player) {
        this.player = player;
    }

    /**
     * Getter method for the player
     * @return the player playing
     */
    public Player getPlayer() {
        return player;
    }

}
