package org.example;

import database.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DatabaseConnection dbc = new DatabaseConnection();
        dbc.connect("songs.db");
    }
}