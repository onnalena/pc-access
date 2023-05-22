package com.example.pcaccess.stages;

import com.example.pcaccess.PCAccessApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalTime;

public class TimerStage extends Stage {

    private Scene scene;
    private String title;

    public TimerStage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PCAccessApplication.class.getResource("timer.fxml"));
        setScene(new Scene(fxmlLoader.load(), 250, 100));
        setTitle("Access Token was verified - Beginning Timer");
    }
}
