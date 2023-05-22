package com.example.pcaccess.stages;

import com.example.pcaccess.PCAccessApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TimeOutStage extends Stage {

    private Scene scene;
    private String title;

    public TimeOutStage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PCAccessApplication.class.getResource("timer.fxml"));
        setScene(new Scene(fxmlLoader.load(), 320, 240));
        setTitle("Access Token was verified - Beginning Timer");
    }
}
