package com.example.tejasvedantham.spacetrader.model;

public class Planet {
    private String name;
    private Market market;
    public Planet(String name) {
        this.name = name;
        this.market = new Market
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
