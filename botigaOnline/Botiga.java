package botigaOnline;

import java.util.ArrayList;

class Botiga {
    ArrayList<Article> articles = new ArrayList<>();

    void afegirArticle(Article article) {
        articles.add(article);
    }

    void eliminarArticle(String codi) {
        articles.removeIf(article -> article.codi.equals(codi));
    }

    float calcularValorEstoc() {
        float total = 0;
        for (Article article : articles) {
            total += article.calcularPreuFinal();
        }
        return total;
    }

    void llistarEstoc() {
        for (Article article : articles) {
            System.out.println(article.codi + " - " + article.descripcio + " - Preu Final: " + article.calcularPreuFinal());
        }
    }
}

