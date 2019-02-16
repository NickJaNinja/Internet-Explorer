//
//  Game.swift
//  Internet Explorer
//
//  Created by Cecilia on 2/15/19.
//  Copyright © 2019 Cecilia. All rights reserved.
//

import Foundation
class Game {
    /** the game difficulty */
    var difficulty: GameDifficulty?
    /** the player */
    var player: Player?
    
    /**
     * Constructor for the game
     *
     * @param difficulty   difficulty of game
     * @param player        the player
     */
    func Game (difficulty: GameDifficulty, player: Player) {
        self.difficulty = difficulty
        self.player = player
    }
    
    /**
     * getter for game difficulty
     *
     * @return difficulty
     */
    func getGameDifficulty() -> GameDifficulty {return difficulty!}
    
    /**
     * getter for player
     * @return player
     */
    func getPlayer() -> Player {return player!}
    
    
    /**
     * setter for game difficulty
     *
     * @param difficulty the new difficulty
     */
    func setGameDifficulty (difficulty: GameDifficulty) {self.difficulty = difficulty}
    
    /**
     * setter for player
     *
     * @param player the new difficulty
     */
    func setPlayer(player: Player) {self.player = player}
    
}
