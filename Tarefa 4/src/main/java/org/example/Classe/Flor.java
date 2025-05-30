package org.example.Classe;

public class Flor {
        private String nome;
        private String cor;
        private String aroma;

        public Flor(String nome, String cor, String aroma) {
            this.nome = nome;
            this.cor = cor;
            this.aroma = aroma;
        }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAroma() {
        return aroma;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }
}
