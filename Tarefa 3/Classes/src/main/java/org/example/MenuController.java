package org.example;

import java.io.IOException;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class MenuController {
    @FXML
    private Button bt_jogo;
    @FXML
    private Button bt_calcado;
    @FXML
    private Button bt_times;

    @FXML
    private Button bt_livro;

    @FXML
    private Button bt_instrumento;

    @FXML
    private Button bt_flor;

    @FXML
    private Button btcarro;

    @FXML
    private Button bt_animais;

    @FXML
    private Button bt_pessoa;

    @FXML
    private Button bt_perifericos;


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

    @FXML
    void MostrarJogo(ActionEvent event) throws IOException {
        App.setRoot("jogo");

    }
    @FXML
    void MostrarPerifericos(ActionEvent event) throws IOException {
        App.setRoot("periferico");

    }

    @FXML
    void MostrarFlores(ActionEvent event) throws IOException {
        App.setRoot("flor");
    }
    @FXML
    void MostrarLivros(ActionEvent event) throws IOException {
        App.setRoot("livro");

    }
    @FXML
    void MostrarInstrumento(ActionEvent event) throws IOException {
        App.setRoot("instrumento");

    }
    @FXML
    void MostrarCalcado(ActionEvent event) throws IOException {
        App.setRoot("calcado");

    }

}
