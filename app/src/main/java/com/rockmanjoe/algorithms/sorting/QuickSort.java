package com.rockmanjoe.algorithms.sorting;

public class QuickSort {
    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            var pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        var pivot = array[high]; // Selecting the last element as the pivot
        var i = low - 1; // Index of smaller element; indicates the right position of pivot
        for (var j = low; j < high; j++) {
            if (array[j] < pivot) { // If current element is smaller than the pivot
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high); // Swap the pivot with the element at the right position (i + 1)
        return i + 1;
    }

    private static void swap(int[] array, int a, int b) {
        var temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
