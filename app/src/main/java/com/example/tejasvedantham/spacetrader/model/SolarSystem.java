package com.example.tejasvedantham.spacetrader.model;

import java.util.ArrayList;

/**
 * Represents a universe for the game
 *
 * @author Byte Me
 * @version 1.0
 */
public class SolarSystem {

    private String name;
    private Coordinate location;
    private TechLevel techLevel;
    private Resource resource;
    private ArrayList<Planet> planets = new ArrayList<Planet>();
    /**
     * Creates a Solar System object with the given parameters
     * @param name the name of the solar system
     * @param coordinate the location of solar system
     * @param techLevel the tech level of the solar system
     * @param resource the resource of the solar system
     */
    public SolarSystem(String name, Coordinate coordinate, TechLevel techLevel, Resource resource) {
        this.name = name;
        this.location = coordinate;
        this.techLevel = techLevel;
        this.resource = resource;
        Planet tempP = new Planet(name);
        planets.add(tempP);
    }

    /**
     * Creates a Solar System object with the given parameters and two default values
     * @param name the name of the solar system
     * @param coordinate the location of solar system
     */
    public SolarSystem(String name, Coordinate coordinate) {
        this(name, coordinate, TechLevel.PREAGRICULTURE, Resource.NOSPECIALRESOURCES);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getLocation() {
        return location;
    }

    public void setLocation(Coordinate location) {
        this.location = location;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof Coordinate)) return false;
        SolarSystem other = (SolarSystem) obj;
        return this.location.equals(other.location);
    }

    @Override
    public int hashCode() {
        return location.hashCode();
    }
}
