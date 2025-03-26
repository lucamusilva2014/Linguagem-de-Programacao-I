package org.example;

import java.util.Scanner;

class Fracao {
    int numerador, denominador;

    Fracao(int num, int den) {
        if (den == 0) throw new IllegalArgumentException("Denominador não pode ser zero.");
        int m = mdc(num, den);
        numerador = num / m;
        denominador = den / m;
    }

    int mdc(int a, int b) {
        return b == 0 ? Math.abs(a) : mdc(b, a % b);
    }

    Fracao somar(Fracao f) {
        int num = numerador * f.denominador + f.numerador * denominador;
        int den = denominador * f.denominador;
        return new Fracao(num, den);
    }

    Fracao operar(Fracao f, char op) {
        int num = 0, den = 0;
        if (op == '+') return somar(f);
        if (op == '-') { num = numerador * f.denominador - f.numerador * denominador; den = denominador * f.denominador; }
        if (op == '*') { num = numerador * f.numerador; den = denominador * f.denominador; }
        if (op == '/') {
            if (f.numerador == 0) throw new ArithmeticException("Divisão por zero não permitida.");
            num = numerador * f.denominador;
            den = denominador * f.numerador;
        }
        return new Fracao(num, den);
    }

    public String toString() {
        return numerador + "/" + denominador;
    }
}

public class Fracoes {
    public static void main() {
        Scanner s = new Scanner(System.in);

        System.out.print("Escolha a operação (+, -, *, /): ");
        char op = s.next().charAt(0);

        System.out.print("Quantas frações deseja inserir? ");
        int n = s.nextInt();

        System.out.print("Digite o numerador da primeira fração: ");
        int num = s.nextInt();
        int den;
        do {
            System.out.print("Digite o denominador da primeira fração (não pode ser zero): ");
            den = s.nextInt();
        } while (den == 0);

        Fracao resultado = new Fracao(num, den);

        for (int i = 1; i < n; i++) {
            System.out.print("Digite o numerador da próxima fração: ");
            num = s.nextInt();
            do {
                System.out.print("Digite o denominador da próxima fração (não pode ser zero): ");
                den = s.nextInt();
            } while (den == 0);

            resultado = resultado.operar(new Fracao(num, den), op);
        }

        System.out.println("Resultado: " + resultado);
    }
}