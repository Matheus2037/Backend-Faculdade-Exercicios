package org.example;

import java.util.ArrayList;

public class Playlist {
    private String nome;
    private ArrayList<Musica> musicas;
    private MusicCloud musicCloud;

    //Construtor da classe Playlist
    public Playlist(String nome, MusicCloud musicCloud) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
        this.musicCloud = musicCloud;
    }

    // Getters e Setters para o atributo Nome
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getters e Setters para o atributo musicas
    public ArrayList<Musica> getMusicas() {
        return this.musicas;
    }

    public boolean addMusicas(Musica musica) throws Exception {
        // Usa a instância de MusicCloud para acessar as músicas disponíveis
        ArrayList<Musica> musicasDisponiveis = musicCloud.getMusicasDisponiveis();

        if (musicasDisponiveis.contains(musica.getTitulo())) {
            this.musicas.add(musica);
            return true;
        } else {
            throw new Exception("A música não está disponível no catálogo.");
        }
    }
}
