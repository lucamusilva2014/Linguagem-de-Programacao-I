package org.example.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import org.example.App;
import org.example.Classe.Pessoa;
import org.example.DAO.PessoaDAO;

import java.io.IOException;

import static org.example.ExibirAlerta.exibirAlerta;

public class PessoaController {

    @FXML
    private Button btnAlterar, bt_menu, btnAtualizar, btnExcluir1, btnSalvar;

    @FXML
    private TableColumn<Pessoa, Integer> colIdade;
    @FXML
    private TableColumn<Pessoa, String> colCpf, colNome;

    @FXML
    private ImageView imageView;

    @FXML
    private TableView<Pessoa> tablePessoas;

    @FXML
    private TextField txtCpf, txtNome, txtIdade;

    private final ObservableList<Pessoa> listaPessoas = FXCollections.observableArrayList();
    private final PessoaDAO pessoaDAO = new PessoaDAO();

    @FXML
    private void initialize() {
        colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));

        atualizarListaPessoas();
    }

    private void atualizarListaPessoas() {
        listaPessoas.setAll(pessoaDAO.listarTodos());
        tablePessoas.setItems(listaPessoas);
        tablePessoas.refresh();
    }

    @FXML
    void Alterar(ActionEvent event) {
        Pessoa selecionado = tablePessoas.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            txtNome.setText(selecionado.getNome());
            txtCpf.setText(selecionado.getCpf());
            txtIdade.setText(String.valueOf(selecionado.getIdade()));
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione uma pessoa para alterar.");
        }
    }

    @FXML
    void Atualizar(ActionEvent event) {
        Pessoa selecionado = tablePessoas.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            selecionado.setNome(txtNome.getText());
            selecionado.setCpf(txtCpf.getText());
            try {
                selecionado.setIdade(Integer.parseInt(txtIdade.getText()));
                pessoaDAO.atualizar(selecionado);
                atualizarListaPessoas();
                exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Pessoa atualizada com sucesso!");
            } catch (NumberFormatException e) {
                exibirAlerta(Alert.AlertType.ERROR, "Erro", "Idade deve ser um número válido.");
            }
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione uma pessoa para atualizar.");
        }
    }

    @FXML
    void Excluir(ActionEvent event) {
        Pessoa selecionado = tablePessoas.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            pessoaDAO.excluir(selecionado.getCpf());
            atualizarListaPessoas();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Pessoa excluída com sucesso!");
        } else {
            exibirAlerta(Alert.AlertType.WARNING, "Atenção", "Selecione uma pessoa para excluir.");
        }
    }

    @FXML
    void Salvar(ActionEvent event) {
        try {
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            int idade = Integer.parseInt(txtIdade.getText());

            Pessoa novaPessoa = new Pessoa(cpf, nome, idade);
            pessoaDAO.salvar(novaPessoa);
            atualizarListaPessoas();

            txtNome.clear();
            txtCpf.clear();
            txtIdade.clear();
            exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Pessoa salva com sucesso!");
        } catch (NumberFormatException e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro", "Preencha todos os campos corretamente!");
        }
    }

    @FXML
    void MostrarMenu(ActionEvent event) {
        try {
            App.setRoot("menu");
        } catch (IOException e) {
            exibirAlerta(Alert.AlertType.ERROR, "Erro", "Falha ao carregar o menu.");
        }
    }
}
