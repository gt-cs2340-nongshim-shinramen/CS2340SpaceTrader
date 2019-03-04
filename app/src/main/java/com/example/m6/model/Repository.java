package com.example.m6.model;

import java.util.ArrayList;
import java.util.List;

//this class hold player that we created information.
public class Repository {

    private static int next_id = 1;

    private static int getNextUniqueID() {
        return next_id++;
    }

    private List<Player> allPlayers;


    /**
     * Make a new Repository object
     */
    public Repository() {
        allPlayers = new ArrayList<>();

    }

}
