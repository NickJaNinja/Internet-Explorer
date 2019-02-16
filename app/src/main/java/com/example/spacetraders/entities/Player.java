package com.example.spacetraders.entities;

/**
 * This class represents the player
 *
 * @author Internet-Explorer
 * @version 1.0
 */
public class Player {
    private String name;
    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;
    private int credits;
    private Ship ship;

    /**
     * constuctor with all parameters
     *
     * @param name player's name
     * @param pilotSkill initial pilotSkill
     * @param fighterSkill initial fighterSkill
     * @param traderSkill initial traderSkill
     * @param engineerSkill inital engineerSkill
     * @param credits initial credits
     * @param ship initial ship
     */
    public Player(String name, int pilotSkill, int fighterSkill, int traderSkill, int engineerSkill, int credits, Ship ship) {
        this.name = name;
        this.pilotSkill = pilotSkill;
        this.fighterSkill = fighterSkill;
        this.traderSkill = traderSkill;
        this.engineerSkill = engineerSkill;
        this.credits = credits;
        this.ship = ship;
    }

    /**
     * constuctor with default values for credit = 1000 & ship = GNAT
     *
     * @param name player's name
     * @param pilotSkill initial pilotSkill
     * @param fighterSkill initial fighterSkill
     * @param traderSkill initial traderSkill
     * @param engineerSkill inital engineerSkill
     */
    public Player(String name, int pilotSkill, int fighterSkill, int traderSkill, int engineerSkill) {
        this(name, pilotSkill, fighterSkill, traderSkill, engineerSkill, 1000, new Ship(ShipType.GNAT));
    }

    /**
     *  Create a base player
     */
    public Player() {
        this("", 0, 0, 0, 0, 1000, new Ship(ShipType.GNAT));
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

    /**
     * getter for ship
     *
     * @return ship
     */
    public Ship getShip() {
        return ship;
    }

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
     * setter for credits
     *w
     * @param credits player's credits
     */
    public void setCredits(int credits) {
        this.credits = credits;
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
