package com.rockmanjoe.algorithms.sorting;

public class MergeSort {
    public static void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int low, int high) {
        if (low < high) { // If there is more than one element in the array
            var middle = (low + high) / 2;
            mergeSort(array, low, middle); // Keep dividing the left tree
            mergeSort(array, middle + 1, high); // Keep dividing the right tree
            merge(array, low, middle, high); // We merge the left and right trees and sort
        }
    }

    private static void merge(int[] array, int low, int middle, int high) {
        // We create two temporary arrays to store the left and right trees
        var left = new int[middle - low + 1];
        var right = new int[high - middle];

        System.arraycopy(array, low, left, 0, left.length);
        System.arraycopy(array, middle + 1, right, 0, right.length);

        var i = 0;
        var j = 0;
        var k = low;

        // We compare the elements of the left and right trees and merge them in the correct order
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // We copy the remaining elements of the left and right trees
        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}
