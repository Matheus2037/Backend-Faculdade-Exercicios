package org.example;

public class PortoPequeno extends BasePorto{

    public PortoPequeno(String nome) {
        this.nome = nome;
    }
    @Override
    public void atracarBarco(Barco barcoadd){
        if(barcoadd.tamanho <= 10){
            BarcosAtracados.add(barcoadd);
        }else {
            System.out.println("Barco " + barcoadd.nome + " é muito grande para o porto pequeno.");
        }
    }
}
