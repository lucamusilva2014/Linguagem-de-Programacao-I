package org.example.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import org.example.App;
import org.example.Classe.Time;
import org.example.DAO.TimeDAO;

import java.io.IOException;

import static org.example.ExibirAlerta.exibirAlerta;

public class TimeController {

    @FXML
    private Button btnSalvar, btnAtualizar, btnExcluir, btnAlterar, bt_menu;
    @FXML
    private TableColumn<Time, String> colNome, colPais;
    @FXML
    private TableColumn<Time, Integer> colTitulos;
    @FXML
    private ImageView imageView;
    @FXML
    private TableView<Time> tableTimes;
    @FXML
    private TextField txtNome, txtPais, txtTitulos;

    private ObservableList<Time> listaTimes = FXCollections.observableArrayList();
    private TimeDAO timeDAO = new TimeDAO();

    @FXML
    private void initialize() {
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colPais.setCellValueFactory(new PropertyValueFactory<>("pais"));
        colTitulos.setCellValueFactory(new PropertyValueFactory<>("titulos"));

        listaTimes.setAll(timeDAO.listarTodos());
        tableTimes.setItems(listaTimes);
    }

    @FXML
    void Salvar(ActionEvent event) {
        try {
            String nome = txtNome.getText();
            String pais = txtPais.getText();
            int titulos = Integer.parseInt(txtTitulos.getText());

            Time novoTime = new Time(nome, pais, titulos);
            timeDAO.salvar(novoTime);
            atualizarListaTimes();

            txtNome.clear();
            txtPais.clear();
            txtTitulos.clear();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Time cadastrado com sucesso!");
        } catch (NumberFormatException e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro", "Preencha todos os campos corretamente!");
        }
    }

    @FXML
    void Atualizar(ActionEvent event) {
        Time selecionado = tableTimes.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            selecionado.setPais(txtPais.getText());
            selecionado.setTitulos(Integer.parseInt(txtTitulos.getText()));

            timeDAO.atualizar(selecionado);
            atualizarListaTimes();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Time atualizado com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um time para atualizar.");
        }
    }

    @FXML
    void Excluir(ActionEvent event) {
        Time selecionado = tableTimes.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            timeDAO.excluir(selecionado.getNome());
            atualizarListaTimes();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Time excluído com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um time para excluir.");
        }
    }

    private void atualizarListaTimes() {
        listaTimes.setAll(timeDAO.listarTodos());
        tableTimes.refresh();
    }

    @FXML
    void Alterar(ActionEvent event) {
        Time selecionado = tableTimes.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            txtNome.setText(selecionado.getNome());
            txtPais.setText(selecionado.getPais());
            txtTitulos.setText(String.valueOf(selecionado.getTitulos()));
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um time para alterar.");
        }
    }

    @FXML
    void MostrarMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");
    }
}
