package com.example.tejasvedantham.spacetrader.model;

//import java.io.Serializable;

/**
 * Represents a trade good object that will be in the market
 *
 * @author Byte Me
 * @version 1.0
 */
public class TradeGood {

    private TradeGoodType tradeGoodType;
    private int marketPrice;

    /**
     * Creates a trade good object with the designated type and market price
     *
     * @param tradeGoodType the type of trade good
     * @param marketPrice the price of the trade good in the specific planet's market
     */
    public TradeGood(TradeGoodType tradeGoodType, int marketPrice) {
        this.tradeGoodType = tradeGoodType;
        this.marketPrice = marketPrice;
    }

    public TradeGood() {}

    /**
     * Getter method for the trade good type
     * @return the trade good type
     */
    public TradeGoodType getTradeGoodType() {
        return tradeGoodType;
    }

    /**
     * Getter method for the market price
     * @return the market price
     */
    public int getMarketPrice() {
        return marketPrice;
    }

    /**
     * Setter method for the market price
     * @param marketPrice the market price to set to
     */
    public void setMarketPrice(int marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * Setter method for the trade good type
     * @param tradeGoodType the trade good type to set the trade good to
     */
    public void setTradeGoodType(TradeGoodType tradeGoodType) {
        this.tradeGoodType = tradeGoodType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof TradeGood)) return false;
        TradeGood other = (TradeGood) obj;
        return this.tradeGoodType.equals(other.getTradeGoodType());
    }
}
