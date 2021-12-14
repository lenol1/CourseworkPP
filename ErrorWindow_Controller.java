package com.example.demo2.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ErrorWindow_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CloseButton;

    @FXML
    void initialize() {
        CloseButton.setOnAction(event -> {
            CloseButton.getScene().getWindow().hide();
        });
    }
    @FXML
    static void ErrorStage()
    {
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(ErrorWindow_Controller.class.getResource("ErrorWindow.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
