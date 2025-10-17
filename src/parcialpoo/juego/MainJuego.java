package parcialpoo.juego;

import java.util.Random;
import java.util.Scanner;

public class MainJuego {
    private static final String[] PALABRAS = {
            "programacion", "java", "clase", "objeto",
            "metodo", "herencia", "constructor", "poo"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String nombre = obtenerNombreJugador(scanner);

        Jugador jugador = new Jugador(nombre, 6);

        boolean seguirJugando = true;

        while (seguirJugando) {
            jugador.reiniciarIntentos();

            String palabra = PALABRAS[random.nextInt(PALABRAS.length)];

            JuegoAhorcado juego = new JuegoAhorcado(palabra, jugador);

            juego.jugar(scanner);

            if (juego.palabraAdivinada()) {
                jugador.registrarVictoria();
                System.out.println("🎉 ¡Felicidades " + nombre + "! Ganaste esta ronda.");
            } else {
                jugador.registrarDerrota();
                System.out.println("💀 Mejor suerte para la próxima, " + nombre);
            }

            System.out.println("\n📊 Estadísticas actuales:");
            System.out.println(jugador.toString());

            seguirJugando = preguntarContinuar(scanner);
        }

        System.out.println("\n👋 Gracias por jugar, " + nombre + "!");
    }

    private static String obtenerNombreJugador(Scanner scanner) {
        String nombre;
        do {
            System.out.print("Ingresa tu nombre: ");
            nombre = scanner.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("⚠️ El nombre no puede estar vacío.");
            }
        } while (nombre.isEmpty());
        return nombre;
    }

    private static boolean preguntarContinuar(Scanner scanner) {
        String respuesta;
        do {
            System.out.print("¿Quieres volver a jugar? (s/n): ");
            respuesta = scanner.nextLine().trim().toLowerCase();
            if (!respuesta.equals("s") && !respuesta.equals("n")) {
                System.out.println("⚠️ Por favor ingresa 's' para sí o 'n' para no.");
            }
        } while (!respuesta.equals("s") && !respuesta.equals("n"));

        return respuesta.equals("s");
    }
}