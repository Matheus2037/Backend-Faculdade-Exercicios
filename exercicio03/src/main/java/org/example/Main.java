package org.example;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Barco> Barcos = new ArrayList<>();

        Barcos.add(new Barco("Titanic", 15));
        Barcos.add(new Barco("Balsa Pequena", 5));
        Barcos.add(new Barco("Porta Aviões", 20));
        Barcos.add(new Barco("Iate Luxuoso", 8));
        Barcos.add(new Barco("Canoa", 3));

        PortoPequeno portoPequeno = new PortoPequeno("Porto Pequeno");
        PortoGrande portoGrande = new PortoGrande("Porto Grande");

        for (Barco barco : Barcos) {
            portoPequeno.atracarBarco(barco);

            if (!portoPequeno.BarcosAtracados.contains(barco)) {
                portoGrande.atracarBarco(barco);
            }
        }

        System.out.println("\nBarcos atracados no Porto Pequeno:");
        for (Barco barco : portoPequeno.BarcosAtracados) {
            System.out.println(barco.nome);
        }

        System.out.println("\nBarcos atracados no Porto Grande:");
        for (Barco barco : portoGrande.BarcosAtracados) {
            System.out.println(barco.nome);
        }
    }
}