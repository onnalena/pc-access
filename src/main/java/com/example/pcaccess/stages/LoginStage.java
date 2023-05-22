package com.example.pcaccess.stages;

import com.example.pcaccess.PCAccessApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginStage extends Stage {

    private Scene scene;
    private String title;

    public LoginStage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PCAccessApplication.class.getResource("access-pc.fxml"));
        setScene(new Scene(fxmlLoader.load()));
        setTitle("Enter Access Token!");
    }
}
