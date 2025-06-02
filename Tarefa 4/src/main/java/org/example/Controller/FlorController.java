package org.example.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import org.example.App;
import org.example.Classe.Flor;
import org.example.DAO.FlorDAO;

import java.io.IOException;

import static org.example.ExibirAlerta.exibirAlerta;

public class FlorController {

    @FXML
    private Button btnSalvar, btnAtualizar, btnExcluir, btnAlterar, bt_menu;
    @FXML
    private TableColumn<Flor, String> colNome, colCor, colAroma;
    @FXML
    private ImageView imageView;
    @FXML
    private TableView<Flor> tableFlores;
    @FXML
    private TextField txtNome, txtCor, txtAroma;

    private ObservableList<Flor> listaFlores = FXCollections.observableArrayList();
    private FlorDAO florDAO = new FlorDAO();

    @FXML
    private void initialize() {
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colAroma.setCellValueFactory(new PropertyValueFactory<>("aroma"));

        listaFlores.setAll(florDAO.listarTodas());
        tableFlores.setItems(listaFlores);
    }

    @FXML
    void Salvar(ActionEvent event) {
        try {
            String nome = txtNome.getText();
            String cor = txtCor.getText();
            String aroma = txtAroma.getText();

            Flor novaFlor = new Flor(nome, cor, aroma);
            florDAO.salvar(novaFlor);
            atualizarListaFlores();

            txtNome.clear();
            txtCor.clear();
            txtAroma.clear();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Planta cadastrada com sucesso!");
        } catch (Exception e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro", "Preencha todos os campos corretamente!");
        }
    }

    @FXML
    void Atualizar(ActionEvent event) {
        Flor selecionada = tableFlores.getSelectionModel().getSelectedItem();
        if (selecionada != null) {
            selecionada.setCor(txtCor.getText());
            selecionada.setAroma(txtAroma.getText());

            florDAO.atualizar(selecionada);
            atualizarListaFlores();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Planta atualizada com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione uma Planta  para atualizar.");
        }
    }

    @FXML
    void Excluir(ActionEvent event) {
        Flor selecionada = tableFlores.getSelectionModel().getSelectedItem();
        if (selecionada != null) {
            florDAO.excluir(selecionada.getNome());
            atualizarListaFlores();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Planta  excluída com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione uma Planta  para excluir.");
        }
    }

    private void atualizarListaFlores() {
        listaFlores.setAll(florDAO.listarTodas());
        tableFlores.refresh();
    }

    @FXML
    void Alterar(ActionEvent event) {
        Flor selecionada = tableFlores.getSelectionModel().getSelectedItem();
        if (selecionada != null) {
            txtNome.setText(selecionada.getNome());
            txtCor.setText(selecionada.getCor());
            txtAroma.setText(selecionada.getAroma());
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione uma Planta  para alterar.");
        }
    }

    @FXML
    void MostrarMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");
    }
}
