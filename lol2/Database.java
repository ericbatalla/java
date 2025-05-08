package lol2;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/ericjava";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

