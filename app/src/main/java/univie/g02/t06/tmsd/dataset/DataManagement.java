package univie.g02.t06.tmsd.dataset;

import java.util.ArrayList;

public class DataManagement {

    ArrayList<Song> allSongs;
    CsvParse csvParse;

    public DataManagement() throws Exception {
        if (allSongs == null) {
            allSongs = new ArrayList<>();
            csvParse = new CsvParse();
            allSongs = csvParse.getAllSongs();
        }
    }

    public ArrayList<Song> getAllSongs() {
        return allSongs;
    }

    public ArrayList<Song> findSongsByTitle(String title) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song s : allSongs) {
            if (s.getSongName().contains(title)) {
                result.add(s);
            }
        }
        return result;
    }
}
