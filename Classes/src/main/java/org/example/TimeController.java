package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class TimeController {

    @FXML
    private Button bt_empatar;

    @FXML
    private Button bt_ganhar;

    @FXML
    private Button bt_perder;

    @FXML
    private Button bt_salvar;

    @FXML
    private Button bt_voltar;

    @FXML
    private Label lb_classe;

    @FXML
    private TextField tf_nacionalidade;

    @FXML
    private TextField tf_nome;

    @FXML
    private TextField tf_titulos;
    public static class Time {
        private static String nome;
        private static String nacionalidade;
        private static Integer titulos;

        public static String getNome() {
            return nome;
        }

        public static void setNome(String nome) {
            TimeController.Time.nome = nome;
        }

        public String getEspecie() {
            return nacionalidade;
        }

        public static void setNacionalidade(String nacionalidade) {
            TimeController.Time.nacionalidade = nacionalidade;
        }

        public Integer getTitulos() {
            return titulos;
        }

        public static void setTitulos(Integer titulos) {
            TimeController.Time.titulos = titulos;
        }
    }


    @FXML
    void CadastrarTime(ActionEvent event) {
        String nome = tf_nome.getText();
        Integer titulos = Integer.parseInt(tf_titulos.getText());
        String nacionalidade = tf_nacionalidade.getText();
        TimeController.Time.setNome(nome);
        TimeController.Time.setTitulos(titulos);
        TimeController.Time.setNacionalidade(nacionalidade);
        Notifications.create()
                .title("Cadastro de Times")
                .position(Pos.TOP_CENTER)
                .text("Time cadastrado com sucesso!\nNome: " + nome + "\nNacionalidade: " + nacionalidade + "\nTitulos: " + titulos)
                .darkStyle()
                .showInformation();
        esconderCampos();



    }
    public void esconderCampos() {
        tf_nome.setVisible(false);
        tf_nacionalidade.setVisible(false);
        tf_titulos.setVisible(false);
        bt_salvar.setVisible(false);

    }


    @FXML
    void Empatar(ActionEvent event) {
        String nome = TimeController.Time.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(""+nome+" Empatou o Jogo" )
                .darkStyle()
                .showInformation();


    }

    @FXML
    void Ganhar(ActionEvent event) {
        String nome = TimeController.Time.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(""+nome+"Ganhou o Jogo" )
                .darkStyle()
                .showInformation();


    }

    @FXML
    void MostraTelaMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");

    }

    @FXML
    void Perder(ActionEvent event) {
        String nome = TimeController.Time.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(""+nome+" Perdeu o Jogo" )
                .darkStyle()
                .showInformation();


    }

}
