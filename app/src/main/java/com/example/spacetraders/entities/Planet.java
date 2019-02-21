package com.example.spacetraders.entities;

import java.util.Random;

/**This class represents a planet*/
public class Planet {

    private String name;
    private Star parentStar;
    private TechLevel techLevel;
    private ResourcesLevel resourcesLevel;
    private PoliticalSystem politicalSystem;

    /**Constructor for Planet, randomizes levels
     * @param name name
     */
    public Planet(String name, Star parentStar) {
        this.name = name;
        this.parentStar = parentStar;
        Random r = new Random();

        int techPick = r.nextInt(TechLevel.values().length);
        this.techLevel = TechLevel.values()[techPick];

        int resourcesPick = r.nextInt(ResourcesLevel.values().length);
        this.resourcesLevel = ResourcesLevel.values()[resourcesPick];

        int politicalPick = r.nextInt(PoliticalSystem.values().length);
        this.politicalSystem = PoliticalSystem.values()[politicalPick];
    }


    /**Constructor for Planet
     * @param name name
     * @param techLevel tech level
     * @param resourcesLevel resources level
     * @param politicalSystem political system
     */
    public Planet(String name, Star parentStar, TechLevel techLevel, ResourcesLevel resourcesLevel, PoliticalSystem politicalSystem) {
        this.name = name;
        this.parentStar = parentStar;
        this.techLevel = techLevel;
        this.resourcesLevel = resourcesLevel;
        this.politicalSystem = politicalSystem;
    }
}
