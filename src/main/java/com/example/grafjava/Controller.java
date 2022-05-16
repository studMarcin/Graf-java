package com.example.grafjava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

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
    ScrollPane graphPane;

    GridPane nodes;
    Graph graph;

    public void gen(ActionEvent e){
        int c = 6, w = 10;
        double min = 0,  max = 1;
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
        graph = new Graph(w, c);
        Generation.generate(graph, min, max);
        graph.printGraph();
        showGraph(w, c);
    }

    public void bfs(ActionEvent e){
        //wywoluje bfs
        massages.setText("Uruchamiam BFS");
    }

    public void dijsktra(ActionEvent e){
        //wywoluje dijkstre
        massages.setText("Uruchamiam Dijkstre");
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
        FileChooser fileChooser = new FileChooser();
        Files f = new Files();
        Graph g = null;
        try {
            File selectedFile = fileChooser.showOpenDialog(null);
            pathToFile.setText(selectedFile.getPath());
            g = f.read(selectedFile.getPath());
            g.printGraph();
            showGraph(g.rows, g.cols);
            massages.setText("");
        }catch(InputMismatchException er){
            massages.setText("Nieprawidłowy format grafu");
        }catch(FileNotFoundException er){
            massages.setText("Wybierz plik z grafem");
        }

    }

    public void showGraph(int rows, int cols) {
        nodes = new GridPane();
        nodes.setVgap(5);
        nodes.setHgap(5);
        nodes.setPadding(new Insets(10, 10, 10, 10));

        /*for (int i = 0; i < rows; i++) {
            nodes.getRowConstraints().add(new RowConstraints());
        }

        for (int i = 0; i < cols; i++) {
            nodes.getColumnConstraints().add(new ColumnConstraints());
        }*/

        Button[] buttons = new Button[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = cols * i + j;
                buttons[index] = new Button(String.valueOf(index));
                buttons[index].setOnAction(this::test);
                buttons[index].setId("node");
                nodes.add(buttons[index], j, i);
            }
        }
        graphPane.setContent(nodes);
    }

    public void test(ActionEvent e) {
        // Wypisuje się każde połączenie z wierzchołka na który kliknęliśmy na konsolę
        for (Edge edge: graph.neighbours[Integer.parseInt(((Button)e.getSource()).getText())]) {
            System.out.print(edge.node + ": " + edge.wage + " ");
        }
        System.out.println();
    }

}
