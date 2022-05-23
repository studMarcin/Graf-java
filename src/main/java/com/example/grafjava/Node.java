package com.example.grafjava;

import javafx.scene.control.Button;

public class Node extends Button implements Comparable<Node>{

    int number;
    double distance;
    Node prev;

    Node(double size, int number) {
        this.setPrefSize(size, size);
        this.setMaxSize(size, size);
        this.setMinSize(size, size);
        this.number = number;
        distance = Double.POSITIVE_INFINITY;
        prev = null;
    }

    Node(int number) {
        this.number = number;
        distance = Double.POSITIVE_INFINITY;
        prev = null;
    }

    @Override
    public int compareTo(Node o) {
        return o.distance > distance ? 0 : 1;
    }
}
