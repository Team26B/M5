package com.example.tejasvedantham.spacetrader.model;

/**
 * Represents the various trade good types
 *
 * @author Byte Me
 * @version 1.0
 */
public enum TradeGoodType {
    WATER(30, 0, 0, 2, 3, 4, "drought", "lotsofwater", "desert", 30, 50),
    FURS(250, 0, 0, 0, 10, 10, "cold", "richfauna", "lifeless", 230, 280),
    FOOD(100, 1, 0, 1, 5, 5, "cropfail", "richsoil", "poorsoil", 90, 160),
    ORE(350, 2, 2, 3, 20, 10, "war", "mineralrich", "mineralpoor", 350, 420),
    GAMES(250, 3, 1, 6, -10, 5, "boredom", "artistic", null, 160, 270),
    FIREARMS(1250, 3, 1, 5, -75, 100, "war", "warlike", null, 600, 1100),
    MEDICINE(650, 4, 1, 6, -20, 10, "plague", "lotsofherbs", null,  400, 700),
    MACHINES(900, 4, 3, 5, -30, 5, "lackofworkers", null, null, 600, 800),
    NARCOTICS(3500, 5, 0, 5, -125, 150, "boredom", "weirdmushrooms", null, 2000, 3000),
    ROBOTS(5000, 6, 4, 7, -150, 100, "lackofworkers", null, null, 3500, 5000);

    private int basePrice;
    private int mtlp;
    private int mtlu;
    private int ttp;
    private int ipl;
    private int var;
    private String ie;
    private String cr;
    private String er;
    private int mtl;
    private int mth;

    /**
     * Initializes the values of a particular trade good type
     *
     * @param basePrice the base price for the trade good type
     * @param mtlp the Minimum Tech Level to Produce this resource
     * @param mtlu the Minimum Tech Level to Use this resource
     * @param ttp the Tech Level which produces the most of this item
     * @param ipl the Price increase per tech level
     * @param var the maximum percentage that the price can vary above or below the base
     * @param ie a Radical price increase event
     * @param cr a condition representing when the price is unusually low
     * @param er a condition when the price is very expensive
     * @param mtl the Min price offered in space trade with random trader (not on planet)
     * @param mth the Max price offered in space trade with random trader (not on a planet)
     */
    private TradeGoodType(int basePrice, int mtlp, int mtlu, int ttp, int ipl, int var, String ie,
                      String cr, String er, int mtl, int mth) {
        this.basePrice = basePrice;
        this.mtlp = mtlp;
        this.mtlu = mtlu;
        this.ttp = ttp;
        this.ipl = ipl;
        this.var = var;
        this.ie = ie;
        this.cr = cr;
        this.er = er;
        this.mtl = mtl;
        this.mth = mth;
    }

    /**
     * Getters and setters for all variables
     */
    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getMtlp() {
        return mtlp;
    }

    public void setMtlp(int mtlp) {
        this.mtlp = mtlp;
    }

    public int getMtlu() {
        return mtlu;
    }

    public void setMtlu(int mtlu) {
        this.mtlu = mtlu;
    }

    public int getTtp() {
        return ttp;
    }

    public void setTtp(int ttp) {
        this.ttp = ttp;
    }

    public int getIpl() {
        return ipl;
    }

    public void setIpl(int ipl) {
        this.ipl = ipl;
    }

    public int getVar() {
        return var;
    }

    public void setVar(int var) {
        this.var = var;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getCr() {
        return cr;
    }

    public void setCr(String cr) {
        this.cr = cr;
    }

    public String getEr() {
        return er;
    }

    public void setEr(String er) {
        this.er = er;
    }

    public int getMtl() {
        return mtl;
    }

    public void setMtl(int mtl) {
        this.mtl = mtl;
    }

    public int getMth() {
        return mth;
    }

    public void setMth(int mth) {
        this.mth = mth;
    }
}
