package org.example.Classe;

public class Calcado {
    private int id;
    private String tipo;
    private String cor;
    private Integer tamanho;

    public Calcado(int id, String tipo, String cor, Integer tamanho) {
        this.id = id;
        this.tipo = tipo;
        this.cor = cor;
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }
}
