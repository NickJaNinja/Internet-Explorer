//
//  Planet.swift
//  test2
//
//  Created by Cecilia on 4/17/19.
//  Copyright © 2019 Cecilia. All rights reserved.
//

import Foundation
class Planet {
    var planetName: String = "ma";
    var techLevel: Int = 0;
    var xCord: Int = 0;
    var yCOrd: Int = 0;
    
    init (planetName: String, techLevel: Int, xCord: Int, yCOrd: Int) {
        self.planetName = planetName;
        self.techLevel = techLevel;
        self.xCord = xCord;
        self.yCOrd = yCOrd;
    }
    
}
