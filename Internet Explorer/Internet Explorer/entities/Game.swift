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
    var  GameDifficulty difficulty
    /** the player */
    var Player player
    
    /**
     * Constructor for the game
     *
     * @param difficulty   difficulty of game
     * @param player        the player
     */
    func Game (GameDifficulty, difficulty, Player player) {
    self.difficulty = difficulty
    self.player = player
    }
    
    /**
     * getter for game difficulty
     *
     * @return difficulty
     */
    func GameDifficulty getGameDifficulty() {return difficulty}
    
    /**
     * getter for player
     * @return player
     */
    func Player getPlayer() {return player}
    
    
    /**
     * setter for game difficulty
     *
     * @param difficulty the new difficulty
     */
    func void setGameDifficulty(GameDifficulty difficulty) {self.difficulty = difficulty}
    
    /**
     * setter for player
     *
     * @param player the new difficulty
     */
    func void setPlayer(Player player) {self.player = player}
    
}
