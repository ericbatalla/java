package ex1;

public class Secretari extends EmpleatOficina {

    public Secretari(String nombre, int edad, float salario) {
        super(nombre, edad, salario);
    }

    public void treballar(){
        System.out.print("Soc un secretari i gestiono reunions i documents.\n");
    }
}
