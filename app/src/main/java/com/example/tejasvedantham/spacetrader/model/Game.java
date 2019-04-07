package com.example.tejasvedantham.spacetrader.model;

import java.io.Serializable;

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

    public void setGame(Game nGame) {
        singleton_game = nGame;
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
