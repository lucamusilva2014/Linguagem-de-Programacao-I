package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class LivroController {

    @FXML
    private Button bt_avaliar;

    @FXML
    private Button bt_devolver;

    @FXML
    private Button bt_emprestar;

    @FXML
    private Button bt_salvar;

    @FXML
    private Button bt_voltar;

    @FXML
    private Label lb_classe;

    @FXML
    private TextField tf_autor;

    @FXML
    private TextField tf_genero;

    @FXML
    private TextField tf_titulo;
    public static class Livro {
        private static String titulo;
        private static String autor;
        private static String genero;

        public static String getTitulo() {
            return titulo;
        }

        public static void setTitulo(String titulo) {
            LivroController.Livro.titulo = titulo;
        }

        public String getAutor() {
            return autor;
        }

        public static void setAutor(String autor) {
            LivroController.Livro.autor = autor;
        }

        public String getGenero() {
            return genero;
        }

        public static void setGenero(String genero) {
            LivroController.Livro.genero= genero;
        }
    }


    @FXML
    void CadastrarLivro(ActionEvent event) {
        String titulo = tf_titulo.getText();
        String autor = tf_autor.getText();
        String genero = tf_genero.getText();
        LivroController.Livro.setTitulo(titulo);
        LivroController.Livro.setGenero(genero);
        LivroController.Livro.setAutor(autor);
        Notifications.create()
                .title("Cadastro de Livros")
                .position(Pos.TOP_CENTER)
                .text("Livro cadastrado com sucesso!\nTitulo: " + titulo + "\nAutor: " + autor+ "\nGenero: " + genero)
                .darkStyle()
                .showInformation();
        esconderCampos();
    }

    public void esconderCampos() {
        tf_titulo.setVisible(false);
        tf_autor.setVisible(false);
        tf_genero.setVisible(false);
        bt_salvar.setVisible(false);

    }

    @FXML
    void Devolver(ActionEvent event) {
        String titulo = LivroController.Livro.getTitulo();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(""+titulo+" Devolvido")
                .darkStyle()
                .showInformation();


    }

    @FXML
    void Emprestar(ActionEvent event) {
        String titulo = LivroController.Livro.getTitulo();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(""+titulo+" Emprestado")
                .darkStyle()
                .showInformation();


    }
    @FXML
    void Avaliar(ActionEvent event) {
        String titulo = LivroController.Livro.getTitulo();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(""+titulo+" Avaliado")
                .darkStyle()
                .showInformation();

    }


    @FXML
    void MostraTelaMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");

    }

}
