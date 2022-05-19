package com.example.grafjava;


import java.io.*;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Files {
    public Graph read(String filename) throws FileNotFoundException, InputMismatchException, NoSuchElementException {
        int r, c;
        File f = new File(filename);
        Scanner scanner = null;

        scanner = new Scanner(f);
        String pom;

        r = scanner.nextInt();
        c = scanner.nextInt();

        Graph g = new Graph(r, c);
        pom = scanner.nextLine();
        for (int i = 0; i < r * c; i++) {
            Scanner linereader;
            int edges_num;
            pom = scanner.nextLine();
            edges_num = pom.split(":").length -1;
            pom = pom.replaceAll("[:\t]","");
            pom = pom.replace('.',',');
            linereader = new Scanner(pom);

            if(pom.length() != 0) {
                for (int j = 0; j<edges_num; j++) {
                    Edge e = null;
                    e = new Edge(linereader.nextInt(),linereader.nextDouble());
                    g.neighbours[i].add(e);
                }
            }
        }
        return g;
    }
    public void save(Graph g, String filename) throws IOException{
        FileWriter fw = null;

        fw = new FileWriter(filename);

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
