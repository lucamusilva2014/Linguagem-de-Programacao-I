package org.example.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import org.example.Classe.Animal;

public class AnimalController {

    @FXML
    private Button btnAtualizar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnSalvar;

    @FXML
    private TableColumn<Animal, Integer> colId;

    @FXML
    private TableColumn<Animal, String> colNome;

    @FXML
    private TableColumn<Animal, String> colEspecie;

    @FXML
    private TableColumn<Animal, Float> colPeso;

    @FXML
    private ImageView imageView;

    @FXML
    private TableView<Animal> tableAnimais;

    @FXML
    private TextField txtEspecie;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPeso;

    private ObservableList<Animal> listaAnimais = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));

        // Associar lista à tabela
        tableAnimais.setItems(listaAnimais);
    }

    @FXML
    void Salvar(ActionEvent event) {
        try {
            int id = listaAnimais.size() + 1; // Gerando um ID simples
            String nome = txtNome.getText();
            String especie = txtEspecie.getText();
            float peso = Float.parseFloat(txtPeso.getText());

            Animal novoAnimal = new Animal(id, nome, especie, peso);
            listaAnimais.add(novoAnimal); // Adiciona à lista, que reflete na tabela

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
            tableAnimais.refresh(); // Atualiza a tabela
        }
    }

    @FXML
    void Excluir(ActionEvent event) {
        Animal selecionado = tableAnimais.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            listaAnimais.remove(selecionado);
        }
    }
}
