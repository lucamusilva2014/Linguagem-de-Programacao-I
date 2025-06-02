package org.example.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import org.example.App;
import org.example.Classe.Livro;
import org.example.DAO.LivroDAO;

import java.io.IOException;

import static org.example.ExibirAlerta.exibirAlerta;

public class LivroController {

    @FXML
    private Button btnSalvar, btnAtualizar, btnExcluir, btnAlterar, bt_menu;
    @FXML
    private TableColumn<Livro, Integer> colId;
    @FXML
    private TableColumn<Livro, String> colTitulo, colAutor;
    @FXML
    private TableColumn<Livro, Integer> colAno;
    @FXML
    private ImageView imageView;
    @FXML
    private TableView<Livro> tableLivro;
    @FXML
    private TextField txttitulo, txtautor, txtAno;

    private ObservableList<Livro> listaLivros = FXCollections.observableArrayList();
    private LivroDAO livroDAO = new LivroDAO();

    @FXML
    private void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colAno.setCellValueFactory(new PropertyValueFactory<>("ano"));

        listaLivros.setAll(livroDAO.listarTodos());
        tableLivro.setItems(listaLivros);
    }

    @FXML
    void Salvar(ActionEvent event) {
        try {
            int isbn = listaLivros.size() + 1; // Geração automática de ID fictício
            String titulo = txttitulo.getText();
            String autor = txtautor.getText();
            int ano = Integer.parseInt(txtAno.getText());

            Livro novoLivro = new Livro(isbn, titulo, autor, ano);
            livroDAO.salvar(novoLivro);
            atualizarListaLivros();

            txttitulo.clear();
            txtautor.clear();
            txtAno.clear();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Livro salvo com sucesso!");
        } catch (NumberFormatException e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro", "Preencha todos os campos corretamente!");
        }
    }

    @FXML
    void Atualizar(ActionEvent event) {
        Livro selecionado = tableLivro.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            selecionado.setTitulo(txttitulo.getText());
            selecionado.setAutor(txtautor.getText());
            selecionado.setAno(Integer.parseInt(txtAno.getText()));

            livroDAO.atualizar(selecionado);
            atualizarListaLivros();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Livro atualizado com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um livro para atualizar.");
        }
    }

    @FXML
    void Excluir(ActionEvent event) {
        Livro selecionado = tableLivro.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            livroDAO.excluir(selecionado.getIsbn());
            atualizarListaLivros();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Livro excluído com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um livro para excluir.");
        }
    }

    private void atualizarListaLivros() {
        listaLivros.setAll(livroDAO.listarTodos());
        tableLivro.refresh();
    }

    @FXML
    void Alterar(ActionEvent event) {
        Livro selecionado = tableLivro.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            txttitulo.setText(selecionado.getTitulo());
            txtautor.setText(selecionado.getAutor());
            txtAno.setText(String.valueOf(selecionado.getAno()));
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um livro para alterar.");
        }
    }

    @FXML
    void MostrarMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");
    }
}
