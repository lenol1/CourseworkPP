package com.example.demo2.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demo2.Db.DataBaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button LogInButton;

    @FXML
    private TextField LoginField;

    @FXML
    private TextField PasswordField;

    @FXML
    void initialize() {
        FXMLLoader loader = new FXMLLoader();
        LogInButton.setOnAction(event -> {
            String Login = LoginField.getText();
            String Password = PasswordField.getText();
            try {
                if(CheckName(Login, Password)) {
                    LogInButton.getScene().getWindow().hide();
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
                }
                else
                    ErrorWindow_Controller.ErrorStage();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
    @FXML
    boolean CheckName(String MLogin, String MPassword) throws SQLException, ClassNotFoundException {
        String Pquery = "SELECT password FROM toys.managers where Login ='"+MLogin+"'";
        String result = "";
        try (PreparedStatement statement = DataBaseConnection.getDbConnection().prepareStatement(Pquery)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next())
                    result = resultSet.getString(1);
                    if (result.equals(MPassword))
                        return true;
                    else
                        return false;
                }
        }
    }
}
