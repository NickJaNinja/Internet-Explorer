package com.example.spacetraders.entities;

/**
 * This enum represents the various resource levels
 */
public enum ResourcesLevel {
    NO_SPECIAL_RESOURCES("No Special Resources"),
    MINERAL_RICH("Mineral Rich"),
    MINERAL_POOR("Mineral Poor"),
    DESERT("Desert"),
    LOTS_OF_WATER("Lots of Water"),
    RICH_SOIL("Rich Soil"),
    POOR_SOIL("Poor Soil"),
    RICH_FAUNA("Rich Fauna"),
    LIFELESS("Lifeless"),
    WEIRD_MUSHROOMS("Weird Mushrooms"),
    LOTS_OF_HERBS("Lots of Herbs"),
    ARTISTIC("Artistic"),
    WARLIKE("Warlike");

    private final String name;

    /**
     * Constructor for the enumeration
     *
     * @param name  the name
     */
    ResourcesLevel(String name) {
        this.name = name;
    }

// --Commented out by Inspection START (4/2/19, 11:03 PM):
//    /**
//     * getter for level
//     *
//     * @return level
//     */
//    public int getLevel() {
//        return level;
//    }
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)

    /**
     * getter for name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

}
