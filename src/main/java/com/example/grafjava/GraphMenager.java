package com.example.grafjava;


import static java.lang.Math.floor;

public class GraphMenager {
    public void setColor(Edge edge, double weight, double max){
        int c;
        double x = 309/max; //współczynnik wagi
        //paleta HSL od 50 stopni do 359 stopni
        c = (int)floor(50 + x * weight);

        edge.setStyle("-fx-background-color: hsb(" + c +", 100%, 100%)");
    }
    public void setColor(Node node, double distance){
        double c;
        c = 50 + distance;
        node.setStyle("-fx-background-color: hsb("+ c+ ", 100%, 100%)");
    }
}