package org.example;
import java.util.Scanner;
import java.util.Random;

public class ex00 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o seu primeiro nome: ");
        String primeiroNome = scanner.nextLine();

        System.out.print("Digite o seu sobrenome: ");
        String sobrenome = scanner.nextLine();

        Random random = new Random();
        int numeroAleatorio = random.nextInt(100) + 1;

        String username = primeiroNome + sobrenome + numeroAleatorio;

        System.out.println("Nome de usuário gerado: " + username);

        scanner.close();
    }
}