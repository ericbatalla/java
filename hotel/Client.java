package hotel;

public class Client {
    private String nom;
    private String dni;
    private String numTargeta;

    public Client(String nom, String dni, String numTargeta) {
        this.nom = nom;
        this.dni = dni;
        this.numTargeta = numTargeta;
    }
}

class Reserva {
    private int id;
    private Client client;
    private Habitacio habitacio;
    private int dies;

    public Reserva(int id, Client client, Habitacio habitacio, int dies) {
        this.id = id;
        this.client = client;
        this.habitacio = habitacio;
        this.dies = dies;
        habitacio.ocupar();
    }

    public int calcularCost() {
        return habitacio.getPreuPerNit() * dies;
    }
}
