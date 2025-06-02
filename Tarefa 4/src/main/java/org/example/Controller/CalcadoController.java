package org.example.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import org.example.App;
import org.example.Classe.Calcado;
import org.example.DAO.CalcadoDAO;

import java.io.IOException;

import static org.example.ExibirAlerta.exibirAlerta;

public class CalcadoController {

    @FXML
    private Button btnSalvar, btnAtualizar, btnExcluir, btnAlterar, bt_menu;
    @FXML
    private TableColumn<Calcado, Integer> colId;
    @FXML
    private TableColumn<Calcado, String> colTipo, colCor;
    @FXML
    private TableColumn<Calcado, Integer> colTamanho;
    @FXML
    private ImageView imageView;
    @FXML
    private TableView<Calcado> tableCalcados;
    @FXML
    private TextField txtTipo, txtCor, txtTamanho;

    private ObservableList<Calcado> listaCalcados = FXCollections.observableArrayList();
    private CalcadoDAO calcadoDAO = new CalcadoDAO();

    @FXML
    private void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));

        listaCalcados.setAll(calcadoDAO.listarTodos());
        tableCalcados.setItems(listaCalcados);
    }

    @FXML
    void Salvar(ActionEvent event) {
        try {
            String tipo = txtTipo.getText();
            String cor = txtCor.getText();
            int tamanho = Integer.parseInt(txtTamanho.getText());

            Calcado novoCalcado = new Calcado(0, tipo, cor, tamanho);
            calcadoDAO.salvar(novoCalcado);
            atualizarListaCalcados();

            txtTipo.clear();
            txtCor.clear();
            txtTamanho.clear();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Calçado salvo com sucesso!");
        } catch (NumberFormatException e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro", "Preencha todos os campos corretamente!");
        }
    }

    @FXML
    void Atualizar(ActionEvent event) {
        Calcado selecionado = tableCalcados.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            selecionado.setTipo(txtTipo.getText());
            selecionado.setCor(txtCor.getText());
            selecionado.setTamanho(Integer.parseInt(txtTamanho.getText()));

            calcadoDAO.atualizar(selecionado);
            atualizarListaCalcados();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Calçado atualizado com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um calçado para atualizar.");
        }
    }

    @FXML
    void Excluir(ActionEvent event) {
        Calcado selecionado = tableCalcados.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            calcadoDAO.excluir(selecionado.getId());
            atualizarListaCalcados();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Calçado excluído com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um calçado para excluir.");
        }
    }

    private void atualizarListaCalcados() {
        listaCalcados.setAll(calcadoDAO.listarTodos());
        tableCalcados.refresh();
    }

    @FXML
    void Alterar(ActionEvent event) {
        Calcado selecionado = tableCalcados.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            txtTipo.setText(selecionado.getTipo());
            txtCor.setText(selecionado.getCor());
            txtTamanho.setText(String.valueOf(selecionado.getTamanho()));
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um calçado para alterar.");
        }
    }

    @FXML
    void MostrarMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");
    }
}
