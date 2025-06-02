package org.example.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import org.example.App;
import org.example.Classe.Periferico;
import org.example.DAO.PerifericoDAO;

import java.io.IOException;

import static org.example.ExibirAlerta.exibirAlerta;

public class PerifericoController {

    @FXML
    private Button btnSalvar, btnAtualizar, btnExcluir, btnAlterar, bt_menu;
    @FXML
    private TableColumn<Periferico, Integer> colId;
    @FXML
    private TableColumn<Periferico, String> colNome, colModelo;
    @FXML
    private TableColumn<Periferico, Float> colPreco;
    @FXML
    private ImageView imageView;
    @FXML
    private TableView<Periferico> tablePeriferico;
    @FXML
    private TextField txtNome, txtModelo, txtPreco;

    private ObservableList<Periferico> listaPerifericos = FXCollections.observableArrayList();
    private PerifericoDAO perifericoDAO = new PerifericoDAO();

    @FXML
    private void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));

        listaPerifericos.setAll(perifericoDAO.listarTodos());
        tablePeriferico.setItems(listaPerifericos);
    }

    @FXML
    void Salvar(ActionEvent event) {
        try {
            String nome = txtNome.getText();
            String modelo = txtModelo.getText();
            float preco = Float.parseFloat(txtPreco.getText());

            Periferico novoPeriferico = new Periferico(0, nome, modelo, preco);
            perifericoDAO.salvar(novoPeriferico);
            atualizarListaPerifericos();

            txtNome.clear();
            txtModelo.clear();
            txtPreco.clear();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Periférico salvo com sucesso!");
        } catch (NumberFormatException e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro", "Preencha todos os campos corretamente!");
        }
    }

    @FXML
    void Atualizar(ActionEvent event) {
        Periferico selecionado = tablePeriferico.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            selecionado.setNome(txtNome.getText());
            selecionado.setModelo(txtModelo.getText());
            selecionado.setPreco(Float.parseFloat(txtPreco.getText()));

            perifericoDAO.atualizar(selecionado);
            atualizarListaPerifericos();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Periférico atualizado com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um periférico para atualizar.");
        }
    }

    @FXML
    void Excluir(ActionEvent event) {
        Periferico selecionado = tablePeriferico.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            perifericoDAO.excluir(selecionado.getId());
            atualizarListaPerifericos();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Periférico excluído com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um periférico para excluir.");
        }
    }

    private void atualizarListaPerifericos() {
        listaPerifericos.setAll(perifericoDAO.listarTodos());
        tablePeriferico.refresh();
    }

    @FXML
    void Alterar(ActionEvent event) {
        Periferico selecionado = tablePeriferico.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            txtNome.setText(selecionado.getNome());
            txtModelo.setText(selecionado.getModelo());
            txtPreco.setText(String.valueOf(selecionado.getPreco()));
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um periférico para alterar.");
        }
    }

    @FXML
    void MostrarMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");
    }
}
