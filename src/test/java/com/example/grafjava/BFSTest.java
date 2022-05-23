package com.example.grafjava;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class BFSTest {

    @Test
    public void BFSTestConnectedGraphShouldTrue(){
        Graph graph = null;
        Files f = new Files();
        try {
            graph = f.read("C:\\Users\\Kowalski\\IdeaProjects\\Graf-java\\src\\test\\test_graphs\\BFSGraph1.txt");
        }catch(FileNotFoundException e){
            ;
        }
        BFS bfs = new BFS();
        Assert.assertTrue(bfs.BFS(graph,2));
    }

    @Test
    public void BFSTestUnconnectedGraphShouldFalse(){
        Graph graph = null;
        Files f = new Files();
        try {
            graph = f.read("C:\\Users\\Kowalski\\IdeaProjects\\Graf-java\\src\\test\\test_graphs\\BFSGraph2Unconected.txt");
        }catch(FileNotFoundException e){
            ;
        }
        BFS bfs = new BFS();
        Assert.assertFalse(bfs.BFS(graph,2));
    }
}