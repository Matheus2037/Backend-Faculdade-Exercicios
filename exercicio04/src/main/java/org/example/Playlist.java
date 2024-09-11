package org.example;

import java.util.ArrayList;

public class Playlist {
    private String nome;
    private ArrayList<Musica> Musicas;

    //Construtor da classe Playlist
    public Playlist(String nome) {
        this.nome = nome;
        Musicas = new ArrayList<>();
    }

    // Getters e Setters para o atributo Nome
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    // Getters e Setters para o atributo Musicas
    public ArrayList<Musica> getMusicas(){
        return this.Musicas;
    }
    public void addMusicas(ArrayList<Musica> Musicas){
        this.Musicas.addAll(Musicas);
    }
}
