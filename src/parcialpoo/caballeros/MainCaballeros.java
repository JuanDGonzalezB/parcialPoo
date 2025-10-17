package parcialpoo.caballeros;

import java.util.Scanner;

public class MainCaballeros {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        gestorCaballeros gestor = new gestorCaballeros();
        int opcion;

        do {
            System.out.println("Menu Caballeros");
            System.out.println("1. Crear caballero");
            System.out.println("2. Mostrar caballeros");
            System.out.println("3. Eliminar caballero");
            System.out.println("4. Batalla entre caballeros");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1 -> gestor.crearCaballero();
                case 2 -> gestor.mostrarCaballeros();
                case 3 -> gestor.eliminarCaballero();
                case 4 -> gestor.batallaCaballeros();
                case 0 -> System.out.println("Saliendo del gestor...");
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }
            System.out.println();
        } while (opcion != 0);
    }
}