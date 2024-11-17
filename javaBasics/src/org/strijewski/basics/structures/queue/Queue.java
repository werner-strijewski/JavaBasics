package org.strijewski.basics.structures.queue;

public class Queue<T> {
    private Node<T> front; // Front of the queue
    private Node<T> rear;  // Rear of the queue
    private int size;      // Size of the queue

    // Constructor
    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Enqueue: Add an element to the rear of the queue
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);

        if (rear == null) {
            front = rear = newNode; // If the queue is empty, front and rear are the same
        } else {
            rear.next = newNode;   // Add the new node at the rear
            rear = newNode;        // Update the rear pointer
        }

        size++; // Increase size
    }

    // Dequeue: Remove and return the element from the front of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }

        T data = front.data;       // Get the front element
        front = front.next;        // Move the front pointer to the next node

        if (front == null) {       // If the queue becomes empty, set rear to null
            rear = null;
        }

        size--; // Decrease size
        return data;
    }

    // Peek: Return the front element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return front.data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Get the size of the queue
    public int size() {
        return size;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue size: " + queue.size()); // Output: 3
        System.out.println("Front element: " + queue.peek()); // Output: 10

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 10
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 20

        System.out.println("Queue size after dequeuing: " + queue.size()); // Output: 1
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: false

        // Dequeue the last element
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 30
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: true
    }
}