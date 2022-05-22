package com.example.grafjava;

import java.util.LinkedList;
import java.util.Random;

public class Generation {
    public static void generate(Graph graph, double minW, double maxW, double cohesionLevel) {

        int currNode = 0;
        double wage;

        Random rand = new Random();

        for (LinkedList<GraphEdge> row: graph.neighbours) {
            if (rand.nextDouble() < cohesionLevel) {
                if ((currNode + 1) % graph.cols != 0) {
                    wage = rand.nextDouble() * (maxW - minW) + minW;
                    row.addLast(new GraphEdge(currNode + 1, wage));
                    graph.neighbours[currNode + 1].addLast(new GraphEdge(currNode, wage));
                }
            }

            if (rand.nextDouble() < cohesionLevel) {
                if (currNode < graph.cols * (graph.rows - 1)) {
                    wage = rand.nextDouble() * (maxW - minW) + minW;
                    row.addLast(new GraphEdge(currNode + graph.cols, wage));
                    graph.neighbours[currNode + graph.cols].addLast(new GraphEdge(currNode, wage));
                }
            }
            currNode++;
        }
    }
}
