package com.example.m6.model;

public enum Spaceship {
    GNAT(15);

    private int bay;
    Spaceship(int bay) {
        this.bay = bay;
    }
    public int getBay(){
        return bay;
    }
}

