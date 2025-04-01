package hotel;

import java.util.ArrayList;

public class Hotel {
    private String nom;
    private int estrelles;
    private List<Habitacio> habitacions;

    public Hotel(String nom, int estrelles) {
        this.nom = nom;
        this.estrelles = estrelles;
        this.habitacions = new ArrayList<>();
    }

    public void afegirHabitacio(Habitacio habitacio) {
        habitacions.add(habitacio);
    }

    public List<Habitacio> getHabitacionsDisponibles() {
        List<Habitacio> disponibles = new ArrayList<>();
        for (Habitacio h : habitacions) {
            if (!h.estaOcupada()) {
                disponibles.add(h);
            }
        }
        return disponibles;
    }
}

