package com.example.spacetraders.entity;

/**
 * This class represents the various spaceships
 */
public enum ShipType {
    FLEA("Flea"), GNAT("Gnat"), FIREFLY("Firefly"), MOSQUITO("Mosquito"), BUMBLEBEE("Bumblebee"),
    BEETLE("Beetle"), HORNET("Hornet"), GRASSHOPPER("Grasshopper"), TERMITE("Termite"), WASP("Wasp");

    private String name;

    /**
     * Constructor for the enumeration
     *
     * @param name   name of ship
     */
    Spaceship(String name) {
        this.name = name;
    }
}
