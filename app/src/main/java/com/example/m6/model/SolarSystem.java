package com.example.m6.model;

import java.io.Serializable;

public class SolarSystem implements Serializable {
    private String name;
    private int coordinate_x;
    private int coordinate_y;
    private int techLevel;
    private int resource;
    private TechLevel techLevelValue;
    private Resource resourceValue;
    private Planet planet;
    SolarSystem(String name, int x, int y, int techLevel, int resource) {
        this.planet = new Planet(name, x, y, techLevel, resource);
        this.name = name;
        coordinate_x = x;
        coordinate_y = y;
        this.techLevel = techLevel;
        this.resource = resource;
        resourceValue = Resource.values()[resource];
        techLevelValue = TechLevel.values()[techLevel];
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCoordinate_x() {
        return coordinate_x;
    }
    public void setCoordinate_x(int coordinate_x) {
        this.coordinate_x = coordinate_x;
    }
    public int getCoordinate_y() {
        return coordinate_y;
    }
    public void setCoordinate_y(int coordinate_y) {
        this.coordinate_y = coordinate_y;
    }
    public int getTechLevel() {
        return techLevel;
    }
    public void setTechLevel(int techLevel) {
        this.techLevel = techLevel;
    }
    public TechLevel getTechLevelValue() {
        return techLevelValue;
    }
    public int getResource() {
        return resource;
    }
    public void setResource(int resource) {
        this.resource = resource;
    }
    public Resource getResourceValue() {
        return resourceValue;
    }

    public Planet getPlanet() {
        return planet;
    }

    public String toString(){
        return name+", ("+coordinate_x+", "+coordinate_y+"), techLevel " +techLevel + " " + techLevelValue +", resource : "+resource + " " + resourceValue;
    }
}
