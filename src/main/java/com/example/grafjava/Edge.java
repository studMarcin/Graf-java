package com.example.grafjava;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Edge extends Label {

    int node;
    double wage;

    Edge (int node, double wage) {
        this.node = node;
        this.wage = wage;
        this.setId("edge");
    }

    public void setSize(double length, double width) {
        this.setFont(new Font(width));
        this.setPrefSize(length, width);
        this.setMaxSize(length, width);
        this.setMinSize(length, width);
    }
}
