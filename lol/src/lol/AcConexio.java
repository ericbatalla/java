package lol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AcConexio {
    private static Connection con;
    public final static String USER = "root";
    public final static String PASSW = "";

    public static void main(String[] args) {
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306",USER, PASSW);
            System.out.println("Server Connected");
        }catch (SQLException e) {
            System.out.println("No s'ha pogut connectar la meva base de dades");
            e.printStackTrace();
        }
    }
}
