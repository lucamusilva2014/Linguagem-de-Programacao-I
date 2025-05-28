package org.example.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import org.example.Classe.Animal;
import org.example.DAO.AnimalDAO;

import static org.example.ExibirAlerta.exibirAlerta;

public class AnimalController {

    @FXML
    private Button btnAtualizar, btnExcluir, btnSalvar;
    @FXML
    private Button btnAlterar;

    @FXML
    private TableColumn<Animal, Integer> colId;

    @FXML
    private TableColumn<Animal, String> colNome, colEspecie;

    @FXML
    private TableColumn<Animal, Float> colPeso;

    @FXML
    private ImageView imageView;

    @FXML
    private TableView<Animal> tableAnimais;

    @FXML
    private TextField txtEspecie, txtNome, txtPeso;

    private ObservableList<Animal> listaAnimais = FXCollections.observableArrayList();
    private AnimalDAO animalDAO = new AnimalDAO();

    @FXML
    private void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));

        listaAnimais.setAll(animalDAO.listarTodos());
        tableAnimais.setItems(listaAnimais);
    }

    @FXML
    void Salvar(ActionEvent event) {
        try {
            String nome = txtNome.getText();
            String especie = txtEspecie.getText();
            float peso = Float.parseFloat(txtPeso.getText());

            Animal novoAnimal = new Animal(0, nome, especie, peso);
            animalDAO.salvar(novoAnimal);
            atualizarListaAnimais();

            txtNome.clear();
            txtEspecie.clear();
            txtPeso.clear();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Animal salvo com sucesso!");
        } catch (NumberFormatException e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro", "Prencha todo os Campos Corretamente!.");
        }
    }

    @FXML
    void Atualizar(ActionEvent event) {
        Animal selecionado = tableAnimais.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            selecionado.setNome(txtNome.getText());
            selecionado.setEspecie(txtEspecie.getText());
            selecionado.setPeso(Float.parseFloat(txtPeso.getText()));

            animalDAO.atualizar(selecionado);
            atualizarListaAnimais();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Animal atualizado com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um animal para atualizar.");
        }
        }


    @FXML
    void Excluir(ActionEvent event) {
        Animal selecionado = tableAnimais.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            animalDAO.excluir(selecionado.getId());
            atualizarListaAnimais();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Animal excluído com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um animal para excluir.");
        }
        }

    private void atualizarListaAnimais() {
        listaAnimais.setAll(animalDAO.listarTodos());
        tableAnimais.refresh();
    }

    @FXML
    void Alterar(ActionEvent event) {
        Animal selecionado = tableAnimais.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            txtNome.setText(selecionado.getNome());
            txtEspecie.setText(selecionado.getEspecie());
            txtPeso.setText(String.valueOf(selecionado.getPeso()));

        }
        else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione um animal para Alterar.");
        }

    }
}
