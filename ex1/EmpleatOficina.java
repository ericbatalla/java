package ex1;

public class EmpleatOficina extends Empleat {

    public EmpleatOficina(String nombre, int edad, float salario) {
        super(nombre, edad, salario);
    }

    public void treballar(){
        System.out.print("Soc un empleat d'oficina i faig tasques administratives.\n");
    }


}
