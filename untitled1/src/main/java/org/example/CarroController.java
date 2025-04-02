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

    public TextField getTfano() {
        return tfano;
    }

    public void setTfano(TextField tfano) {
        this.tfano = tfano;
    }

    public TextField getTfmarca() {
        return tfmarca;
    }

    public void setTfmarca(TextField tfmarca) {
        this.tfmarca = tfmarca;
    }

    public TextField getTfcor() {
        return tfcor;
    }

    public void setTfcor(TextField tfcor) {
        this.tfcor = tfcor;
    }

    @FXML
    void CadastrarCarro(ActionEvent event) {

    }

    @FXML
    void MostraTelaMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");

    }


}