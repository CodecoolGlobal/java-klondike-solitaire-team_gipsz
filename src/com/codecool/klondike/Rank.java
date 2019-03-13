package com.codecool.klondike;

public enum Rank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;

    public String lowerCaseRank () {
        return toString().toLowerCase();
    }

    public Rank getNextRank() {
        Rank nextRank = null;

        Rank[] allRanks = Rank.values();

        for (int i = 0; i < allRanks.length-1; i++) {
            if (this.equals(allRanks[i])) nextRank = allRanks[i + 1];
        }

        return nextRank;
    }
}
