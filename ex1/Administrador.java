package ex1;

public class Administrador extends EmpleatTecnic{

    public Administrador(String nombre, int edad, float salario) {
        super(nombre, edad, salario);
    }

    public void treballar(){
        System.out.print("Soc un administrador de sistemes i gestiono els servidors i la xarxa.\n");

    }
}
