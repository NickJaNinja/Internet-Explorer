//
//  Univerese.swift
//  test2
//
//  Created by Cecilia on 4/17/19.
//  Copyright © 2019 Cecilia. All rights reserved.
//

import Foundation
class Universe {

    var universeName: String = "ma";
    
    init (universeName: String) {
        self.universeName = universeName;
        let one = Planet(planetName: "String", techLevel: 0, xCord: 1, yCOrd: 2)
        let two = Planet(planetName: "s", techLevel: 0, xCord: 3, yCOrd: 4)
        let three = Planet(planetName: "m", techLevel: 0, xCord: 5, yCOrd: 6)
        let four = Planet(planetName: "q", techLevel: 0, xCord: 7, yCOrd: 8)
        let five = Planet(planetName: "u", techLevel: 0, xCord: 9, yCOrd: 0)
        let six = Planet(planetName: "d", techLevel: 0, xCord: 11, yCOrd: 22)
        let seven = Planet(planetName: "x", techLevel: 0, xCord: 33, yCOrd: 44)
        let eight = Planet(planetName: "v", techLevel: 0, xCord: 55, yCOrd: 66)
        let nine = Planet(planetName: "xx", techLevel: 0, xCord: 77, yCOrd: 88)
        let ten = Planet(planetName: "oo", techLevel: 0, xCord: 99, yCOrd: 00)
        print(one.planetName, two.planetName, three.planetName, five.planetName, four.planetName, six.planetName, seven.planetName, eight.planetName, nine.planetName, ten.planetName)
        print(one.xCord, two.xCord, three.xCord, five.xCord, four.xCord, six.xCord, seven.xCord, eight.xCord, nine.xCord, ten.xCord)
        print(one.yCOrd, two.yCOrd, three.yCOrd, five.yCOrd, four.yCOrd, six.yCOrd, seven.yCOrd, eight.yCOrd, nine.yCOrd, ten.yCOrd)
        print(one.techLevel, two.techLevel, three.techLevel, five.techLevel, four.techLevel, six.techLevel, seven.techLevel, eight.techLevel, nine.techLevel, ten.techLevel)
    }
}
