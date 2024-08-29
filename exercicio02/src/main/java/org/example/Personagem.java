package org.example;

public class Personagem {
    public String nome;
    public Integer vida;
    public Integer ataque;

    public void receberDano(Integer dano){
        this.vida -= dano;
    }
    public void atacar(Personagem personagem){
        if (personagem.vida > 0){
            personagem.receberDano(this.ataque);
        }
        else {
            System.out.println("Ataque falhou!");
        }

    }
}
