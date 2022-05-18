/*package com.example.grafjava;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class BFSTest {

    @Test
    public void BFSTest() {
        Graph graph = null;
        Files f = new Files();
        Generation gen = new Generation();
        try {
            graph = f.read("C:\\Users\\r0ler\\IdeaProjects\\Grafjava\\ala");
        }catch(FileNotFoundException  e){
            ;
        }
        graph.printGraph();;
        BFS bfs = new BFS();
        bfs.BFS(graph,2);
    }
}*/