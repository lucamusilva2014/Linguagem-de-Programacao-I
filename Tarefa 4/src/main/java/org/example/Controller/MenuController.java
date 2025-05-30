package org.example.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.App;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button bt_animais;

    @FXML
    private Button bt_calcado;

    @FXML
    private Button bt_flor;

    @FXML
    private Button bt_instrumento;

    @FXML
    private Button bt_jogo;

    @FXML
    private Button bt_livro;

    @FXML
    private Button bt_perifericos;

    @FXML
    private Button bt_pessoa;

    @FXML
    private Button bt_times;

    @FXML
    private Button btcarro;

    @FXML
    void MostrarAnimais(ActionEvent event) throws IOException {
        App.setRoot("animal");

    }

    @FXML
    void MostrarCalcado(ActionEvent event) {

    }

    @FXML
    void MostrarFlores(ActionEvent event) {

    }

    @FXML
    void MostrarInstrumento(ActionEvent event) {

    }

    @FXML
    void MostrarJogo(ActionEvent event) {

    }

    @FXML
    void MostrarLivros(ActionEvent event) {

    }

    @FXML
    void MostrarPerifericos(ActionEvent event) {

    }

    @FXML
    void MostrarTelaCarro(ActionEvent event) {

    }

    @FXML
    void MostrarTimes(ActionEvent event) {

    }

    @FXML
    void MostrarPessoas(ActionEvent event) throws IOException {
        App.setRoot("pessoa");

    }

}
