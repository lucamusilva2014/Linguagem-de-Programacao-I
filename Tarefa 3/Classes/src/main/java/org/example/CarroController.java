package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;
import javafx.scene.control.Label;

import java.io.IOException;

public class CarroController {


    @FXML
    private Button bt_acelerar;

    @FXML
    private Button bt_frear;

    @FXML
    private Button bt_ligarmotor;


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

    public static class Carro {
        private static String marca;
        private static String cor;
        private static int ano;

        public static String getMarca() {
            return marca;
        }

        public static void setMarca(String marca) {
            Carro.marca = marca;
        }

        public String getCor() {
            return cor;
        }

        public static void setCor(String cor) {
            Carro.cor = cor;
        }

        public int getAno() {
            return ano;
        }

        public static void setAno(int ano) {
            Carro.ano = ano;
        }
    }



    @FXML
    public void CadastrarCarro(ActionEvent event) {
        String marca = tfmarca.getText();
        int ano = Integer.parseInt(tfano.getText());
        String cor = tfcor.getText();
        Carro.setMarca(marca);
        Carro.setCor(cor);
        Carro.setAno(ano);
        Notifications.create()
                .title("Cadastro de Carros")
                .position(Pos.TOP_CENTER)
                .text("Carro cadastrado com sucesso!\nMarca: " + marca + "\nAno: " + ano + "\nCor: " + cor)
                .darkStyle()
                .showInformation();
        esconderCampos();

    }
    public void esconderCampos() {
        tfmarca.setVisible(false);
        tfano.setVisible(false);
        tfcor.setVisible(false);
        btsalvar.setVisible(false);

    }
    @FXML
    public void LigarMotor(ActionEvent event) {
        String marca = Carro.getMarca();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(""+ marca+" Ligou o Motor" )
                .darkStyle()
                .showInformation();


    }
    @FXML
    public void Acelerar(ActionEvent event) {
        String marca = Carro.getMarca();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(""+ marca+" Acelerou" )
                .darkStyle()
                .showInformation();


    }
    @FXML
    public void Freiar(ActionEvent event) {
        String marca = Carro.getMarca();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(""+ marca+" Freiou" )
                .darkStyle()
                .showInformation();


    }


    @FXML
    public void MostraTelaMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");

    }


}