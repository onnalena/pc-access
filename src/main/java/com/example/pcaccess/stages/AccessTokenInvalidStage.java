package com.example.pcaccess.stages;

import com.example.pcaccess.PCAccessApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AccessTokenInvalidStage extends Stage {

    private Scene scene;
    private String title;

    public AccessTokenInvalidStage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PCAccessApplication.class.getResource("invalid-login.fxml"));
        setScene(new Scene(fxmlLoader.load(), 320, 240));
        setTitle("ERROR");
    }
}
