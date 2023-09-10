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
        var array = list.toArray(new PlayingCard[0]);

        // Act
        var quickSort = new QuickSort();
        quickSort.sort(array);

        // Assert
        var dataValidator = new DataValidator();
        assertTrue(dataValidator.areSorted(array),
                "Array is not sorted: " + Arrays.toString(array));
    }
}
