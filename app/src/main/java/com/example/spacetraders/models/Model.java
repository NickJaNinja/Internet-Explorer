package com.example.spacetraders.models;

import com.example.spacetraders.entities.Game;
import com.example.spacetraders.entities.GameDifficulty;
import com.example.spacetraders.entities.Player;

public class Model {
    private Game game;

    /**
     * Creates a new game
     *
     * @param gd game difficulty
     * @param p player
     */
    public void createGame(GameDifficulty gd, Player p) {
        game = new Game(gd, p);
    }
}
