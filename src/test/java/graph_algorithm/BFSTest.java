package graph_algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class BFSTest {

    @Test
    public void BFSTestConnectedGraphShouldTrue(){
        Graph graph = null;
        Files f = new Files();
        try {
            graph = f.read("src/test/test_graphs/BFSGraph1.txt");
            graph.chosen = 2;
        }catch(FileNotFoundException e){
            ;
        }
        BFS bfs = new BFS();
        Assert.assertTrue(bfs.BFS(graph));
    }

    @Test
    public void BFSTestUnconnectedGraphShouldFalse(){
        Graph graph = null;
        Files f = new Files();
        try {
            graph = f.read("src/test/test_graphs/BFSGraph2Unconected.txt");
            graph.chosen = 2;
        }catch(FileNotFoundException e){
            ;
        }
        BFS bfs = new BFS();
        Assert.assertFalse(bfs.BFS(graph));
    }

}