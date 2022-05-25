package com.example.grafjava;

import javafx.scene.layout.GridPane;

import java.util.*;

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

    public static double colorDistance(Graph graph, Node[] buttons){
        double max = 0;
        GraphMenager gm = new GraphMenager();
        for(Double d : distance){
            if(d>max && !d.equals(Double.POSITIVE_INFINITY)){
                max = d;
            }
        }
        for(int i = 0; i<graph.rows* graph.cols;i++){
            if (distance[i] > max) {
                buttons[i].setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000; -fx-border-radius: 144px");
                continue;
            }
            gm.setColor(buttons[i],distance[i],max);
        }
        return max;
    }

    public static double showPath(Graph graph, int start, Node[] buttons, HashMap<GraphEdge, Edge> pickEdge) {
        int curr = start;
        int next;
        while (curr != graph.chosen) {
            buttons[curr].setStyle("-fx-background-color: #444444");
            next = parents[curr];
            for (GraphEdge edge: graph.neighbours[curr]) {
                if (edge.node == next) {
                    pickEdge.get(edge).setStyle("-fx-background-color: #444444");
                }
            }
            curr = next;
        }
        return distance[start];
    }
}
