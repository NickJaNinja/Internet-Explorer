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

class Ship {
    /** type of ship*/
    var type: ShipType?
    
    /**
     * Constructor for the ship
     *
     * @param type   type of ship
     */
    func Ship(type: ShipType) {
        self.type = type
    }
    
    /**
     * getter for ship type
     *
     * @return  type of ship
     */
    func getShipType() -> ShipType{
        return type!
    }
    
    /**
     * to string for ship
     *
     * @return string of ship
     */
    func toString() -> String{
        return "Ship{" + "type=" + type + "}";
    }
}
