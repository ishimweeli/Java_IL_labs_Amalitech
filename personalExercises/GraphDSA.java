package personalExercises;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

    public class GraphDSA {
        static class Graph {
            int numVertices;
            List<List<Integer>> adjacencyList;

            Graph(int vertices) {
                numVertices = vertices;
                adjacencyList = new ArrayList<>(vertices);

                for (int i = 0; i < vertices; i++) {
                    adjacencyList.add(new ArrayList<>());
                }
            }

            void addEdge(int source, int destination) {
                adjacencyList.get(source).add(destination);
                adjacencyList.get(destination).add(source); // Uncomment this line for undirected graphs
            }

            void bfs(int startVertex) {
                boolean[] visited = new boolean[numVertices];
                Queue<Integer> queue = new LinkedList<>();

                visited[startVertex] = true;
                queue.offer(startVertex);

                while (!queue.isEmpty()) {
                    int currentVertex = queue.poll();
                    System.out.print(currentVertex + " ");

                    for (int neighbor : adjacencyList.get(currentVertex)) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }

        public static void main(String[] args) {
            Graph graph = new Graph(6);

            graph.addEdge(0, 1);
            graph.addEdge(0, 4);
            graph.addEdge(1, 2);
            graph.addEdge(1, 3);
            graph.addEdge(1, 4);
            graph.addEdge(2, 3);
            graph.addEdge(3, 4);
            graph.addEdge(3, 5);

            System.out.println("Breadth-First Search traversal: ");
            graph.bfs(0);
        }
    }

