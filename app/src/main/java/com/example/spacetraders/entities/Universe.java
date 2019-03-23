package com.example.spacetraders.entities;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;

/**
 * This class represents the game universe
 */
public class Universe {
    private static final String[] SOLARSYSTEMNAMES =
            {
                    "Acamar",
                    "Adahn",        // The alternate personality for The Nameless One in "Planescape: Torment"
                    "Aldea",
                    "Andevian",
                    "Antedi",
                    "Balosnee",
                    "Baratas",
                    "Brax",            // One of the heroes in Master of Magic
                    "Bretel",        // This is a Dutch device for keeping your pants up.
                    "Calondia",
                    "Campor",
                    "Capelle",        // The city I lived in while programming this game
                    "Carzon",
                    "Castor",        // A Greek demi-god
                    "Cestus",
                    "Cheron",
                    "Courteney",    // After Courteney Cox…
                    "Daled",
                    "Damast",
                    "Davlos",
                    "Deneb",
                    "Deneva",
                    "Devidia",
                    "Draylon",
                    "Drema",
                    "Endor",
                    "Esmee",        // One of the witches in Pratchett's Discworld
                    "Exo",
                    "Ferris",        // Iron
                    "Festen",        // A great Scandinavian movie
                    "Fourmi",        // An ant, in French
                    "Frolix",        // A solar system in one of Philip K. Dick's novels
                    "Gemulon",
                    "Guinifer",        // One way of writing the name of king Arthur's wife
                    "Hades",        // The underworld
                    "Hamlet",        // From Shakespeare
                    "Helena",        // Of Troy
                    "Hulst",        // A Dutch plant
                    "Iodine",        // An element
                    "Iralius",
                    "Janus",        // A seldom encountered Dutch boy's name
                    "Japori",
                    "Jarada",
                    "Jason",        // A Greek hero
                    "Kaylon",
                    "Khefka",
                    "Kira",            // My dog's name
                    "Klaatu",        // From a classic SF movie
                    "Klaestron",
                    "Korma",        // An Indian sauce
                    "Kravat",        // Interesting spelling of the French word for "tie"
                    "Krios",
                    "Laertes",        // A king in a Greek tragedy
                    "Largo",
                    "Lave",            // The starting system in Elite
                    "Ligon",
                    "Lowry",        // The name of the "hero" in Terry Gilliam's "Brazil"
                    "Magrat",        // The second of the witches in Pratchett's Discworld
                    "Malcoria",
                    "Melina",
                    "Mentar",        // The Psilon home system in Master of Orion
                    "Merik",
                    "Mintaka",
                    "Montor",        // A city in Ultima III and Ultima VII part 2
                    "Mordan",
                    "Myrthe",        // The name of my daughter
                    "Nelvana",
                    "Nix",            // An interesting spelling of a word meaning "nothing" in Dutch
                    "Nyle",            // An interesting spelling of the great river
                    "Odet",
                    "Og",            // The last of the witches in Pratchett's Discworld
                    "Omega",        // The end of it all
                    "Omphalos",        // Greek for navel
                    "Orias",
                    "Othello",        // From Shakespeare
                    "Parade",        // This word means the same in Dutch and in English
                    "Penthara",
                    "Picard",        // The enigmatic captain from ST:TNG
                    "Pollux",        // Brother of Castor
                    "Quator",
                    "Rakhar",
                    "Ran",            // A film by Akira Kurosawa
                    "Regulas",
                    "Relva",
                    "Rhymus",
                    "Rochani",
                    "Rubicum",        // The river Ceasar crossed to get into Rome
                    "Rutia",
                    "Sarpeidon",
                    "Sefalla",
                    "Seltrice",
                    "Sigma",
                    "Sol",            // That's our own solar system
                    "Somari",
                    "Stakoron",
                    "Styris",
                    "Talani",
                    "Tamus",
                    "Tantalos",        // A king from a Greek tragedy
                    "Tanuga",
                    "Tarchannen",
                    "Terosa",
                    "Thera",        // A seldom encountered Dutch girl's name
                    "Titan",        // The largest moon of Jupiter
                    "Torin",        // A hero from Master of Magic
                    "Triacus",
                    "Turkana",
                    "Tyrus",
                    "Umberlee",        // A god from AD&D, which has a prominent role in Baldur's Gate
                    "Utopia",        // The ultimate goal
                    "Vadera",
                    "Vagra",
                    "Vandor",
                    "Ventax",
                    "Xenon",
                    "Xerxes",        // A Greek hero
                    "Yew",            // A city which is in almost all of the Ultima games
                    "Yojimbo",        // A film by Akira Kurosawa
                    "Zalkon",
                    "Zuul"            // From the first Ghostbusters movie
            };

    private static final String[] PREFIXES =
            {
                    "Asdf",
                    "Qwerty"
            };
    private static final String[] SUFFIXES =
            {
                    "Fdsa",
                    "Ytrewq"
            };


    private Random r = new Random();
    /**
     * dimensions of universe
     */
    private static final int MAXX = 500;
    private static final int MAXY = 500;
    private int numSolarSystems = 5 + r.nextInt(5);

    private SolarSystem[] solarSystems;

    /**
     * Constructor for Universe
     */
    public Universe() {
        Set<Coordinates> coordSet = new HashSet<>();
        Set<String> nameSet = new HashSet<>();
        this.solarSystems = new SolarSystem[SOLARSYSTEMNAMES.length];

        for (int i = 0; i < numSolarSystems; i++) {
            //keep making random names and coordinates until we find one that hasn't been used yet
            //choose coordinates
            int randX = r.nextInt(MAXX);
            int randY = r.nextInt(MAXY);
            Coordinates randCoords = new Coordinates(randX, randY);
            while (coordSet.contains(randCoords)) {
                randX = r.nextInt(MAXX);
                randY = r.nextInt(MAXY);
                randCoords = new Coordinates(randX, randY);
            }
            //choose name
            int randPrefixIndex = r.nextInt(PREFIXES.length);
            int randSuffixIndex = r.nextInt(SUFFIXES.length);
            int randNameNumber = 1 + r.nextInt(100);
            String name = PREFIXES[randPrefixIndex] + SUFFIXES[randSuffixIndex] + randNameNumber;
            while (nameSet.contains(name)) {
                randPrefixIndex = r.nextInt(PREFIXES.length);
                randSuffixIndex = r.nextInt(SUFFIXES.length);
                randNameNumber = 1 + r.nextInt(100);
                name = PREFIXES[randPrefixIndex] + SUFFIXES[randSuffixIndex] + randNameNumber;
            }
            coordSet.add(randCoords);
            nameSet.add(name);
            this.solarSystems[i] = new SolarSystem(name, randCoords);
        }
    }

    /**
     * getter for solar systems
     *
     * @return array of solar systems
     */
    public SolarSystem[] getSolarSystems() {
        return solarSystems;
    }

    /**
     * gets a random solar system
     *
     * @return random solar system
     */
    public SolarSystem getRandomSolarSystem() {
        return solarSystems[r.nextInt(solarSystems.length)];
    }

    /**
     * gets a random planet
     *
     * @return random planet
     */
    public Planet getRandomPlanet() {
        Planet plan = solarSystems[r.nextInt(solarSystems.length)].getRandomPlanet();
        System.out.println("RANDOM PLANET: " + plan.toString());
        return plan;
    }

    /**
     * to string for universe
     *
     * @return string of universe info
     */
    @Override
    public String toString() {
        String str = "Universe: " + solarSystems.length + " solar systems\n ";
        for (SolarSystem s : solarSystems) {
            str += s.toString();
        }
        return str;
    }

}
