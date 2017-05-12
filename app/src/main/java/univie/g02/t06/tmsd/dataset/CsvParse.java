package univie.g02.t06.tmsd.dataset;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CsvParse {

    CsvParse() {
    }

    ArrayList<Song> getAllSongs() throws Exception {

        InputStream is = this.getClass().getClassLoader().getResourceAsStream("res/raw/subset_cleaned.csv");
        ArrayList<Song> songs = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        int i = 0;
        Song curSong = null;
        while ((line = br.readLine()) != null) {
            if (i == 0) { // erste Zeile ignorieren
                i++;
                continue;
            }

            String[] field = line.split(",");
            Song song = new Song(Integer.parseInt(field[0]), field[1].replaceAll("\"", ""), Integer.parseInt(field[2]), Integer.parseInt(field[3]), new Tag(Integer.parseInt(field[4]), field[5], Integer.parseInt(field[6])));
            if ((curSong == null) || (curSong.getSongID() == song.getSongID())) {
                songs.add(song);
                curSong = song;
            } else {
                song.addTag(new Tag(Integer.parseInt(field[4]), field[5], Integer.parseInt(field[6])));
            }
        }

        return songs;
    }
}
