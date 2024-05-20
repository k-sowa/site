package database;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    @Test
    public void readSong() {
        Optional<Song> result = Song.Persistence.read(2);
        Song toCheck = new Song (2, "The Rolling Stones", "(I Can't Get No) Satisfaction",224);
        assertEquals(toCheck, result.get());
    }


}