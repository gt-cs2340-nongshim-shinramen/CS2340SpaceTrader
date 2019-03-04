package com.example.m6.model;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Universe implements Serializable {

    //Acamar is initial solar system when new player is created.
    String[] nameList = {"Acamar", "Baratas", "Calondia", "Daled", "Exo", "Ferris", "Hades", "Kira", "Lave", "Kimchi"};

    private int x;
    private int y;
    boolean[][] coordinate = new boolean[150][100];
    private List<SolarSystem> system = new ArrayList<>();
    public Universe(){
        int systemCount = 0;
        while(systemCount < 10) {
            x = (int)(Math.random()*150);
            y = (int)(Math.random()*100);
            if(!coordinate[x][y]) {
                system.add(new SolarSystem(nameList[systemCount], x, y, (int)(Math.random()*7), (int)(Math.random()*12)));
                coordinate[x][y]=true;
                systemCount++;
            }
        }
        Log.d("UniverseSystem", system.toString());
    }

    public static void printMap(Universe universe) {
        for (int i = 0; i < 150; i++) {
            for (int j = 0; j < 100; j++) {
                if (universe.getCoordinate()[i][j]) {
                    System.out.print("*("+i+", "+j+")");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public List<SolarSystem> getSystem() {
        return system;
    }
    public boolean[][] getCoordinate(){
        return coordinate;
    }

    public static void printListofSystem(Universe universe) {
        for(SolarSystem e : universe.getSystem()) {
            System.out.println(e.getName()+", ("+e.getCoordinate_x()+", "+e.getCoordinate_y()+"), techLevel " +e.getTechLevel() +" resource : "+e.getResource());
        }
    }


}
