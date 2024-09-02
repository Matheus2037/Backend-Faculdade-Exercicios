package org.example;

public class PortoGrande extends BasePorto {

    public PortoGrande(String nome) {
        this.nome = nome;
    }

    @Override
    public void atracarBarco(Barco barcoadd) {
        if (barcoadd.tamanho > 10) {
            super.atracarBarco(barcoadd);
        } else {
            System.out.println("Barco " + barcoadd.nome + " é muito pequeno para o porto grande.");
        }
    }
}
