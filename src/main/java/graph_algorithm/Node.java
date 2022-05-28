package graph_algorithm;

import javafx.scene.control.Button;

public class Node extends Button{

    int number;

    Node(double size, int number) {
        this.setPrefSize(size, size);
        this.setMaxSize(size, size);
        this.setMinSize(size, size);
        this.number = number;
    }

}
