package org.example;

public class Filme {
    public String nome;
    public Float preco;
    public Integer idadeMinima;

    public Filme(String nome, Float preco, Integer idadeMinima) {
        this.nome = nome;
        this.preco = preco;
        this.idadeMinima = idadeMinima;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Integer getIdadeMinima() {
        return idadeMinima;
    }

    public void setIdadeMinima(Integer idadeMinima) {
        this.idadeMinima = idadeMinima;
    }
}
