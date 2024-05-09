package personalExercises;
    import java.util.*;

    public class DepthFirstSearch {

        static class Graph {
            private int V; // Number of vertices
            private LinkedList<Integer>[] adjList; // Adjacency list representation

            public Graph(int V) {
                this.V = V;
                adjList = new LinkedList[V];
                for (int i = 0; i < V; i++) {
                    adjList[i] = new LinkedList<>();
                }
            }

            // Add an edge to the graph
            public void addEdge(int v, int w) {
                adjList[v].add(w);
            }

            // Depth-First Search traversal starting from a given vertex
            public void DFS(int v) {
                boolean[] visited = new boolean[V]; // Mark all vertices as not visited
                DFSUtil(v, visited); // Call the recursive helper function to perform DFS
            }

            // Recursive function to perform DFS traversal
            private void DFSUtil(int v, boolean[] visited) {
                visited[v] = true; // Mark the current vertex as visited
                System.out.print(v + " "); // Print the vertex

                // Recur for all the vertices adjacent to this vertex
                Iterator<Integer> iterator = adjList[v].iterator();
                while (iterator.hasNext()) {
                    int n = iterator.next();
                    if (!visited[n]) {
                        DFSUtil(n, visited); // Recursive call for adjacent vertices
                    }
                }
            }
        }

        public static void main(String[] args) {
            Graph graph = new Graph(4);

            // Add edges to the graph
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(1, 2);
            graph.addEdge(2, 0);
            graph.addEdge(2, 3);
            graph.addEdge(3, 3);

            System.out.println("Depth-First Search (DFS) traversal starting from vertex 2:");
            graph.DFS(2);
        }
    }

