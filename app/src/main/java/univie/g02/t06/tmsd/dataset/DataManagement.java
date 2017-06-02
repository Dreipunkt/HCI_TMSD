package univie.g02.t06.tmsd.dataset;

import java.util.ArrayList;
import java.util.HashSet;

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



    public ArrayList<String> getAllGenres(){
        ArrayList<String> genres = new ArrayList<String>();
        for (int i = 0; i < allSongs.size(); i++){
            genres.add(allSongs.get(i).getGenre());
        }
        ArrayList<String> genres_unique = new ArrayList<>(new HashSet<String>(genres));
        return genres_unique;
    }

    public ArrayList<Song> findSongsbyArtistTitle(String search) {
        ArrayList<Song> result = new ArrayList<>();
        search = search.toLowerCase();
        for (Song s : allSongs) {
            if (s.getTitle().toLowerCase().contains(search) || s.getArtistTitle().toLowerCase().contains(search))
            {
                result.add(s);
            }
        }
        return result;
    }

    public  ArrayList<Song> getSongsbyArtist(String artist) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song s : allSongs) {
            if (s.getArtistName().contentEquals(artist)) {
                result.add(s);
            }
        }
        return result;
    }

     /**
     * Liefert alle Songs, die String title enthalten.
     *
     * @param title
     * @return
     */

    public ArrayList<Song> getSongsbyTitle(String title) {
        ArrayList<Song> result = new ArrayList<Song>();
        for (int i = 0; i < allSongs.size(); i++){
            Song element = allSongs.get(i);
            if (element.getTitle().contentEquals(title)) result.add(element);
        }
        return result;
    }

    public ArrayList<Song> getSongsbyYear(int year) {
        ArrayList<Song> result = new ArrayList<Song>();
        for (Song s : allSongs) {
            if(s.getYear() == year) result.add(s);
        }
        return result;
    }

    public ArrayList<Song> getSongsbyFromYear(int year) {
        ArrayList<Song> result = new ArrayList<Song>();
        for (Song s : allSongs) {
            if(s.getYear() >= year) result.add(s);
        }
        return result;
    }

    public ArrayList<Song> getSongsbyToYear(int year) {
        ArrayList<Song> result = new ArrayList<Song>();
        for (Song s : allSongs) {
            if(s.getYear() <= year) result.add(s);
        }
        return result;
    }

    public ArrayList<Song> getSongsbyGenre(String genre) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song s : allSongs) {
            if (s.getGenre().contentEquals(genre)) {
                result.add(s);
            }
        }
        return result;
    }


    public ArrayList<Song> getSongsbyArtistFamilarity(boolean bool) {
        ArrayList<Song> result = new ArrayList<Song>();
        if(bool) {
            for (Song s : allSongs) {
                if(s.getArtistFamiliarity() >= 0.5) result.add(s);
            }
        }
        else{
            for (Song s : allSongs) {
                if(s.getArtistFamiliarity() < 0.5) result.add(s);
            }
        }
        return result;
    }

    public ArrayList<Song> getSongbyArtistHotness(boolean bool) {
        ArrayList<Song> result = new ArrayList<Song>();
        if(bool) {
            for (Song s : allSongs) {
                if(s.getArtistHotness() >= 0.5) result.add(s);
            }
        }
        else{
            for (Song s : allSongs) {
                if(s.getArtistHotness() < 0.5) result.add(s);
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
