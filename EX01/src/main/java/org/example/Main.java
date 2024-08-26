package org.example;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Que ambientação você prefere? \n" +
                         "1 - Sci-fi \n" +
                         "2 - Medieval \n");
        String ambientacao = scanner.nextLine();

        System.out.print("Que gênero você prefere? \n" +
                         "1 - Comédia \n" +
                         "2 - Drama \n");
        String genero = scanner.nextLine();

        if(ambientacao.equals("1") && genero.equals("1")){
            System.out.println("Sugerimos o filme Homens de Preto.");
        }
        else if (ambientacao.equals("1") && genero.equals("2")) {
            System.out.println("Sugerimos o filme Arrival.");
        }
        else if (ambientacao.equals("2") && genero.equals("1")) {
            System.out.println("Sugerimos o filme Shrek.");
        }
        else if (ambientacao.equals("2") && genero.equals("2")) {
            System.out.println("Sugerimos o filme Gladiador.");
        }
        else {
            System.out.println("Nenhuma preferência identificada!");
        }
      }
    }
