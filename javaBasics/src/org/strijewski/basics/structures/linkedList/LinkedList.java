package org.strijewski.basics.structures.linkedList;

public class LinkedList<T> {
    private Node<T> head; // Head of the list

    // Constructor
    public LinkedList() {
        this.head = null;
    }

    // Add a new element to the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode; // Set the head if the list is empty
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next; // Traverse to the last node
            }
            current.next = newNode; // Add the new node at the end
        }
    }

    // Remove an element by value
    public void remove(T data) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        // If the head needs to be removed
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        // Traverse the list to find the node to remove
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Element not found!");
        } else {
            current.next = current.next.next; // Remove the node
        }
    }

    // Display all elements in the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Find if an element exists in the list
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true; // Element found
            }
            current = current.next;
        }
        return false; // Element not found
    }

    // Get the size of the list
    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Clear the entire list
    public void clear() {
        head = null;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Initial List:");
        list.display();

        System.out.println("Contains 20? " + list.contains(20));
        System.out.println("Contains 40? " + list.contains(40));

        list.remove(20);
        System.out.println("After removing 20:");
        list.display();

        System.out.println("Size of the list: " + list.size());

        list.clear();
        System.out.println("After clearing the list:");
        list.display();
    }
}
