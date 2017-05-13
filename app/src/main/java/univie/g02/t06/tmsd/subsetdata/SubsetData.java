package univie.g02.t06.tmsd.subsetdata;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;


public class SubsetData{
    ArrayList<SubsetSong> songs;

    public SubsetData() {
        if (songs == null) {
            songs = new ArrayList<>();
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("res/raw/msd_sampledata.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            int i = 0;
            try {
                while ((line = br.readLine()) != null) {
                    String[] field = line.split(",");
                    SubsetSong singlesong = new SubsetSong(field[0], field[1], field[2], field[3],
                            field[4], field[5], field[6], Double.parseDouble(field[7]),
                            Double.parseDouble(field[8]), Double.parseDouble(field[9]),
                            Integer.parseInt(field[10]), field[11]);
                    songs.add(singlesong);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public ArrayList<SubsetSong> getAllSongs(){
        return songs;
    }

    public ArrayList<String> getAllGenres(){
        ArrayList<String> genres = new ArrayList<String>();
        for (int i = 0; i < songs.size(); i++){
            genres.add(songs.get(i).getGenre());
        }
        ArrayList<String> genres_unique = new ArrayList<>(new HashSet<String>(genres));
        return genres_unique;
    }

    public  ArrayList<SubsetSong> findSongsbyArtistTitle(String search) {
        ArrayList<SubsetSong> al = new ArrayList<>();
        search = search.toLowerCase();
        for (SubsetSong s : songs) {
            if (s.getTitle().toLowerCase().contains(search) || s.getArtistTitle().toLowerCase().contains(search))
            {
                al.add(s);
            }
        }
        return al;
    }

    public  ArrayList<SubsetSong> getSongsbyArtist(String artist) {
        ArrayList<SubsetSong> al = new ArrayList<>();
        for (SubsetSong s : songs) {
            if (s.getArtistName().contentEquals(artist)) {
                al.add(s);
            }
        }
        return al;
    }

    public ArrayList<SubsetSong> getSongsbyTitle(String title) {
        ArrayList<SubsetSong> al = new ArrayList<SubsetSong>();
        for (int i = 0; i < songs.size(); i++){
            SubsetSong element = songs.get(i);
            if (element.getTitle().contentEquals(title)) al.add(element);
        }
        return al;
    }

    public ArrayList<SubsetSong> getSongsbyYear(int year) {
        ArrayList<SubsetSong> al = new ArrayList<SubsetSong>();
        for (SubsetSong s : songs) {
            if(s.getYear() == year) al.add(s);
        }
        return al;
    }

    public ArrayList<SubsetSong> getSongsbyFromYear(int year) {
        ArrayList<SubsetSong> al = new ArrayList<SubsetSong>();
        for (SubsetSong s : songs) {
            if(s.getYear() >= year) al.add(s);
        }
        return al;
    }

    public ArrayList<SubsetSong> getSongsbyToYear(int year) {
        ArrayList<SubsetSong> al = new ArrayList<SubsetSong>();
        for (SubsetSong s : songs) {
            if(s.getYear() <= year) al.add(s);
        }
        return al;
    }

    public ArrayList<SubsetSong> getSongsbyGenre(String genre) {
        ArrayList<SubsetSong> al = new ArrayList<>();
        for (SubsetSong s : songs) {
            if (s.getGenre().contentEquals(genre)) {
                al.add(s);
            }
        }
        return al;
    }


    public ArrayList<SubsetSong> getSongsbyArtistFamilarity(boolean bool) {
        ArrayList<SubsetSong> al = new ArrayList<SubsetSong>();
        if(bool) {
            for (SubsetSong s : songs) {
                if(s.getArtistFamiliarity() >= 0.5) al.add(s);
            }
        }
        else{
            for (SubsetSong s : songs) {
                if(s.getArtistFamiliarity() < 0.5) al.add(s);
            }
        }
        return al;
    }

    public ArrayList<SubsetSong> getSongbyArtistHotness(boolean bool) {
        ArrayList<SubsetSong> al = new ArrayList<SubsetSong>();
        if(bool) {
            for (SubsetSong s : songs) {
                if(s.getArtistHotness() >= 0.5) al.add(s);
            }
        }
        else{
            for (SubsetSong s : songs) {
                if(s.getArtistHotness() < 0.5) al.add(s);
            }
        }
        return al;
    }

}
