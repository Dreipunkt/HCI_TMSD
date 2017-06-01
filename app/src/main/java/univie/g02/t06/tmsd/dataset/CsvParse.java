package univie.g02.t06.tmsd.dataset;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CsvParse {

    CsvParse() {
    }

    ArrayList<Song> getAllSongs() throws Exception {

        InputStream is = this.getClass().getClassLoader().getResourceAsStream("res/raw/msd_sampledata_tags.csv");
        ArrayList<Song> songs = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        int i = 0;
        Song curSong = null;
        while ((line = br.readLine()) != null) {
            String[] field = line.split(",");
            Song song = new Song(field[0], field[1], field[2], field[3],
                    Double.parseDouble(field[4]), Double.parseDouble(field[5]),
                    Double.parseDouble(field[6]), Integer.parseInt(field[7]), field[8],
                    new Tag(field[9], Integer.parseInt(field[10])));
            if ((curSong == null) || !(curSong.getTrackId().contentEquals(song.getTrackId()))) {
                songs.add(song);
                curSong = song;
            } else {
                song.addTag(new Tag(field[9], Integer.parseInt(field[10])));
            }
        }

        return songs;
    }

}
