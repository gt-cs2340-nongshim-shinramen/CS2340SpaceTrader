package com.example.m6.model;

public enum difficulty {
    BEGINNER ("Beginner"),
    EASY ("Easy"),
    NORMAL("Normal"),
    HARD("Hard"),
    IMPOSSIBLE("Impossible");

    private final String difficulty;

    difficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDifficulty(){
        return difficulty;
    }

}
