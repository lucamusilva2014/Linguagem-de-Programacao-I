# Lista de Exercicios 1

## 1)Faça um algoritmo que leia a idade de uma pessoa expressa em anos, meses e dias e escreva a idade dessa pessoa expressa apenas em dias. Considerar ano com 365 dias e mês com 30 dias. 
```java
import java.util.*;
public class Idade{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Expresse sua idade na:");
        System.out.println("Quantidade de anos");
        int ano = sc.nextInt();
        System.out.println("Quantidade de meses");
        int mes = sc.nextInt();
        System.out.println("Quantidade de dias");
        int dia = sc.nextInt();
        int total= (ano*365)+(mes*30)+dia;
        System.out.println("Total de dias  " +  total);
     }
}
```


## 2)Escreva um algoritmo para ler o número total de eleitores de um município, o número de votos brancos, nulos e válidos. Calcular e escrever o percentual que cada um representa em relação ao total de eleitores. 
```java
import java.util.*;
public class Eleitores{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Total de Eleitores");
        int eleitores = sc.nextInt();
        System.out.println("Votos Brancos");
        int branco = sc.nextInt();
        System.out.println("Votos Nulos");
        int nulo= sc.nextInt();
        System.out.println("Votos Validos");
        int valido= sc.nextInt();
       if((branco+nulo+valido)>eleitores) {
        System.out.println("Total de votos maior que numeros de Eleitores");  
}else {


        float pbranco= (branco*100)/eleitores;
        float pnulo= (nulo*100)/eleitores;
        float pvalido= (valido*100)/eleitores;
        System.out.println("Votos Brancos:" + pbranco+"%");
        System.out.println("Votos Nulos:" + pnulo+"%");
        System.out.println("Votos Validos:" + pvalido+"%");
     }
     }
}
```

## 3)Escreva um algoritmo para ler o salário mensal atual de um funcionário e o percentual de reajuste. Calcular e escrever o valor do novo salário. 

```java
import java.util.*;
public class Reajuste{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Salario Mensal");
        float salario = sc.nextFloat();
        System.out.println("Reajuste");
        float reajuste = sc.nextFloat();
        float total=(salario*(reajuste/100))+salario;
        
  
        System.out.println("Salario apos reajuste:" + total);
     }
}

```

## 4)O custo de um carro novo ao consumidor é a soma do custo de fábrica com a porcentagem do distribuidor e dos impostos (aplicados ao custo de fábrica). Supondo que o percentual do distribuidor seja de 28% e os impostos de 45%, escrever um algoritmo para ler o custo de fábrica de um carro, calcular e escrever o custo final ao consumidor. 

```java
import java.util.*;
public class Carro{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Custo de Fabrica");
        double custo = sc.nextDouble();
        double imposto =(custo*0.45);
        double dist=(custo*0.28);
        double total=custo+imposto+dist;
        String resultado = String.format("%.2f", total);
        
  
        System.out.println("Custo Total do Carro:" + resultado);
     }
}
```

## 5)Uma revendedora de carros usados paga a seus funcionários vendedores um salário fixo por mês, mais uma comissão também fixa para cada carro vendido e mais 5% do valor das vendas por ele efetuadas. Escrever um algoritmo que leia o número de carros por ele vendidos, o valor total de suas vendas, o salário fixo e o valor que ele recebe por carro vendido. Calcule e escreva o salário final do vendedor.

```java
import java.util.*;
public class Carro{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Carros Vendidos:");
        int carro = sc.nextInt();
        System.out.println("Valor Total de Vendas:");
        double venda= sc.nextDouble();
        System.out.println("Salario Fixo:");
        double salario = sc.nextDouble();
        System.out.println("Valor por Carro Vendido:");
        double valorc = sc.nextDouble();     
        
        double total=salario+(valorc*carro)+(venda*0.05);
        
        String resultado = String.format("%.2f", total);
        
  
        System.out.println("Salario Final:" + resultado);
     }
}
```

## 6)Escreva um algoritmo para ler uma temperatura em graus Fahrenheit, calcular e escrever o valor correspondente em graus Celsius. Observação: Para testar se a sua resposta está correta saiba que 100°C = 212°F
```java
import java.util.*;
public class Temperatura{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Temperatura Fahrenheit:");
        double fahrenheit = sc.nextDouble();
        double celsius=(fahrenheit-32)/1.8;
        String resultado = String.format("%.2f", celsius);
        
  
        System.out.println("Temperatura em Celsius:" + resultado);
     }
}
```
## 7)Ler um valor e escrever a mensagem É MAIOR QUE 10! se o valor lido for maior que 10, caso contrário escrever NÃO É MAIOR QUE 10! 
```java
import java.util.*;
public class Maior{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um numero:");
        int numero = sc.nextInt();
if(numero>10) {
        System.out.println("Numero Maior que 10");  
}else {
        System.out.println("Numero Nao e Maior que 10");  
     }
     
}
}
```
## 8)Ler um valor e escrever se é positivo ou negativo (considere o valor zero como positivo). 
```java
import java.util.*;
public class Positivo{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um numero:");
        int numero = sc.nextInt();
if(numero>0) {
        System.out.println("Positivo");  
}else {
        System.out.println("Negativo");  
     }
     
}
}
```
## 9)As maçãs custam R$ 1,30 cada se forem compradas menos de uma dúzia, e R$ 1,00 se forem compradas pelo menos doze. Escreva um programa que leia o número de maçãs compradas, calcule e escreva o custo total da compra. 
```java
import java.util.*;
public class Vendas{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Macas Compradas:");
        int macas = sc.nextInt();

if(macas<12) {
       double total=(1.30*macas); 
    String resultado = String.format("%.2f", total);
    System.out.println("Valor Total:" + resultado);
       
}else {
       double total=1*macas; 
    String resultado = String.format("%.2f", total);
    System.out.println("Valor Total:" + resultado);
     }
}
}
```
## 10)Ler as notas da 1a. e 2a. avaliações de um aluno. Calcular a média aritmética simples e escrever uma mensagem que diga se o aluno foi ou não aprovado (considerar que nota igual ou maior que 6 o aluno é aprovado). Escrever também a média calculada. 

```java
import java.util.*;
public class Nota{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Avaliacao 1:");
        double nota1 = sc.nextDouble();
        System.out.println("Avaliacao 2:");
        double nota2 = sc.nextDouble();
        double media=(nota1+nota2)/2;
    String resultado = String.format("%.2f", media);
    System.out.println("Media:" + resultado);
        
if(media>=6) {
    System.out.println("Aprovado");
       
}else {
    System.out.println("Reprovado");
     }
}
}
```
## 11)Ler o ano atual e o ano de nascimento de uma pessoa. Escrever uma mensagem que diga se ela poderá ou não votar este ano (não é necessário considerar o mês em que a pessoa nasceu).
```java
import java.util.*;
public class Voto{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ano atual:");
        int atual = sc.nextInt();
        System.out.println("Ano de Nascimento:");
        int nasc = sc.nextInt();
        int idade=atual-nasc;
if(idade<16) {
    System.out.println("Nao Pode Votar");
       
}else {
    System.out.println("Pode Votar");
     }
}
}
```
## 12)Ler dois valores (considere que não serão lidos valores iguais) e escrever o maior deles. 
```java
import java.util.*;
public class Maior{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um Valor:");
        int valor1 = sc.nextInt();
        System.out.println("Digite Outro Valor:");
        int  valor2= sc.nextInt();
        
if(valor1>valor2) {
    System.out.println("Valor Maior:"+valor1);
       
}else {
    System.out.println("Valor Maior:"+valor2);
     }
}
}

```

## 13)Ler dois valores (considere que não serão lidos valores iguais) e escrevê-los em ordem crescente.
```java
import java.util.*;
public class Crescente{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um Valor:");
        int valor1 = sc.nextInt();
        System.out.println("Digite Outro Valor:");
        int  valor2= sc.nextInt();
        
if(valor1>valor2) {
    System.out.println(""+valor2+", "+valor1);
       
}else {
    System.out.println(""+valor1+", "+valor2);
     }
}
}
```
## 14)Ler a hora de início e a hora de fim de um jogo de Xadrez (considere apenas horas inteiras, sem os minutos) e calcule a duração do jogo em horas, sabendo-se que o tempo máximo de duração do jogo é de 24 horas e que o jogo pode iniciar em um dia e terminar no dia seguinte.
```java
import java.util.*;
public class Xadrez{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hora Inicio:");
        int inicio = sc.nextInt();
        System.out.println("Hora Fim:");
        int  fim= sc.nextInt();
        
if(inicio==fim) {
    int total=24;
    System.out.println("Tempo de Jogo:"+total);
}
else if(inicio<fim) {
    int total=fim-inicio;
    System.out.println("Tempo de Jogo:"+total);
}
else {
    int total=24-(inicio-fim);
    System.out.println("Tempo de Jogo:"+total);
}
}
}
```
## 15)A jornada de trabalho semanal de um funcionário é de 40 horas. O funcionário que trabalhar mais de 40 horas receberá hora extra, cujo cálculo é o valor da hora regular com um acréscimo de 50%. Escreva um algoritmo que leia o número de horas trabalhadas em um mês, o salário por hora e escreva o salário total do funcionário, que deverá ser acrescido das horas extras, caso tenham sido trabalhadas (considere que o mês possua 4 semanas exatas).
 ```java
import java.util.*;
public class Jornada{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hora Trabalhadas:");
        int horas = sc.nextInt();
        System.out.println("Salario por Hora:");
        double  salario= sc.nextDouble();
        
        
if(horas>160) {
    double extra=(horas-160)*(salario*1.5);
    double salariot=extra+salario*160;
    String resultado = String.format("%.2f", salariot);
    System.out.println("Salario Total:"+resultado);
}
else {
    double salariot=salario*horas;
    String resultado = String.format("%.2f", salariot);
    System.out.println("Salario Total:"+resultado);
}
}
}
```
## 16)Na empresa em que trabalhamos, há tabelas com o gasto de cada mês. Para fechar o balanço do primeiro trimestre, precisamos somar o gasto total. Sabendo que, em janeiro, foram gastos 15 mil reais, em fevereiro, 23 mil reais e, em março, 17 mil reais, faça um programa que calcule e imprima a despesa total no trimestre e a média mensal de gastos.
```java
import java.util.*;
public class Trimestre{



     public static void main(String []args){
         //declaração de variável
         int j, f, m, total; 
         float media;
         //atribuição de valor à vari´vel
         Scanner sc = new Scanner(System.in);
         
         j=15000;
         f=23000;
         m=17000;
         // calculos necessários
         total=j+f+m;
         media= total/3;
         
         // impressão de resultados
        System.out.println("Total de gastos");
        System.out.println(total);
        System.out.println("Media de gastos:  " +  media);
        // lendo dados
        System.out.println("Digite o gasto em abril");
        j=sc.nextInt();
        
        System.out.println("Digite o gasto em maio");
        f=sc.nextInt();
         System.out.println("Digite o gasto em junho");
        m=sc.nextInt();
        
        // calculos
        total=j+f+m;
         media= total/3;
         
         // impressão de resultados
        System.out.println("Total de gastos");
        System.out.println(total);
        System.out.println("Media de gastos:  " +  media);
        
     }
}

```

## 17)Programa que leia as notas e calcule a média de LP1 deste semestre, referente a um determinado aluno.
### Fórmula para cálculo de média de LP1. (P1*0.6+((E1+E2)/2)*0.4)*0.5+(max(((P1*0.6+((E1+E2)/2)*0.4)-5.9),0)/((P1*0.6+((E1+E2)/2)*0.4)-5.9))*(API*0.5)+X+(SUB*0.2)

```java
/* Online Java Compiler and Editor */
import java.util.*;
public class Nota{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("P1:");
        double p1 = sc.nextDouble();
        System.out.println("E1:");
        double e1 = sc.nextDouble();
        System.out.println("E2:");
        double e2 = sc.nextDouble();
        System.out.println("API:");
        double api = sc.nextDouble();
        System.out.println("x:");
        double x = sc.nextDouble(); 
        double y = (p1*0.6 + ((e1+e2)/2)*0.4-5.9);
        double z = 0;
       double max= Math.max(y, z);
    double nota =(p1*0.6+((e1+e2)/2)*0.4)*0.5+(max/y)*(api*0.5)+x;
            System.out.println("Nota:"+nota);
    if (nota<6){
        System.out.println("SUB:");
        double sub = sc.nextDouble(); 
      double  nota_final=nota+(sub*0.2);
        System.out.println("Nota Final:"+nota_final);
    }
     }
}
```
