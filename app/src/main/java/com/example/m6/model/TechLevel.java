package com.example.m6.model;

public enum TechLevel {
    PRE_AGRICULTURE(0),
    AGRICULTURE(1),
    MEDIEVAL(2),
    RENAISSANCE(3),
    EARLY_INDUSTRIAL(4),
    INDUSTRIAL(5),
    POST_INDUSTRIAL(6),
    HI_TECH(7);

    private int code;

    TechLevel(int num) {
        code = num;
    }
    public int getnumber(){
        return code;
    }
}