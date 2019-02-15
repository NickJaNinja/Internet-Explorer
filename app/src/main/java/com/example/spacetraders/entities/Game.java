package com.example.spacetraders.entities;

/**
 * This class represents the game
 */
public class Game {
    private GameDifficulty difficulty;
    private Player player;

    /**
     * constructor for game
     *
     * @param difficulty difficulty selected
     * @param player player in the game
     */
    public Game(GameDifficulty difficulty, Player player) {
        this.difficulty = difficulty;
        this.player = player;
    }

    /**
     * getter for game difficulty
     *
     * @return difficulty
     */
    public GameDifficulty getGameDifficulty() {return difficulty;}

    /**
     * getter for player
     * @return player
     */
    public Player getPlayer() {return player;}
}
