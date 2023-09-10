package com.rockmanjoe.algorithms.sortable;

import java.util.Comparator;

public class PlayingCard implements Comparable<PlayingCard> {
    private final Suit suit;
    private final Rank rank;

    public PlayingCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }

    @Override
    public int compareTo(PlayingCard playingCard) {
        var bySuit = this.suit.compareTo(playingCard.suit);
        return bySuit == 0 ?
                this.rank.compareTo(playingCard.rank) : bySuit;
    }

    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }
}
