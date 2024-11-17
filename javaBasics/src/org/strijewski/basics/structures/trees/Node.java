package org.strijewski.basics.structures.trees;

class Node<T extends Comparable<T>> {
    T data;
    Node<T> left;
    Node<T> right;

    // Constructor
    Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}