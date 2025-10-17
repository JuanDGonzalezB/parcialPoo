package parcialpoo.caballeros;

public class Armadura {
    Tipo material;
    boolean weapons;

    @Override
    public String toString() {
        String armas = weapons ? "con armas" : "sin armas";
        String tipoMaterial = (material != null) ? material.toString() : "desconocido";
        return "Armadura de " + tipoMaterial + " (" + armas + ")";
    }
}
