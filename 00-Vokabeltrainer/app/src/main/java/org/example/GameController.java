package org.example;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameController {
    public Button submitButton;
    public Label submitLabel;

    public void handleButtonClick(){
        System.out.println("button is clicked");
        submitButton.setText("text has changed");
        submitLabel.setText("Hello godfred");

    }
}