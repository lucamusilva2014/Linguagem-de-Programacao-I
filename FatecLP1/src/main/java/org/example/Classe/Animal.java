package org.example.Classe;

public class Animal {
    private int id;
    private String nome;
    private String especie;
    private float peso;

    // Construtor
    public Animal(int id, String nome, String especie, float peso) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.peso = peso;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public float getPeso() { return peso; }
    public void setPeso(float peso) { this.peso = peso; }
}
