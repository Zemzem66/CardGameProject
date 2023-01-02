module com.example.cardgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.persistence;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;


    opens com.example.cardgame to javafx.fxml;
    exports com.example.cardgame;
    opens Server to javafx.fxml;
    exports Server;
}