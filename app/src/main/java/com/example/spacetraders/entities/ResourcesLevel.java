package com.example.spacetraders.entities;

/**
 * This enum represents the various resource levels
 */
public enum ResourcesLevel {
    NO_SPECIAL_RESOURCES(0, "No Special Resources"),
    MINERAL_RICH(1, "Mineral Rich"),
    MINERAL_POOR(2, "Mineral Poor"),
    DESERT(3, "Desert"),
    LOTS_OF_WATER(4, "Lots of Water"),
    RICH_SOIL(5, "Rich Soil"),
    POOR_SOIL(6, "Poor Soil"),
    RICH_FAUNA(7, "Rich Fauna"),
    LIFELESS(8, "Lifeless"),
    WEIRD_MUSHROOMS(9, "Weird Mushrooms"),
    LOTS_OF_HERBS(10, "Lots of Herbs"),
    ARTISTIC(11, "Artistic"),
    WARLIKE(12, "Warlike");

    private final int level;
    private final String name;
    /**
     * Constructor for the enumeration
     *
     * @param level   resources level
     * @param name the name
     */
    ResourcesLevel(int level, String name) {
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
    public String getName() {
        return name;
    }
}
