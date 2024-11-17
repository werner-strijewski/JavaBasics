package org.strijewski.basics.structures.hashTable;

class HashNode<K, V> {
    K key;
    V value;
    HashNode<K, V> next;

    // Constructor
    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}