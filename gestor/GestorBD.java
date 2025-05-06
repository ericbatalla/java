import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorBD {
    private static Connection connexio;
    public final static String USER = "root";
    public final static String PASSW = "";

    public static void main(String[] args) {
        try {
            connexio = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306", USER, PASSW);
            System.out.println("Server Connectat");
        } catch (SQLException e) {
            System.out.println("No s'ha pogut connectar a la meva base de dade");
            e.printStackTrace();
        }
    }
}







