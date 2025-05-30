package org.example.Classe;

public class Periferico {
        private int id;
        private String nome;
        private String modelo;
        private Float preco;

        public Periferico(int id, String nome, String modelo, Float preco) {
                this.id = id;
                this.nome = nome;
                this.modelo = modelo;
                this.preco = preco;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getModelo() {
                return modelo;
        }

        public void setModelo(String modelo) {
                this.modelo = modelo;
        }

        public Float getPreco() {
                return preco;
        }

        public void setPreco(Float preco) {
                this.preco = preco;
        }
}


