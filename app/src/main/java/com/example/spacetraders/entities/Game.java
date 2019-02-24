package com.example.spacetraders.entities;

/**
 * This class represents the game
 */
public class Game {
    /** the game difficulty */
    private GameDifficulty difficulty;
    /** the player */
    private Player player;
    /** the universe */
    private Universe universe;

    /**
     * Constructor for the game
     *
     */
    public Game() {
        this(GameDifficulty.BEGINNER, null);
    }

    /**
     * Constructor for the game
     *
     * @param difficulty   difficulty of game
     * @param player        the player
     */
    public Game(GameDifficulty difficulty, Player player) {
        this.difficulty = difficulty;
        this.player = player;
        this.universe = new Universe();
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

    /**
     * getter for universe
     * @return universe
     */
    public Universe getUniverse() {return universe;}


    /**
     * setter for game difficulty
     *
     * @param difficulty the new difficulty
     */
    public void setGameDifficulty(GameDifficulty difficulty) {this.difficulty = difficulty;}

    /**
     * setter for player
     *
     * @param player the new difficulty
     */
    public void setPlayer(Player player) {this.player = player;}

     /**
     * setter for universe
     *
     * @param universe the new universe
     */
    public void setUniverse(Universe universe) {this.universe = universe;}

}
