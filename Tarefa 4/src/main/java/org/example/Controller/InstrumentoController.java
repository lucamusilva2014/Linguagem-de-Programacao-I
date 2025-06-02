package org.example.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import org.example.App;
import org.example.Classe.Instrumento;
import org.example.DAO.InstrumentoDAO;

import java.io.IOException;

import static org.example.ExibirAlerta.exibirAlerta;

public class InstrumentoController {

    @FXML
    private Button btnSalvar, btnAtualizar, btnExcluir, btnAlterar, bt_menu;
    @FXML
    private TableColumn<Instrumento, String> colTipo, colMarca;
    @FXML
    private TableColumn<Instrumento, Float> colPreco;
    @FXML
    private ImageView imageView;
    @FXML
    private TableView<Instrumento> tableInstrumento;
    @FXML
    private TextField txtTipo, txtMarca, txtPreco;

    private ObservableList<Instrumento> listaInstrumentos = FXCollections.observableArrayList();
    private InstrumentoDAO instrumentoDAO = new InstrumentoDAO();

    @FXML
    private void initialize() {
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));

        listaInstrumentos.setAll(instrumentoDAO.listarTodos());
        tableInstrumento.setItems(listaInstrumentos);
    }

    @FXML
    void Salvar(ActionEvent event) {
        try {
            String tipo = txtTipo.getText();
            String marca = txtMarca.getText();
            float preco = Float.parseFloat(txtPreco.getText());

            Instrumento novoInstrumento = new Instrumento(tipo, marca, preco);
            instrumentoDAO.salvar(novoInstrumento);
            atualizarListaInstrumentos();

            txtTipo.clear();
            txtMarca.clear();
            txtPreco.clear();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Instrumento salvo com sucesso!");
        } catch (NumberFormatException e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro", "Preencha todos os campos corretamente!");
        }
    }

    @FXML
    void Atualizar(ActionEvent event) {
        Instrumento selecionado = tableInstrumento.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            selecionado.setMarca(txtMarca.getText());
            selecionado.setPreco(Float.parseFloat(txtPreco.getText()));

            instrumentoDAO.atualizar(selecionado);
            atualizarListaInstrumentos();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Instrumento atualizado com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um instrumento para atualizar.");
        }
    }

    @FXML
    void Excluir(ActionEvent event) {
        Instrumento selecionado = tableInstrumento.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            instrumentoDAO.excluir(selecionado.getTipo());
            atualizarListaInstrumentos();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Instrumento excluído com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um instrumento para excluir.");
        }
    }

    private void atualizarListaInstrumentos() {
        listaInstrumentos.setAll(instrumentoDAO.listarTodos());
        tableInstrumento.refresh();
    }

    @FXML
    void Alterar(ActionEvent event) {
        Instrumento selecionado = tableInstrumento.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            txtTipo.setText(selecionado.getTipo());
            txtMarca.setText(selecionado.getMarca());
            txtPreco.setText(String.valueOf(selecionado.getPreco()));
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um instrumento para alterar.");
        }
    }

    @FXML
    void MostrarMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");
    }
}
