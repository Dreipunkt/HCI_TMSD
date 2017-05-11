package univie.g02.t06.tmsd.dummydata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class DummyAPIData {
    static DummySong song1 = new DummySong("Artist a","Title a1","Rock", 0.4, 0.4, 0.4, 2000);
    static DummySong song2 = new DummySong("Artist a","Title a2","Rock", 0.6, 0.6, 0.6, 2001);
    static DummySong song3 = new DummySong("Artist b", "Title b1", "Pop", 0.4, 0.5, 0.6,2002);
    static DummySong[] songs = {song1,song2,song3};

    public static ArrayList<DummySong> getAllDummySongs(){
        ArrayList<DummySong> al = new ArrayList<DummySong>(Arrays.asList(songs));
        return al;
    }

    public static ArrayList<String> getDummyAllGenres(){
        ArrayList<String> genres = new ArrayList<String>();
        for (int i = 0; i < songs.length; i++){
            genres.add(songs[i].getDummyGenre());
        }
        HashSet<String> hs = new HashSet<String>();
        hs.addAll(genres);
        genres.clear();
        genres.addAll(hs);
        return genres;
    }

    public static ArrayList<DummySong> getDummySongsbyArtist(String artist) {
        ArrayList<DummySong> al = new ArrayList<DummySong>();
        for (int i = 0; i < songs.length; i++){
            DummySong element = songs[i];
            if (element.getDummyArtist() == artist) al.add(element);
        }
        return al;
    }

    public static ArrayList<DummySong> getDummySongsbyTitle(String title) {
        ArrayList<DummySong> al = new ArrayList<DummySong>();
        for (int i = 0; i < songs.length; i++){
            DummySong element = songs[i];
            if (element.getDummyTitle() == title) al.add(element);
        }
        return al;
    }

    public static ArrayList<DummySong> getDummySongsbyYear(int year) {
        ArrayList<DummySong> al = new ArrayList<DummySong>();
        for (int i = 0; i < songs.length; i++){
            DummySong element = songs[i];
            if (element.getDummyYear() == year) al.add(element);
        }
        return al;
    }

    public static ArrayList<DummySong> getDummySongsbyFromYear(int year) {
        ArrayList<DummySong> al = new ArrayList<DummySong>();
        for (int i = 0; i < songs.length; i++){
            DummySong element = songs[i];
            if (element.getDummyYear() >= year) al.add(element);
        }
        return al;
    }

    public static ArrayList<DummySong> getDummySongsbyToYear(int year) {
        ArrayList<DummySong> al = new ArrayList<DummySong>();
        for (int i = 0; i < songs.length; i++){
            DummySong element = songs[i];
            if (element.getDummyYear() <= year) al.add(element);
        }
        return al;
    }

    public static ArrayList<DummySong> getDummySongsbyGenre(String genre) {
        ArrayList<DummySong> al = new ArrayList<DummySong>();
        for (int i = 0; i < songs.length; i++){
            DummySong element = songs[i];
            if (element.getDummyGenre() == genre) al.add(element);
        }
        return al;
    }

    public static ArrayList<DummySong> getDummySongsbyEnergy(boolean bool) {
        ArrayList<DummySong> al = new ArrayList<DummySong>();
        if(bool) {
            for (int i = 0; i < songs.length; i++) {
                DummySong element = songs[i];
                if (element.getDummyEnergy() >= 0.5) al.add(element);
            }
        }
        else{
            for (int i = 0; i < songs.length; i++) {
                DummySong element = songs[i];
                if (element.getDummyEnergy() < 0.5) al.add(element);
            }
        }
        return al;
    }

    public static ArrayList<DummySong> getDummySongsbyDance(boolean bool) {
        ArrayList<DummySong> al = new ArrayList<DummySong>();
        if(bool) {
            for (int i = 0; i < songs.length; i++) {
                DummySong element = songs[i];
                if (element.getDummyDance() >= 0.5) al.add(element);
            }
        }
        else{
            for (int i = 0; i < songs.length; i++) {
                DummySong element = songs[i];
                if (element.getDummyDance() < 0.5) al.add(element);
            }
        }
        return al;
    }

    public static ArrayList<DummySong> getDummySongsbyHot(boolean bool) {
        ArrayList<DummySong> al = new ArrayList<DummySong>();
        if(bool) {
            for (int i = 0; i < songs.length; i++) {
                DummySong element = songs[i];
                if (element.getDummyHot() >= 0.5) al.add(element);
            }
        }
        else{
            for (int i = 0; i < songs.length; i++) {
                DummySong element = songs[i];
                if (element.getDummyHot() < 0.5) al.add(element);
            }
        }
        return al;
    }

}
