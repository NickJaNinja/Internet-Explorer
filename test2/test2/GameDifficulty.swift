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
enum GameDifficulty: String {
    case BEGINNER = "Beginner"
    case EASY = "Easy"
    case NORMAL = "Normal"
    case HARD = "Hard"
    case IMPOSSIBLE = "Impossible"
    
    var final name: String?
    
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
    public toString() -> String { return name }
}

