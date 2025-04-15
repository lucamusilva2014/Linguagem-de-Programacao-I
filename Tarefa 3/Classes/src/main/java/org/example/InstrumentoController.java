package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class InstrumentoController {

    @FXML
    private Button bt_afinar;

    @FXML
    private Button bt_guardar;

    @FXML
    private Button bt_salvar;

    @FXML
    private Button bt_tocar;

    @FXML
    private Button bt_voltar;

    @FXML
    private Label lb_carro;

    @FXML
    private TextField tf_marca;

    @FXML
    private TextField tf_nome;

    @FXML
    private TextField tf_preco;
    public static class Instrumento {
        private static String nome;
        private static String marca;
        private static Float preco;

        public static String getNome() {
            return nome;
        }

        public static void setNome(String nome) {
            InstrumentoController.Instrumento.nome = nome;
        }

        public String getMarca() {
            return marca;
        }

        public static void setMarca(String marca) {
            InstrumentoController.Instrumento.marca = marca;
        }

        public Float getPreco() {
            return preco;
        }

        public static void setPreco(Float preco) {
            InstrumentoController.Instrumento.preco = preco;
        }
    }



    @FXML
    void CadastrarInstrumento(ActionEvent event) {
        String nome = tf_nome.getText();
        Float preco =  Float.parseFloat(tf_preco.getText());
        String marca = tf_marca.getText();
        InstrumentoController.Instrumento.setNome(nome);
        InstrumentoController.Instrumento.setPreco(preco);
        InstrumentoController.Instrumento.setMarca(marca);
        Notifications.create()
                .title("Cadastro de Instrumentos")
                .position(Pos.TOP_CENTER)
                .text("Instrumento cadastrado com sucesso!\nNome: " + nome + "\nMarca: " + marca + "\nPreço: " + preco)
                .darkStyle()
                .showInformation();
        esconderCampos();

    }

    public void esconderCampos() {
        tf_nome.setVisible(false);
        tf_preco.setVisible(false);
        tf_marca.setVisible(false);
        bt_salvar.setVisible(false);





    }
    @FXML
    void Afinar(ActionEvent event) {
        String nome = InstrumentoController.Instrumento.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text("Afinando "+nome )
                .darkStyle()
                .showInformation();




    }
    @FXML
    void Guardar(ActionEvent event) {
        String nome = InstrumentoController.Instrumento.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text("Guardando "+nome )
                .darkStyle()
                .showInformation();



    }

    @FXML
    void MostraTelaMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");

    }

    @FXML
    void Tocar(ActionEvent event) {
        String nome = InstrumentoController.Instrumento.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text("Tocando "+nome )
                .darkStyle()
                .showInformation();



    }

}
