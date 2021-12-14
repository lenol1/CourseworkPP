package com.example.demo2.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ManagerMenu_Controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup Buttons;

    @FXML
    private Button ExitButton;

    @FXML
    private RadioButton FillRoom;

    @FXML
    private Button NextButton;

    @FXML
    private RadioButton SearchToy;

    @FXML
    private RadioButton ShowList;

    @FXML
    private RadioButton SortToys;
    @FXML
    void initialize() {
        FXMLLoader loader = new FXMLLoader();

        ExitButton.setOnAction(event -> {
            ExitButton.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("pp.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        NextButton.setOnAction(event -> {
            if (FillRoom.isSelected()) {
                NextButton.getScene().getWindow().hide();
                ChangeStage(loader, "CreateRoom.fxml");
            } else if (ShowList.isSelected()) {
                NextButton.getScene().getWindow().hide();
                ChangeStage(loader, "ShowList.fxml");
            } else if (SortToys.isSelected()) {
                NextButton.getScene().getWindow().hide();
                ChangeStage(loader,"Sort.fxml");
            }
            else if(SearchToy.isSelected()) {
                NextButton.getScene().getWindow().hide();
                ChangeStage(loader,"SearchResult.fxml");
            }
        });
    }
   public void ChangeStage(FXMLLoader loader ,String fxmlfile)
    {
        loader.setLocation(getClass().getResource(fxmlfile));
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