package parcialpoo.caballeros;

public class Caballero {
    String nombre;
    String constelacion;
    int cosmos;
    Dios dios;
    Armadura armadura;

    public Caballero() {
    }

    @Override
    public String toString() {

        String diosTexto = (dios != null) ? dios.toString() : "Desconocido";
        String armaduraTexto = (armadura != null) ? armadura.material.toString() : "Sin armadura";

        return "Caballero " + nombre + " de " + constelacion +
                " | Dios: " + diosTexto +
                " | Cosmos: " + cosmos +
                " | Armadura: " + armaduraTexto;
    }

    public void burnCosmos() {
        int nuevoCosmos = Math.max(0, cosmos - 10);
        System.out.println(nombre + " está usando " + (cosmos * 2) + " cosmos!");
        cosmos = nuevoCosmos;
    }

    public void burnCosmos(int c) {
        if (c <= 0) {
            System.out.println("El multiplicador debe ser positivo.");
            return;
        }
        cosmos *= c;
        System.out.println(nombre + " ha multiplicado su cosmos a " + cosmos);
    }
}