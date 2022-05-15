package com.example.grafjava;


import java.io.*;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Files {
    //TODO integracja tego syfu z GUI
    public Graph read(String filename) {
        int r, c;
        File f = new File(filename);
        Scanner scanner = null;
        try {
            scanner = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma pliku o podanej nazwie");
            return null;
        }
        String pom;
        try{
            r = scanner.nextInt();
            c = scanner.nextInt();
        }catch(InputMismatchException ex){
            System.out.println("Nieprawidłowy format pliku A");
            return null;
        }
        Graph g = new Graph(r, c);
        pom = scanner.nextLine();
        for (int i = 0; i < r * c; i++) {
            Scanner linereader;
            int edges_num;
            try {
                pom = scanner.nextLine();
                edges_num = pom.split(":").length -1;
                pom = pom.replaceAll("[:\t]","");
                pom = pom.replace('.',',');
                linereader = new Scanner(pom);
            }catch(NoSuchElementException ex){
                System.out.println("Niewłaściwy pormat pliku B");
                return null;
            }
            if(pom.length() != 0) {
                for (int j = 0; j<edges_num; j++) {
                    Edge e = null;
                    try {
                        e = new Edge(linereader.nextInt(),linereader.nextDouble());
                    }catch (InputMismatchException ex) {
                        System.out.println("Niewłaściwy format pliku C");
                        return null;
                    }
                    g.neighbours[i].add(e);
                }
            }
        }
        return g;
    }
    public void save(Graph g, String filename){
        FileWriter fw = null;
        try {
            fw = new FileWriter(filename);
        }catch(IOException e){
            System.out.println("Podaj plik");
        }
        PrintWriter writer = new PrintWriter(fw);
        writer.printf("%d %d\n",g.rows, g.cols);
        for(int i=0; i<g.rows*g.cols;i++){
            for(Edge e : g.neighbours[i]){
                String str = new String();
                writer.printf(str.format(Locale.US, "%d: %f ", e.node, e.wage));
            }
            writer.printf("\n");
        }
        writer.close();
    }
}