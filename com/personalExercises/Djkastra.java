package com.personalExercises;

import java.util.*;

public class Djkastra {

    public static class Node implements Comparable<Node> {
        private String name;
        private int distance = Integer.MAX_VALUE;
        private List<Node> shortestPath = new LinkedList<>();
        private Map<Node, Integer> adjacentNodes = new HashMap<>();
        public Node(String name) {
            this.name = name;
        }

        public void addAdjacentNode(Node node, int weight) {
            adjacentNodes.put(node, weight);
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.distance, node.distance);
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public List<Node> getShortestPath() {
            return shortestPath;
        }

        public void setShortestPath(List<Node> shortestPath) {
            this.shortestPath = shortestPath;
        }

        public Map<Node, Integer> getAdjacentNodes() {
            return adjacentNodes;
        }
    }

    public void calculateShortestPath(Node source) {
        source.setDistance(0);
        Set<Node> settledNodes = new HashSet<>();
        Queue<Node> unsettledNodes = new PriorityQueue<>(Collections.singleton(source));

        while (!unsettledNodes.isEmpty()) {
            Node currentNode = unsettledNodes.poll();
            currentNode.getAdjacentNodes().entrySet().stream()
                    .filter(entry -> !settledNodes.contains(entry.getKey()))
                    .forEach(entry -> {
                        evaluateDistanceAndPath(entry.getKey(), entry.getValue(), currentNode);
                        unsettledNodes.add(entry.getKey());
                    });
            settledNodes.add(currentNode);
        }
    }

    public void evaluateDistanceAndPath(Node adjacent, int edgeWeight, Node sourceNode) {
        int newDistance = sourceNode.getDistance() + edgeWeight;
        if (newDistance < adjacent.getDistance()) {
            adjacent.setDistance(newDistance);
            List<Node> updatedShortestPath = new ArrayList<>(sourceNode.getShortestPath());
            updatedShortestPath.add(sourceNode);
            adjacent.setShortestPath(updatedShortestPath);
        }
    }
    public static void main(String[] args) {
        Djkastra dijkstra = new Djkastra();


        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");

        nodeA.addAdjacentNode(nodeB, 5);
        nodeA.addAdjacentNode(nodeC, 3);
        nodeB.addAdjacentNode(nodeC, 2);

        dijkstra.calculateShortestPath(nodeA);

        // Print the shortest path from A to C
        List<Node> shortestPath = nodeC.getShortestPath();
        System.out.print("Shortest path from A to C: ");
        for (Node node : shortestPath) {
            System.out.print(node.name + " -> ");
        }
        // Print the last node without "->"
        System.out.println(nodeC.name);
    }

}