//
//  ShipType.swift
//  Internet Explorer
//
//  Created by Cecilia on 2/15/19.
//  Copyright © 2019 Cecilia. All rights reserved.
//

import Foundation
/**
 * This class represents the various spaceships
 */
enum ShipType{
    case FLEA("Flea": String, 0: Int, 0: Int, 0: Int, 2: Int, 20: Int, 0: Int)
    case GNAT("Gnat", 1, 0, 1, 15, 14, 0)
    case FIREFLY("Firefly", 1, 1, 1, 20, 17, 0)
    case MOSQUITO("Mosquito", 2, 1, 1, 14, 13, 0) //"strong hull"
    case BUMBLEBEE("Bumblebee", 1, 2, 2, 20, 15, 1) //"same hull as firefly"
    case BEETLE("Beetle", 0, 1, 1, 50, 14, 3) //weak hull
    case HORNET("Hornet", 3, 2, 1, 20, 16, 2) //strong hull
    case GRASSHOPPER("Grasshopper", 2, 2, 3, 30, 15, 3)
    case TERMITE("Termite", 1, 3, 2, 60, 13, 3) //strong hull
    case WASP("Wasp", 3, 2, 2, 35, 14, 3) //strong hull
    
    var final name: String!;
    var final int numWeapons;
    var final int numShields;
    var final int numGadgets;
    var final int numCargoHolds;
    var final int fuel;
    var final int numMerc;
    
    /**
     * Constructor for the enumeration
     *
     * @param name   name of ship type
     */
    func ShipType(String name, int numWeapons, int numShields, int numGadgets, int numCargoHolds, int fuel, int numMerc) {
    this.name = name;
    this.numWeapons = numWeapons;
    this.numShields = numShields;
    this.numGadgets = numGadgets;
    this.numCargoHolds = numCargoHolds;
    this.fuel = fuel;
    this.numMerc = numMerc;
    }
    
    /**
     *
     * @return the display string representation of the shiptype
     */
    func toString() -> String { return name }
}
