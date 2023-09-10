package com.rockmanjoe.algorithms.sorting;

public class QuickSort {
    public <T extends Comparable<T>> void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if (low < high) {
            var pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        var pivot = array[high]; // Selecting the last element as the pivot
        var i = low - 1; // Index of smaller element; indicates the right position of pivot
        for (var j = low; j < high; j++) {
            if (array[j].compareTo(pivot) < 0) { // If current element is smaller than the pivot
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high); // Swap the pivot with the element at the right position (i + 1)
        return i + 1;
    }

    private <T extends Comparable<T>> void swap(T[] array, int a, int b) {
        var temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
