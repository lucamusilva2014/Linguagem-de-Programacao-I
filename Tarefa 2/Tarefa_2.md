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
### Carro
![image](https://github.com/user-attachments/assets/cbaf9257-1701-4cbe-82e0-50dc24912599)

### Pessoa
![image](https://github.com/user-attachments/assets/bb7ce9f5-047c-4098-8d23-9eabc81f67cb)

### Animal
![image](https://github.com/user-attachments/assets/4444fc79-d6e8-4a8b-8cca-92c4d31b81b4)

### Perifericos
![image](https://github.com/user-attachments/assets/f574a421-cbb7-4bb2-8889-c425ce274400)

### Jogo
![image](https://github.com/user-attachments/assets/2ff98b80-39c0-404a-8066-65b652a773f2)

### Flor
![image](https://github.com/user-attachments/assets/3191b3a3-ce0b-455b-8d77-5d9be8eb23f8)

 ### Time
![image](https://github.com/user-attachments/assets/e7bad9f0-59be-4dc6-9ee2-dbff4b6985d7)

### Livro
![image](https://github.com/user-attachments/assets/c7e9722e-d62a-4879-914c-dfb5772c6ecf)

### Calçados
![image](https://github.com/user-attachments/assets/0e6263be-866c-44a5-91df-c695376f6872)

### Instrumento
![image](https://github.com/user-attachments/assets/4d2cf6c7-c2eb-4202-a6a4-6b18eebcfd54)

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

