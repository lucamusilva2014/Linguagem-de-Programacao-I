package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class JogoController {

    @FXML
    private Button bt_salvar;

    @FXML
    private Button bt_save;

    @FXML
    private Button bt_start;

    @FXML
    private Button bt_turnoff;

    @FXML
    private Button bt_voltar;

    @FXML
    private Label lb_classe;

    @FXML
    private TextField tf_plataforma;

    @FXML
    private TextField tf_nome;

    @FXML
    private TextField tf_tipo;

    public static class Jogo {
        private static String nome;
        private static String plataforma;
        private static String tipo;

        public static String getNome() {
            return nome;
        }

        public static void setNome(String nome) {
            JogoController.Jogo.nome = nome;
        }

        public String getPlataforma() {
            return plataforma;
        }

        public static void setPlataforma(String plataforma) {
            JogoController.Jogo.plataforma = plataforma;
        }

        public String getTipo() {
            return tipo;
        }

        public static void setTipo(String tipo) {
            JogoController.Jogo.tipo= tipo;
        }
    }

    @FXML
    void CadastrarJogo(ActionEvent event) {
        String nome = tf_nome.getText();
        String tipo = tf_tipo.getText();
        String plataforma = tf_plataforma.getText();
        JogoController.Jogo.setNome(nome);
        JogoController.Jogo.setPlataforma(plataforma);
        JogoController.Jogo.setTipo(tipo);
        Notifications.create()
                .title("Cadastro de Jogos")
                .position(Pos.TOP_CENTER)
                .text("Jogo cadastrado com sucesso!\nNome: " + nome + "\nPlataforma: " + plataforma+ "\nTipo: " + tipo)
                .darkStyle()
                .showInformation();
        esconderCampos();

    }

    public void esconderCampos() {
        tf_nome.setVisible(false);
        tf_plataforma.setVisible(false);
        tf_tipo.setVisible(false);
        bt_salvar.setVisible(false);

    }

    @FXML
    void Save(ActionEvent event) {
        String nome = JogoController.Jogo.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text("Salvando "+nome)
                .darkStyle()
                .showInformation();



    }

    @FXML
    void MostraTelaMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");

    }

    @FXML
    void Start(ActionEvent event) {
        String nome = JogoController.Jogo.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text("Iniciando "+nome)
                .darkStyle()
                .showInformation();



}

    @FXML
    void Turnoff(ActionEvent event) {
        String nome = JogoController.Jogo.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text("Encerrando "+nome)
                .darkStyle()
                .showInformation();



    }

}
