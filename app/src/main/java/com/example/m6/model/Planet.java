package com.example.m6.model;

import java.io.Serializable;

public class Planet implements Serializable {
    private String name;
    private double goodsPrice;
    private int coordinateX, coordinateY;
    private int techLevel;
    private int resource;

    public Planet(String name, int coordinateX, int coordinateY, int techLevel, int resource) {
        this(name, 0, coordinateX, coordinateY, techLevel, resource);
    }
    public Planet(String name, double goodsPrice, int coordinateX, int coordinateY, int techLevel, int resource) {

        this.name = name;
        this.goodsPrice = goodsPrice;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.techLevel = techLevel;
        this.resource = resource;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getGoodsPrice() {
        return goodsPrice;
    }
    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
    public int getCoordinateX() {
        return coordinateX;
    }
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }
    public int getCoordinateY() {
        return coordinateY;
    }
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public int getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(int techLevel) {
        this.techLevel = techLevel;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}
