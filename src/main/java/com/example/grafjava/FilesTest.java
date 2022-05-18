package com.example.grafjava;

import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import junit.framework.Assert;
import com.example.grafjava.Graph;


public class FilesTest {

    @Test
    public void readTest() {
        Graph g = null;
        Files f = new Files();
        try {
            g = f.read("C:\\Users\\r0ler\\IdeaProjects\\Grafjava\\src\\main\\java\\com\\example\\grafjava\\100w");
        }catch(FileNotFoundException e){
            System.out.println("Wybier plika");
        }
        g.printGraph();
    }

    @Test
    public void saveTest(){
        Graph g = new Graph(4,4);
        Generation gen = new Generation();
        gen.generate(g, 0, 1,0.4);
        Files savefile = new Files();
        g.printGraph();

        try{
            savefile.save(g, "ala");
        }catch(IOException e){
            System.out.println("Ala ma kota");
        }
    }

    @Test
    public void readGenGraph(){
        Graph g = null;
        Files f = new Files();
        try {
            g = f.read("C:\\Users\\r0ler\\IdeaProjects\\Grafjava\\ala");
        }catch(FileNotFoundException e){
            System.out.println("Wybier Plika");
        }
        g.printGraph();
    }

}