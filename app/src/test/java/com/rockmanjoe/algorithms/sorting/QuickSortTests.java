package com.rockmanjoe.algorithms.sorting;

import com.rockmanjoe.algorithms.DataValidator;
import com.rockmanjoe.algorithms.sortable.Deck;
import com.rockmanjoe.algorithms.sortable.PlayingCard;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuickSortTests {
    private final NumberFormat numberFormat = NumberFormat.getInstance();

    @Test
    public void givenExampleArray_whenQuickSort_shouldSort() {
        // Arrange
        var deck = new Deck();
        var list = deck.getCardsList();
        Collections.shuffle(list);
        var array = deck.getCards();

        System.out.println("Deck before sorting:");
        deck.printDeck();

        // Act
        var quickSort = new QuickSort();
        quickSort.sort(array);

        // Assert
        var dataValidator = new DataValidator();
        assertTrue(dataValidator.areSorted(array),
                "Deck is not sorted: " + Arrays.toString(array));

        System.out.println("Deck after sorting:");
        deck.printDeck();
    }
}
