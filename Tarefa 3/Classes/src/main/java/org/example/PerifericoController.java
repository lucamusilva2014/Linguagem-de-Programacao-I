package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class PerifericoController {

    @FXML
    private Button bt_atualizar;

    @FXML
    private Button bt_conectar;

    @FXML
    private Button bt_desconectar;

    @FXML
    private Button bt_salvar;

    @FXML
    private Button bt_voltar;

    @FXML
    private Label lb_classe;

    @FXML
    private TextField tf_cor;

    @FXML
    private TextField tf_nome;

    @FXML
    private TextField tf_tipo;
    public static class Periferico {
        private static String nome;
        private static String cor;
        private static String tipo;

        public static String getNome() {
            return nome;
        }

        public static void setNome(String nome) {
            PerifericoController.Periferico.nome = nome;
        }

        public String getCor() {
            return cor;
        }

        public static void setCor(String cor) {
            PerifericoController.Periferico.cor = cor;
        }

        public String getTipo() {
            return tipo;
        }

        public static void setTipo(String tipo) {
            PerifericoController.Periferico.tipo= tipo;
        }
    }


    @FXML
    void CadastrarPeriferico(ActionEvent event) {
        String nome = tf_nome.getText();
        String tipo = tf_tipo.getText();
        String cor = tf_cor.getText();
        PerifericoController.Periferico.setNome(nome);
        PerifericoController.Periferico.setCor(cor);
        PerifericoController.Periferico.setTipo(tipo);
        Notifications.create()
                .title("Cadastro de Perifericos")
                .position(Pos.TOP_CENTER)
                .text("Periferico cadastrado com sucesso!\nNome: " + nome + "\nCor: " + cor+ "\nTipo: " + tipo)
                .darkStyle()
                .showInformation();
        esconderCampos();

    }

    public void esconderCampos() {
        tf_nome.setVisible(false);
        tf_cor.setVisible(false);
        tf_tipo.setVisible(false);
        bt_salvar.setVisible(false);

    }

    @FXML
    void Conectar(ActionEvent event) {
        String nome = PerifericoController.Periferico.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(""+nome+" Conectado")
                .darkStyle()
                .showInformation();


    }

    @FXML
    void Desconectar(ActionEvent event) {
        String nome = PerifericoController.Periferico.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(""+nome+" Desconectado")
                .darkStyle()
                .showInformation();


    }

    @FXML
    void MostraTelaMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");


    }

    @FXML
    void Save(ActionEvent event) {
        String nome = PerifericoController.Periferico.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text("Driver do "+nome+" Atualizado ")
                .darkStyle()
                .showInformation();


    }

}
