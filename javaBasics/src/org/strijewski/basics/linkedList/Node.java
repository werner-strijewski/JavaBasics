package org.strijewski.basics.linkedList;

class Node<T> {
    T data;
    Node<T> next;

    // Constructor
    Node(T data) {
        this.data = data;
        this.next = null;
    }
}
