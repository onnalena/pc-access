package com.example.pcaccess.service;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.Alert;

public class TriggerAlert {
    public static void alert(Event event, final String header, final String errorMsg) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText(header);
        errorAlert.setContentText(errorMsg);
        errorAlert.initOwner(((Node)(event.getSource())).getScene().getWindow());
        errorAlert.showAndWait();
    }
}
