package com.example.tpc9;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;


public class PerilController implements Initializable {

    
    
    public Label peril;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SignInUser nome = new SignInUser();
        peril.setText(nome.returnUsername());
    }
}