package com.rockmanjoe.algorithms;

public class DataValidator {
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++)
            if (array[i] > array[i+1])
                return false;
        return true;
    }
}
