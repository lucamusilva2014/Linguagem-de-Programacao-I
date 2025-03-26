package org.example;
import java.util.Scanner;

public class Flor {
    private String nome;
    private String cor;
    private String aroma;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setAroma(String  aroma) {
        this.aroma = aroma;
    }


    public void Regar() {
        System.out.println( "Regando "+nome);
    }


    public void Polenizar() {
        System.out.println(nome+" Soltou Polen.");
    }


    public void Florescer() {
        System.out.println("Floresceu "+nome);
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        Flor  flor = new  Flor();

        System.out.print("Digite o Nome da Flor: ");
        flor.setNome(scanner.next());

        System.out.print("Digite a cor: ");
        flor.setCor(scanner.next());
        scanner.nextLine();

        System.out.print("Digite o Aroma: ");
        flor.setAroma(scanner.next());

        System.out.println("\nAções da Flor:");
        flor.Regar();
        flor.Polenizar();
        flor.Florescer();
    }
}