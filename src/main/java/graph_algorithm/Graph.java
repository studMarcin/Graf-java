package graph_algorithm;

import java.util.LinkedList;

public class Graph {

    LinkedList<GraphEdge>[] neighbours;
    int rows, cols;
    int chosen = 0;

    Graph(int rows, int cols) {
        neighbours = new LinkedList[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            neighbours[i] = new LinkedList<>();
        }
        this.rows = rows;
        this.cols = cols;
    }

    public void printGraph() {
        for (LinkedList<GraphEdge> row: neighbours) {
            for (GraphEdge edge: row) {
                System.out.print(edge.node + ": " + edge.wage + " ");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return cols * rows;
    }
}
