package com.rockmanjoe.datastructures;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeapTests {
    @Test
    public void givenArray_whenHeapify_shouldHeapify() {
        // Arrange
        var array = new int[]{1, 12, 9, 5, 6, 10};
        var heap = new Heap(array);

        // Act
        heap.heapify();
        System.out.println("Heapified array:");
        System.out.println(heap);

        // Assert
        assertThat(heap.getMax()).isEqualTo(12);
    }

    @Test
    public void givenArray_whenInsertNumber_shouldHeapify() {
        // Arrange
        var array = new int[]{1, 12, 9, 5, 6, 10};
        var heap = new Heap(array);
        heap.heapify();

        // Act
        heap.insert(20);

        // Assert
        assertThat(heap.getMax()).isEqualTo(20);
    }

    @Test
    public void givenArray_whenDelete_shouldHeapify() throws HeapException {
        // Arrange
        var array = new int[]{1, 12, 9, 5, 6, 10};
        var heap = new Heap(array);
        heap.heapify();

        // Act
        heap.delete(12);

        // Assert
        assertThat(heap.getMax()).isEqualTo(10);
    }

    @Test
    public void givenArray_whenDeleteMax_shouldHeapify() throws HeapException {
        // Arrange
        var array = new int[]{1, 12, 9, 5, 6, 10};
        var heap = new Heap(array);
        heap.heapify();

        // Act
        var value = heap.deleteMax();

        // Assert
        assertThat(value).isEqualTo(12);
        assertThat(heap.getMax()).isEqualTo(10);
    }
}
