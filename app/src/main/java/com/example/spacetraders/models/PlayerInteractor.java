package com.example.spacetraders.models;

import com.example.spacetraders.entities.Game;
import com.example.spacetraders.entities.Player;

public class PlayerInteractor extends Interactor {
    public PlayerInteractor(Game g) { super(g); }

    public void setPlayer (Player p) { getGame().setPlayer(p); }
}
