package com.example.spacetraders.models;

import com.example.spacetraders.entities.Game;

public class Interactor {
    private Game myGame;

    protected Interactor(Game g) { myGame = g; }

    protected Game getGame() {
        return myGame;
    }
}
