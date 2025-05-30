package org.example.Classe;

public class Jogo {
    private int id;
    private String nome;
    private String plataforma;
    private String tipo;

    public Jogo(int id, String nome, String plataforma, String tipo) {
        this.id = id;
        this.nome = nome;
        this.plataforma = plataforma;
        this.tipo = tipo;
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

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
