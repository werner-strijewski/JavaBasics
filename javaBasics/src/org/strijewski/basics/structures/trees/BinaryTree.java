package org.strijewski.basics.structures.trees;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    // Constructor
    public BinaryTree() {
        this.root = null;
    }

    // Insert a node into the binary tree
    public void insert(T data) {
        root = insertRecursive(root, data);
    }

    private Node<T> insertRecursive(Node<T> current, T data) {
        if (current == null) {
            return new Node<>(data);
        }

        if (data.compareTo(current.data) < 0) {
            current.left = insertRecursive(current.left, data); // Go to the left subtree
        } else if (data.compareTo(current.data) > 0) {
            current.right = insertRecursive(current.right, data); // Go to the right subtree
        }

        return current; // Return unchanged node
    }

    // Search for a value in the binary tree
    public boolean search(T data) {
        return searchRecursive(root, data);
    }

    private boolean searchRecursive(Node<T> current, T data) {
        if (current == null) {
            return false; // Base case: node not found
        }

        if (data.equals(current.data)) {
            return true; // Node found
        }

        return data.compareTo(current.data) < 0
                ? searchRecursive(current.left, data) // Search in the left subtree
                : searchRecursive(current.right, data); // Search in the right subtree
    }

    // Inorder Traversal (Left, Root, Right)
    public void inorderTraversal() {
        System.out.print("Inorder Traversal: ");
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(Node<T> current) {
        if (current != null) {
            inorderRecursive(current.left);
            System.out.print(current.data + " ");
            inorderRecursive(current.right);
        }
    }

    // Preorder Traversal (Root, Left, Right)
    public void preorderTraversal() {
        System.out.print("Preorder Traversal: ");
        preorderRecursive(root);
        System.out.println();
    }

    private void preorderRecursive(Node<T> current) {
        if (current != null) {
            System.out.print(current.data + " ");
            preorderRecursive(current.left);
            preorderRecursive(current.right);
        }
    }

    // Postorder Traversal (Left, Right, Root)
    public void postorderTraversal() {
        System.out.print("Postorder Traversal: ");
        postorderRecursive(root);
        System.out.println();
    }

    private void postorderRecursive(Node<T> current) {
        if (current != null) {
            postorderRecursive(current.left);
            postorderRecursive(current.right);
            System.out.print(current.data + " ");
        }
    }

    // Main method for demonstration
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        // Insert nodes
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        // Traversals
        tree.inorderTraversal();   // Output: 20 30 40 50 60 70 80
        tree.preorderTraversal(); // Output: 50 30 20 40 70 60 80
        tree.postorderTraversal(); // Output: 20 40 30 60 80 70 50

        // Search for values
        System.out.println("Search 40: " + tree.search(40)); // Output: true
        System.out.println("Search 100: " + tree.search(100)); // Output: false
    }
}