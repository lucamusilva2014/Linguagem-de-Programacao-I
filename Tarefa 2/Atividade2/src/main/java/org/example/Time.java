package org.example;
import java.util.Scanner;

public class Time {
    private String nome;
    private String pais;
    private Integer titulos;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setTitulos(Integer titulos) {
        this.titulos = titulos;
    }


    public void Ganhar() {
        System.out.println( nome+" Ganhou.");
    }


    public void Empatar() {
        System.out.println(nome+" Empatou.");
    }


    public void Perder() {
        System.out.println(nome+" Perdeu.");
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        Time  time = new Time();

        System.out.print("Digite o Nome do Time: ");
        time.setNome(scanner.next());

        System.out.print("Digite o País do Time: ");
        time.setPais(scanner.next());
        scanner.nextLine();

        System.out.print("Digite a Quantidade de Titulos: ");
        time.setTitulos(scanner.nextInt());

        System.out.println("\nAções do Time:");
        time.Ganhar();
        time.Empatar();
        time.Perder();
    }
}