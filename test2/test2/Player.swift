//
//  Player.swift
//  Internet Explorer
//
//  Created by Cecilia on 2/15/19.
//  Copyright © 2019 Cecilia. All rights reserved.
//

import Foundation
/**
 * self class represents the player
 *
 * @author Internet-Explorer
 * @version 1.0
 */
class Player {
    var name: String = "Bob the Destroyer";
    var pilotSkill: Int = 4;
    var fighterSkill: Int = 4;
    var traderSkill: Int = 4;
    var engineerSkill: Int = 4;
    var credits: Int = 1000;
    var ship: Ship = ShipType.GNAT;
    
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
    init Player(name: String, pilotSkill: Int, fighterSkill: Int, traderSkill: Int, engineerSkill: Int, credits: Int, ship: Ship) {
        self.name = name;
        self.pilotSkill = pilotSkill;
        self.fighterSkill = fighterSkill;
        self.traderSkill = traderSkill;
        self.engineerSkill = engineerSkill;
        self.credits = credits;
        self.ship = ship;
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
    init Player(name: String, pilotSkill: Int, fighterSkill: Int, traderSkill: Int, engineerSkill: Int) {
        self(name, pilotSkill, fighterSkill, traderSkill, engineerSkill, 1000, new Ship(ShipType.GNAT));
    }
    
    /**
     * getter for name
     *
     * @return name
     */
    func getName() -> String {
        return name;
    }
    
    /**
     * getter for pilotSkill
     *
     * @return pilotSkill
     */
    func getPilotSkill() -> Int {
        return pilotSkill;
    }
    
    /**
     * getter for fighterSkill
     *
     * @return fighterSkill
     */
    func getFighterSkill() -> Int {
        return fighterSkill;
    }
    
    /**
     * getter for traderSkill
     *
     * @return traderSkill
     */
    func getTraderSkill() -> Int {
        return traderSkill;
    }
    
    /**
     * getter for engineerSkill
     *
     * @return engineerSkill
     */
    func getEngineerSkill() -> Int {
        return engineerSkill;
    }
    
    /**
     * getter for credits
     *
     * @return credits
     */
    func getCredits() -> Int {
        return credits;
    }
    
    /**
     * getter for ship
     *
     * @return ship
     */
    func getShip() -> Ship {
        return ship;
    }
    
    /**
     * setter for name
     *
     * @param name player's name
     */
    func setName(name: String) {
        self.name = name;
    }
    
    /**
     * setter for pilotSkill
     *
     * @param pilotSkill player's pilotSkill
     */
    func setPilotSkill(pilotSkill: Int) {
        self.pilotSkill = pilotSkill;
    }
    
    /**
     * setter for fighterSkill
     *
     * @param fighterSkill player's fighterSkill
     */
    func setFighterSkill(fighterSkill: Int) {
        self.fighterSkill = fighterSkill;
    }
    
    /**
     * setter for traderSkill
     *
     * @param traderSkill player's traderSkill
     */
    func setTraderSkill(traderSkill: Int) {
        self.traderSkill = traderSkill;
    }
    
    /**
     * setter for engineerSkill
     *
     * @param engineerSkill player's engineerSkill
     */
    func setEngineerSkill(engineerSkill: Int) {
        self.engineerSkill = engineerSkill;
    }
    
    /**
     * setter for credits
     *w
     * @param credits player's credits
     */
    func setCredits(credits: Int) {
        self.credits = credits;
    }
    
    /**
     * setter for ship
     *
     * @param ship player's ship
     */
    func setShip(ship: Ship) {
        self.ship = ship;
    }
    
    /**
     * to string for player
     *
     * @return string of player info
     */
    func toString() -> String {
        return "Player{" + "name='" + name + "'" + ", pilotSkill=" + pilotSkill +
            ", fighterSkill=" + fighterSkill + ", traderSkill=" + traderSkill +
            ", engineerSkill=" + engineerSkill + ", credits=" + credits +
            ", ship=" + ship + "}";
    }
}
