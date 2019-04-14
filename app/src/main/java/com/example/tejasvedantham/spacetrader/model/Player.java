package com.example.tejasvedantham.spacetrader.model;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a player object for the game
 *
 * @author Byte Me
 * @version 1.0
 */
public class Player {

    private String name;
    private int pilotPoints;
    private int fighterPoints;
    private int traderPoints;
    private int engineerPoints;
    private int numCredits;
    private boolean isBountyHunter;
    private boolean isPirate;
    private Spaceship spaceship;
    private ArrayList<TradeGood> ownedGoods;
    /**
     * Creates a player object with a defualt name and spaceship and 4 skill points for each skill
     */
    public Player() {
        this("Byte Me", 4, 4, 4, 4, new Spaceship(SpaceshipType.GNAT), new ArrayList<TradeGood>());
    }

    /**
     * Creates a player object with a designated name and skill points
     *
     * @param name           the name of the player
     * @param pilotPoints    the number of pilot skill points
     * @param fighterPoints  the number of fighter skill points
     * @param traderPoints   the number of trader skill points
     * @param engineerPoints the number of engineer skill points
     */
    public Player(String name, int pilotPoints, int fighterPoints, int traderPoints,
                  int engineerPoints, Spaceship spaceship, ArrayList<TradeGood> list) {
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.fighterPoints = fighterPoints;
        this.traderPoints = traderPoints;
        this.engineerPoints = engineerPoints;
        this.numCredits = 1000;
        this.isBountyHunter = false;
        this.isPirate = false;
        this.spaceship = spaceship;
        this.ownedGoods = list;
    }

    /**
     * Getter method for the name of the player
     *
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the pilot skill points
     *
     * @return the pilot skill points
     */
    public int getPilotPoints() {
        return pilotPoints;
    }

    /**
     * Getter method for the fighter skill points
     *
     * @return the fighter skill points
     */
    public int getFighterPoints() {
        return fighterPoints;
    }

    /**
     * Getter method for the trader skill points
     *
     * @return the trader skill points
     */
    public int getTraderPoints() {
        return traderPoints;
    }

    /**
     * Getter method for the engineer skill points
     *
     * @return the engineer skill points
     */
    public int getEngineerPoints() {
        return engineerPoints;
    }

    /**
     * Getter method for the number of credits
     *
     * @return the number of credits
     */
    public int getNumCredits() {
        return numCredits;
    }

    public void setNumCredits(int numCredits) {
        this.numCredits = numCredits;
    }

    /**
     * Getter method for the spaceship
     *
     * @return the spaceship
     */
    public Spaceship getSpaceship() {
        return spaceship;
    }
    /**
     * Getter method for the owned goods
     *
     * @return owned goods
     */
    @Exclude
    public ArrayList<TradeGood> getOwnedGoods() {
        return ownedGoods;
    }

    /**
     * buys the good
     * @param good
     * @param market
     * @return true if can buy, false if not
     */
    public boolean buy(TradeGood good, Market market) {
        //list of goods in the market
        ArrayList<TradeGood> goods = market.getOnMarket();
        int price = 0;
        //if the market contains this good
        if(goods.contains(good)) {
            price = goods.get(goods.indexOf(good)).getMarketPrice();
            //if you have enough credits for this purchase
            if (price <= this.numCredits) {
                //if you have enough space in your cargo bay
                if (spaceship.getCargoNum() < spaceship.getSpaceShipType().getNumCargoBays()) {
                    //decrement your credits
                    this.numCredits = this.numCredits - price;
                    //increment number of items in cargo bay
                    spaceship.setCargoNum(spaceship.getCargoNum() + 1);
                    //add the good to your list
                    ownedGoods.add(good);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * sells a good from the cargo bay
     * @param good
     * @param market
     * @return true if can sell, false if cannot sell
     */
    public boolean sell(TradeGood good, Market market) {
        ArrayList<TradeGood> goods = market.getOnMarket();
        int price = 0;
        //if you own the good you are trying to sell
        if(ownedGoods.contains(good)) {
            //get the selling price
            price = goods.get(goods.indexOf(good)).getMarketPrice();
            //increment the number of credits
            //numCredits += price;
            //decrement the number of items in cargo bay
            //spaceship.setCargoNum(spaceship.getCargoNum() - 1);
            //remove the item from your list
            //ownedGoods.remove(good);
            return true;
        } else {
            return false;
        }
    }
    /**
     * Determines if the player is a bounty hunter
     *
     * @return whether or not the player is a bounty hunter
     */
    public boolean isBountyHunter() {
        return isBountyHunter;
    }

    /**
     * Determines if the player is a pirate
     *
     * @return whether or not the player is a pirate
     */
    public boolean isPirate() {
        return isPirate;
    }

    /**
     * Handles the player making a trade
     */
    public void trade() {
        //This method will be implemented in a later version
    }

    /**
     * Handles the player making a robbery
     */
    public void rob() {
        //This method will be implemented in a later version
    }

    public String toString() {
        StringBuilder toReturn = new StringBuilder("\n");
        toReturn.append("--------------------\n");
        toReturn.append("Player name: " + getName() + "\n");
        toReturn.append("Game difficulty: " + Game.getInstance().getDifficulty() + "\n");
        toReturn.append("Fighter Points: " + getFighterPoints() + "\n");
        toReturn.append("Engineer Points: " + getEngineerPoints() + "\n");
        toReturn.append("Trader Points: " + getTraderPoints() + "\n");
        toReturn.append("Pilot Points: " + getPilotPoints() + "\n");
        toReturn.append("Credits: " + getNumCredits() + "\n");
        toReturn.append("Spaceship Type: " + getSpaceship().getSpaceShipType() + "\n");
        toReturn.append("--------------------");

        return toReturn.toString();
    }

}
