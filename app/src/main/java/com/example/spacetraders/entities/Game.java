package com.example.spacetraders.entities;

import java.util.List;

/**
 * This class represents the game
 */
public class Game {
    /**
     * the game difficulty
     */
    private GameDifficulty difficulty;
    /**
     * the player
     */
    private Player player;
    /**
     * the universe
     */
    private Universe universe;
    /**
     * the solar system
     */
    private SolarSystem currSystem;
    /**
     * planet the player is on
     */
    private Planet currPlanet;

    /**
     * Constructor for the game
     */
    public Game() {
        this(GameDifficulty.BEGINNER, null);
    }

    /**
     * Constructor for the game
     *
     * @param difficulty difficulty of game
     * @param player     the player
     */
    public Game(GameDifficulty difficulty, Player player) {
        this.difficulty = difficulty;
        this.player = player;
        this.universe = new Universe();
        this.currSystem = universe.getRandomSolarSystem();
        this.currPlanet = currSystem.getRandomPlanet();
    }

    /**
     * Used to fly between planets WITHIN a solar system
     *
     * @param to planet to fly to
     * @return 1 if planet is different from curr planet, 0 if planet is the same
     */
    public int travelToPlanet(Planet to) {
        int distance = universe.distanceBetweenPlanets(currPlanet, to);
        if (player.travel(distance) == 0) {
            return 0;
        }
        currPlanet = to;
        return 1;
    }

    public int travelToSystem(SolarSystem to) {
        int distance = universe.distanceBetweenSystems(currSystem, to);
        if (player.travel(distance) == 0) {
            return 0;
        }
        currPlanet = to.getClosestToSun();
        currSystem = to;
        return 1;
    }

    /**
     * Passes a good, an amount, and a price all the way down to player
     * and ship to be able to carry out a transaction if valid
     *
     * @param sg     the type of the good associated with this transaction
     * @param amount the total amount of the good to buy
     * @param price  the price of each good
     * @return 1 if transaction occurred, 0 otherwise
     */
    public int makeTransaction(ShopGoods sg, int amount, int price) {
        return player.makeTransaction(sg, amount, price) & currPlanet.makeTransaction(sg, amount);
    }

    /**
     * getter for game difficulty
     *
     * @return difficulty
     */
    public GameDifficulty getGameDifficulty() {
        return difficulty;
    }

    /**
     * getter for player
     *
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * getter for universe
     *
     * @return universe
     */
    public Universe getUniverse() {
        return universe;
    }

    /**
     * getter for current planet
     *
     * @return current planet
     */
    public Planet getCurrentPlanet() {
        return currPlanet;
    }

    /**
     * getter for current system
     *
     * @return current system
     */
    public SolarSystem getCurrentSystem() {
        return currSystem;
    }

    public Shop getCurrentShop() {
        return currPlanet.getShop();
    }

    public List<ShopEntry> getShopEntries() {
        return currPlanet.getShopEntries();
    }

    public List<ShopEntry> getPlayerEntries() {
        return player.getPlayerEntries();
    }

    /**
     * setter for game difficulty
     *
     * @param difficulty the new difficulty
     */
    public void setGameDifficulty(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * setter for universe
     *
     * @param universe the new universe
     */
    public void setUniverse(Universe universe) {
        this.universe = universe;
    }

    /**
     * setter for current planet
     */
    public void setCurrentPlanet(Planet newCurr) {
        this.currPlanet = newCurr;
    }

    public SolarSystem[] getSolarSystems() {
        return universe.getSolarSystems();
    }
}
