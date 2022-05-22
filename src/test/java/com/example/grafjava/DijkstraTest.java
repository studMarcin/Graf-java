package com.example.grafjava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;

import java.io.FileNotFoundException;
import java.util.Objects;

public class DijkstraTest extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GUI.fxml")));
            Scene scene = new Scene(root);
            String css = Objects.requireNonNull(this.getClass().getResource("style.css")).toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Before
    public void setUp () throws Exception {
    }

    @After
    public void tearDown () throws Exception {
        FxToolkit.hideStage();
        //release(new KeyCode[]{});
        //release(new MouseButton[]{});
    }

    @Test
    public void dijkstra_coherentGraph_correctPath() throws FileNotFoundException {

        //Given
        Files f = new Files();
        Graph graph = f.read("src/test/test_graphs/coherentGraph1");
        Node[] buttons = new Node[graph.getSize()];
        Dijkstra dijkstra = new Dijkstra();

        for (int i = 0; i < graph.getSize(); i++) {
            buttons[i] = new Node(i);
        }

        //When
        double expectedDistance = 9.0;

        //Then
        double result = dijkstra.dijkstra(graph, buttons);
        Assertions.assertEquals(result, expectedDistance);
    }

}
