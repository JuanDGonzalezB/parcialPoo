package parcialpoo;

import java.util.Scanner;

public class TextoMorse {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese un texto para traducirlo a morse: ");
        String entrada = leer.nextLine();

        entrada = entrada.toUpperCase();
        String[] palabras = entrada.split(" ");
        String textoMorse = "";

        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];
            System.out.println("Procesando palabra: '" + palabra + "'.");

            for (int j = 0; j < palabra.length(); j++) {
                char letra = palabra.charAt(j);
                String codigoMorse = buscarMorse(letra);

                textoMorse = textoMorse + codigoMorse + " ";
                System.out.println("Letra: (" + letra + "), a Morse: " + codigoMorse);
            }

            // Espacio doble entre palabras
            textoMorse = textoMorse + "  ";
        }

        System.out.println("El texto ingresado traducido a Morse es: " + textoMorse);
    }

    public static String buscarMorse(char letra) {
        char[] simbolos = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
                "-----", ".----", "..---", "...--", "....-", ".....",
                "-....", "--...", "---..", "----."};

        for (int i = 0; i < simbolos.length; i++) {
            if (letra == simbolos[i]) {
                return morse[i];
            }
        }

        return "?"; // Si no lo encuentra
    }
}