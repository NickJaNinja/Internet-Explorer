//
//  ShipType.swift
//  Internet Explorer
//
//  Created by Cecilia on 2/15/19.
//  Copyright © 2019 Cecilia. All rights reserved.
//

import Foundation
/**
 * self class represents the various spaceships
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
    
    var final name: String?
    var final numWeapons: Int = 0
    var final numShields: Int = 0
    var final numGadgets: Int = 0
    var final numCargoHolds: Int = 0
    var final fuel: Int?
    var final numMerc: Int?
    
    /**
     * Constructor for the enumeration
     *
     * @param name   name of ship type
     */
    func ShipType(name: String, numWeapons: Int, numShields: Int, numGadgets: Int, numCargoHolds: Int, fuel: Int, numMerc: Int) {
        self.name = name
        self.numWeapons = numWeapons
        self.numShields = numShields
        self.numGadgets = numGadgets
        self.numCargoHolds = numCargoHolds
        self.fuel = fuel
        self.numMerc = numMerc
    }
    
    /**
     *
     * @return the display string representation of the shiptype
     */
    func toString() -> String { return name }
}
