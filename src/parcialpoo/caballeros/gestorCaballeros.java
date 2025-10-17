package parcialpoo.caballeros;

import java.util.ArrayList;
import java.util.Scanner;

public class gestorCaballeros {

    private ArrayList<Caballero> caballeros = new ArrayList<>();
    private Scanner leer = new Scanner(System.in);

    public void crearCaballero() {
        Caballero c = new Caballero();

        while (true) {
            System.out.println("Ingrese el nombre de su caballero: ");
            String nombre = leer.nextLine().trim();
            if (!nombre.isEmpty()) {
                c.nombre = nombre;
                break;
            } else {
                System.out.println("Error: El nombre no puede estar vacío.");
            }
        }

        while (true) {
            System.out.println("Ingrese la constelación del caballero: ");
            String constelacion = leer.nextLine().trim();
            if (!constelacion.isEmpty()) {
                c.constelacion = constelacion;
                break;
            } else {
                System.out.println("Error: La constelación no puede estar vacía.");
            }
        }

        while (true) {
            System.out.println("Ingrese el nombre en mayúscula del Dios de su caballero: ATENA, HADES, POSEIDON, ODIN o MISTERIOSO.");
            String diosTexto = leer.nextLine().trim().toUpperCase();

            switch (diosTexto) {
                case "ATENA" -> c.dios = Dios.ATENA;
                case "HADES" -> c.dios = Dios.HADES;
                case "POSEIDON" -> c.dios = Dios.POSEIDON;
                case "ODIN" -> c.dios = Dios.ODIN;
                case "MISTERIOSO" -> c.dios = Dios.ORIGEN_MISTERIOSO;
                default -> {
                    System.out.println("Error: Dios no válido. Opciones: ATENA, HADES, POSEIDON, ODIN, MISTERIOSO.");
                    continue;
                }
            }
            break;
        }

        while (true) {
            System.out.println("Ingrese el nombre en mayúscula del tipo de armadura: BRONCE, PLATA, ORO o NEGRA.");
            String tipoTexto = leer.nextLine().trim().toUpperCase();

            switch (tipoTexto) {
                case "BRONCE" -> c.armadura = new Bronce();
                case "PLATA" -> c.armadura = new Plata();
                case "ORO" -> c.armadura = new Oro();
                case "NEGRA" -> c.armadura = new Negra();
                default -> {
                    System.out.println("Error: Tipo de armadura no válido. Opciones: BRONCE, PLATA, ORO, NEGRA.");
                    continue;
                }
            }
            break;
        }

        while (true) {
            System.out.println("Ingrese el cosmos para su caballero (número positivo mayor a 0): ");
            if (leer.hasNextInt()) {
                int cosmos = leer.nextInt();
                leer.nextLine();
                if (cosmos > 0) {
                    c.cosmos = cosmos;
                    break;
                } else {
                    System.out.println("Error: El cosmos debe ser un número positivo mayor a 0.");
                }
            } else {
                System.out.println("Error: Debe ingresar un número válido.");
                leer.nextLine();
            }
        }

        caballeros.add(c);
        System.out.println("Caballero creado con éxito.");
    }

    public void mostrarCaballeros() {
        if (caballeros.isEmpty()) {
            System.out.println("No se han registrado caballeros.");
            return;
        }
        System.out.println("Lista de Caballeros:");
        for (int i = 0; i < caballeros.size(); i++) {
            System.out.println((i + 1) + ". " + caballeros.get(i));
        }
    }

    public void eliminarCaballero() {
        mostrarCaballeros();
        if (caballeros.isEmpty()) return;

        while (true) {
            System.out.println("Ingrese el número del caballero a eliminar:");
            if (leer.hasNextInt()) {
                int index = leer.nextInt() - 1;
                leer.nextLine();

                if (index >= 0 && index < caballeros.size()) {
                    Caballero eliminado = caballeros.remove(index);
                    System.out.println("Caballero '" + eliminado.nombre + "' eliminado.");
                    break;
                } else {
                    System.out.println("Error: Número inválido. Debe estar entre 1 y " + caballeros.size());
                }
            } else {
                System.out.println("Error: Debe ingresar un número válido.");
                leer.nextLine();
            }
        }
    }

    public void batallaCaballeros() {
        mostrarCaballeros();
        if (caballeros.size() < 2) {
            System.out.println("Para que haya una batalla de caballeros debe haber mínimo 2.");
            return;
        }

        int c1, c2;

        while (true) {
            System.out.println("Ingrese el número del primer caballero:");
            if (leer.hasNextInt()) {
                c1 = leer.nextInt() - 1;
                leer.nextLine();
                if (c1 >= 0 && c1 < caballeros.size()) {
                    break;
                } else {
                    System.out.println("Error: Número inválido. Debe estar entre 1 y " + caballeros.size());
                }
            } else {
                System.out.println("Error: Debe ingresar un número válido.");
                leer.nextLine();
            }
        }

        while (true) {
            System.out.println("Ingrese el número del segundo caballero:");
            if (leer.hasNextInt()) {
                c2 = leer.nextInt() - 1;
                leer.nextLine();
                if (c2 >= 0 && c2 < caballeros.size()) {
                    if (c2 != c1) {
                        break;
                    } else {
                        System.out.println("Error: No puede seleccionar el mismo caballero.");
                    }
                } else {
                    System.out.println("Error: Número inválido. Debe estar entre 1 y " + caballeros.size());
                }
            } else {
                System.out.println("Error: Debe ingresar un número válido.");
                leer.nextLine();
            }
        }

        Caballero cab1 = caballeros.get(c1);
        Caballero cab2 = caballeros.get(c2);

        System.out.println("\nBATALLA ENTRE CABALLEROS");
        System.out.println("⚔️  " + cab1.nombre + " vs " + cab2.nombre + " ⚔️");
        System.out.println(cab1.nombre + ": " + cab1.cosmos + " de cosmos | " + cab1.armadura.getClass().getSimpleName());
        System.out.println(cab2.nombre + ": " + cab2.cosmos + " de cosmos | " + cab2.armadura.getClass().getSimpleName());
        System.out.println("-----------------------------------");

        Caballero ganador;

        if (cab1.cosmos > cab2.cosmos) {
            ganador = cab1;
        } else if (cab2.cosmos > cab1.cosmos) {
            ganador = cab2;
        } else {

            int poderArmadura1 = obtenerPoderArmadura(cab1.armadura);
            int poderArmadura2 = obtenerPoderArmadura(cab2.armadura);

            if (poderArmadura1 > poderArmadura2) {
                ganador = cab1;
            } else if (poderArmadura2 > poderArmadura1) {
                ganador = cab2;
            } else {
                System.out.println("¡La batalla termina en empate absoluto!");
                return;
            }
        }

        System.out.println("¡EL GANADOR ES: " + ganador.nombre + "! ");
        System.out.println("Con " + ganador.cosmos + " de cosmos y armadura " + ganador.armadura.getClass().getSimpleName());
    }

    private int obtenerPoderArmadura(Armadura armadura) {
        if (armadura instanceof Oro) return 4;
        if (armadura instanceof Plata) return 3;
        if (armadura instanceof Bronce) return 2;
        if (armadura instanceof Negra) return 1;
        return 0;
    }
}