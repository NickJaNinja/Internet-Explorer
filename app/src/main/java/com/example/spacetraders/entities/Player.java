package com.example.spacetraders.entities;

import java.io.Serializable;
import java.util.List;

/**
 * This class represents the player
 *
 * @author Internet-Explorer
 * @version 1.0
 */
public class Player implements Serializable {
    private String name;
    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;
    private int credits;
    private int reputation;
    private Ship ship;
    //private Planet currPlanet;

    /**
     * constuctor with all parameters
     *
     * @param name          player's name
     * @param pilotSkill    initial pilotSkill
     * @param fighterSkill  initial fighterSkill
     * @param traderSkill   initial traderSkill
     * @param engineerSkill initial engineerSkill
     * @param credits       initial credits
     * @param reputation    initial reputation level
     * @param ship          initial ship
     */
    public Player(String name, int pilotSkill, int fighterSkill, int traderSkill, int engineerSkill, int credits, int reputation, Ship ship) {
        this.name = name;
        this.pilotSkill = pilotSkill;
        this.fighterSkill = fighterSkill;
        this.traderSkill = traderSkill;
        this.engineerSkill = engineerSkill;
        this.credits = credits;
        this.reputation = reputation;
        this.ship = ship;
    }

    /**
     * constuctor with default values for credit = 1000 & ship = GNAT
     *
     * @param name          player's name
     * @param pilotSkill    initial pilotSkill
     * @param fighterSkill  initial fighterSkill
     * @param traderSkill   initial traderSkill
     * @param engineerSkill initial engineerSkill
     */
    public Player(String name, int pilotSkill, int fighterSkill, int traderSkill, int engineerSkill) {
        this(name, pilotSkill, fighterSkill, traderSkill, engineerSkill, 10000, 0, new Ship(ShipType.GNAT));
    }

    /**
     * Create a base player
     */
    public Player() {
        this("", 0, 0, 0, 0, 1000, 0, new Ship(ShipType.GNAT));
    }

    /**
     * Travel a given distance and remove fuel from ship
     *
     * @param distance Distance to travel
     * @return 1 on success, 0 otherwise
     */
    public int travel(int distance) {
        return ship.travel(distance);
    }

    /**
     * Doesn't completely refuel the ship
     * Used if player wants to refuel by a custom amount
     *
     * @param creditAmount Amount of credits put towards refueling
     */
    public void refuelShipPartial(int creditAmount) {
        if (creditAmount >= ship.getFullRefuelCost()) {
            refuelShipMax();
        }
        if (creditAmount > this.credits) {
            ship.refuel(this.credits);
            this.credits -= this.credits;
        } else {
            ship.refuel(creditAmount);
            this.credits -= creditAmount;
        }
    }

    /**
     * Refuels ship to have a full tank
     */
    public void refuelShipMax() {
        int refuelCost = ship.getFullRefuelCost();
        if (refuelCost > credits) {
            ship.refuel(this.credits);
            this.credits -= this.credits;
        } else {
            ship.refuel(refuelCost);
            this.credits -= refuelCost;
        }
    }

    public List<ShopEntry> getPlayerEntries() {
        return ship.getInventoryCargo();
    }

    /**
     * Carries out a transaction of goods if valid
     *
     * @param sg     the type of the good associated with this transaction
     * @param amount the total amount of the good to buy
     * @param price  the price of each good
     * @return 1 if transaction occurred, 0 otherwise
     */
    public int makeTransaction(ShopGoods sg, int amount, int price) {
        if (credits < amount * price) {
            return 0;
        }
        if (ship.addCargo(sg, amount, price) == 0) {
            return 0;
        }
        credits -= amount * price;
        return 1;

        /*if (amount <= 0) {
            if (ship.removeCargo(sg, amount, price) == 0) {
                return 0;
            }
            credits += amount * price;
            return 1;
        } else {
            if (ship.addCargo(sg, amount, price) == 0) {
                return 0;
            }
            credits -= amount * price;
        }
        return 1;*/
    }

    /**
     * getter for name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getter for pilotSkill
     *
     * @return pilotSkill
     */
    public int getPilotSkill() {
        return pilotSkill;
    }

    /**
     * getter for fighterSkill
     *
     * @return fighterSkill
     */
    public int getFighterSkill() {
        return fighterSkill;
    }

    /**
     * getter for traderSkill
     *
     * @return traderSkill
     */
    public int getTraderSkill() {
        return traderSkill;
    }

    /**
     * getter for engineerSkill
     *
     * @return engineerSkill
     */
    public int getEngineerSkill() {
        return engineerSkill;
    }

    /**
     * getter for credits
     *
     * @return credits
     */
    public int getCredits() {
        return credits;
    }

    public int getCargoSpace() { return ship.getCargoSpaces(); }

    /**
     * getter for reputation
     *
     * @return reputation
     */
    public int getReputation() {
        return reputation;
    }

    /**
     * getter for ship
     *
     * @return ship
     */
    public Ship getShip() {
        return ship;
    }

    public int getFuelPercentage() { return ship.getFuelPercentage(); }

    public int getRange() { return ship.getRange(); }

    public double getMaxRange() { return ship.getMaxRange();}

    /**
     * setter for name
     *
     * @param name player's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter for pilotSkill
     *
     * @param pilotSkill player's pilotSkill
     */
    public void setPilotSkill(int pilotSkill) {
        this.pilotSkill = pilotSkill;
    }

    /**
     * setter for fighterSkill
     *
     * @param fighterSkill player's fighterSkill
     */
    public void setFighterSkill(int fighterSkill) {
        this.fighterSkill = fighterSkill;
    }

    /**
     * setter for traderSkill
     *
     * @param traderSkill player's traderSkill
     */
    public void setTraderSkill(int traderSkill) {
        this.traderSkill = traderSkill;
    }

    /**
     * setter for engineerSkill
     *
     * @param engineerSkill player's engineerSkill
     */
    public void setEngineerSkill(int engineerSkill) {
        this.engineerSkill = engineerSkill;
    }

    /**
     * getter for credits
     * w
     *
     * @param credits player's credits
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * getter for reputation
     *
     * @param reputation the reputation
     */
    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    /**
     * setter for ship
     *
     * @param ship player's ship
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    /**
     * to string for player
     *
     * @return string of player info
     */
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", pilotSkill=" + pilotSkill +
                ", fighterSkill=" + fighterSkill +
                ", traderSkill=" + traderSkill +
                ", engineerSkill=" + engineerSkill +
                ", credits=" + credits +
                ", ship=" + ship +
                '}';
    }
}
