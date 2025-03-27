package ex1;

public class Empleat {

    private String nom;
    private int edad;
    private float salariBase;

    public Empleat(String nombre, int edad, float salario) {
        this.nom = nombre;
        this.edad = edad;
        this.salariBase = salario;
    }

    public void treballar(){
        System.out.print("Soc un empleat.");
    }
    public void pagarSou(){
        System.out.println(nom + " ha cobrat " + salariBase + " euros.");
    }
    public void pagarSou(float extra){
        System.out.print(nom + " ha cobrat " + (salariBase + extra) + " euros amb bonus.\n");
    }
    public void augmentarSou(float augment){
        salariBase += augment;
        System.out.print(nom + " ha rebut un augment de " + augment + " euros.\n");
    }
}
