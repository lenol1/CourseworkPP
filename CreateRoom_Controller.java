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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateRoom_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField AmountField;

    @FXML
    private Button BackButton;

    @FXML
    private TextField CapacityField;

    @FXML
    private Button NextButton;

    @FXML
    void initialize() {
        FXMLLoader loader = new FXMLLoader();
        NextButton.setOnAction(event -> {
            if(CapacityField.getText() != null && AmountField.getText()!=null)
            {
                if(!CapacityField.getText().equals("0") && !CapacityField.getText().equals("500")) {
                    Room gameroom = new Room();
                    int capacity = Integer.parseInt(CapacityField.getText());
                    gameroom.setCapacity(capacity);
                    double max_amount = Double.parseDouble(AmountField.getText());
                    gameroom.setMax_amount(max_amount);
                    System.out.println(Room.toys.toString());
                }
            }
            NextButton.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("ToysAdding.fxml"));
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
