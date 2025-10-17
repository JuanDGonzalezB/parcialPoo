package parcialpoo.zodiacoapp;

import java.util.Scanner;
public class ZodiacoApp {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Agrega tu dia y mes de nacimiento: ");
        int dia = leer.nextInt();
        int mes = leer.nextInt();

        String caballero = obtenerCaballeroDelZodiaco(dia, mes);

        System.out.println("Su caballero del Zodiaco es: "+caballero);
    }
    public static String obtenerCaballeroDelZodiaco(int dia, int mes) {
        if (mes < 1 || mes > 12) {
            return "Fecha inválida (mes incorrecto)";
        }

        int diasDelMes;
        switch (mes) {
            case 2 -> diasDelMes = 29; // febrero (considerando año bisiesto)
            case 4, 6, 9, 11 -> diasDelMes = 30;
            default -> diasDelMes = 31;
        }
        if (dia < 1 || dia > diasDelMes) {
            return "Fecha inválida (día incorrecto)";
        }

        if (mes == 1){
            if(dia <= 19) {
                return "Shura de capricornio";
            }else {
                return "Camus de Acuario";

            }
        }
        if (mes == 2) {
            if (dia <= 18) {
                return "Camus de Acuario";
            } else {
                return "Afrodita de Piscis";
            }
        }
        if (mes == 3) {
            if (dia <= 20) {
                return "Afrodita de Piscis";
            } else {
                return "Mu de Aries";
            }
        }
        if (mes == 4) {
            if (dia <= 19) {
                return "Mu de Aries";
            } else {
                return "Aldebaran e Tauro";
            }
        }
        if (mes == 5) {
            if (dia <= 20) {
                return "Aldebaran e Tauro";
            } else {
                return "Saga de Geminis";
            }
        }
        if (mes == 6) {
            if (dia <= 20) {
                return "Saga de Geminis";
            } else {
                return "Deathmask de Cancer";
            }
        }
        if (mes == 7) {
            if (dia <= 22) {
                return "Deathmask de Cancer";
            } else {
                return "Aioria de Leo";
            }
        }
        if (mes == 8) {
            if (dia <= 22) {
                return "Aioria de Leo";
            } else {
                return "Shaka de Virgo";
            }
        }
        if (mes == 9) {
            if (dia <= 22) {
                return "Shaka de Virgo";
            } else {
                return "Dohko de Libra";
            }
        }
        if (mes == 10) {
            if (dia <= 22) {
                return "Dohko de Libra";
            } else {
                return "Milo de Escorpio";
            }
        }
        if (mes == 11) {
            if (dia <= 21) {
                return "Milo de Escorpio";
            } else {
                return "Aioros de Sagitario";
            }
        }
        if (mes == 12) {
            if (dia <= 21) {
                return "Aioros de Sagitario";
            } else {
                return "Shura de Capricornio";
            }
        }
        return("Fecha invalida");
    }
}

