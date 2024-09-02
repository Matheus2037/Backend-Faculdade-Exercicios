package org.example;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BasePorto {
    public String nome;
    ArrayList<Barco> BarcosAtracados = new ArrayList<>();

    public void atracarBarco(Barco barcoadd){

        BarcosAtracados.add(barcoadd);
        System.out.println("Barco " + barcoadd.nome + " atracado no porto: " + nome);
    }
    public void desatracarBarco(Barco barcoremover){
        BarcosAtracados.remove(barcoremover);
        System.out.println("Barco " + barcoremover.nome + " desatracado do porto: " + nome);
    }
}
