package com.example.spacetraders.entities;

import java.util.Random;

/**This class represents a star*/
public class Star {

    private String name;
    private char classification;
    private Random r = new Random();

    /**
     * Constructor for Star.
     *
     * @param name name
     */
    public Star(String name, char classification) {
        this.name = name;
        this.classification = classification;
    }

    /**
     * Constructor for Star.
     *
     * @param name name
     */
    public Star(String name) {
        this.name = name;
        classification = GenerateClassification();
    }

    /**
     * Generates a classification for the star
     *
     * @return char classification
     */
    private char GenerateClassification() {
        float roll = r.nextFloat() * 100;
        if (roll > 60) return 'M'; // 40% chance
        else if (roll <= 60 && roll > 35) return 'K';// 25% chance
        else if (roll <= 35 && roll > 21) return 'F';// 14% chance
        else if (roll <= 21 && roll > 10) return 'G';// 11% chance
        else if (roll <= 10 && roll > 2.7f) return 'A';// 7.3% chance
        else if (roll <= 2.7f && roll > 0.4f) return 'B';// 2.3% chance
        else return 'O';// 0.4% chance
    }

    /**
     * gets name of star.
     *
     * @return String name of star
     */
    public String getName() {
        return name;
    }
}
