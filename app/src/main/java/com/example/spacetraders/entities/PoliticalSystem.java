package com.example.spacetraders.entities;

import android.support.annotation.Nullable;

/**
 * This enum represents the political systems
 */
public enum PoliticalSystem {
    ANARCHY("Anarchy"),
    CAPITALIST_STATE("Capitalist State"),
    COMMUNIST_STATE("Communist State"),
    CONFEDERACY("Confederacy"),
    CORPORATE_STATE("Corporate State"),
    CYBERNETIC_STATE("Cybernetic State"),
    DEMOCRACY("Democracy"),
    DICTATORSHIP("Dictatorship"),
    FASCIST_STATE("Fascist State"),
    FEUDAL_STATE("Feudal State"),
    MILITARY_STATE("Military State"),
    MONARCHY("Monarchy"),
    PACIFIST_STATE("Pacifist State"),
    SOCIALIST_STATE("Socialist State"),
    STATE_OF_SATORI("State of Satori"),
    TECHNOCRACY("Technocracy"),
    THEOCRACY("Theocracy");

    private final String name;

    /**
     * Constructor for the enumeration
     *
     * @param name the name
     */
    PoliticalSystem(String name) {
        this.name = name;
    }

    /**
     * getter for name
     *
     * @return name
     */
    @Nullable
    public String getName() {
        return name;
    }

}
