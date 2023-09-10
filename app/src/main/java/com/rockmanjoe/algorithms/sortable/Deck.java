package com.rockmanjoe.algorithms.sortable;

import java.util.Arrays;
import java.util.List;

public class Deck {
    private final PlayingCard[] cards;

    public Deck() {
        cards = new PlayingCard[52];
        int i = 0;
        for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
            for (PlayingCard.Rank rank : PlayingCard.Rank.values()) {
                cards[i++] = new PlayingCard(suit, rank);
            }
        }
    }

    public PlayingCard[] getCards() {
        return cards;
    }

    public List<PlayingCard> getCardsList() {
        return Arrays.asList(cards);
    }
}