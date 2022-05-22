module com.example.grafjava {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.desktop;
    requires junit;


    opens com.example.grafjava to javafx.fxml;
    exports com.example.grafjava;
}