module com.example.grafjava {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.desktop;
    requires junit;


    opens graph_algorithm to javafx.fxml;
    exports graph_algorithm;
}