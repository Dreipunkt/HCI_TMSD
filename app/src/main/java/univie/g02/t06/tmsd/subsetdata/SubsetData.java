package univie.g02.t06.tmsd.subsetdata;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

import au.com.bytecode.opencsv.CSVReader;


public class SubsetData{
    private ArrayList<SubsetSong> songs = new ArrayList<>();

    public SubsetData() {
        //if (songs == null) {
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("res/raw/msd_sampledata.csv");
            InputStreamReader reader = new InputStreamReader(is);
            CSVReader csvreader = new CSVReader(reader, ',');
            String[] line;
            try{
                while ((line = csvreader.readNext()) != null) {
                    SubsetSong singlesong = new SubsetSong(line[0], line[1], line[2], line[3], line[4],
                            line[5], line[6], Double.parseDouble(line[7]), Double.parseDouble(line[8]),
                            Double.parseDouble(line[9]), Integer.parseInt(line[10]), line[11]);
                    songs.add(singlesong);
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        //}
    }


    public ArrayList<SubsetSong> getAllSongs(){
        ArrayList<SubsetSong> al = new ArrayList<>(songs);
        return al;
    }

    public ArrayList<String> getAllGenres(){
        ArrayList<String> genres = new ArrayList<String>();
        for (int i = 0; i < songs.size(); i++){
            genres.add(songs.get(i).getGenre());
        }
        ArrayList<String> genres_unique = new ArrayList<>(new HashSet<String>(genres));
        return genres_unique;
    }

    public  ArrayList<SubsetSong> getSongsbyArtist(String artist) {
        ArrayList<SubsetSong> al = new ArrayList<>();
        for (int i = 0; i < songs.size(); i++){
            SubsetSong element = songs.get(i);
            if (element.getArtistName() == artist) al.add(element);
        }
        return al;
    }

    public ArrayList<SubsetSong> getSongsbyTitle(String title) {
        ArrayList<SubsetSong> al = new ArrayList<SubsetSong>();
        for (int i = 0; i < songs.size(); i++){
            SubsetSong element = songs.get(i);
            if (element.getTitle() == title) al.add(element);
        }
        return al;
    }

    public ArrayList<SubsetSong> getSongsbyYear(int year) {
        ArrayList<SubsetSong> al = new ArrayList<SubsetSong>();
        for (int i = 0; i < songs.size(); i++){
            SubsetSong element = songs.get(i);
            if (element.getYear() == year) al.add(element);
        }
        return al;
    }

    public ArrayList<SubsetSong> getSongsbyFromYear(int year) {
        ArrayList<SubsetSong> al = new ArrayList<SubsetSong>();
        for (int i = 0; i < songs.size(); i++){
            SubsetSong element = songs.get(i);
            if (element.getYear() >= year) al.add(element);
        }
        return al;
    }

    public ArrayList<SubsetSong> getSongsbyToYear(int year) {
        ArrayList<SubsetSong> al = new ArrayList<SubsetSong>();
        for (int i = 0; i < songs.size(); i++){
            SubsetSong element = songs.get(i);
            if (element.getYear() <= year) al.add(element);
        }
        return al;
    }

    public ArrayList<SubsetSong> getSongsbyGenre(String genre) {
        ArrayList<SubsetSong> al = new ArrayList<SubsetSong>();
        for (int i = 0; i < songs.size(); i++){
            SubsetSong element = songs.get(i);
            if (element.getGenre() == genre) al.add(element);
        }
        return al;
    }




    public ArrayList<SubsetSong> getSongsbyArtistFamilarity(boolean bool) {
        ArrayList<SubsetSong> al = new ArrayList<SubsetSong>();
        if(bool) {
            for (int i = 0; i < songs.size(); i++) {
                SubsetSong element = songs.get(i);
                if (element.getArtistFamiliarity() >= 0.5) al.add(element);
            }
        }
        else{
            for (int i = 0; i < songs.size(); i++) {
                SubsetSong element = songs.get(i);
                if (element.getArtistFamiliarity() < 0.5) al.add(element);
            }
        }
        return al;
    }

    public ArrayList<SubsetSong> getSongbyArtistHotness(boolean bool) {
        ArrayList<SubsetSong> al = new ArrayList<SubsetSong>();
        if(bool) {
            for (int i = 0; i < songs.size(); i++) {
                SubsetSong element = songs.get(i);
                if (element.getArtistHotness() >= 0.5) al.add(element);
            }
        }
        else{
            for (int i = 0; i < songs.size(); i++) {
                SubsetSong element = songs.get(i);
                if (element.getArtistHotness() < 0.5) al.add(element);
            }
        }
        return al;
    }

}
