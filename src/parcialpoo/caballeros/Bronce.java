package parcialpoo.caballeros;

public class Bronce extends Armadura {
    int durabilidad = 100;
    String animal = "Pegaso";

    public String toString() {
        return super.toString() + " | Animal: " + animal + " | Durabilidad: " + durabilidad;
    }
    public Bronce() {
        super.material = Tipo.Bronce;
        super.weapons = false;
    }


}