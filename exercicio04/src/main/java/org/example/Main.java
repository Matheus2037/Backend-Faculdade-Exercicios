package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MusicCloud musicCloud = new MusicCloud();

        musicCloud.setMusicasDisponiveis(new Musica("Bad", "Michael Jackson"));
        musicCloud.setMusicasDisponiveis(new Musica("Stay", "Rihanna ft. Mikky Ekko"));
        musicCloud.setMusicasDisponiveis(new Musica("Happier", "Marshmello ft. Bastille"));
        musicCloud.setMusicasDisponiveis(new Musica("Shape", "Ed Sheeran"));

        System.out.print("Nome da Playlist: ");
        String nomePlaylist = scanner.nextLine();

        Playlist playlist = new Playlist(nomePlaylist, musicCloud);

        while (true){
            try{

                System.out.println(musicCloud.getMusicasDisponiveis());

                System.out.print("Qual o titulo/nome da musica: ");
                String tituloMusica = scanner.nextLine();

                boolean musicaEncontrada = false;

                for (Musica musica : musicCloud.getMusicasDisponiveis()){
                    if (musica.getTitulo().equalsIgnoreCase(tituloMusica)){
                        playlist.addMusicas(musica);
                        musicaEncontrada = true;
                        break;
                    }
                }
                if (!musicaEncontrada) {
                    System.out.println("Música não encontrada.");
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.print("Deseja continuar? (s/n): ");
            String continuar = scanner.nextLine();
            if (!continuar.equalsIgnoreCase("s")) {
                System.out.println("Sua playlist "+ playlist.getNome() + " ficou: \n" +
                        playlist.getMusicas());
                break;
            }
        }
    }
}