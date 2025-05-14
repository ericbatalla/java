package lol;
import java.util.Scanner;

public class AppLol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- MENÚ CAMPIONS ---");
            System.out.println("1. Mostrar campions");
            System.out.println("2. Consultar campió");
            System.out.println("3. Afegir nou campió");
            System.out.println("4. Sortir");
            System.out.print("Tria opció: ");
            String op = scanner.nextLine();

            if (op.equals("1")) {
                ChampionManager.mostrar();
            } else if (op.equals("2")) {
                System.out.print("Introdueix ID o nom: ");
                String key = scanner.nextLine();
                ChampionManager.consultar(key);
            } else if (op.equals("3")) {
                System.out.print("Nom: ");
                String name = scanner.nextLine();
                System.out.print("Títol: ");
                String title = scanner.nextLine();
                System.out.print("Tags (coma separats): ");
                String tags = scanner.nextLine();
                System.out.print("Lore: ");
                String lore = scanner.nextLine();
                ChampionManager.afegir(name, title, tags, lore);
            } else if (op.equals("4")) {
                exit = true;
                System.out.println("Fins aviat!");
            } else {
                System.out.println("Opció no vàlida. Torna-ho a provar.");
            }
        }
        scanner.close();
    }
}


