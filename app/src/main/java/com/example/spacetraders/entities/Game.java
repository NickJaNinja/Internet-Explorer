package com.example.spacetraders.entities;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * This class represents the game
 */
public class Game implements Serializable {

    /**
     * the game difficulty
     */
    private final GameDifficulty difficulty;
    /**
     * the player
     */
    private final Player player;
    /**
     * the universe
     */
    private final Universe universe;
    /**
     * the solar system
     */
    private SolarSystem currSystem;
    /**
     * content_planet the player is on
     */
    private Planet currPlanet;

// --Commented out by Inspection START (4/2/19, 11:03 PM):

    /**
     * Constructor for the game
     */
    public Game() {
        this(GameDifficulty.BEGINNER, null);
    }
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)

    /**
     * Constructor for the game
     *
     * @param difficulty difficulty of game
     * @param player     the player
     */
    public Game(@Nullable GameDifficulty difficulty, @Nullable Player player) {
        this.difficulty = difficulty;
        this.player = player;
        this.universe = new Universe();
        this.currSystem = universe.getRandomSolarSystem();
        this.currPlanet = currSystem.getRandomPlanet();
    }

    /**
     * Used to fly between planets WITHIN a solar system
     *
     * @param to content_planet to fly to
     * @return 1 if content_planet is different from curr content_planet, 0 if content_planet is
     * the same
     */
    public int travelToPlanet(@Nullable Planet to) {
        if (to == null) {

            return 0;
        } else {
            currPlanet = to;
            currPlanet.restockShop();
            return 1;
        }

    }

    /**
     * Travels between solar systems
     *
     * @param to solar system to travel towards
     * @return 1 on success, 0 on fail
     */
    public int travelToSystem(@Nullable SolarSystem to) {
        int distance = universe.distanceBetweenSystems(currSystem, to);
        if (player.travel(distance) == 0) {
            return 0;
        }
        currPlanet = Objects.requireNonNull(to).getClosestToSun();
        currSystem = to;
        return 1;
    }

    /**
     * Refuels the ship back to maximum fuel
     */
    public void refuelShipMax() {
        player.refuelShipMax();
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
    public int makeTransaction(@Nullable ShopGoods sg, int amount, int price) {
        return player.makeTransaction(sg, amount, price) & currPlanet.makeTransaction(sg, amount);
    }

    /**
     * Gets the amount of credits the player has
     *
     * @return player credits
     */
    public int getCredits() {
        return player.getCredits();
    }

    /**
     * Gets the remaining amount of cargo space in the ship
     *
     * @return cargo space
     */
    public int getCargoSpace() {
        return player.getCargoSpace();
    }



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
// --Commented out by Inspection STOP (4/3/19, 8:04 AM)


    /**
     * getter for universe
     *
     * @return universe
     */
    public Universe getUniverse() {
        return universe;
    }
// --Commented out by Inspection STOP (4/3/19, 8:04 AM)

    /**
     * getter for current content_planet
     *
     * @return current content_planet
     */
    @Nullable
    public Planet getCurrentPlanet() {
        return currPlanet;
    }

    /**
     * getter for current system
     *
     * @return current system
     */
    @Nullable
    public SolarSystem getCurrentSystem() {
        return currSystem;
    }

// --Commented out by Inspection START (4/3/19, 8:04 AM):
//    /**
//     * Gets the current shop
//     *
//     * @return current shop
//     */
//    public Shop getCurrentShop() {
//        return currPlanet.getShop();
//    }
// --Commented out by Inspection STOP (4/3/19, 8:04 AM)

    /**
     * Gets the shops entries (what is in stock)
     *
     * @return shop entries
     */
    @Nullable
    public List<ShopEntry> getShopEntries() {
        return currPlanet.getShopEntries();
    }

    /**
     * gets the shop entries filtered
     *
     * @return shop entries filtered
     */
    @Nullable
    public List<ShopEntry> getShopEntriesFiltered() {
        return currPlanet.getShopEntriesFiltered();
    }

    /**
     * Gets the player's entries (inventory)
     *
     * @return player entries
     */
    @Nullable
    public List<ShopEntry> getPlayerEntries() {
        return player.getPlayerEntries();
    }

    /*
     * setter for current content_planet
     *
     * @param newCurr new current planet
     */
    /*
    public void setCurrentPlanet(Planet newCurr) {
        this.currPlanet = newCurr;
    }
*/
    /**
     * Gets all of the solar systems
     *
     * @return the solar systems
     */
    @Nullable
    public SolarSystem[] getSolarSystems() {
        return universe.getSolarSystems();
    }

    /**
     * Gets the ships's fuel as a percentage of its capacity
     *
     * @return fuel percentage
     */
    public int getFuelPercentage() {
        return player.getFuelPercentage();
    }

    /**
     * Gets the range in light-years that the player can fly
     * given the player might not be at maximum fuel
     *
     * @return the range
     */
    public int getRange() {
        return player.getRange();
    }

    /**
     * Gets the range in light-years that the player can fly
     * assuming fuel is at max
     *
     * @return the range
     */
    public double getMaxRange() {
        return player.getMaxRange();
    }

    /**
     * Finds out whether the current planet is a warp gate or not
     *
     * @return true if warp gate, false otherwise
     */
    public boolean isOnWarpGatePlanet() {return currPlanet.getIsWarpGate();}

    /**
     *
     * @return land type
     */
    public int getLandType() {
        return currPlanet.getLandType();
    }

    /**
     *
     * @return back color
     */
    public int getColorBack() {
        return currPlanet.getColorBack();
    }

    /**
     *
     * @return front color
     */
    public int getColorFront() {
        return currPlanet.getColorFront();
    }


    /**
     * @return list of ships based on tech level
     */
    @Nullable
    public List<ShipType> getShipsBasedOnTechLevel() {
        if (this.getCurrentPlanet() != null) {
            return player.getShipsBasedOnTechLevel(this.getCurrentPlanet().getTechLevel());
        }
        return null;
    }

    /**
     * set player's ship type
     * @param shipType player's ship type
     */
    public void setShipType(@Nullable ShipType shipType) {
        player.setShipType(shipType);
    }

//    /**
//     * gets name of current planet
//     *
//     * @return the name
//     */
//    public String getNameOfCurrentPlanet() {
//        return this.currPlanet.getName();
//    }

    @Override
    @NonNull
    //A make no sense toString to get rid of warning
    public String toString() {
        return difficulty.toString();
    }

    /**
     * set player's credit
     * @param credits player's credit
     */
    public void setCredits(int credits) {
        player.setCredits(credits);
    }

    public void setCurrPlanet (Planet planet) {
        currPlanet = planet;
    }


}
