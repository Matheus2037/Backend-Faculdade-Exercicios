package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema();

        cinema.addFilme(new Filme("Batman: O Cavaleiro das Trevas", 15.00f, 18));
        cinema.addFilme(new Filme("Homem-Aranha: Através do Aranhaverso", 12.00f, 16));
        cinema.addFilme(new Filme("Um Sonho de Liberdade", 10.00f, 14));
        cinema.addFilme(new Filme("Gran Turismo - De Jogador a Corredor", 20.00f, 21));
        cinema.addFilme(new Filme("O Poderoso Chefão", 8.00f, 10));

        while (true) {
            try {
                System.out.print("Nome do cliente: ");
                String nomeCliente = scanner.nextLine();
                System.out.print("Idade do cliente: ");
                int idadeCliente = scanner.nextInt();
                scanner.nextLine();

                Cliente cliente = new Cliente(nomeCliente, idadeCliente);

                System.out.print("Nome do filme: ");
                String nomeFilme = scanner.nextLine();

                Filme filmeEscolhido = null;
                for (Filme filme : cinema.getFilmesDisponiveis()) {
                    if (filme.getNome().equalsIgnoreCase(nomeFilme)) {
                        filmeEscolhido = filme;
                        break;
                    }
                }

                if (filmeEscolhido == null) {
                    System.out.println("Filme não encontrado.");
                    continue;
                }

                System.out.print("Escolha o assento (ex: A1 a F5): ");
                String assento = scanner.nextLine();

                Ingresso ingresso = new Ingresso(cliente, filmeEscolhido, assento);

                cinema.venderIngresso(ingresso);
                System.out.println("Ingresso vendido com sucesso!");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Deseja continuar? (s/n): ");
            String continuar = scanner.nextLine();
            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }
        }

        scanner.close();
    }
}
