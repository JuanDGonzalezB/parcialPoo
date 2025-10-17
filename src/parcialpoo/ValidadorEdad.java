package parcialpoo;
import java.util.Scanner;
public class ValidadorEdad {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese año y mes de la fecha actual ( YYYY / MM ): ");
        int añoActual = leer.nextInt();
        int mesActual = leer.nextInt();

        System.out.println("Ingrese año y mes de la fecha de su nacimiento ( YYYY / MM ): ");
        int añoNacimiento = leer.nextInt();
        int mesNacimiento = leer.nextInt();

        if (mesActual < 1 || mesActual > 12 || mesNacimiento < 1 || mesNacimiento > 12) {
            System.out.println("Error: El mes debe estar entre 1 y 12.");
            return;
        }
        if (añoNacimiento > añoActual ||
                (añoNacimiento == añoActual && mesNacimiento > mesActual)) {
            System.out.println("Error: La fecha de nacimiento no puede ser futura.");
            return;
        }
        int  edad = añoActual - añoNacimiento;

        if(mesActual < mesNacimiento){
            edad = edad - 1;
        }
        int mes = mesActual - mesNacimiento;

        if(mes < 0){
            mes = mes + 12;
        }

        System.out.println("Usted tiene: "+edad+" años y "+mes+" meses. ");
        if(edad>=18){
            System.out.println("Usted es mayor de edad");
        } else{
            System.out.println("Usted es menor de edad");
        }


    }
}