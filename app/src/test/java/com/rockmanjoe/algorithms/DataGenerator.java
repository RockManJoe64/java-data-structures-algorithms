package com.rockmanjoe.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public final class DataGenerator {
    public static int[] generateSortedArray(int size) {
        var array = new int[size];
        for (var i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static int[] generateRandomArray(int size) {
        var array = new int[size];
        for (var i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * size);
        }
        return array;
    }

    public static int[] generateShuffledArray(int size) {
        var shuffledList = Arrays.stream((DataGenerator.generateSortedArray(size)))
                .boxed()
                .toList();
        shuffledList = new LinkedList<>(shuffledList);

        Collections.shuffle(shuffledList);

        return shuffledList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
