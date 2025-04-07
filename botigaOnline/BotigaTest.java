package botigaOnline;

public class BotigaTest {
    public static void main(String[] args) {
        DiscDur dd1 = new DiscDur("dd1", "Disc Dur 1", 40, 1.5f, 100);
        Cpu cpu1 = new Cpu("cpu1", "Processador 1", 35, 0.05f, 2500);

        Botiga botiga = new Botiga();
        botiga.afegirArticle(dd1);
        botiga.afegirArticle(cpu1);

        botiga.llistarEstoc();
    }
}
