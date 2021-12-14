package com.example.demo2.Controllers;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ShowList_Controller {

    private ObservableList<Toy> toyData = FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TableColumn<Toy, Double> Cost;

    @FXML
    private Button ExitButton;

    @FXML
    private TextArea Info;

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
        List<Toy> ltoys = Room.toys;
        FXMLLoader loader = new FXMLLoader();

        toyData.addAll(Room.toys);
        for( int i = 0;i<ltoys.size();i++)
        {
            ToyName.setCellValueFactory(new PropertyValueFactory<Toy,String>("name"));
            ToyType.setCellValueFactory(new PropertyValueFactory<Toy,String>("type"));
            Cost.setCellValueFactory(new PropertyValueFactory<Toy,Double>("cost"));
            SizeCategory.setCellValueFactory(new PropertyValueFactory<Toy,String>("size_category"));
            Number.setCellValueFactory(new PropertyValueFactory<Toy,Integer>("number"));
        }
        Table.setItems(toyData);
        Info.setText("Current amount:"+Room.getCurrent_amount(ltoys));
        ExitButton.setOnAction(event -> {
            ExitButton.getScene().getWindow().hide();
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
