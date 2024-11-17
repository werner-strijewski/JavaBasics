package org.strijewski.basics.structures.heap;

/* This heap has the minimum value at the root. */
import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> heap; // Dynamic array to store heap elements

    // Constructor
    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Get the index of the parent of a node
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Get the index of the left child of a node
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // Get the index of the right child of a node
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Insert a new element into the heap
    public void insert(int value) {
        heap.add(value); // Add the new element at the end
        int currentIndex = heap.size() - 1;

        // Bubble up: Maintain the Min-Heap property
        while (currentIndex > 0 && heap.get(currentIndex) < heap.get(parent(currentIndex))) {
            // Swap with parent
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    // Extract the minimum element (root) from the heap
    public int extractMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty!");
        }

        int min = heap.get(0); // The root is the smallest element
        int lastElement = heap.remove(heap.size() - 1); // Remove the last element

        if (!heap.isEmpty()) {
            heap.set(0, lastElement); // Move the last element to the root
            heapifyDown(0); // Restore the heap property
        }

        return min;
    }

    // Heapify down: Restore the Min-Heap property after extraction
    private void heapifyDown(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        // Find the smallest among root, left child, and right child
        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        // If the smallest is not the root, swap and continue heapifying
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Get the minimum element without removing it
    public int getMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty!");
        }
        return heap.get(0);
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Display the heap
    public void display() {
        System.out.println(heap);
    }

    // Main method for demonstration
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        // Insert elements into the heap
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(15);

        System.out.println("Heap after insertions:");
        minHeap.display(); // Output: [5, 15, 10, 20]

        System.out.println("Minimum element: " + minHeap.getMin()); // Output: 5

        System.out.println("Extracted minimum: " + minHeap.extractMin()); // Output: 5
        System.out.println("Heap after extraction:");
        minHeap.display(); // Output: [10, 15, 20]

        System.out.println("Extracted minimum: " + minHeap.extractMin()); // Output: 10
        System.out.println("Heap after extraction:");
        minHeap.display(); // Output: [15, 20]
    }
}
