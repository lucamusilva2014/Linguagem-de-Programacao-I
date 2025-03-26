package org.example;
import java.util.Scanner;


public class TesteClasse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean sair = false;

        Animal animal = new Animal();
        Calcado calcado = new Calcado();
        Carro carro = new Carro();
        Flor  flor = new  Flor();
        Instrumento instrumento = new Instrumento();
        Jogo jogo = new Jogo();
        Livro  livro = new Livro();
        Time  time = new Time();
        Periferico periferico= new Periferico();
        Pessoa pessoa = new Pessoa();

        while(!sair) {
            System.out.println("\nEscolha uma Opção ");
            System.out.println("1 - Classe Animal");
            System.out.println("2 - Classe Calcado");
            System.out.println("3 - Classe Carro");
            System.out.println("4 - Classe Flor");
            System.out.println("5 - Classe Instrumento");
            System.out.println("6 - Classe Jogo");
            System.out.println("7 - Classe Livro");
            System.out.println("8 - Classe Pessoa");
            System.out.println("9 - Classe Time");
            System.out.println("10 - Classe Periferico");
            System.out.println("11- Calculo de Frações");
            System.out.println("0 - Sair");
            System.out.println("Digite sua Opção:");
            int opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    Animal.main();
                break;
                case 2:
                    Calcado.main();
                break;
                case 3:
                    Carro.main();
                    break;
                case 4:
                    Flor.main();
                    break;
                case 5:
                    Instrumento.main();
                    break;
                case 6:
                    Jogo.main();
                    break;
                case 7:
                    Livro.main();
                    break;
                case 8:
                    Pessoa.main();
                    break;
                case 9:
                    Time.main();
                    break;
                case 10:
                    Periferico.main();
                    break;
                case 11:
                    Fracoes.main();
                    break;
                case 0:
                    sair = true;
                    System.out.println("Saiu do programa");
                    break;
                default:
                    System.out.println("Opção invalida");


            }
        }
        scanner.close();
    }

}
