package com.example.grafjava;


import java.util.Scanner;

public class Files {
    //musze jeszcze przetestować
    public Graph read(String filename){
        int r, c;
        Scanner scanner = new Scanner(filename);
        String pom;
        String [] pom_tab;
        r = scanner.nextInt();
        c = scanner.nextInt();
        Graph g = new Graph(r,c);
        for(int i = 0; i<r*c; i++){
            pom = scanner.nextLine();
            pom_tab = pom.split(" :");
            for(int j = 0; j<pom.length(); j+=2){
                Edge e = new Edge(Integer.parseInt(pom_tab[j]),Double.parseDouble(pom_tab[j+1]));
                g.neighbours[i].add(e);
            }
        }
        return g;
    }
}
