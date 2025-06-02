Create database classes;
use classes;
CREATE TABLE animais (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    peso FLOAT NOT NULL
);
CREATE TABLE pessoas (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    idade INT NOT NULL
);
CREATE TABLE calcado(
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(100) NOT NULL,
    cor VARCHAR(50) NOT NULL,
    tamanho INT
);
CREATE TABLE carro(
 placa VARCHAR(10) PRIMARY KEY,
    modelo VARCHAR(100) NOT NULL,
    ano INT NOT NULL,
    cor VARCHAR(50) NOT NULL

);
CREATE TABLE flor(
    nome VARCHAR(100) NOT NULL,
    cor VARCHAR(50) NOT NULL,
    aroma VARCHAR(100) NOT NULL
);
 CREATE TABLE instrumento(
  tipo VARCHAR(100) NOT NULL,
    marca VARCHAR(100) NOT NULL,
    preco FLOAT NOT NULL
 
 );
 
CREATE TABLE jogo(
id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    plataforma VARCHAR(50) NOT NULL,
    tipo VARCHAR(50) NOT NULL
);
CREATE TABLE livro(
  isbn INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    autor VARCHAR(150) NOT NULL,
    ano INT

);
CREATE TABLE periferico(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    preco FLOAT NOT NULL
);
CREATE TABLE time(
    nome VARCHAR(100) NOT NULL,
    pais VARCHAR(100) NOT NULL,
    titulos INT

);