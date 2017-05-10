package univie.g02.t06.tmsd.dataset;

public class Song {
    private String title;
    private String artist;
    private double duration; // in seconds
    private int year;

    /**
     *
     * @param title
     * @param artist
     * @param duration
     * @param year
     */

    Song(String title, String artist, double duration, int year) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public double getDuration() {
        return duration;
    }

    public int getYear() {
        return year;
    }
}