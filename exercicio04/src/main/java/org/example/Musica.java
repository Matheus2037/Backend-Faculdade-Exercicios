package org.example;

public class Musica {
    private String titulo;
    private String artista;

    //Construtor da classe Musica
    public Musica(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    //Getters e Setters do atributo titulo
    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    //Getters e Setters do atributo artista
    public String getArtista(){
        return this.artista;
    }
    public void setArtista(String artista){
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Música: " + titulo + " - Artista: " + artista;
    }
}
