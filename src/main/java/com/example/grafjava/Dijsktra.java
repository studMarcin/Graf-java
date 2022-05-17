package com.example.grafjava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node n1, Node n2) {
        return Double.compare(n1.distance, n2.distance);
    }
}

public class Dijsktra {

    PriorityQueue<Node> priorityQueue;

    NodeComparator cmp = new NodeComparator();

    public void dijsktra(Graph graph, Node[] buttons) {
        priorityQueue = new PriorityQueue<>(cmp);

        for (Node node: buttons) {
            node.distance = Double.POSITIVE_INFINITY;
            node.prev = -1;
        }

        buttons[graph.chosen].distance = 0;
        priorityQueue.addAll(Arrays.asList(buttons));

        Node u;

        while(!priorityQueue.isEmpty()) {
            // Do debugowania
            for (Node node: priorityQueue) {
                System.out.print(node.distance + " ");
            }
            System.out.println("\n(" + priorityQueue.peek().distance + ")");

            u = priorityQueue.poll();
            for (Edge edge: graph.neighbours[u.number]) {
                if (buttons[edge.node].distance > u.distance + edge.wage) {
                    buttons[edge.node].distance = u.distance + edge.wage;
                    buttons[edge.node].prev = u.number;
                }
            }
        }

        for (Node node: buttons) {
            System.out.println("Droga do wierzchołka " + node.number + " wynosi: " + node.distance);
            //System.out.println(node.prev);
        }
    }
}
