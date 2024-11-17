package org.strijewski.basics.algorithms.search.binary;

public class BinarySearch {

    // Iterative implementation of Binary Search
    public static int binarySearchIterative(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevents overflow

            // Check if the target is at mid
            if (array[mid] == target) {
                return mid; // Target found
            }

            // Adjust search range
            if (target < array[mid]) {
                right = mid - 1; // Target is in the left half
            } else {
                left = mid + 1; // Target is in the right half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;

        int result = binarySearchIterative(sortedArray, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }
}