package org.example;
import java.util.Scanner;

public class Livro {
    private String titulo;
    private String autor;
    private Integer ano;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }


    public void Avaliar() {
        System.out.println(titulo+"Avaliado");
    }


    public void Emprestar() {
        System.out.println(titulo+" Emprestado");
    }


    public void Abrir() {
        System.out.println(titulo+" Foi Aberto");
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        Livro  livro = new Livro();

        System.out.print("Digite o Titulo: ");
        livro.setTitulo(scanner.next());

        System.out.print("Digite o Autor: ");
        livro.setAutor(scanner.next());
        scanner.nextLine();

        System.out.print("Digite o Ano: ");
        livro.setAno(scanner.nextInt());

        System.out.println("\nAções do Livro:");
        livro.Avaliar();
        livro.Emprestar();
        livro.Abrir();
    }
}