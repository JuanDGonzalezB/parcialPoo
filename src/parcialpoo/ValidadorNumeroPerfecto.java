package parcialpoo;
import java.util.Scanner;
public class ValidadorNumeroPerfecto {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese un numero para saber si es un numero perfecto: ");
        int numero = leer.nextInt();

        if (numero <= 0) {
            System.out.println("Por favor ingrese un número entero positivo.");
            return;
        }

        int suma = 0;

        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                suma = suma + i;

            }
        }
        if (suma == numero) {
            System.out.println(numero+ ", este numero es un numero perfecto.");
        }
        else  {
            System.out.println(numero+ ", este numero no es un numero perfecto.");
        }
    }
}