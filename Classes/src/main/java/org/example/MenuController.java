package org.example;

import java.io.IOException;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private Button bt_times;

    @FXML
    private Button btcarro;

    @FXML
    private Button bt_animais;

    @FXML
    private Button bt_pessoa;

    @FXML
    void MostrarTelaCarro(ActionEvent event) throws IOException {

        App.setRoot("carro");
    }

    @FXML
    void MostrarṔessoas(ActionEvent event) throws IOException {
        App.setRoot("pessoa");
    }

    @FXML
    void MostrarAnimais(ActionEvent event) throws IOException {
        App.setRoot("animal");

    }

    @FXML
    void MostrarTimes(ActionEvent event) throws IOException {
        App.setRoot("time");


    }
}
