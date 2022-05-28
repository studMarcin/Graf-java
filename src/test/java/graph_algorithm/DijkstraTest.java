package graph_algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class DijkstraTest {

    @Test
    public void dijkstra_coherentGraph1_correctPath() throws FileNotFoundException {

        //Given
        Files f = new Files();
        Graph graph = f.read("src/test/test_graphs/coherentGraph1");


        //When
        double[] expectedDistance = {0.0, 11.0, 23.0, 24.0, 24.0, 24.0, 3.0, 15.0, 20.0, 26.0, 29.0, 34.0, 15.0, 20.0, 23.0, 25.0, 28.0, 37.0, 29.0, 27.0, 24.0, 33.0, 34.0, 44.0, 34.0, 35.0, 39.0, 40.0, 43.0, 55.0, 38.0, 35.0, 44.0, 46., 50.0, 54.0};

        //Then
        double[] result = Dijkstra.dijkstra(graph);
        Assertions.assertArrayEquals(expectedDistance, result);
    }

    @Test
    public void dijkstra_coherentGraph2_correctPath() throws FileNotFoundException {

        //Given
        Files f = new Files();
        Graph graph = f.read("src/test/test_graphs/coherentGraph2");

        //when
        double[] expectedDistance = {0.0, 8.0, 14.0, 22.0, 23.0, 3.0, 8.0, 14.0, 22.0, 24.0, 10.0, 12.0, 16.0, 17.0, 20.0, 13.0, 12.0, 13.0, 14.0, 18.0};

        //Then
        double[] result = Dijkstra.dijkstra(graph);
        Assertions.assertArrayEquals(expectedDistance, result);
    }

}
