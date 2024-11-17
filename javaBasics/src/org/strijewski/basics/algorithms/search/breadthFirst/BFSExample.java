package org.strijewski.basics.algorithms.search.breadthFirst;

public class BFSExample {
    public static void main(String[] args) {
        Graph graph = new Graph(6); // Create a graph with 6 vertices

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        System.out.println("Graph adjacency list:");
        graph.displayGraph();

        // Perform BFS
        System.out.println("Performing BFS from vertex 0:");
        graph.bfs(0);
    }
}