package org.example;
import java.util.Scanner;

public class Periferico {
    private String nome;
    private String modelo;
    private String cor;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCor(String  cor) {
        this.cor = cor;
    }


    public void Conectar() {
        System.out.println(nome+" Conectado");
    }


    public void Atualizar() {
        System.out.println("Atualizando Driver do "+nome);
    }


    public void Desconectar() {
        System.out.println(nome+" Desconectado");
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        Periferico periferico= new Periferico();

        System.out.print("Digite o Nome do Periferico: ");
        periferico.setNome(scanner.next());

        System.out.print("Digite o Modelo do Periferico: ");
        periferico.setModelo(scanner.next());
        scanner.nextLine();

        System.out.print("Digite a Cor do Periferico: ");
        periferico.setCor(scanner.next());

        System.out.println("\nAções do Periferico:");
        periferico.Conectar();
        periferico.Atualizar();
        periferico.Desconectar();
    }
}