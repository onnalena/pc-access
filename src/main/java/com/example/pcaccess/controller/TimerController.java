package com.example.pcaccess.controller;

import com.example.pcaccess.stages.LoginStage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TimerController implements Initializable {

    @FXML
    private Label startTimeAsString;

    @FXML
    private Label timerLabel;

    private Timeline timeline;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startTimeAsString.setText("Tracking Time started @" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm.ss")));

        LocalTime startTime = LocalTime.now();
        final int[] overallTime = {60 - startTime.getMinute()};

        if (timeline != null) {
            timeline.stop();
        }

        // update timerLabel
        timerLabel.setText(overallTime[0] + " minutes remaining");
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.minutes(1),
                        (EventHandler<ActionEvent>) event -> {
                            overallTime[0]--;
                            // update timerLabel
                            timerLabel.setText(overallTime[0] + " minutes remaining");
                            if (overallTime[0] <= 0) {
                                timeline.stop();
                            }
                        }));
        timeline.playFromStart();
    }

    @FXML
    public void onLogoutButtonClick(Event event) throws IOException {
        LoginStage loginStage = new LoginStage();
        loginStage.show();
        loginStage.setAlwaysOnTop(true);
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}