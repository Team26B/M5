package com.example.tejasvedantham.spacetrader.model;

/**
 * Represents a coordinate
 *
 * @author Byte Me
 * @version 1.0
 */
public class Coordinate {

    private int x;
    private int y;

    /**
     * Creates a coordinate object with the given x and y values
     * @param x the x value of the coordinate
     * @param y the y value of the coordinate
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a coordinate object with default x and y values
     */
    public Coordinate() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Setter method for the x value
     * @param x the new x value
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Setter method for the y value
     * @param y the new y value
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Getter method for the x value
     * @return the x value
     */
    public int getX() {
        return x;
    }

    /**
     * Getter method for the y value
     * @return the y value
     */
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof Coordinate)) return false;
        Coordinate other = (Coordinate) obj;
        return (this.x == other.x && this.y == other.y);
    }

    @Override
    public int hashCode() {
        String result = (31*17 + x) + "" + (31*17 + y);
        return Integer.parseInt(result);
    }
}
