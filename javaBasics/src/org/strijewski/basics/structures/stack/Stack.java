package org.strijewski.basics.structures.stack;

// Define the Stack class
public class Stack<T> {
    private T[] elements;   // Array to hold stack elements
    private int size;       // Current size of the stack
    private static final int DEFAULT_CAPACITY = 10; // Initial capacity of the stack

    // Constructor
    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (T[]) new Object[DEFAULT_CAPACITY]; // Create an array of generic type
        size = 0;
    }

    // Push an element onto the stack
    public void push(T data) {
        if (size == elements.length) {
            resize(); // Resize array if it's full
        }
        elements[size++] = data; // Add the element and increase the size
    }

    // Pop an element off the stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T topElement = elements[--size]; // Decrease size and get the top element
        elements[size] = null;          // Avoid memory leaks
        return topElement;
    }

    // Peek at the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[size - 1];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the current size of the stack
    public int size() {
        return size;
    }

    // Resize the stack's internal array when full
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newElements = (T[]) new Object[elements.length * 2]; // Double the capacity
        System.arraycopy(elements, 0, newElements, 0, size);     // Copy old elements
        elements = newElements;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack size: " + stack.size()); // Output: 3

        // Peek at the top element
        System.out.println("Top element: " + stack.peek()); // Output: 30

        // Pop elements off the stack
        System.out.println("Popped: " + stack.pop()); // Output: 30
        System.out.println("Popped: " + stack.pop()); // Output: 20

        System.out.println("Stack size after popping: " + stack.size()); // Output: 1

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false

        // Pop the last element
        System.out.println("Popped: " + stack.pop()); // Output: 10

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: true
    }
}

