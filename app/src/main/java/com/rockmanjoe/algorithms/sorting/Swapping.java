package com.rockmanjoe.algorithms.sorting;

public final class Swapping {
    private Swapping() {}

    public static void swap(int[] array, int a, int b) {
        var temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
