package univie.g02.t06.tmsd.dataset;

import java.util.ArrayList;

public class DataManagement {

    ArrayList<Song> allSongs;
    CsvParse csvParse;

    /**
     *
     * @throws Exception
     */

    public DataManagement() throws Exception {
        if (allSongs == null) {
            allSongs = new ArrayList<>();
            csvParse = new CsvParse();
            allSongs = csvParse.getAllSongs();
        }
    }

    /**
     * Liefert alle Songs in der Datenbank.
     *
     * @return
     */

    public ArrayList<Song> getAllSongs() {
        return allSongs;
    }

    /**
     * Liefert alle Songs, die String title enthalten.
     *
     * @param title
     * @return
     */

    public ArrayList<Song> findSongsByTitle(String title) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song s : allSongs) {
            if (s.getSongName().contains(title)) {
                result.add(s);
            }
        }
        return result;
    }

    /**
     * Liefert eine Liste aller aehnlichen Songs. Wahrscheinlich sehr rechenintensiv.
     *
     * @param ps
     * @return
     */

    public ArrayList<Song> getSimilarSongs(Song ps) {
        ArrayList<Song> result = new ArrayList<>();

        boolean flag = false;

        for (Song s : allSongs) {
            flag = false;
            for (Tag t : s.getTags()) {
                for (Tag pt : ps.getTags()) {
                    if (t.getName().contains(pt.getName())) {
                        result.add(s);
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
        }
        return result;
    }
}
