package ex1;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        // Creació d'empleats
        Empleat empOficina = new EmpleatOficina("Anna", 30, 2000);
        Empleat empSecretari = new Secretari("Laura", 28, 2100);
        Empleat empComptable = new Comptable("Joan", 35, 2300);
        Empleat empProgramador = new Programador("Marc", 25, 2500);
        Empleat empAdministrador = new Administrador("Jordi", 40, 2700);
        // Array d'empleats per demostrar polimorfisme: en un array de tipus pare podem posar classes filles diferents
        ArrayList<Empleat> empleats = new ArrayList<>();
        empleats.add(empOficina);
        empleats.add(empSecretari);
        empleats.add(empComptable);
        empleats.add(empProgramador);
        empleats.add(empAdministrador);





        for (Empleat e : empleats) {
            e.treballar();  // LLigadura dinàmica: Es crida el mètode adequat segons la subclasse
            System.out.println("----------------------");
        }
        //Sobrecàrrega
        empProgramador.pagarSou(); // Sense bonus
        empAdministrador.pagarSou(500); // Amb bonus
        empProgramador.augmentarSou(500);
        empProgramador.pagarSou();
    }
}





