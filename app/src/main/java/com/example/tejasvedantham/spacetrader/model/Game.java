package com.example.tejasvedantham.spacetrader.model;

/**
 * Represents the game being played
 *
 * @author Byte Me
 * @version 1.0
 */
public class Game {

    private Player player;
    private Difficulty difficulty;

    private static Game singleton_game = null;

    /**
     * Creates an instance of the game with a player and the game difficulty
     *
     * @param player the player of the game
     */
    public static Game getInstance() {
        if (singleton_game == null) {
            singleton_game = new Game();
        }

        return singleton_game;
    }

    private Game() {
        player = new Player();
        difficulty = Difficulty.BEGINNER;
    }

    /**
     * Getter method for the player
     * @return the player playing
     */
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player nPlayer) {
        this.player = nPlayer;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty( Difficulty nDifficulty) {
        this.difficulty = nDifficulty;
    }
}
