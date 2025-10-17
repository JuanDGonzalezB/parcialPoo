package parcialpoo.juego;

public class Jugador {
    private String nombre;
    private int intentosRestantes;
    private int intentosIniciales;
    private int partidasGanadas;
    private int partidasPerdidas;

    // ✅ Constructor
    public Jugador(String nombre, int intentosIniciales) {
        validarParametros(nombre, intentosIniciales);
        this.nombre = nombre.trim();
        this.intentosIniciales = intentosIniciales;
        this.intentosRestantes = intentosIniciales;
        this.partidasGanadas = 0;
        this.partidasPerdidas = 0;
    }

    private void validarParametros(String nombre, int intentos) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (intentos <= 0) {
            throw new IllegalArgumentException("Los intentos deben ser positivos");
        }
    }

    // ✅ Getters
    public String getNombre() {
        return nombre;
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public int getIntentosIniciales() {
        return intentosIniciales;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public int getTotalPartidas() {
        return partidasGanadas + partidasPerdidas;
    }

    public double getPorcentajeVictorias() {
        if (getTotalPartidas() == 0) return 0.0;
        return (double) partidasGanadas / getTotalPartidas() * 100;
    }

    public void restarIntento() {
        if (intentosRestantes > 0) {
            intentosRestantes--;
        } else {
            intentosRestantes = 0;
        }
    }

    public boolean tieneIntentos() {
        return intentosRestantes > 0;
    }

    public void reiniciarIntentos() {
        this.intentosRestantes = this.intentosIniciales;
    }

    public void registrarVictoria() {
        partidasGanadas++;
    }

    public void registrarDerrota() {
        partidasPerdidas++;
    }

    @Override
    public String toString() {
        return String.format(
                "Jugador: %s | Ganadas: %d | Perdidas: %d | Total: %d | Éxito: %.1f%% | Intentos restantes: %d",
                nombre,
                partidasGanadas,
                partidasPerdidas,
                getTotalPartidas(),
                getPorcentajeVictorias(),
                intentosRestantes
        );
    }
}