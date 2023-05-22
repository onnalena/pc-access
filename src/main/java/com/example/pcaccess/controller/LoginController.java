package com.example.pcaccess.controller;

import com.example.pcaccess.service.LoginService;
import com.example.pcaccess.stages.AccessTokenInvalidStage;
import com.example.pcaccess.stages.LoginStage;
import com.example.pcaccess.stages.TimerStage;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField identityNumber;

    @FXML
    private TextField pin;

    @FXML
    protected void onSubmitButtonClick(Event event) throws IOException, SQLException {
        final LoginService service = new LoginService();

        boolean isValid = service.isValid(event, identityNumber.getCharacters().toString(), pin.getCharacters().toString());

        if (isValid) {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            TimerStage timerStage = new TimerStage();
            timerStage.setX(1250);
            timerStage.setY(650);
            timerStage.show();
            timerStage.setAlwaysOnTop(true);
        }
    }
}