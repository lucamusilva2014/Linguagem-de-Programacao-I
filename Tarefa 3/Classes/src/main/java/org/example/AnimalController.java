package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class AnimalController {

    @FXML
    private Button bt_comer;

    @FXML
    private Button bt_correr;

    @FXML
    private Button bt_dormir;

    @FXML
    private Button bt_salvar;

    @FXML
    private Button bt_voltar;

    @FXML
    private Label lb_carro;

    @FXML
    private TextField tf_especie;

    @FXML
    private TextField tf_nome;

    @FXML
    private TextField tf_peso;

    public static class Animal {
        private static String nome;
        private static String especie;
        private static Float peso;

        public static String getNome() {
            return nome;
        }

        public static void setNome(String nome) {
            AnimalController.Animal.nome = nome;
        }

        public String getEspecie() {
            return especie;
        }

        public static void setEspecie(String especie) {
            AnimalController.Animal.especie = especie;
        }

        public Float getPeso() {
            return peso;
        }

        public static void setPeso(Float peso) {
            AnimalController.Animal.peso = peso;
        }
    }

    @FXML
  public void CadastrarAnimal(ActionEvent event) {
        String nome = tf_nome.getText();
        Float peso =  Float.parseFloat(tf_peso.getText());
        String especie = tf_especie.getText();
        AnimalController.Animal.setNome(nome);
        AnimalController.Animal.setPeso(peso);
        AnimalController.Animal.setEspecie(especie);
        Notifications.create()
                .title("Cadastro de Animais")
                .position(Pos.TOP_CENTER)
                .text("Animal cadastrado com sucesso!\nNome: " + nome + "\nEspécie: " + especie + "\nPeso: " + peso)
                .darkStyle()
                .showInformation();
        esconderCampos();

    }

    public void esconderCampos() {
        tf_nome.setVisible(false);
        tf_peso.setVisible(false);
        tf_especie.setVisible(false);
        bt_salvar.setVisible(false);




    }

    @FXML
  public void Comer(ActionEvent event) {
        String nome = AnimalController.Animal.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(""+nome+" Está Comendo" )
                .darkStyle()
                .showInformation();



    }

    @FXML
 public void Correr(ActionEvent event) {
        String nome = AnimalController.Animal.getNome();

        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(""+nome+" Está Correndo" )
                .darkStyle()
                .showInformation();


    }

    @FXML
   public void Dormir(ActionEvent event) {
        String nome =  AnimalController.Animal.getNome();
        Notifications.create()
                .title("Ação")
                .position(Pos.TOP_CENTER)
                .text(""+nome+" Está Dormindo" )
                .darkStyle()
                .showInformation();


    }

    @FXML
   public void MostraTelaMenu(ActionEvent event) throws IOException {

        App.setRoot("menu");

    }

}
