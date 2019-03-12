package com.example.m6.model;

public enum Resource {

    NOSPECIALRESOURCES(0),
    MINERALRICH(1),
    MINERALPOOR(2),
    DESERT(3),
    LOTSOFWATER(4),
    RICHSOIL(5),
    POORSOIL (6),
    RICHFAUNA(7),
    LIFELESS(8),
    WEIRDMUSHROOMS(9),
    LOTSOFHERBS(10),
    ARTISTIC(11),
    WARLIKE(12),
    DROUGHT(13),
    COLD(14),
    CROPFAIL(15),
    BOREDOM(16),
    WAR(17),
    PLAGUE(18),
    LACKOFWORKERS(19);
    private int code;

    Resource(int n) {
        code = n;
    }

    public int getNumber() {
        return code;
    }

}