package org.example;

import database.DatabaseConnection;
import database.Song;


public class Main {
    public static void main(String[] args){

        System.out.println(Song.Persistence.read(2).get().artist());
    }
}