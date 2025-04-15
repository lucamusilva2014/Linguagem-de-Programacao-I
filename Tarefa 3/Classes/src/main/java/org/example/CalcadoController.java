package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class CalcadoController {

    @FXML
    private Button bt_calcar;

    @FXML
    private Button bt_experimentar;

    @FXML
    private Button bt_salvar;

    @FXML
    private Button bt_tirar;

    @FXML
    private Button bt_voltar;

    @FXML
    private Label lb_carro;

    @FXML
    private TextField tf_cor;

    @FXML
    private TextField tf_nome;

    @FXML
    private TextField tf_tamanho;

    public static class Calcado {
        private static String nome;
        private static String cor;
        private static Float tamanho;

        public static String getNome() {
            return nome;
        }

        public static void setNome(String nome) {
            CalcadoController.Calcado.nome = nome;
        }

        public String getCor() {
            return cor;
        }

        public static void setCor(String especie) {
            CalcadoController.Calcado.cor = cor;
        }

        public Float getTamanho() {
            return tamanho;
        }

        public static void setTamanho(Float tamanho) {
            CalcadoController.Calcado.tamanho = tamanho;
        }
    }


    @FXML
    void CadastrarCalcado(ActionEvent event) {
        String nome = tf_nome.getText();
        Float tamanho =  Float.parseFloat(tf_tamanho.getText());
        String cor = tf_cor.getText();
        CalcadoController.Calcado.setNome(nome);
        CalcadoController.Calcado.setTamanho(tamanho);
        CalcadoController.Calcado.setCor(cor);
        Notifications.create()
                .title("Cadastro de Calçados")
                .position(Pos.TOP_CENTER)
                .text("Calçado cadastrado com sucesso!\nNome: " + nome + "\nCor: " + cor + "\nTamanho: " + tamanho)
                .darkStyle()
                .showInformation();
        esconderCampos();

    }

    public void esconderCampos() {
        tf_nome.setVisible(false);
        tf_cor.setVisible(false);
        tf_tamanho.setVisible(false);
        bt_salvar.setVisible(false);





    }

    @FXML
    void Calcar(ActionEvent event) {
        String nome = CalcadoController.Calcado.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text("Calçou o "+nome )
                .darkStyle()
                .showInformation();


    }

    @FXML
    void Experimentar(ActionEvent event) {
        String nome = CalcadoController.Calcado.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text("Experimentou o "+nome )
                .darkStyle()
                .showInformation();

    }

    @FXML
    void MostraTelaMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");

    }

    @FXML
    void Tirar(ActionEvent event) {
        String nome = CalcadoController.Calcado.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text("Tirou o "+nome )
                .darkStyle()
                .showInformation();

    }

}
