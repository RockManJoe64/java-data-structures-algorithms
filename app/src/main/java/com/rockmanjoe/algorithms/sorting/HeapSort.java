package com.rockmanjoe.algorithms.sorting;

/**
 * Heap sort is a comparison-based sorting algorithm.
 * It is borrowing the heaping concept from the heap data structure.
 * On every heap iteration, the largest element is swapped with the last element of the heap.
 * The size of the heap is reduced by one, and the heap is re-heapified.
 */
public class HeapSort {
    public static void sort(int[] array) {
        int n = array.length;

        // Build the max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            Swapping.swap(array, 0, i); // Move current root to end of array
            heapify(array, i, 0); // Heapify the reduced heap
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // Find the largest element among root, left child and right child
        if(left < n && array[left] > array[largest]) {
            largest = left;
        }
        if(right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) { // Swap and continue heapify-ing if root is not largest
            Swapping.swap(array, i, largest);
            heapify(array, n, largest);
        }
    }
}
