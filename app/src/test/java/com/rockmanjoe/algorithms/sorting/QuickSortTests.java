package com.rockmanjoe.algorithms.sorting;

import com.rockmanjoe.algorithms.DataGenerator;
import com.rockmanjoe.algorithms.DataValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuickSortTests {
    @Test
    public void givenExampleArray_whenQuickSort_shouldSort() {
        // Arrange
        var array = new int[]{7, 2, 1, 6, 8, 5, 3, 4};

        // Act
        QuickSort.sort(array);

        // Assert
        assertTrue(DataValidator.isSorted(array));
    }

    @ParameterizedTest
    @MethodSource("provideNumberArrays")
    public void givenArrayOfInts_whenQuickSort_shouldSort(int[] array) {
        System.out.println("Array size: " + array.length);

        // Act
        var start = Instant.now();

        QuickSort.sort(array);

        var end = Instant.now();
        var duration = Duration.between(start, end).toNanos();
        System.out.println("QuickSort took " + duration + " nanoseconds");

        // Assert
        assertTrue(DataValidator.isSorted(array));
    }

    public static Stream<Arguments> provideNumberArrays() {
        var randomArray = DataGenerator.generateRandomArray(1000);
        var shuffledArray = DataGenerator.generateShuffledArray(1000);

        return Stream.of(
                Arguments.of(randomArray),
                Arguments.of(shuffledArray)
        );
    }
}
