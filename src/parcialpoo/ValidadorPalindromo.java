package parcialpoo;
import java.util.Scanner;

public class ValidadorPalindromo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese una palabra o frase: ");
        String texto = sc.nextLine().toLowerCase();

        if (texto.isEmpty()) {
            System.out.println("No ingresó texto válido.");
            return;
        }

        texto = texto.replaceAll("[^a-záéíóúñ]", "");
        texto = texto.replaceAll("[á]", "a")
                .replaceAll("[é]", "e")
                .replaceAll("[í]", "i")
                .replaceAll("[ó]", "o")
                .replaceAll("[ú]", "u");

        StringBuilder invertido = new StringBuilder(texto).reverse();

        if (texto.equals(invertido.toString())) {
            System.out.println("Esta palabra o frase es un palíndromo.");
        } else {
            System.out.println("Esto no es un palíndromo.");
        }
    }
}