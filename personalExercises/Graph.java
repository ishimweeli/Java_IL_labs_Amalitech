package personalExercises;

import java.util.*;

// Class to represent a graph
class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adjList; // Array of lists to store adjacency lists

    // Constructor
    Graph(int vertices) {
        V = vertices;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Function to add an edge between two vertices
    void addEdge(int v, int w) {
        adjList[v].add(w); // Add w to v's list
        adjList[w].add(v); // Add v to w's list (for undirected graph)
    }

    // Function to print the adjacency list representation of the graph
    void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + " is connected to:");
            for (Integer vertex : adjList[i]) {
                System.out.print(" " + vertex);
            }
            System.out.println();
        }
    }
}



