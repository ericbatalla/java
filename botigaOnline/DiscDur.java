package botigaOnline;

class DiscDur extends Article {
    int capacitat; // capacitat en GB

    public DiscDur(String codi, String descripcio, int unitats, float preuBase, int capacitat) {
        super(codi, descripcio, unitats, preuBase);
        this.capacitat = capacitat;
    }

    @Override
    float calcularPreuFinal() {
        return preuBase * capacitat * 0.9f;
    }
}
