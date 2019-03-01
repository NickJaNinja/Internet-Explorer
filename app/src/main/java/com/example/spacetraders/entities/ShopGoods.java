package com.example.spacetraders.entities;
/**This enum represents the various shop goods*/
public enum ShopGoods implements TradeGoods {
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
                50),
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
                280),
        FOOD("Food",
                TechLevel.AGRICULTURE,
                TechLevel.PRE_AGRICULTURE,
                TechLevel.AGRICULTURE,
                100,
                5,
                5,
                RadicalPriceEvent.CROPFAIL,
                ResourcesLevel.RICH_SOIL,
                ResourcesLevel.POOR_SOIL,
                90,
                160),
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
                350, 420),
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
                270),
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
                1100),
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
                700),
        MACHINES("Machines",
                TechLevel.EARLY_INDUSTRIAL,
                TechLevel.RENAISSANCE,
                TechLevel.INDUSTRIAL,
                900,
                -30,
                5,
                RadicalPriceEvent.LACKOFWORKERS,
                ResourcesLevel.NO_SPECIAL_RESOURCES,
                ResourcesLevel.NO_SPECIAL_RESOURCES,
                600,
                800),
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
                3000),
        ROBOTS("Robots",
                TechLevel.POST_INDUSTRIAL,
                TechLevel.POST_INDUSTRIAL,
                TechLevel.HI_TECH,
                5000,
                -100,
                50,
                RadicalPriceEvent.LACKOFWORKERS,
                ResourcesLevel.NO_SPECIAL_RESOURCES,
                ResourcesLevel.NO_SPECIAL_RESOURCES,
                3500,
                5000);

        /**
         * MTLP = Minimum Tech Level to Produce this resource (You can't buy on planets below this level)
         * MTLU = Minimum Tech Level to Use this resource (You can't sell on planets below this level)
         * TTP = Tech Level which produces the most of this item
         * IPL = Price increase per tech level
         * Var = variance is the maximum percentage that the price can vary above or below the base
         * IE = Radical price increase event, when this even happens on a planet, the price may increase astronomically
         * CR = When this condition is present, the price of this resource is unusually low
         * ER = When this condition is present, the resource is expensive
         * MTL = Min price offered in space trade with random trader (not on a planet)
         * MTH = Max price offered in space trade with random trader (not on a planet)
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

        private ShopGoods (String name, TechLevel mtlp, TechLevel mtlu, TechLevel ttp, int basePrice, int ipl, int var, RadicalPriceEvent ie, ResourcesLevel cr, ResourcesLevel er, int mtl, int mth) {
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
        }

}
