import java.sql.*;

public class GestorBG2 {
    private Connection connexio;

    // Connexió a la base de dades "pelicules"
    public void connectar() {
        try {
            String url = "jdbc:mysql://localhost:3306/pelicules"; // nom de la BD
            String usuari = "root"; // usuari per defecte de XAMPP
            String contrasenya = ""; // XAMPP normalment no té contrasenya
            connexio = DriverManager.getConnection(url, usuari, contrasenya);
            System.out.println("Connexió establerta correctament.");
        } catch (SQLException e) {
            System.out.println("Error");
        }
    }

    // Mostrar tots els registres d’una taula
    public void mostrarTots(String nomTaula) {
        try {
            Statement stmt = connexio.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + nomTaula);

            ResultSetMetaData meta = rs.getMetaData();
            int columnes = meta.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnes; i++) {
                    System.out.print(meta.getColumnName(i) + ": " + rs.getString(i) + " | ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
    }

    // Mostrar un registre concret pel valor clau
    public void mostrarPerClau(String nomTaula, String campClau, String valor) {
        try {
            String query = "SELECT * FROM " + nomTaula + " WHERE " + campClau + " = ?";
            PreparedStatement ps = connexio.prepareStatement(query);
            ps.setString(1, valor);
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData meta = rs.getMetaData();
            int columnes = meta.getColumnCount();

            if (rs.next()) {
                for (int i = 1; i <= columnes; i++) {
                    System.out.print(meta.getColumnName(i) + ": " + rs.getString(i) + " | ");
                }
                System.out.println();
            } else {
                System.out.println("No s’ha trobat cap registre amb " + campClau + " = " + valor);
            }
        } catch (SQLException e) {
            System.out.println("Error" );
        }
    }
}
