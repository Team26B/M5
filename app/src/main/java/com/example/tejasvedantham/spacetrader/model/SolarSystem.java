package com.example.tejasvedantham.spacetrader.model;

import java.sql.ResultSet;

public class SolarSystem {
    private String name;
    private Coordinate location;
    private TechLevel techLevel;
    private Resource resource;

    public SolarSystem(String name, Coordinate coordinate, TechLevel techLevel, Resource resource) {
        this.name = name;
        this.location = coordinate;
        this.techLevel = techLevel;
        this.resource = resource;
    }
    public SolarSystem(String name, Coordinate coordinate) {
        this.name = name;
        this.location = coordinate;
        this.techLevel = TechLevel.PREAGRICULTURE;
        this.resource = Resource.NOSPECIALRESOURCES;
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

    public boolean Equals(SolarSystem otherSS) {
        return this.getLocation().equals(otherSS.getLocation());
    }
}
