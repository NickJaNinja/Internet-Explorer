package com.example.spacetraders.entities;

/**
 * This class represents the game
 */
public class Game {
    /** the game difficulty */
    private GameDifficulty difficulty;
    /** the player */
    private Player player;

    /**
<<<<<<< HEAD
     * constructor for game
     *
     * @param difficulty difficulty selected
     * @param player player in the game
=======
     * Constructor for the game
     *
     * @param difficulty   difficulty of game
     * @param player        the player
>>>>>>> 1c5d8f30f36a03b6b2dd13e61a8e52860dfd4359
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
