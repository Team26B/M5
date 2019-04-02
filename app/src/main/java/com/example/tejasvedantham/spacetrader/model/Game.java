package com.example.tejasvedantham.spacetrader.model;

import java.util.ArrayList;

/**
 * Represents the game being played
 *
 * @author Byte Me
 * @version 1.0
 */
public class Game {

    private Player player;
    private Difficulty difficulty;
    private Universe universe;

    private static Game singleton_game = null;

    /**
     * @return the singleton_game value
     */
    public static Game getInstance() {
        if (singleton_game == null) {
            singleton_game = new Game();
        }
        return singleton_game;
    }

    /**
     * Creates an instance of the game
     */
    private Game() {
        player = new Player();
        difficulty = Difficulty.BEGINNER;
        universe = new Universe();
    }

    /**
     * Executes the random event
     * @param event the random event to occur
     * @return the message to be displayed of the random event that occurred
     */
    public String executeRandomEvent(RandomEvents event) {
        if (event == RandomEvents.INCREASED_PRICES) {
            this.increasedPricesEvent();
        } else if (event == RandomEvents.INCREASED_CREDITS) {
            this.increasedCreditsEvent();
        }
        return event.getMessage();
    }

    /**
     * Executes the random event of prices being increased
     */
    private void increasedPricesEvent() {
        Market currentMarket = universe.getCurrentSS().getMarket();
        currentMarket.updateMarketPrices(0.5);
    }

    /**
     * Executes the random event of all goods being stolen
     */
    private void increasedCreditsEvent() {
        player.setNumCredits(player.getNumCredits() + 100);
    }

    /**
     * Getter method for the player
     * @return the player playing
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Setter method for the player
     * @param nPlayer the player playing
     */
    public void setPlayer(Player nPlayer) {
        this.player = nPlayer;
    }

    /**
     * Getter method for the difficulty
     * @return the game difficulty
     */
    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    /**
     * Setter method for the difficulty
     * @param nDifficulty the difficulty
     */
    public void setDifficulty( Difficulty nDifficulty) {
        this.difficulty = nDifficulty;
    }

    /**
     * Getter method for the universe
     * @return the universe
     */
    public Universe getUniverse() {
        return universe;
    }

    /**
     * Setter method for the difficulty
     * @param universe the difficulty
     */
    public void setUniverse(Universe universe) {
        this.universe = universe;
    }
}
