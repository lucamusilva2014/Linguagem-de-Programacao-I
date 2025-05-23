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

public class AnimalController {

    @FXML
    private Button btnAtualizar, btnExcluir, btnSalvar;

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
        } catch (NumberFormatException e) {
            System.out.println("Erro: Peso precisa ser um número válido.");
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
        }
    }

    @FXML
    void Excluir(ActionEvent event) {
        Animal selecionado = tableAnimais.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            animalDAO.excluir(selecionado.getId());
            atualizarListaAnimais();
        }
    }

    private void atualizarListaAnimais() {
        listaAnimais.setAll(animalDAO.listarTodos());
        tableAnimais.refresh();
    }
}
