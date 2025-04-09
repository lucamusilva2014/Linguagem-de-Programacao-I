package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class PessoaController {

    @FXML
    private Button bt_andar;

    @FXML
    private Button bt_estudar;

    @FXML
    private Button bt_programar;

    @FXML
    private Button bt_salvar;

    @FXML
    private Button bt_voltar;

    @FXML
    private Label lb_carro;

    @FXML
    private TextField tf_email;

    @FXML
    private TextField tf_idade;

    @FXML
    private TextField tf_nome;

    public static class Pessoa {
        private static String nome;
        private static String email;
        private static int idade;

        public static String getNome() {
            return nome;
        }

        public static void setNome(String nome) {
            PessoaController.Pessoa.nome = nome;
        }

        public String getCor() {
            return email;
        }

        public static void setEmail(String email) {
            PessoaController.Pessoa.email = email;
        }

        public int getAno() {
            return idade;
        }

        public static void setIdade(int idade) {
            PessoaController.Pessoa.idade = idade;
        }
    }

    @FXML
    void CadastrarPessoa(ActionEvent event) {
        String nome = tf_nome.getText();
        int idade = Integer.parseInt(tf_idade.getText());
        String email = tf_email.getText();
        PessoaController.Pessoa.setNome(nome);
        PessoaController.Pessoa.setIdade(idade);
        PessoaController.Pessoa.setEmail(email);
        Notifications.create()
                .title("Cadastro de Carro")
                .position(Pos.TOP_CENTER)
                .text("Pessoa cadastrado com sucesso!\nNome: " + nome + "\nIdade: " + idade + "\nEmail: " + email)
                .darkStyle()
                .showInformation();
        esconderCampos();

    }

    private void esconderCampos() {
        tf_nome.setVisible(false);
        tf_idade.setVisible(false);
        tf_email.setVisible(false);
        bt_salvar.setVisible(false);


    }

    @FXML
    void Estudar(ActionEvent event) {
        String nome = PessoaController.Pessoa.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(""+nome+" Está Estudando" )
                .darkStyle()
                .showInformation();


    }

    @FXML
    void MostraTelaMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");
    }

    @FXML
    void Programar(ActionEvent event) {
        String nome = PessoaController.Pessoa.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(""+nome+" Esta Programando" )
                .darkStyle()
                .showInformation();

    }

    public void Andar(ActionEvent actionEvent) {
        String nome = PessoaController.Pessoa.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(""+nome+" Andou" )
                .darkStyle()
                .showInformation();

    }
}
