package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CarroController {

    @FXML
    private Button btsalvar;

    @FXML
    private Button btvoltar;

    @FXML
    private TextField tfano;

    @FXML
    private TextField tfcor;

    @FXML
    private TextField tfmarca;

    @FXML
    void CadastrarCarro(ActionEvent event) {
        String marca = tfmarca.getText();
        int ano= Integer.parseInt(tfano.getText());
        String cor= tfcor.getText();
    }

    @FXML
    void MostraTelaMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");

    }


}