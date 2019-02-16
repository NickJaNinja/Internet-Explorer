//
//  Ship.swift
//  Internet Explorer
//
//  Created by Cecilia on 2/15/19.
//  Copyright © 2019 Cecilia. All rights reserved.
//

import Foundation
/**
 * This class represents the player's ship
 */

public class Ship {
    /** type of ship*/
    private ShipType type;
    
    /**
     * Constructor for the ship
     *
     * @param type   type of ship
     */
    public Ship(ShipType type) {
    this.type = type;
    }
    
    /**
     * getter for ship type
     *
     * @return  type of ship
     */
    public ShipType getShipType() {
    return type;
    }
    
    /**
     * to string for ship
     *
     * @return string of ship
     */
    @Override
    public String toString() {
    return "Ship{" +
    "type=" + type +
    '}';
    }
}
