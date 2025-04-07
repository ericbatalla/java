package botigaOnline;

class Cpu extends Article {
    int velocitat; // velocitat en Mhz

    public Cpu(String codi, String descripcio, int unitats, float preuBase, int velocitat) {
        super(codi, descripcio, unitats, preuBase);
        this.velocitat = velocitat;
    }

    @Override
    float calcularPreuFinal() {
        return preuBase * velocitat;
    }
}
