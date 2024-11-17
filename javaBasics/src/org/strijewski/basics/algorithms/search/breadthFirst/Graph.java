package org.strijewski.basics.algorithms.search.breadthFirst;

import java.util.LinkedList;
import java.util.Queue;

class Graph {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list

    // Constructor
    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph (undirected)
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); // For undirected graph
    }

    // Breadth-First Search starting from a given source vertex
    public void bfs(int start) {
        boolean[] visited = new boolean[vertices]; // Track visited vertices
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS

        // Start from the source vertex
        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            // Traverse all adjacent vertices
            for (int neighbor : adjacencyList[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Display the adjacency list
    public void displayGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for (int neighbor : adjacencyList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}