package parcialpoo.juego;

import java.util.ArrayList;
import java.util.Scanner;

public class JuegoAhorcado {
    private String palabraSecreta;
    private char[] progreso;
    private Jugador jugador;
    private ArrayList<Character> letrasUsadas = new ArrayList<>();

    public JuegoAhorcado(String palabraSecreta, Jugador jugador) {
        this.palabraSecreta = palabraSecreta.toLowerCase();
        this.jugador = jugador;
        this.progreso = new char[palabraSecreta.length()];

        for (int i = 0; i < progreso.length; i++) {
            progreso[i] = '_';
        }
    }

    public void jugar(Scanner scanner) {
        System.out.println("\n=== ¡Comienza el juego del Ahorcado! ===");

        while (!palabraAdivinada() && jugador.tieneIntentos()) {
            mostrarProgreso();
            System.out.println("Intentos restantes: " + jugador.getIntentosRestantes());
            System.out.println("Letras usadas: " + letrasUsadas);

            char letra = pedirLetra(scanner);

            if (palabraSecreta.indexOf(letra) >= 0) {
                actualizarProgreso(letra);
                System.out.println("✅ ¡Letra correcta!");
            } else {
                jugador.restarIntento();
                System.out.println("❌ Letra incorrecta. Pierdes un intento.");
            }
        }

        // Resultado final
        if (palabraAdivinada()) {
            System.out.println("\n🎉 ¡Has adivinado la palabra: " + palabraSecreta + "!");
        } else {
            System.out.println("\n💀 Te quedaste sin intentos. La palabra era: " + palabraSecreta);
        }
    }

    // ✅ Nuevo método con validación completa
    private char pedirLetra(Scanner scanner) {
        String entrada;

        while (true) {
            System.out.print("Ingresa una letra: ");
            entrada = scanner.nextLine().toLowerCase().trim();

            if (entrada.length() != 1) {
                System.out.println("⚠️ Debes ingresar solo una letra.");
                continue;
            }

            char letra = entrada.charAt(0);

            if (!Character.isLetter(letra)) {
                System.out.println("⚠️ Solo se permiten letras (a-z).");
                continue;
            }

            if (letrasUsadas.contains(letra)) {
                System.out.println("⚠️ Ya habías ingresado esa letra.");
                continue;
            }

            letrasUsadas.add(letra);
            return letra;
        }
    }

    private void mostrarProgreso() {
        System.out.print("\nPalabra: ");
        for (char c : progreso) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    private void actualizarProgreso(char letra) {
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                progreso[i] = letra;
            }
        }
    }

    public boolean palabraAdivinada() {
        for (char c : progreso) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}