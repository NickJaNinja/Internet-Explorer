package com.example.spacetraders.entities;
/**This enum represents the various shop goods*/
public enum IllegalGoods {
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
            666);

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

    /**
     * Constructor for the enumeration
     *
     * @param name the name
     * @param mtlp min tech level to produce
     * @param mtlu min tech level to use
     * @param ttp the ttp
     * @param basePrice the base price
     * @param ipl the ipl
     * @param var the var
     * @param ie the ie
     * @param cr the cr
     * @param er the er
     * @param mtl the mtl
     * @param mth the mth
     */
    IllegalGoods (String name, TechLevel mtlp, TechLevel mtlu, TechLevel ttp, int basePrice, int ipl, int var, RadicalPriceEvent ie, ResourcesLevel cr, ResourcesLevel er, int mtl, int mth) {
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

    /**
     * getter for name
     *
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * getter for mtlp
     *
     * @return mtlp
     */
    public TechLevel getMtlp() {
        return mtlp;
    }
    /**
     * getter for mtlu
     *
     * @return mtlu
     */
    public TechLevel getMtlu() {
        return mtlu;
    }
    /**
     * getter for itp
     *
     * @return name
     */
    public TechLevel getTtp() {
        return ttp;
    }
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
    /**
     * getter for ie
     *
     * @return ie
     */
    public RadicalPriceEvent getIe() {
        return ie;
    }
    /**
     * getter for cr
     *
     * @return cr
     */
    public ResourcesLevel getCr() {
        return cr;
    }
    /**
     * getter for er
     *
     * @return er
     */
    public ResourcesLevel getEr() {
        return er;
    }
    /**
     * getter for mtl
     *
     * @return mtl
     */
    public int getMtl() {
        return mtl;
    }
    /**
     * getter for mth
     *
     * @return mth
     */
    public int getMth() {
        return mth;
    }
}
