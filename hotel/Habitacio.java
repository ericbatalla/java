package hotel;

public class Habitacio {
    private int id;
    private String categoria;
    private int llits;
    private boolean ocupada;
    private static final int PREU_SUPERLUXE = 200;
    private static final int PREU_LUXE = 100;
    private static final int PREU_NORMAL = 60;

    public Habitacio(int id, String categoria, int llits) {
        this.id = id;
        this.categoria = categoria;
        this.llits = llits;
        this.ocupada = false;
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public void ocupar() {
        this.ocupada = true;
    }

    public void alliberar() {
        this.ocupada = false;
    }

    public int getPreuPerNit() {
        return switch (categoria.toLowerCase()) {
            case "superluxe" -> PREU_SUPERLUXE;
            case "luxe" -> PREU_LUXE;
            default -> PREU_NORMAL;
        };
    }
}
