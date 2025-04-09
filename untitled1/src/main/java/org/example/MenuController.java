package org.example;

import java.io.IOException;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class MenuController  {

    @FXML
    private Button btcarro;

    @FXML
    void MostrarTelaCarro(ActionEvent event) throws IOException {

        App.setRoot("carro");
    }
    @FXML
    void MostrarṔessoas(ActionEvent event) throws IOException {
        App.setRoot("pessoa");
    }
}
