package org.strijewski.basics.structures.hashTable;

import java.util.LinkedList;


public class CustomHashtable<K, V> {
    private LinkedList<HashNode<K, V>>[] buckets; // Array of buckets (linked lists)
    private int capacity;                         // Number of buckets
    private int size;                             // Number of key-value pairs

    private static final int DEFAULT_CAPACITY = 10;

    // Constructor
    @SuppressWarnings("unchecked")
    public CustomHashtable() {
        this.capacity = DEFAULT_CAPACITY;
        this.buckets = new LinkedList[capacity];
        this.size = 0;
    }

    // Hash function to get the index for a key
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    // Put a key-value pair into the hashtable
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new LinkedList<>();
        }

        // Check if the key already exists in the bucket
        for (HashNode<K, V> node : buckets[bucketIndex]) {
            if (node.key.equals(key)) {
                node.value = value; // Update value if key exists
                return;
            }
        }

        // If the key doesn't exist, add a new node
        buckets[bucketIndex].add(new HashNode<>(key, value));
        size++;
    }

    // Get the value for a given key
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode<K, V>> bucket = buckets[bucketIndex];

        if (bucket != null) {
            for (HashNode<K, V> node : bucket) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }
        }
        return null; // Key not found
    }

    // Remove a key-value pair from the hashtable
    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode<K, V>> bucket = buckets[bucketIndex];

        if (bucket != null) {
            for (HashNode<K, V> node : bucket) {
                if (node.key.equals(key)) {
                    bucket.remove(node);
                    size--;
                    return node.value; // Return the removed value
                }
            }
        }
        return null; // Key not found
    }

    // Get the number of key-value pairs in the hashtable
    public int size() {
        return size;
    }

    // Check if the hashtable is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Display all key-value pairs in the hashtable
    public void display() {
        for (int i = 0; i < capacity; i++) {
            if (buckets[i] != null) {
                System.out.print("Bucket " + i + ": ");
                for (HashNode<K, V> node : buckets[i]) {
                    System.out.print("[" + node.key + ": " + node.value + "] -> ");
                }
                System.out.println("null");
            }
        }
    }

    // Main method for demonstration
    public static void main(String[] args) {
        CustomHashtable<String, Integer> hashtable = new CustomHashtable<>();

        // Add key-value pairs
        hashtable.put("Apple", 1);
        hashtable.put("Banana", 2);
        hashtable.put("Orange", 3);
        hashtable.put("Apple", 4); // Update the value for key "Apple"

        // Display the hashtable
        System.out.println("Hashtable after insertions:");
        hashtable.display();

        // Get a value
        System.out.println("Value for 'Apple': " + hashtable.get("Apple")); // Output: 4

        // Remove a key
        System.out.println("Removed value for 'Banana': " + hashtable.remove("Banana"));

        // Display the hashtable
        System.out.println("Hashtable after removal:");
        hashtable.display();

        // Check size and emptiness
        System.out.println("Size: " + hashtable.size()); // Output: 2
        System.out.println("Is empty? " + hashtable.isEmpty()); // Output: false
    }
}