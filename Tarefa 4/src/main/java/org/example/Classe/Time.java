package org.example.Classe;

public class Time {
    private String nome;
    private String pais;
    private Integer titulos;

    public Time(String nome, String pais, Integer titulos) {
        this.nome = nome;
        this.pais = pais;
        this.titulos = titulos;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTitulos() {
        return titulos;
    }

    public void setTitulos(Integer titulos) {
        this.titulos = titulos;
    }
}
