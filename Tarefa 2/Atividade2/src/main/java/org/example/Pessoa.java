package org.example;
import java.util.Scanner;

public class Pessoa {
    private String nome;
    private int idade;
    private String email;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void Andar() {
        System.out.println(nome + " andou");
    }


    public void Estudar() {
        System.out.println(nome + " Estudou");
    }


    public void Programar() {
        System.out.println(nome + " Programando");
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();

        System.out.print("Digite o Nome: ");
        pessoa.setNome(scanner.nextLine());

        System.out.print("Digite a Idade: ");
        pessoa.setIdade(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Digite o Email : ");
        pessoa.setEmail(scanner.nextLine());

        System.out.println("\nAções da Pessoa:");
        pessoa.Andar();
        pessoa.Estudar();
        pessoa.Programar();
    }
}