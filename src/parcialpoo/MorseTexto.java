package parcialpoo;

import java.util.Scanner;

public class MorseTexto {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("(Use un espacio entre letras y tres espacios entre palabras)");
        System.out.println("Ejemplo: .... --- .-.. .-   -- ..- -. -.. ---");
        System.out.println("Digite su texto en código Morse para traducirlo a texto:");

        String entrada = leer.nextLine().trim();

        if (entrada.isEmpty()) {
            System.out.println("No ingresó ningún texto en código Morse. Intente nuevamente.");
            return;
        }

        entrada = entrada.replaceAll("^\\s+|\\s+$", "");

        String[] palabrasMorse = entrada.split(" {3}");
        String textoFinal = "";

        for (int i = 0; i < palabrasMorse.length; i++) {
            String palabra = palabrasMorse[i].trim();

            if (palabra.isEmpty()) {
                continue;
            }

            String[] letrasMorse = palabra.split(" ");
            for (int j = 0; j < letrasMorse.length; j++) {
                String letra = letrasMorse[j].trim();

                if (!letra.isEmpty()) {
                    String letraTraducida = buscarLetra(letra);

                    if (!letraTraducida.equals("Error")) {
                        textoFinal += letraTraducida;
                    }
                }
            }
            textoFinal += " ";
        }

        System.out.println("\nEl texto traducido es: " + textoFinal.trim());
    }

    public static String buscarLetra(String letra) {
        String[] letrasMorse = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        String[] letrasTraducidas = {
                "A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X", "Y", "Z"
        };

        String[] numerosMorse = {
                "-----", ".----", "..---", "...--", "....-", ".....",
                "-....", "--...", "---..", "----."
        };

        String[] numerosTraducidos = {
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
        };

        for (int i = 0; i < letrasMorse.length; i++) {
            if (letra.equals(letrasMorse[i])) {
                return letrasTraducidas[i];
            }
        }

        for (int i = 0; i < numerosMorse.length; i++) {
            if (letra.equals(numerosMorse[i])) {
                return numerosTraducidos[i];
            }
        }

        return "Error";
    }
}