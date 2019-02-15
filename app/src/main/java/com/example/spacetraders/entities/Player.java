package com.example.spacetraders.entity;

/**
 * This class represents the player
 */
public class Player {
    private String name;
    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;
    private int credits;
    private Spaceship ship;

    public Player(String name, int pilotSkill, int fighterSkill, int traderSkill, int engineerSkill) {
        this(name, pilotSkill, fighterSkill, traderSkill, engineerSkill, 1000, Spaceship.GNAT);
    }

    public Player(String name, int pilotSkill, int fighterSkill, int traderSkill, int engineerSkill, int credits, Spaceship ship) {
        this.name = name;
        this.pilotSkill = pilotSkill;
        this.fighterSkill = fighterSkill;
        this.traderSkill = traderSkill;
        this.engineerSkill = engineerSkill;
        this.credits = credits;
        this.ship = ship;
    }

}
