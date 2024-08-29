package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ArrayList<Personagem> inimigos = new ArrayList<>();
        Random random = new Random();

        Personagem Orc = new Personagem();
        Personagem Goblin = new Personagem();
        Personagem Lobo = new Personagem();
        Personagem Jogador = new Personagem();

        Jogador.nome = "Amassador de monstro";
        Jogador.vida = 125;
        Jogador.ataque = 25;

        Orc.nome = "Orc";
        Orc.vida = 150;
        Orc.ataque = 20;

        Goblin.nome = "Goblin";
        Goblin.vida = 75;
        Goblin.ataque = 5;

        Lobo.nome = "Lobo";
        Lobo.vida = 100;
        Lobo.ataque = 10;

        inimigos.add(Orc);
        inimigos.add(Goblin);
        inimigos.add(Lobo);


        Jogador.atacar(Lobo);

        while (Jogador.vida > 0 && !todosInimigosDerrotados(inimigos)) {
            Personagem inimigoAleatorio = inimigos.get(random.nextInt(inimigos.size()));
            Jogador.atacar(inimigoAleatorio);
            System.out.println(Jogador.nome + " atacou " + inimigoAleatorio.nome + ". Vida restante do " + inimigoAleatorio.nome + ": " + inimigoAleatorio.vida);

            Collections.shuffle(inimigos);

            for (Personagem inimigo : inimigos) {
                if (inimigo.vida > 0) {
                    inimigo.atacar(Jogador);
                    System.out.println(inimigo.nome + " atacou " + Jogador.nome + ". Vida restante do " + Jogador.nome + ": " + Jogador.vida);
                }
            }
        }

        if (Jogador.vida <= 0) {
            System.out.println("O jogador foi derrotado!");
        } else {
            System.out.println("Todos os inimigos foram derrotados!");
        }
    }

    private static boolean todosInimigosDerrotados(ArrayList<Personagem> inimigos) {
        for (Personagem inimigo : inimigos) {
            if (inimigo.vida > 0) {
                return false;
            }
        }
        return true;
    }

}
