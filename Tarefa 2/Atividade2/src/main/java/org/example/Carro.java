package org.example;
import java.util.Scanner;

public class Carro {
    private String modelo;
    private int ano;
    private String cor;

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }


    public void ligarmotor() {
        System.out.println(modelo + " Ligou o motor");
    }


    public void acelarar() {
        System.out.println(modelo + " Acelerou");
    }


    public void frear() {
        System.out.println(modelo + " Freiou");
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        Carro carro = new Carro();

        System.out.print("Digite o Modelo do Carro: ");
        carro.setModelo(scanner.nextLine());

        System.out.print("Digite o Ano do Carro : ");
        carro.setAno(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Digite a Cor do Carro : ");
        carro.setCor(scanner.nextLine());

        System.out.println("\nAções do Carro:");
        carro.ligarmotor();
        carro.acelarar();
        carro.frear();
    }
}