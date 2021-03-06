package com.example.spacetraders.entities;

import android.support.annotation.Nullable;

/**
 * shop goods enum
 */
public enum ShopGoods {
    WATER("Water",
            TechLevel.PRE_AGRICULTURE,
            TechLevel.PRE_AGRICULTURE,
            TechLevel.MEDIEVAL,
            30,
            3,
            4,
            RadicalPriceEvent.DROUGHT,
            ResourcesLevel.LOTS_OF_WATER,
            ResourcesLevel.DESERT,
            30,
            50,
            false),
    FURS("Furs",
            TechLevel.PRE_AGRICULTURE,
            TechLevel.PRE_AGRICULTURE,
            TechLevel.PRE_AGRICULTURE,
            250,
            10,
            10,
            RadicalPriceEvent.COLD,
            ResourcesLevel.RICH_FAUNA,
            ResourcesLevel.LIFELESS,
            230,
            280,
            false),
    FOOD("Food",
            TechLevel.AGRICULTURE,
            TechLevel.PRE_AGRICULTURE,
            TechLevel.AGRICULTURE,
            100,
            5,
            5,
            RadicalPriceEvent.CROP_FAIL,
            ResourcesLevel.RICH_SOIL,
            ResourcesLevel.POOR_SOIL,
            90,
            160,
            false),
    ORE("Ore",
            TechLevel.MEDIEVAL,
            TechLevel.MEDIEVAL,
            TechLevel.RENAISSANCE,
            350,
            20,
            10,
            RadicalPriceEvent.WAR,
            ResourcesLevel.MINERAL_RICH,
            ResourcesLevel.MINERAL_POOR,
            350,
            420,
            false),
    GAMES("Games",
            TechLevel.RENAISSANCE,
            TechLevel.AGRICULTURE,
            TechLevel.POST_INDUSTRIAL,
            250,
            -10,
            5,
            RadicalPriceEvent.BOREDOM,
            ResourcesLevel.ARTISTIC,
            ResourcesLevel.NO_SPECIAL_RESOURCES,
            160,
            270,
            false),
    FIREARMS("Firearms",
            TechLevel.RENAISSANCE,
            TechLevel.AGRICULTURE,
            TechLevel.INDUSTRIAL,
            1250,
            -75,
            100,
            RadicalPriceEvent.WAR,
            ResourcesLevel.WARLIKE,
            ResourcesLevel.NO_SPECIAL_RESOURCES,
            600,
            1100,
            false),
    MEDICINE("Medicine",
            TechLevel.EARLY_INDUSTRIAL,
            TechLevel.AGRICULTURE,
            TechLevel.POST_INDUSTRIAL,
            650,
            -20,
            10,
            RadicalPriceEvent.PLAGUE,
            ResourcesLevel.LOTS_OF_HERBS,
            ResourcesLevel.NO_SPECIAL_RESOURCES,
            400,
            700,
            false),
    MACHINES("Machines",
            TechLevel.EARLY_INDUSTRIAL,
            TechLevel.RENAISSANCE,
            TechLevel.INDUSTRIAL,
            900,
            -30,
            5,
            RadicalPriceEvent.LACK_OF_WORKERS,
            ResourcesLevel.NO_SPECIAL_RESOURCES,
            ResourcesLevel.NO_SPECIAL_RESOURCES,
            600,
            800,
            false),
    NARCOTICS("Narcotics",
            TechLevel.INDUSTRIAL,
            TechLevel.AGRICULTURE,
            TechLevel.INDUSTRIAL,
            3500,
            -125,
            150,
            RadicalPriceEvent.BOREDOM,
            ResourcesLevel.WEIRD_MUSHROOMS,
            ResourcesLevel.NO_SPECIAL_RESOURCES,
            2000,
            3000,
            false),
    ROBOTS("Robots",
            TechLevel.POST_INDUSTRIAL,
            TechLevel.POST_INDUSTRIAL,
            TechLevel.HI_TECH,
            5000,
            -100,
            50,
            RadicalPriceEvent.LACK_OF_WORKERS,
            ResourcesLevel.NO_SPECIAL_RESOURCES,
            ResourcesLevel.NO_SPECIAL_RESOURCES,
            3500,
            5000,
            false),
    BOBCOIN("Bobcoin",
            TechLevel.POST_INDUSTRIAL,
            TechLevel.POST_INDUSTRIAL,
            TechLevel.HI_TECH,
            420,
            0,
            69,
            RadicalPriceEvent.BOREDOM,
            ResourcesLevel.NO_SPECIAL_RESOURCES,
            ResourcesLevel.NO_SPECIAL_RESOURCES,
            240,
            666,
            true);

    /**
     * name = the name
     * M T L P = Minimum Tech Level to Produce this resource (You can't buy on planets below this
     * level)
     * M T L U =
     * Minimum Tech Level to Use this resource (You can't sell on planets below this level)
     * TTP = Tech Level which produces the most of this item
     * IPL = Price increase per tech level
     * Var = variance is the maximum percentage that the price can vary above or below the base
     * IE = Radical price increase event, when this even happens on a content_planet, the price may
     * increase astronomically
     * CR = When this condition is present, the price of this resource is unusually low
     * ER = When this condition is present, the resource is expensive
     * MTL = Min price offered in space trade with random trader (not on a content_planet)
     * MTH = Max price offered in space trade with random trader (not on a content_planet)
     * isIllegal = true if illegal, false if legal
     */
    private final String name;
    private final TechLevel mtlp;
    private final TechLevel mtlu;
    private final TechLevel ttp;
    private final int basePrice;
    private final int ipl;
    private final int var;
    private final RadicalPriceEvent ie;
    private final ResourcesLevel cr;
    private final ResourcesLevel er;
    private final int mtl;
    private final int mth;
    private final boolean isIllegal;

    /**
     * Constructor for the enumeration
     *
     * @param name      the name
     * @param mtlp      min tech level to produce
     * @param mtlu      min tech level to use
     * @param ttp       the ttp
     * @param basePrice the base price
     * @param ipl       the ipl
     * @param var       the var
     * @param ie        the ie
     * @param cr        the cr
     * @param er        the er
     * @param mtl       the mtl
     * @param mth       the mth
     * @param isIllegal legal condition
     */

    ShopGoods(String name, TechLevel mtlp, TechLevel mtlu, TechLevel ttp, int basePrice, int ipl,
              int var, RadicalPriceEvent ie, ResourcesLevel cr, ResourcesLevel er, int mtl, int mth,
              boolean isIllegal) {
        this.name = name;
        this.mtlp = mtlp;
        this.mtlu = mtlu;
        this.ttp = ttp;
        this.basePrice = basePrice;
        this.ipl = ipl;
        this.var = var;
        this.ie = ie;
        this.cr = cr;
        this.er = er;
        this.mtl = mtl;
        this.mth = mth;
        this.isIllegal = isIllegal;
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

// --Commented out by Inspection START (4/2/19, 11:03 PM):
//    /**
//     * getter for m t l p
//     *
//     * @return m t l p
// --Commented out by Inspection START (4/2/19, 11:03 PM):
////     */
////    public TechLevel getM t l p() {
////        return m t l p;
// --Commented out by Inspection START (4/2/19, 11:03 PM):
//////    }
////// --Commented out by Inspection STOP (4/2/19, 11:03 PM)
//// --Commented out by Inspection STOP (4/2/19, 11:03 PM)
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)

//    /**
//     * getter for m t l u
//     *
//     * @return m t l u
//     */
//    public TechLevel getMtlu() {
//        return mtlu;
//    }
//
//    /**
//     * getter for itp
//     *
//     * @return name
//     */
//    public TechLevel getTtp() {
//        return ttp;
//    }

    /**
     * getter for base price
     *
     * @return base price
     */
    public int getBasePrice() {
        return basePrice;
    }

    /**
     * getter for ipl
     *
     * @return ipl
     */
    public int getIpl() {
        return ipl;
    }

    /**
     * getter for var
     *
     * @return var
     */
    public int getVar() {
        return var;
    }

//    /**
//     * getter for ie
//     *
//     * @return ie
//     */
//    public RadicalPriceEvent getIe() {
//        return ie;
//    }

    /**
     * getter for cr
     *
     * @return cr
     */
    @Nullable
    public ResourcesLevel getCr() {
        return cr;
    }

    /**
     * getter for er
     *
     * @return er
     */
    @Nullable
    public ResourcesLevel getEr() {
        return er;
    }

// --Commented out by Inspection START (4/2/19, 11:03 PM):
//    /**
//     * getter for mtl
//     *
//     * @return mtl
//     */
//    public int getMtl() {
//        return mtl;
//    }
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)

// --Commented out by Inspection START (4/2/19, 11:03 PM):
//    /**
//     * getter for mth
//     *
//     * @return mth
//     */
//    public int getMth() {
//        return mth;
//    }
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)

//    /**
//     * getter for isIllegal
//     *
//     * @return isIllegal
//     */
//    public boolean isIllegal() {
//        return isIllegal;
//    }

    /**
     * getter for level of m t l p
     *
     * @return level of m t l p
     */
    public int getLevelofMtlp() {
        return mtlp.getLevel();
    }

    @Override
    // A make no sense toString to get rid of warning
    public String toString() {
        return "" + mtl + mth + mtlu + ttp + ie + cr + isIllegal;
    }
}
