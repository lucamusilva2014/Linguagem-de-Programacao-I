# Lista de Exercicios 2
 ## 1. Coletar 10 figuras contendo dois ou mais objetos de uma mesma classe. 
 ### Imagem 1 - Carros
![302478-diferentes-tipos-de-carros-gratis-vetor](https://github.com/user-attachments/assets/7d6e9d57-294c-410a-a2fd-22670886b532)

 ### Imagem 2 - Pessoas
 ![images](https://github.com/user-attachments/assets/eb8900a8-d207-4d8a-9c2b-142579f23f63)

  ### Imagem 3 - Animais
  
![download](https://github.com/user-attachments/assets/406aab14-00b8-467a-bc7c-2de948539900)

 ### Imagem 4 - Perifericos

![perifericos-entrada-y-salida](https://github.com/user-attachments/assets/3cd8bee6-81f4-4734-a984-1ff2c8864295)

### Imagem 5 - Jogos
![images (1)](https://github.com/user-attachments/assets/e5d40441-91eb-40a0-9f54-433577534b54)

### Imagem 6 - Flores 
![download (1)](https://github.com/user-attachments/assets/25475054-e3ba-4b5e-90a1-a37dbf7f6dce)

### Imagem 7 - Times
![images (2)](https://github.com/user-attachments/assets/37029bef-daa0-43be-b95f-fe8ce5c5fe67)

### Imagem 8-Livros
![depositphotos_12376816-stock-photo-stack-of-old-books](https://github.com/user-attachments/assets/36545578-0223-47d0-93c4-3c650da7bfc1)

### Imagem 9-Calçados
![depositphotos_89625510-stock-illustration-woman-shoes-set](https://github.com/user-attachments/assets/3d213545-01c0-49f0-b43e-cd75b9dd05b0)
### Imagem 10- Instrumentos
![gettyimages-461072583-612x612](https://github.com/user-attachments/assets/9765d25d-f4d9-4c8d-a10c-3eb5e9b5d4a8)

## 2.Modelar via UML ou outra ferramenta cada classe do item 1, com três métodos e três atributos.
![image](https://github.com/user-attachments/assets/e3536e58-22e4-4dfc-b34b-d0ade89553b1)


## 3.Implementar, usando a Linguagem Java, as classes modeladas no item 2.
### Carro
``` java
package org.example;
import java.util.Scanner;

public class Carro {
    private String modelo;
    private int ano;
    private String cor;

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }


    public void ligarmotor() {
        System.out.println(modelo + " Ligou o motor");
    }


    public void acelarar() {
        System.out.println(modelo + " Acelerou");
    }


    public void frear() {
        System.out.println(modelo + " Freiou");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carro carro = new Carro();

        System.out.print("Digite o Modelo do Carro: ");
        carro.setModelo(scanner.nextLine());

        System.out.print("Digite o Ano do Carro : ");
        carro.setAno(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Digite a Cor do Carro : ");
        carro.setCor(scanner.nextLine());

        System.out.println("\nAções do Carro:");
        carro.ligarmotor();
        carro.acelarar();
        carro.frear();

        scanner.close();
    }
}
```
### Pessoa
```java
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

    public static void main(String[] args) {
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

        scanner.close();
    }
}
```
### Animal
```java
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Animal animal = new Animal();

        System.out.print("Digite a Especie: ");
        animal.setEspecie(scanner.nextLine());

        System.out.print("Digite o Peso: ");
        animal.setPeso(scanner.nextFloat());
        scanner.nextLine();

        System.out.print("Digite a Idade : ");
        animal.setIdade(scanner.nextInt());

        System.out.println("\nAções da Pessoa:");
        animal.Comer();
        animal.Dormir();
        animal.Correr();

        scanner.close();
    }
}
```
### Periferico
```java
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

    public static void main(String[] args) {
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

        scanner.close();
    }
}
```
### Jogo
```java
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

    public static void main(String[] args) {
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

        scanner.close();
    }
}
```
### Flor
```java
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

    public static void main(String[] args) {
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

        scanner.close();
    }
}
```
### Time

```java
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

    public static void main(String[] args) {
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

        scanner.close();
    }
}
```
### Livro
```java
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

    public static void main(String[] args) {
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

        scanner.close();
    }
}
```
### Calçado
```java
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

    public static void main(String[] args) {
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

        scanner.close();
    }
}
```

### Instrumento
```java
package org.example;
import java.util.Scanner;

public class Instrumento {
    private String tipo;
    private String marca;
    private Float  preco;

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }


    public void Tocar() {
        System.out.println("Tocou "+tipo);
    }


    public void Afinar() {
        System.out.println("Afinou"+tipo);
    }


    public void Limpar() {
        System.out.println("Limpou "+tipo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Instrumento instrumento = new Instrumento();

        System.out.print("Digite o Tipo: ");
        instrumento.setTipo(scanner.next());

        System.out.print("Digite a Marca: ");
        instrumento.setMarca(scanner.next());
        scanner.nextLine();

        System.out.print("Digite o Preço: ");
        instrumento.setPreco(scanner.nextFloat());

        System.out.println("\nAções do Instrumento:");
        instrumento.Tocar();
        instrumento.Afinar();
        instrumento.Limpar();

        scanner.close();
    }
}
```
## 4.Criar uma classe TestaClasse, contendo: método main,  um objeto de cada classe para teste.  Nesta classe, evocar, pelo menos, dois métodos de cada classe. Além disso, a classe TestaClasse deve conter um menu em que fica em loop, apresentando as opções até que o usuário deseje sair.
```java
package org.example;

import java.util.Scanner;

class SomarSubtrair {
    int somar(int a, int b) {
        return a + b;
    }

    int subtrair(int a, int b) {
        return a - b;
    }
}

class MultiplicarDividir {
    int multiplicar(int a, int b) {
        return a * b;
    }

    double dividir(int a, int b) {
        if (b != 0) {
            return (double) a / b;
        } else {
            System.out.println("Erro: Divisão por zero!");
            return Double.NaN;
        }
    }
}


```
## 5 Observar a figura a seguir e implementar uma classe contendo as operações de soma, subtração, multiplicação e divisão. A classe deverá conter os atributos numerador e denominador. O resultado deve ser apresentado no formato de fração simplificada.
```java
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

public class CalculadoraDeFracoes {
    public static void main(String[] args) {
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
        s.close();
    }
}
```
