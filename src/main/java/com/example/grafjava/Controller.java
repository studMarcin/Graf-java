package com.example.grafjava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Controller {

    @FXML
    Label massages;
    @FXML
    TextField columnsNum;
    @FXML
    TextField rowsNum;
    @FXML
    TextField minWeigth;
    @FXML
    TextField maxWeigth;
    @FXML
    Label pathToFile;
    @FXML
    AnchorPane graphPane;
    @FXML
    Slider cohesionSlider;

    GridPane nodes;
    Graph graph;
    Node[] buttons;
    // Chyba do wyjebania
    Edge[][] edges;

    HashMap<GraphEdge, Edge> pickEdge;

    // Roboczo 0 - nic, 1 - dijsktra, 2 - BFS
    int algorithm;

    public void gen(ActionEvent e){
        int c = 6, w = 10;
        double min = 0,  max = 1;
        double cohesionLevel = cohesionSlider.getValue();
        try {
            c = Integer.parseInt(columnsNum.getText());
            w = Integer.parseInt(rowsNum.getText());
        }catch(NumberFormatException er){
            massages.setText("Nieprawidłowe wymiary");
        }
        try{
            min = Double.parseDouble(minWeigth.getText());
            max = Double.parseDouble(maxWeigth.getText());
        }catch(NumberFormatException er){
            massages.setText("Nieprawidłowe wagi");
        }
        //wywoluje generacje graf
        pickEdge = new HashMap<>();
        graph = new Graph(w, c);
        Generation.generate(graph, min, max, cohesionLevel);
        graph.printGraph();
        showGraph(w, c);
    }

    public void bfs(ActionEvent e){
        //wywoluje bfs
        massages.setText("Uruchamiam BFS");
    }

    public void dijsktra(ActionEvent e){
        //wywoluje dijkstre
        massages.setText("Wybierz wierzchołek początkowy");
        algorithm = 1;
        clearGraph();
    }

    public void save(ActionEvent e){
        FileChooser fileChooser = new FileChooser();
        Files f = new Files();
        try {
            File selectedFile = fileChooser.showOpenDialog(null);
            f.save(graph, selectedFile.getPath());
        }catch(IOException er){
            massages.setText("Wybierz plik na zapis");
        }
        massages.setText("Zapisuje graf");
    }

    public void select(ActionEvent e){
        //wywoluje wybiweranie
        pickEdge = new HashMap<>();
        FileChooser fileChooser = new FileChooser();
        Files f = new Files();
        Graph g = null;
        try {
            File selectedFile = fileChooser.showOpenDialog(null);
            pathToFile.setText(selectedFile.getPath());
            graph = f.read(selectedFile.getPath());
            graph.printGraph();
            showGraph(graph.rows, graph.cols);
            massages.setText("");
        }catch(InputMismatchException er){
            massages.setText("Nieprawidłowy format grafu");
        }catch(FileNotFoundException er){
            massages.setText("Wybierz plik z grafem");
        }

    }

    public void showGraph(int rows, int cols) {
        graphPane.getChildren().remove(nodes);
        nodes = new GridPane();
        nodes.setMaxSize(560, 560);

        double buttonSize;

        if (cols > rows) {
            buttonSize = graphPane.getMaxWidth() / (2 * cols - 1);
        }
        else {
            buttonSize = graphPane.getMaxHeight() / (2 * rows - 1);
        }

        double edgeWidth = buttonSize / 10;
        int index = 0;

        buttons = new Node[rows * cols];

        for (int i = 0; i < rows * 2 - 1; i += 2) {
            for (int j = 0; j < cols * 2 - 1; j += 2) {
                buttons[index] = new Node(buttonSize, index);
                buttons[index].setOnAction(this::test);
                buttons[index].setId("node");
                nodes.add(buttons[index], j, i);
                for (GraphEdge edge: graph.neighbours[index]) {
                    if (edge.node == index + 1) {
                        pickEdge.put(edge, new Edge(index, index + 1, buttonSize, edgeWidth));
                        for (GraphEdge innerEdge: graph.neighbours[index + 1]) {
                            if (innerEdge.node == index) {
                                pickEdge.put(innerEdge, pickEdge.get(edge));
                            }
                        }
                        pickEdge.get(edge).setId("edge");
                        nodes.add(pickEdge.get(edge), j + 1, i);
                        GridPane.setValignment(pickEdge.get(edge), VPos.CENTER);
                    }
                    else if (edge.node == index + cols) {
                        pickEdge.put(edge, new Edge(index, index + cols, edgeWidth, buttonSize));
                        for (GraphEdge innerEdge: graph.neighbours[index + cols]) {
                            if (innerEdge.node == index) {
                                pickEdge.put(innerEdge, pickEdge.get(edge));
                            }
                        }
                        pickEdge.get(edge).setId("edge");
                        nodes.add(pickEdge.get(edge), j, i + 1);
                        GridPane.setHalignment(pickEdge.get(edge), HPos.CENTER);
                    }
                }
                index++;
            }
        }
        graphPane.getChildren().addAll(nodes);
    }

    private void clearGraph() {
        for (int i = 0; i < graph.getSize(); i++) {
            for (javafx.scene.Node node: nodes.getChildren()) {
                node.setId("edge");
            }
        }

        for (Node node: buttons) {
            node.setId("Node");
        }
    }

    public void test(ActionEvent e) {
        // Wypisuje się każde połączenie z wierzchołka na który kliknęliśmy na konsolę
        for (GraphEdge edge: graph.neighbours[((Node)e.getSource()).number]) {
            System.out.print(edge.node + ": " + edge.wage + " ");
        }
        System.out.println();

        if (algorithm == 1) {
            algorithm = 2;
            graph.chosen = ((Node)e.getSource()).number;
            ((Node)e.getSource()).setId("chosen");
            Dijkstra.dijkstra(graph);
            return;
        }

        if (algorithm == 2) {
            Dijkstra.showPath(graph, ((Node)e.getSource()).number, buttons, pickEdge);
        }
    }

}
