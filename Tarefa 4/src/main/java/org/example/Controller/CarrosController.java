package org.example.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import org.example.App;
import org.example.Classe.Carro;
import org.example.DAO.CarroDAO;

import java.io.IOException;

import static org.example.ExibirAlerta.exibirAlerta;

public class CarrosController {

    @FXML
    private Button btnSalvar, btnAtualizar, btnExcluir, btnAlterar, bt_menu;
    @FXML
    private TableColumn<Carro, String> colPlaca, colModelo, colCor;
    @FXML
    private TableColumn<Carro, Integer> colAno;
    @FXML
    private ImageView imageView;
    @FXML
    private TableView<Carro> tableCarros;
    @FXML
    private TextField txtPlaca, txtModelo, txtAno, txtCor;

    private ObservableList<Carro> listaCarros = FXCollections.observableArrayList();
    private CarroDAO carroDAO = new CarroDAO();

    @FXML
    private void initialize() {
        colPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
        colCor.setCellValueFactory(new PropertyValueFactory<>("cor"));

        listaCarros.setAll(carroDAO.listarTodos());
        tableCarros.setItems(listaCarros);
    }

    @FXML
    void Salvar(ActionEvent event) {
        try {
            String placa = txtPlaca.getText();
            String modelo = txtModelo.getText();
            int ano = Integer.parseInt(txtAno.getText());
            String cor = txtCor.getText();

            Carro novoCarro = new Carro(placa, modelo, ano, cor);
            carroDAO.salvar(novoCarro);
            atualizarListaCarros();

            txtPlaca.clear();
            txtModelo.clear();
            txtAno.clear();
            txtCor.clear();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Carro salvo com sucesso!");
        } catch (NumberFormatException e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro", "Preencha todos os campos corretamente!");
        }
    }

    @FXML
    void Atualizar(ActionEvent event) {
        Carro selecionado = tableCarros.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            selecionado.setModelo(txtModelo.getText());
            selecionado.setAno(Integer.parseInt(txtAno.getText()));
            selecionado.setCor(txtCor.getText());

            carroDAO.atualizar(selecionado);
            atualizarListaCarros();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Carro atualizado com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um carro para atualizar.");
        }
    }

    @FXML
    void Excluir(ActionEvent event) {
        Carro selecionado = tableCarros.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            carroDAO.excluir(selecionado.getPlaca());
            atualizarListaCarros();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Carro excluído com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um carro para excluir.");
        }
    }

    private void atualizarListaCarros() {
        listaCarros.setAll(carroDAO.listarTodos());
        tableCarros.refresh();
    }

    @FXML
    void Alterar(ActionEvent event) {
        Carro selecionado = tableCarros.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            txtPlaca.setText(selecionado.getPlaca());
            txtModelo.setText(selecionado.getModelo());
            txtAno.setText(String.valueOf(selecionado.getAno()));
            txtCor.setText(selecionado.getCor());
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um carro para alterar.");
        }
    }

    @FXML
    void MostrarMenu(ActionEvent event) throws IOException {
        App.setRoot("menu");
    }
}
