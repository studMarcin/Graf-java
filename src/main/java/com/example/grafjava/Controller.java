package com.example.grafjava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;

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
        String path;
        FileChooser fileChooser = new FileChooser();
        try {
            File selectedFile = fileChooser.showOpenDialog(null);
        }catch(RuntimeException er){
            massages.setText("Wybierz plik na zapis");
        }
        massages.setText("Zapisuje graf");
    }
    public void select(ActionEvent e){
        //wywoluje wybiweranie
        String path;
        FileChooser fileChooser = new FileChooser();
        try {
            File selectedFile = fileChooser.showOpenDialog(null);
            pathToFile.setText(selectedFile.getPath());
        }catch(RuntimeException er){
            massages.setText("Wybierz plik z grafem");
        }


    }

}
