package com.example.cm2115;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class cardcontroller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    //just a dummmy function to give the transfer and withdrawl button drama
    public void backtoadmin(ActionEvent event)throws IOException {
        root = FXMLLoader.load(getClass().getResource("AccountManager.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}