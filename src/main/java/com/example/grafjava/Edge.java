package com.example.grafjava;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Edge extends Label {

    Edge(double length, double width) {
        this.setFont(new Font(width));
        this.setPrefSize(length, width);
        this.setMaxSize(length, width);
        this.setMinSize(length, width);
    }
}
