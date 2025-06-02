package org.example.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import org.example.App;
import org.example.Classe.Jogo;
import org.example.DAO.JogoDAO;

import java.io.IOException;

import static org.example.ExibirAlerta.exibirAlerta;

public class JogoController {

    @FXML
    private Button btnSalvar, btnAtualizar, btnExcluir, btnAlterar, bt_menu;
    @FXML
    private TableColumn<Jogo, Integer> colId;
    @FXML
    private TableColumn<Jogo, String> colNome, colPlataforma, colTipo;
    @FXML
    private ImageView imageView;
    @FXML
    private TableView<Jogo> tableJogo;
    @FXML
    private TextField txtNome, txtPlataforma, txtTipo;

    private ObservableList<Jogo> listaJogos = FXCollections.observableArrayList();
    private JogoDAO jogoDAO = new JogoDAO();

    @FXML
    private void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colPlataforma.setCellValueFactory(new PropertyValueFactory<>("plataforma"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        listaJogos.setAll(jogoDAO.listarTodos());
        tableJogo.setItems(listaJogos);
    }

    @FXML
    void Salvar(ActionEvent event) {
        try {
            String nome = txtNome.getText();
            String plataforma = txtPlataforma.getText();
            String tipo = txtTipo.getText();

            Jogo novoJogo = new Jogo(0, nome, plataforma, tipo);
            jogoDAO.salvar(novoJogo);
            atualizarListaJogos();

            txtNome.clear();
            txtPlataforma.clear();
            txtTipo.clear();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Jogo salvo com sucesso!");
        } catch (Exception e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro", "Preencha todos os campos corretamente!");
        }
    }

    @FXML
    void Atualizar(ActionEvent event) {
        Jogo selecionado = tableJogo.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            selecionado.setNome(txtNome.getText());
            selecionado.setPlataforma(txtPlataforma.getText());
            selecionado.setTipo(txtTipo.getText());

            jogoDAO.atualizar(selecionado);
            atualizarListaJogos();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Jogo atualizado com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um jogo para atualizar.");
        }
    }

    @FXML
    void Excluir(ActionEvent event) {
        Jogo selecionado = tableJogo.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            jogoDAO.excluir(selecionado.getId());
            atualizarListaJogos();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Jogo excluído com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um jogo para excluir.");
        }
    }

    private void atualizarListaJogos() {
        listaJogos.setAll(jogoDAO.listarTodos());
        tableJogo.refresh();
    }

    @FXML
    void Alterar(ActionEvent event) {
        Jogo selecionado = tableJogo.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            txtNome.setText(selecionado.getNome());
            txtPlataforma.setText(selecionado.getPlataforma());
            txtTipo.setText(selecionado.getTipo());
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um jogo para alterar.");
        }
    }

    @FXML
    void MostrarMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");
    }
}
