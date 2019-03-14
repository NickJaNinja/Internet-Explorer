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
    /** planet the player is on */
    private Planet currPlanet;

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
        currPlanet = universe.getRandomPlanet();
    }

    /**
     * Passes a good, an amount, and a price all the way down to player
     * and ship to be able to carry out a transaction if valid
     *
     * @param sg the type of the good associated with this transaction
     * @param amount the total amount of the good to buy
     * @param price the price of each good
     * @return 1 if transaction occurred, 0 otherwise
     */
    public int makeTransaction(ShopGoods sg, int amount, int price) {
        return player.makeTransaction(sg, amount, price);
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
     * getter for current planet
     * @return current planet
     */
    public Planet getCurrentPlanet() {return currPlanet;}


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

    /**
     * setter for current planet
     */
    public void setCurrentPlanet(Planet newCurr) {this.currPlanet = newCurr;}
}
