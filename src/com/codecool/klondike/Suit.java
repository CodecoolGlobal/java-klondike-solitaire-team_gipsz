package com.codecool.klondike;


public enum Suit {
        HEARTS,
        DIAMONDS,
        SPADES,
        CLUBS;


    public String lowerCaseName() {
        return toString().toLowerCase();
    }
}