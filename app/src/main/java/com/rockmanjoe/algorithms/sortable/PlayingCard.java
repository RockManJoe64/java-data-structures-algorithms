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
    public int compareTo(PlayingCard playingCard) {
        return this.rank.compareTo(playingCard.rank);
    }

    public static enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    public static enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }
}
