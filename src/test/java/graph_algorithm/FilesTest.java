package graph_algorithm;

import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class FilesTest {

    @Test
    public void readTestCorrectFile() {
        Graph graph = null;
        Files f = new Files();
        try {
            graph = f.read("src/test/test_graphs/BFSGraph1.txt");
            graph.chosen = 2;
        }catch(FileNotFoundException e){
            ;
        }
    }
    @Test
    public void readFileNotFoundThrowsException(){
        Graph graph = null;
        Files f = new Files();
        try {
            graph = f.read("przepisNaBigos.txt");
            graph.chosen = 2;
        }catch(FileNotFoundException e){
            System.out.println("Taki plik nie istnieje!");
        }
    }
    @Test
    public void readIncorectImputFile(){
        Files f = new Files();
        try {
            f.read("src/test/test_graphs/incorrectgraph.txt");
        }catch(FileNotFoundException| InputMismatchException e){
            System.out.println("Nieprawidłowy format pliku!");
        }
    }
}