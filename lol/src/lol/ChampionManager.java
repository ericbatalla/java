package lol;

import java.sql.*;

public class ChampionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/ericjava";
    private static final String USER = "root";
    private static final String PASS = "";

    public static void mostrar() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, title, tags FROM champions")) {

            System.out.println("-- LLISTA DE CAMPIONS --");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ": "
                        + rs.getString("name") + " - "
                        + rs.getString("title") + " (tags: "
                        + rs.getString("tags") + ")");
            }

        } catch (SQLException e) {
            System.out.println("Error mostrant campions: " + e.getMessage());
        }
    }

    public static void consultar(String key) {
        boolean isNumber;
        try {
            Integer.parseInt(key);
            isNumber = true;
        } catch (NumberFormatException e) {
            isNumber = false;
        }

        String sql;
        if (isNumber) {
            sql = "SELECT * FROM champions WHERE id = " + key;
        } else {
            sql = "SELECT * FROM champions WHERE name LIKE '%" + key + "%'";
        }

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (!rs.next()) {
                System.out.println("No s'ha trobat cap campió.");
            } else {
                do {
                    System.out.println("Nom: " + rs.getString("name"));
                    System.out.println("Títol: " + rs.getString("title"));
                    System.out.println("Tags: " + rs.getString("tags"));
                    System.out.println("Lore: " + rs.getString("lore") + "\n");
                } while (rs.next());
            }

        } catch (SQLException e) {
            System.out.println("Error consultant campió: " + e.getMessage());
        }
    }

    public static void afegir(String name, String title, String tags, String lore) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            // Comprovar si ja existeix
            ResultSet rsCheck = stmt.executeQuery(
                    "SELECT id FROM champions WHERE name='" + name + "'"
            );
            if (rsCheck.next()) {
                System.out.println("Aquest campió ja existeix.");
                rsCheck.close();
                return;
            }
            rsCheck.close();

            // Obtenir nou ID manualment
            ResultSet rsMax = stmt.executeQuery(
                    "SELECT MAX(id) FROM champions"
            );
            int newId = 1;
            if (rsMax.next()) {
                newId = rsMax.getInt(1) + 1;
            }
            rsMax.close();

            // Inserir campió amb ID explícit
            String sqlInsert = String.format(
                    "INSERT INTO champions (id, name, title, tags, lore) VALUES (%d, '%s', '%s', '%s', '%s')",
                    newId, name, title, tags, lore
            );
            stmt.executeUpdate(sqlInsert);
            System.out.println("Campió afegit amb ID " + newId + ".");

        } catch (SQLException e) {
            System.out.println("Error afegint campió: " + e.getMessage());
        }
    }
}

