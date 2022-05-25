package com.example.grafjava;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class BFS {
    public boolean BFS(Graph g, int node, Node[] buttons) {
        GraphMenager gm = new GraphMenager();
        int size = g.getSize();
        int n;
        int[] color = new int[size];
        LinkedList<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < size; i++) {
            color[i] = 0;
            buttons[i].setStyle("-fx-background-color: #FFFFFF");
        }
        color[node] = 1;
        q.push(node);
        while (!q.isEmpty()) {
            n = q.poll();
            for (GraphEdge x : g.neighbours[n]) {
                if (color[x.node] == 0) {
                    color[x.node] = 1;
                    q.push(x.node);
                }
            }
            buttons[n].setStyle("-fx-background-color: #000000");
            color[n] = 2;
        }
        for (int col: color) {
            if (col != 2) return false;
        }
        return true;
    }
}