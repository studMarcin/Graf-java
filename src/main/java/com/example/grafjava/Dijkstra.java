package com.example.grafjava;

import javafx.scene.layout.GridPane;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra {

    static double[] distance;
    static int[] parents;

    static class Cmp implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return Double.compare(distance[o1], distance[o2]);
        }
    }

    public static double[] dijkstra(Graph graph) {
        int size = graph.cols * graph.rows;
        distance = new double[size];
        parents = new int[size];

        Cmp cmp = new Cmp();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(size, cmp);

        for (int i = 0; i < size; i++) {
            distance[i] = Double.POSITIVE_INFINITY;
            parents[i] = -1;
        }

        distance[graph.chosen] = 0.0;
        priorityQueue.add(graph.chosen);

        int u;

        while(!priorityQueue.isEmpty()) {

            u = priorityQueue.poll();
            for (GraphEdge edge: graph.neighbours[u]) {
                if (distance[edge.node] > distance[u] + edge.wage) {
                    distance[edge.node] = distance[u] + edge.wage;
                    parents[edge.node] = u;
                    priorityQueue.add(edge.node);
                }
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.println("Droga do wierzchołka " + i + " wynosi: " + distance[i]);
            //System.out.println(node.prev);
        }

        return distance;
    }


    public static void showPath(Graph graph, int start, Node[] buttons, HashMap<GraphEdge, Edge> pickEdge) {
        int curr = start;
        int next;
        while (curr != graph.chosen) {
            buttons[curr].setId("path");
            next = parents[curr];
            for (GraphEdge edge: graph.neighbours[curr]) {
                if (edge.node == next) {
                    pickEdge.get(edge).setId("path");
                }
            }
            curr = next;
        }
    }
}
