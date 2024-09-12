package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MusicCloud musicCloud = new MusicCloud();

        musicCloud.setMusicasDisponiveis(new Musica("Teste Titulo 1", "Teste Artista 1"));
        musicCloud.setMusicasDisponiveis(new Musica("Teste Titulo 2", "Teste Artista 2"));
        musicCloud.setMusicasDisponiveis(new Musica("Teste Titulo 3", "Teste Artista 3"));
        musicCloud.setMusicasDisponiveis(new Musica("Teste Titulo 4", "Teste Artista 4"));

        while (true){
            try{
                System.out.print("Nome da Playlist: ");
                String nomePlaylist = scanner.nextLine();

                Playlist playlist = new Playlist(nomePlaylist, musicCloud);

                System.out.println(musicCloud.getMusicasDisponiveis());

                System.out.print("Qual o titulo/nome da musica: ");
                String tituloMusica = scanner.nextLine();

                for (Musica musica : musicCloud.getMusicasDisponiveis()){
                    if (musica.getTitulo().equals(tituloMusica)){
                        musicCloud.setMusicasDisponiveis(musica);
                        break;
                    }else{
                        System.out.println("Musica não encontrada.");
                        continue;
                    }
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.print("Deseja continuar? (s/n): ");
            String continuar = scanner.nextLine();
            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }
        }
    }
}