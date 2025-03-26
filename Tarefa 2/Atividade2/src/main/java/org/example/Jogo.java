package org.example;
import java.util.Scanner;

public class Jogo {
    private String nome;
    private String plataforma;
    private String tipo;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public void setTipo(String  tipo) {
        this.tipo = tipo;
    }


    public void Iniciar() {
        System.out.println( "Iniciando:"+nome);
    }


    public void Salvar() {
        System.out.println("Salvando:"+nome);
    }


    public void Encerrar() {
        System.out.println("Encerrando:"+nome);
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        Jogo jogo = new Jogo();

        System.out.print("Digite o Nome do Jogo: ");
        jogo.setNome(scanner.next());

        System.out.print("Digite a Plataforma: ");
        jogo.setPlataforma(scanner.next());
        scanner.nextLine();

        System.out.print("Digite o Tipo: ");
        jogo.setTipo(scanner.next());

        System.out.println("\nAções do Jogo:");
        jogo.Iniciar();
        jogo.Salvar();
        jogo.Encerrar();
    }
}