package parcialpoo;

import parcialpoo.zodiacoapp.ZodiacoApp;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Zodiaco");
            System.out.println("2. Validador de edad");
            System.out.println("3. Validador de número perfecto");
            System.out.println("4. Validador de palíndromo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); //

            switch (opcion) {
                case 1 -> ZodiacoApp.main(null);
                case 2 -> ValidadorEdad.main(null);
                case 3 -> ValidadorNumeroPerfecto.main(null);
                case 4 -> ValidadorPalindromo.main(null);
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
            System.out.println();
        } while (opcion != 0);
    }
}