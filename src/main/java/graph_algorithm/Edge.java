package graph_algorithm;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Edge extends Label {

    int from, to;

    Edge(int from, int to, double length, double width) {
        this.from = from;
        this.to = to;
        this.setFont(new Font(width));
        this.setPrefSize(length, width);
        this.setMaxSize(length, width);
        this.setMinSize(length, width);
    }
}
