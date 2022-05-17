package com.example.grafjava;

import javafx.scene.control.Button;

public class Node extends Button {

    int number;
    double distance;
    int prev;

    Node(double size, int number) {
        this.setPrefSize(size, size);
        this.setMaxSize(size, size);
        this.setMinSize(size, size);
        this.number = number;
        distance = Double.POSITIVE_INFINITY;
        prev = -1;
    }
}
