package org.example;
import java.util.Scanner;

public class Instrumento {
    private String tipo;
    private String marca;
    private Float  preco;

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }


    public void Tocar() {
        System.out.println("Tocou "+tipo);
    }


    public void Afinar() {
        System.out.println("Afinou"+tipo);
    }


    public void Limpar() {
        System.out.println("Limpou "+tipo);
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        Instrumento instrumento = new Instrumento();

        System.out.print("Digite o Tipo: ");
        instrumento.setTipo(scanner.next());

        System.out.print("Digite a Marca: ");
        instrumento.setMarca(scanner.next());
        scanner.nextLine();

        System.out.print("Digite o Preço: ");
        instrumento.setPreco(scanner.nextFloat());

        System.out.println("\nAções do Instrumento:");
        instrumento.Tocar();
        instrumento.Afinar();
        instrumento.Limpar();
    }
}