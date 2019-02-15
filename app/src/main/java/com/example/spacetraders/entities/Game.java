package com.example.spacetraders.entities;

/**
 * This class represents the game
 */
public class Game {
    private GameDifficulty difficulty;
    private Player player;

    public Game(GameDifficulty difficulty, Player player) {
        this.difficulty = difficulty;
        this.player = player;
    }

    public GameDifficulty getGameDifficulty() {return difficulty;}

    public Player getPlayer() {return player;}
}
