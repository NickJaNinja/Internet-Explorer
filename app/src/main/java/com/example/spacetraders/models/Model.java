package com.example.spacetraders.models;

import com.example.spacetraders.entities.Game;
import com.example.spacetraders.entities.GameDifficulty;
import com.example.spacetraders.entities.Player;

public class Model {
    private Game game;

    /** Singleton Pattern Code
     *  this allows us to get access to this class
     *  anywhere, which will allow our View models to access
     *  the "back end"  more easily
     */
    private static  Model instance = new Model();

    public static Model getInstance() { return instance; }

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
