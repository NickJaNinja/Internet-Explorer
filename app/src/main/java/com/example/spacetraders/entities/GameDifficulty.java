package com.example.spacetraders.entity;

/**
 * This class represents the various game difficulties
 */
public enum GameDifficulty {
    BEGINNER("Beginner"), EASY("Easy"), NORMAL("Normal"), HARD("Hard"), IMPOSSIBLE("Impossible");

    private String name;

    /**
     * Constructor for the enumeration
     *
     * @param name   name of difficulty
     */
    GameDifficulty(String name) {
        this.name = name;
    }

    /**
     *
     * @return the display string representation of the course
     */
    public String toString() { return name; }
}
