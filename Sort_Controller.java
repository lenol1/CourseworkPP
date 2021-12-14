package com.example.demo2.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo2.Objects.Room;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class Sort_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackButton;

    @FXML
    private ToggleGroup Buttons;

    @FXML
    private Button NextButton;

    @FXML
    private RadioButton SortByCost;

    @FXML
    private RadioButton SortByName;

    @FXML
    private RadioButton SortBySize;

    @FXML
    private RadioButton SortByType;

    @FXML
    void initialize() {
        FXMLLoader loader = new FXMLLoader();
        NextButton.setOnAction(event -> {
            if(SortByName.isSelected())
                Room.SortToysByName(Room.toys);
            else if(SortByCost.isSelected())
                Room.SortToysByCost(Room.toys);
            else if(SortByType.isSelected())
                Room.SortToysByType(Room.toys);
            else
                Room.SortToysBySize(Room.toys);
            NextButton.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("ManagerMenu.fxml"));
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
        BackButton.setOnAction(event -> {
            BackButton.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("ManagerMenu.fxml"));
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
    }

}
