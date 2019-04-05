package com.example.spacetraders.entities;


import android.support.annotation.Nullable;

/**
 * This enum represents the various tech levels
 */
public enum TechLevel {
    PRE_AGRICULTURE(0, "Pre-Agriculture"),
    AGRICULTURE(1, "Agriculture"),
    MEDIEVAL(2, "Medieval"),
    RENAISSANCE(3, "Renaissance"),
    EARLY_INDUSTRIAL(4, "Early Industrial"),
    INDUSTRIAL(5, "Industrial"),
    POST_INDUSTRIAL(6, "Post-Industrial"),
    HI_TECH(7, "Hi-Tech");


    private final int level;
    private final String name;

    /**
     * Constructor for the enumeration
     *
     * @param level tech level
     * @param name  the name
     */
    TechLevel(int level, String name) {
        this.level = level;
        this.name = name;
    }

    /**
     * getter for level
     *
     * @return level
     */
    public int getLevel() {
        return level;
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
