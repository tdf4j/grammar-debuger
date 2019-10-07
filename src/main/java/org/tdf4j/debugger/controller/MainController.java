package org.tdf4j.debugger.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    @FXML
    private TextArea Grammartextarea;
    @FXML
    private TextArea Textareatext;
    @FXML
    private TextArea Consoletextarea;

    @FXML
    public void onClickLoad() {
        Grammartextarea.setText("Should");
        Textareatext.setText("work");
        Consoletextarea.setText("like this");
    }

}
