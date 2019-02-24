package com.example.tejasvedantham.spacetrader.viewmodels;

/**
 * Represents a coordinate
 *
 * @author Byte Me
 * @version 1.0
 */
public class Coordinate {

    private Double x;
    private Double y;

    /**
     * Creates a coordinate object with the given x and y values
     * @param x the x value of the coordinate
     * @param y the y value of the coordinate
     */
    public Coordinate(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a coordinate object with default x and y values
     */
    public Coordinate() {
        this.x = 0.0;
        this.y = 0.0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Coordinate)) return false;
        Coordinate other = (Coordinate) obj;
        return (this.x == other.x && this.y == other.y);
    }
}
