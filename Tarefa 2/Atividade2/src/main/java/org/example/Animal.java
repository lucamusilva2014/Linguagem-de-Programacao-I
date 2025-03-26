package org.example;
import java.util.Scanner;

public class Animal {
    private String especie;
    private float peso;
    private int idade;

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


    public void Correr() {
        System.out.println(especie + " Correu");
    }


    public void Comer() {
        System.out.println(especie + " Comeu");
    }


    public void Dormir() {
        System.out.println(especie + " Dormiu");
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        Animal animal = new Animal();

        System.out.print("Digite a Especie: ");
        animal.setEspecie(scanner.nextLine());

        System.out.print("Digite o Peso: ");
        animal.setPeso(scanner.nextFloat());
        scanner.nextLine();

        System.out.print("Digite a Idade : ");
        animal.setIdade(scanner.nextInt());

        System.out.println("\nAções do Animal:");
        animal.Comer();
        animal.Dormir();
        animal.Correr();

    }
}