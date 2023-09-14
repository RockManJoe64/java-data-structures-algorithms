package com.rockmanjoe.datastructures;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {
    private final ArrayList<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public Heap(int[] heap) {
        this.heap = new ArrayList<>(heap.length);
        for (int value : heap) {
            this.heap.add(value);
        }
    }

    public void heapify() {
        heapify(0);
    }

    public void heapify(int i) {
        int n = heap.size();
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // Find the largest element among root, left child and right child
        if(left < n && heap.get(left) > heap.get(largest)) {
            largest = left;
        }
        if(right < n && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        if (largest != i) { // Swap and continue heapify-ing if root is not largest
            Collections.swap(heap, i, largest);
            heapify(largest);
        }
    }

    /**
     * Starting from the parent of the last element, heapify all parents.
     * In the case of a complete tree, the first index of a non-leaf node is given by n/2 - 1.
     * All other nodes after that are leaf-nodes and thus don't need to be heapified.
     */
    private void heapifyAllParentNodes() {
        int n = heap.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public void insert(int value) {
        heap.add(value);
        heapifyAllParentNodes();
    }

    public void delete(int value) {
        int n = heap.size();
        int index = -1;

        // Find the value to delete
        // TODO can this be optimized?
        for (int i = 0; i < n; i++) {
            if (value == heap.get(i)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return; // Value not found so do nothing
        }

        // Swap the value to delete with the last element, then remove the last element
        Collections.swap(heap, index, n - 1);
        heap.remove(n - 1);
        heapifyAllParentNodes();
    }

    public int getMax() {
        return heap.get(0);
    }

    public int deleteMax() throws HeapException {
        int n = heap.size();
        if (n == 0) throw new HeapException("Heap is empty");

        Collections.swap(heap, 0, n - 1);
        var value = heap.remove(n - 1);
        heapify(0);

        return value;
    }

    public String toString() {
        var builder = new StringBuilder();

        var n = heap.size();
        var height = (int) Math.ceil(Math.log(n) / Math.log(2));
        var index = 0;
        for (var i = 0; i < height; i++) {
            var padding = (int) Math.pow(2, height - i - 1);
            builder.append(" ".repeat(Math.max(0, padding)));
            for (var j = 0; j < Math.pow(2, i); j++) {
                if (index < n) {
                    builder.append(heap.get(index++));
                }
                builder.append(" ".repeat(Math.max(0, padding * 2 - 1)));
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}
