module com.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;

    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires mysql.connector.java;

    exports com.example.demo2;
    opens com.example.demo2 to javafx.fxml;
    exports com.example.demo2.Controllers;
    opens com.example.demo2.Controllers to javafx.fxml;
    exports com.example.demo2.Objects;
    opens com.example.demo2.Objects to javafx.fxml;
    exports com.example.demo2.Db;
    opens com.example.demo2.Db to javafx.fxml;
}