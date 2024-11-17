package org.strijewski.basics.structures.arrayList;

public class CustomArrayList<T> {
    private Object[] elements;  // Array to store the elements
    private int size;           // Current number of elements
    private static final int DEFAULT_CAPACITY = 10; // Initial capacity

    // Constructor
    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Add an element to the end of the list
    public void add(T data) {
        ensureCapacity();
        elements[size++] = data;
    }

    // Get an element at a specific index
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    // Remove an element at a specific index
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkIndex(index);
        T removedElement = (T) elements[index];

        // Shift elements to the left
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[--size] = null; // Avoid memory leaks
        return removedElement;
    }

    // Get the current size of the list
    public int size() {
        return size;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Ensure the array has enough capacity; resize if needed
    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }

    // Check if the index is valid
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Display all elements in the list
    public void display() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // Main method for demonstration
    public static void main(String[] args) {
        CustomArrayList<Integer> arrayList = new CustomArrayList<>();

        // Add elements
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        System.out.println("ArrayList after adding elements:");
        arrayList.display(); // Output: [10, 20, 30]

        // Access elements
        System.out.println("Element at index 1: " + arrayList.get(1)); // Output: 20

        // Remove an element
        System.out.println("Removed element: " + arrayList.remove(1)); // Output: 20
        System.out.println("ArrayList after removing element:");
        arrayList.display(); // Output: [10, 30]

        // Check size and emptiness
        System.out.println("Size: " + arrayList.size()); // Output: 2
        System.out.println("Is empty? " + arrayList.isEmpty()); // Output: false

        // Clear the list by removing all elements
        arrayList.remove(0);
        arrayList.remove(0);
        System.out.println("Is empty after clearing? " + arrayList.isEmpty()); // Output: true
    }
}
