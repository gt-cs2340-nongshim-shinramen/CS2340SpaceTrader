package com.example.m6.model;

public enum Goods {
    WATER(0,0,2,30,3,4,"DROUGHT","LOSOFWATER","DESERT",30,50),
    FURS(0,0,0,250,10,10,"COLD","RICHFAUNA","LIFELESS",230,280),
    FOOD(1,0,1,100,5,5,"CROPFAIL","RICHSOIL","POORSOIL",90,160),
    ORE(2,2,3,350,20,10,"WAR","MINERALRICH","MINERALPOOR",350,420),
    GAMES(3,1,6,250,-10,5,"BOREDOM","ARTISTIC","NEVER",160,270),
    FIREARMS(3,1,5,1250,-75,100,"WAR","WARLIKE","NEVER",600,1100),
    MEDICINE(4,1,6,650,-20,10,"PLAGUE","LOTSOFHERBS","NEVER",400,700),
    MACHINES(4,3,5,900,-30,5,"LACKOFWORKERS","NEVER","NEVER",600,800),
    NARCOTICS(5,0,5,3500,-125,150,"BOREDOM","WEIRDMUSHROOMS","NEVER",2000,3000),
    ROBOTS(6,4,7,5000,-150,100,"LACKOFWORKERS","NEVER","NEVER",3500,5000);


    int MTLP;
    int MTLU;
    int TTP;
    int IPL;
    int basePrice;
    int Var;
    String IE;
    String CR;
    String ER;
    int MTL;
    int MTH;


    Goods(int mtlp, int mtlu, int ttp, int baseprice, int ipl, int var,
                 String ie, String cr, String er, int mtl, int mth) {
        MTLP = mtlp;
        MTLU = mtlu;
        TTP = ttp;
        basePrice = baseprice;
        IPL = ipl;
        Var = var;
        IE = ie;
        CR = cr;
        ER = er;
        MTL = mtl;
        MTH = mth;
    }

    public int getMTLP() { return MTLP; }
    public int getMTLU() {
        return MTLU;
    }
    public int getTTP() {
        return TTP;
    }
    public int getIPL() {
        return IPL;
    }
    public int getBasePrice() {
        return basePrice;
    }
    public int getVar() {
        return Var;
    }
    public String getIE() {
        return IE;
    }
    public String getCR() {
        return CR;
    }
    public String getER() {
        return ER;
    }
    public int getMTL() {
        return MTL;
    }
    public int getMTH() {
        return MTH;
    }
}
