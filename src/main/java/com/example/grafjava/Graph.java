package com.example.grafjava;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {

    LinkedList<Edge>[] neighbours;
    int rows, cols;
    int chosen;

    Graph(int rows, int cols) {
        neighbours = new LinkedList[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            neighbours[i] = new LinkedList<>();
        }
        this.rows = rows;
        this.cols = cols;
    }

    public void printGraph() {
        for (LinkedList<Edge> row: neighbours) {
            for (Edge edge: row) {
                System.out.print(edge.node + ": " + edge.wage + " ");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return cols * rows;
    }
}
