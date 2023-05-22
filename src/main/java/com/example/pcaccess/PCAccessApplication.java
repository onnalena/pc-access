package com.example.pcaccess;

import com.example.pcaccess.stages.LoginStage;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class PCAccessApplication extends Application {

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        LoginStage loginStage = new LoginStage();
        loginStage.initStyle(StageStyle.UNDECORATED);
        loginStage.setFullScreen(true);
        loginStage.setResizable(false);
        loginStage.show();
        loginStage.setAlwaysOnTop(true);
    }
}