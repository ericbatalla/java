package ex1;

public class Comptable extends EmpleatOficina {

    public Comptable(String nombre, int edad, float salario) {
        super(nombre, edad, salario);
    }

    public void treballar(){
        System.out.print("Soc un comptable i gestiono els comptes i pressupostos.\n");
    }
}
