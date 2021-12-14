package com.example.demo2.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.example.demo2.Objects.Room;
import com.example.demo2.Objects.Toy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ToysAdding_Controller {

    private ObservableList<Toy> toyData = FXCollections.observableArrayList();
    @FXML
    private Button AddButton;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea Capacity;

    @FXML
    private TableColumn<Toy, Double> Cost;

    @FXML
    private TextArea CurrentAmount;

    @FXML
    private TextArea MaximumAmount;

    @FXML
    private Button NextButton;

    @FXML
    private TableColumn<Toy, Integer> Number;

    @FXML
    private TableColumn<Toy, String> SizeCategory;

    @FXML
    private TableView<Toy> Table;

    @FXML
    private TableColumn<Toy, String> ToyName;

    @FXML
    private TableColumn<Toy, String> ToyType;

    @FXML
    void initialize() {
        FXMLLoader loader = new FXMLLoader();
        List<Toy> ltoys = Room.toys;
        List<Toy> ctoys = new ArrayList<>();
        Room.toys = null;
        toyData.addAll(ltoys);
        for( int i = 0;i<ltoys.size();i++)
        {
            ToyName.setCellValueFactory(new PropertyValueFactory<Toy,String>("name"));
            ToyType.setCellValueFactory(new PropertyValueFactory<Toy,String>("type"));
            Cost.setCellValueFactory(new PropertyValueFactory<Toy,Double>("cost"));
            SizeCategory.setCellValueFactory(new PropertyValueFactory<Toy,String>("size_category"));
            Number.setCellValueFactory(new PropertyValueFactory<Toy,Integer>("number"));
        }
        Table.setItems(toyData);
        AddButton.setOnAction(event -> {
            Room.capacity--;
            Capacity.setText("Capacity:"+Room.capacity);
            MaximumAmount.setText("Max amount:"+Room.max_amount+"$");
            Toy toy = Table.getSelectionModel().getSelectedItem();
            System.out.println(toy.toString());
            ctoys.add(toy);
            toy.setNumber(toy.getNumber()-1);
            if(toy.getNumber()<0)
                ErrorWindow_Controller.ErrorStage();
            CurrentAmount.setText("Current amount:"+Room.getCurrent_amount(ctoys)+"$");
            if(Room.capacity <1 && Room.max_amount<Room.current_amount)
                ErrorWindow_Controller.ErrorStage();
        });
        NextButton.setOnAction(event -> {
        Room room = new Room();
        room.setToys(ctoys);
        System.out.println(Room.toys.toString());
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
    }
}