package com.example.spacetraders.entities;

public enum ShopGoods extends TradeGoods {
        WATER("Water",
                TechLevel.PRE_AGRICULTURAL,
                TechLevel.PRE_AGRICULTURAL,
                TechLevel.MEDIEVAL,
                30,
                3,
                4,
                RadicalPriceEvent.DROUGHT,
                ResourcesLevel.LOTS_OF_WATER,
                ResourcesLevel.DESERT,
                30,
                50);

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

        ShopGoods (String name, TechLevel mtlp, TechLevel mtlu, TechLevel ttp, int basePrice, int ipl, int var, RadicalPriceEvent ie, ResourcesLevel cr, ResourcesLevel er, int mtl, int mth) {
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
