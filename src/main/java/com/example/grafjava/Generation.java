package com.example.grafjava;

import java.util.LinkedList;
import java.util.Random;

public class Generation {
    public static void generate(Graph graph, double minW, double maxW) {

        int currNode = 0;
        double wage;

        Random rand = new Random();

        for (LinkedList<Edge> row: graph.neighbours) {
            if ((currNode + 1) % graph.cols != 0) {
                wage = rand.nextDouble() * (maxW - minW) + minW;
                row.addLast(new Edge(currNode + 1, wage));
                graph.neighbours[currNode + 1].addLast(new Edge(currNode, wage));
            }

            if (currNode < graph.cols * (graph.rows - 1)) {
                wage = rand.nextDouble() * (maxW - minW) + minW;
                row.addLast(new Edge(currNode + graph.cols, wage));
                graph.neighbours[currNode + graph.cols].addLast(new Edge(currNode, wage));
            }
            currNode++;
        }
    }
}
