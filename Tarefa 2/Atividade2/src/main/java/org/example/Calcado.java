package org.example;
import java.util.Scanner;

public class Calcado {
    private String tipo;
    private String cor;
    private Integer tamanho;

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }


    public void Calcar() {
        System.out.println("Calçou "+tipo);
    }


    public void Andar() {
        System.out.println("Andou com "+tipo);
    }


    public void Guardar() {
        System.out.println("Guardou "+tipo);
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        Calcado calcado = new Calcado();

        System.out.print("Digite o Tipo: ");
        calcado.setTipo(scanner.next());

        System.out.print("Digite a Cor: ");
        calcado.setCor(scanner.next());
        scanner.nextLine();

        System.out.print("Digite o Tamanho: ");
        calcado.setTamanho(scanner.nextInt());

        System.out.println("\nAções do Calçado:");
        calcado.Calcar();
        calcado.Andar();
        calcado.Guardar();
    }
}