package org.example;

import java.util.ArrayList;

public class MusicCloud {
    private ArrayList<Musica> musicasDisponiveis;

    //Construtor da classe MusicCloud
    public MusicCloud() {
        musicasDisponiveis = new ArrayList<Musica>();
    }

    //Getter e Setter do atributo musicasDisponiveis
    public ArrayList<Musica> getMusicasDisponiveis() {
        return this.musicasDisponiveis;
    }
    public void setMusicasDisponiveis(Musica musica) {
        this.musicasDisponiveis.add(musica);
    }
}
