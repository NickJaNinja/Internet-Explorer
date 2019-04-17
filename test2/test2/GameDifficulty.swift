//
//  GameDifficulty.swift
//  Internet Explorer
//
//  Created by Cecilia on 2/15/19.
//  Copyright © 2019 Cecilia. All rights reserved.
//

import Foundation
/**
 * This class represents the various game difficulties
 */
class GameDifficulty {
    var BEGINNER: String = "Beginner"
    var EASY: String = "Easy"
    var NORMAL: String = "Normal"
    var HARD: String = "Hard"
    var IMPOSSIBLE: String = "Impossible"
    
    var name: String?
    
    /**
     * Constructor for the enumeration
     *
     * @param name   name of difficulty
     */
    func GameDifficulty (name: String) {
        self.name = name
    }
    
    /**
     *
     * @return the display string representation of the course
     */
    //public toString() -> String { return name }
}

