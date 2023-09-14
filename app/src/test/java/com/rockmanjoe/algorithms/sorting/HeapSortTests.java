package com.rockmanjoe.algorithms.sorting;

import com.rockmanjoe.algorithms.DataGenerator;
import com.rockmanjoe.algorithms.DataValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeapSortTests {
    private final NumberFormat numberFormat = NumberFormat.getInstance();
    
    @Test
    public void givenExampleArray_whenHeapSort_shouldSort() {
        // Arrange
        var array = new int[]{1, 12, 9, 5, 6, 10};

        // Act
        HeapSort.sort(array);

        // Assert
        assertTrue(DataValidator.isSorted(array),
                "Array is not sorted: " + Arrays.toString(array));
    }

    @ParameterizedTest
    @MethodSource("provideRandomNumberArrays")
    public void givenRandomArrayOfInts_whenHeapSort_shouldSort(int[] array) {
        System.out.println("Array size: " + numberFormat.format(array.length));

        // Act
        var start = Instant.now();

        HeapSort.sort(array);

        var end = Instant.now();
        var duration = Duration.between(start, end).toNanos();
        System.out.println("HeapSort took " + numberFormat.format(duration) + " nanoseconds");

        // Assert
        assertTrue(DataValidator.isSorted(array),
                "Array is not sorted: " + Arrays.toString(array));
    }

    public static Stream<Arguments> provideRandomNumberArrays() {
        return Stream.of(
                Arguments.of(DataGenerator.generateRandomArray(1000)),
                Arguments.of(DataGenerator.generateRandomArray(100_000)),
                Arguments.of(DataGenerator.generateRandomArray(1_000_000))
        );
    }

    @ParameterizedTest
    @MethodSource("provideShuffledNumberArrays")
    public void givenShuffledArrayOfInts_whenHeapSort_shouldSort(int[] array) {
        System.out.println("Array size: " + numberFormat.format(array.length));

        // Act
        var start = Instant.now();

        HeapSort.sort(array);

        var end = Instant.now();
        var duration = Duration.between(start, end).toNanos();
        System.out.println("HeapSort took " + numberFormat.format(duration) + " nanoseconds");

        // Assert
        assertTrue(DataValidator.isSorted(array),
                "Array is not sorted: " + Arrays.toString(array));
    }

    public static Stream<Arguments> provideShuffledNumberArrays() {
        return Stream.of(
                Arguments.of(DataGenerator.generateShuffledArray(1000)),
                Arguments.of(DataGenerator.generateShuffledArray(100_000)),
                Arguments.of(DataGenerator.generateShuffledArray(1_000_000))
        );
    }
}
