package com.example.tejasvedantham.spacetrader.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Market{
    private ArrayList<TradeGood> onMarket = new ArrayList<TradeGood>();
    private ArrayList<TradeGood> onShip = new ArrayList<TradeGood>();
    private TechLevel level;
    public Market(TechLevel level){
        this(new ArrayList<TradeGood>(), level);
    }
    public Market(ArrayList<TradeGood> onShip, TechLevel level) {
        this.onShip = onShip;
        this.level = level;
        setPrices();
    }

    public ArrayList<TradeGood> getOnMarket() {
        return onMarket;
    }

    public void setOnMarket(ArrayList<TradeGood> onMarket) {
        this.onMarket = onMarket;
    }

    public ArrayList<TradeGood> getOnShip() {
        return onShip;
    }

    public void setOnShip(ArrayList<TradeGood> onShip) {
        this.onShip = onShip;
    }

    public TechLevel getLevel() {
        return level;
    }

    public void setLevel(TechLevel level) {
        this.level = level;
    }

    public void setPrices() {
        int base;
        int ipl;
        int var;
        int coin;
        int price = 0;
        TradeGood curr;
        for (TradeGoodType temp : TradeGoodType.values()) {
            //make sure the tech level of this market is valid
            if (temp.getMtlp() > this.level.ordinal()) {
                //base price
                base = temp.getBasePrice();
                //calculate ipl * (Techlevel - MTLP)
                ipl = temp.getIpl() * (level.ordinal() - temp.getMtlp());
                //calculate variance
                coin = (int) Math.random() * 2;
                var = (int) Math.random() * temp.getVar();
                //calculate based on heads or tail
                if (coin == 0) {
                    price = base + ipl - var;
                } else {
                    price = base + ipl + var;
                }
                curr = new TradeGood(temp, price);
                onMarket.add(curr);
            }
        }
    }

}
