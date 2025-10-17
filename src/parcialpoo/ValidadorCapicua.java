package parcialpoo;
import java.util.Scanner;

public class ValidadorCapicua {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese un número para saber si es capicúa: ");

        if (!leer.hasNextInt()) {
            System.out.println("Error: Debe ingresar un número entero.");
            return;
        }

        int numero = leer.nextInt();

        if (numero == 0) {
            System.out.println("0 no se considera capicúa para este programa.");
            return;
        }

        if (esCapicua(numero)) {
            System.out.println(numero + " es un número capicúa.");
        } else {
            System.out.println(numero + " no es un número capicúa.");
        }
    }

    public static boolean esCapicua(int numero) {
        int original = numero;
        int invertido = 0;

        while (numero != 0) {
            int digito = numero % 10;
            invertido = invertido * 10 + digito;
            numero = numero / 10;
        }

        return original == invertido;
    }
}


