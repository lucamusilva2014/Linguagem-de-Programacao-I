package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

import java.io.IOException;


public class FlorController {

    @FXML
    private Button bt_florescer;

    @FXML
    private Button bt_polenizar;

    @FXML
    private Button bt_regar;

    @FXML
    private Button bt_salvar;

    @FXML
    private Button bt_voltar;

    @FXML
    private Label lb_carro;

    @FXML
    private TextField tf_aroma;

    @FXML
    private TextField tf_cor;

    @FXML
    private TextField tf_nome;
    public static class Flor {
        private static String nome;
        private static String cor;
        private static String aroma;

        public static String getNome() {
            return nome;
        }

        public static void setNome(String nome) {
            FlorController.Flor.nome = nome;
        }

        public String getCor() {
            return cor;
        }

        public static void setCor(String cor) {
            FlorController.Flor.cor = cor;
        }

        public String getAroma() {
            return aroma;
        }

        public static void setAroma(String aroma) {
            FlorController.Flor.aroma= aroma;
        }
    }



    @FXML
    void CadastrarInstrumento(ActionEvent event) {
        String nome = tf_nome.getText();
        String cor = tf_cor.getText();
        String aroma = tf_aroma.getText();
        FlorController.Flor.setNome(nome);
        FlorController.Flor.setAroma(aroma);
        FlorController.Flor.setCor(cor);
        Notifications.create()
                .title("Cadastro de Flores")
                .position(Pos.TOP_CENTER)
                .text("Flor cadastrado com sucesso!\nNome: " + nome + "\nCor: " + cor+ "\nAroma: " + aroma)
                .darkStyle()
                .showInformation();
        esconderCampos();
    }

    public void esconderCampos() {
        tf_nome.setVisible(false);
        tf_cor.setVisible(false);
        tf_aroma.setVisible(false);
        bt_salvar.setVisible(false);

    }

    @FXML
    void Florescer(ActionEvent event) {
        String nome = FlorController.Flor.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(" "+nome +" Floresceu")
                .darkStyle()
                .showInformation();


    }

    @FXML
    void MostraTelaMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");

    }

    @FXML
    void Polenizar(ActionEvent event) {
        String nome = FlorController.Flor.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(" "+nome +" Foi Polenizada")
                .darkStyle()
                .showInformation();


    }

    @FXML
    void Regar(ActionEvent event) {
        String nome = FlorController.Flor.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(" "+nome +" Foi Regada")
                .darkStyle()
                .showInformation();


    }

}
