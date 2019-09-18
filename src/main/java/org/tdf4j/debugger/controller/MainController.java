package org.tdf4j.debugger.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    @FXML
    private Label labwork;

    @FXML
    public void onClickLoad() {
        labwork.setText("Test work");
    }

}
