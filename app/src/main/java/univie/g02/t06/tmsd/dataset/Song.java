package univie.g02.t06.tmsd.dataset;

import java.util.ArrayList;

public class Song {
    private String track_id;
    private String title;
    private String release;
    private String artist_name;
    private double duration;
    private double artist_familiarity;
    private double artist_hotttnesss;
    private int year;
    private String genre;
    private ArrayList<Tag> tags;

    public Song(String track_id, String title, String release, String artist_name,
                      double duration, double artist_familiarity, double artist_hotttnesss,
                      int year, String genre, Tag tag) {
        this.track_id = track_id;
        this.title = title;
        this.release = release;
        this.artist_name = artist_name;
        this.duration = duration;
        this.artist_familiarity = artist_familiarity;
        this.artist_hotttnesss = artist_hotttnesss;
        this.year = year;
        this.genre = genre;
        tags = new ArrayList<>();
        tags.add(tag);
    }

    public String getTrackId() {
        return track_id;
    }

    public String getTitle() {
        return title;
    }

    public String getRelease() {
        return release;
    }

    public String getArtistName(){
        return artist_name;
    }

    public double getDuration(){
        return duration;
    }

    public double getArtistFamiliarity(){
        return artist_familiarity;
    }

    public double getArtistHotness(){
        return artist_hotttnesss;
    }

    public int getYear(){
        return year;
    }

    public String getGenre(){
        return genre;
    }

    public String getArtistTitle() {
        return artist_name + " - " + title;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    void addTag(Tag tag) {
        tags.add(tag);
    }
}