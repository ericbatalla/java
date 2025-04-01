package hotel;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Gran Hotel", 5);
        hotel.afegirHabitacio(new Habitacio(1, "superluxe", 2));
        hotel.afegirHabitacio(new Habitacio(2, "luxe", 2));
        hotel.afegirHabitacio(new Habitacio(3, "normal", 1));

        System.out.println("Habitacions disponibles: " + hotel.getHabitacionsDisponibles());
    }
}
