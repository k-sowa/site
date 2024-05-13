package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public static void connect(String dbURL) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:"+dbURL);
            System.out.println("Nawiązano połączenie z bazą");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void disconnect() {

    }
}
