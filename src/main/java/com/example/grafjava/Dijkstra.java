package com.example.grafjava;

import java.util.PriorityQueue;

public class Dijkstra {

    public double dijkstra(Graph graph, Node[] buttons) {
        int size = graph.cols * graph.rows;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(size);

        for (int i = 0; i < size; i++) {
            buttons[i].distance = Double.POSITIVE_INFINITY;
            buttons[i].prev = null;
        }

        buttons[graph.chosen].distance = 0.0;
        priorityQueue.add(buttons[graph.chosen]);

        Node u;

        while(!priorityQueue.isEmpty()) {

            u = priorityQueue.poll();
            for (Edge edge: graph.neighbours[u.number]) {
                if (buttons[edge.node].distance > u.distance + edge.wage) {
                    buttons[edge.node].distance = u.distance + edge.wage;
                    buttons[edge.node].prev = u;
                    priorityQueue.add(buttons[edge.node]);
                }
            }
        }

        for (Node node: buttons) {
            System.out.println("Droga do wierzchołka " + node.number + " wynosi: " + node.distance);
            //System.out.println(node.prev);
        }

        // Do testów
        return buttons[size - 1].distance;
    }

    public void showPath(Graph graph, Node start) {
        Node curr = start;
        Node next;
        while (curr.number != graph.chosen) {
            curr.setId("path");
            next = curr.prev;
            for (Edge edge: graph.neighbours[curr.number]) {
                if (edge.node == next.number) {
                    edge.setId("path");
                    for (Edge innerEdge: graph.neighbours[next.number]) {
                        if (innerEdge.node == curr.number) {
                            innerEdge.setId("path");
                            break;
                        }
                    }
                    break;
                }
            }
            curr = next;
        }

    }
}
