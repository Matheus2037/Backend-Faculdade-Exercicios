package org.example;

import java.util.ArrayList;

public class MusicCloud {
    private ArrayList<String> musicasDisponiveis;

    //Construtor da classe MusicCloud
    public MusicCloud() {
        musicasDisponiveis = new ArrayList<>();
    }

    //Getter e Setter do atributo musicasDisponiveis
    public ArrayList<String> getMusicasDisponiveis() {
        return this.musicasDisponiveis;
    }
    public void setMusicasDisponiveis(ArrayList<String> musicasDisponiveis) {
        this.musicasDisponiveis.addAll(musicasDisponiveis);
    }
}
