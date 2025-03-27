package ex1;

public class Programador extends EmpleatTecnic{

    public Programador(String nombre, int edad, float salario) {
        super(nombre, edad, salario);
    }

    public void treballar(){
        System.out.print("Soc un programador i escric codi i desenvolupo aplicacions.\n");
    }
}
