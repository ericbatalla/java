package botigaOnline;

abstract class Article {
    String codi;
    String descripcio;
    int unitats;
    float preuBase;

    public Article(String codi, String descripcio, int unitats, float preuBase) {
        this.codi = codi;
        this.descripcio = descripcio;
        this.unitats = unitats;
        this.preuBase = preuBase;
    }


    abstract float calcularPreuFinal();
}

