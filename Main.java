package com.example.demo2;

import com.example.demo2.Db.DataBaseConnection;
import com.example.demo2.Objects.Room;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Room gameroom = new Room();
        gameroom.setToys(DataBaseConnection.FillToyList());

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Controllers/pp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Game Room Program");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}