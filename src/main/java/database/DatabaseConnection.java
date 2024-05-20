package database;

import java.sql.*;

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
    public static void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                try {
                    connection.close();
                    System.out.println("Połączenie zakończone");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insert(Song song) {
        try {
            Statement insertionStatement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append(" INSERT INTO song ");
            sb.append(String.format("VALUES(%d, '%s', '%s', %d)",
                    song.id(),song.artist(),song.name(),song.time()));
            insertionStatement.executeUpdate(sb.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void select(String columns, String whereClausule) {
        try {
            Statement selectionStatement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append(" SELECT ");
            sb.append(columns);
            sb.append(" FROM song ");
            sb.append(" WHERE ");
            sb.append(whereClausule);
            ResultSet rs = selectionStatement.executeQuery(sb.toString());
            while (rs.next()) {
                System.out.println(String.format("Autorem piosenki \"%s\" jest %s",
                        rs.getString("title"),
                        rs.getString("artist")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
