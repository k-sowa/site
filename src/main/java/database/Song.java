package database;

import java.sql.*;
import java.util.Optional;

public record Song(int id, String artist, String name, int time) {


    public static class Persistence {
        public static Optional<Song> read(int i) {
            Optional<Song> result = Optional.empty();
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:songs.db");
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM song WHERE id = ?");
                preparedStatement.setInt(1,i);

                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    String artist = rs.getString("artist");
                    String name = rs.getString("title");
                    int time = rs.getInt("length");
                    Song song = new Song(i, artist, name, time);
                    result = Optional.of(song);
                }
            } catch (SQLException e) {
                System.out.println("Połączenie się nie powiodło");
            }
            return result;
        }
    }
}
