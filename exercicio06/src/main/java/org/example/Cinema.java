package org.example;
import java.util.ArrayList;
import java.util.HashMap;

public class Cinema {
    private ArrayList<Filme> filmesDisponiveis;
    private HashMap<String, Ingresso> ingressosVendidos;

    public Cinema() {
        filmesDisponiveis = new ArrayList<>();
        ingressosVendidos = new HashMap<>();
    }


    public void addFilme(Filme filme){
        filmesDisponiveis.add(filme);
    }

    public ArrayList<Filme> getFilmesDisponiveis() {
        return filmesDisponiveis;
    }

    public boolean venderIngresso(Ingresso ingresso) throws Exception {
        String assento = ingresso.getAssento();

        if (ingressosVendidos.containsKey(assento)) {
            throw new Exception("Assento já vendido!");
        }

        if (ingresso.getCliente().getIdade() < ingresso.getFilme().getIdadeMinima()) {
            throw new Exception("Idade do cliente não é compatível com a idade mínima do filme!");
        }

        ingressosVendidos.put(assento, ingresso);
        return true;

    }
}
