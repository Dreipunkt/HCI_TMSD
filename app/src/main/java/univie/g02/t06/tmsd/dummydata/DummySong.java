package univie.g02.t06.tmsd.dummydata;


public class DummySong {
    String artist;
    String title;
    String genre;
    double energy;
    double dance;
    double hot;
    int year;

    public DummySong(String artist, String title, String genre, double energy,
                     double dance, double hot, int year) {
        this.artist = artist;
        this.title = title;
        this.genre = genre;
        this.energy = energy;
        this.dance = dance;
        this.hot = hot;
        this.year = year;
    }

    public String getDummyArtist() {
        return artist;
    }

    public String getDummyTitle() {
        return title;
    }

    public String getDummyArtistTitle() {
        return artist + " - " + title;
    }

    public String getDummyGenre() {
        return genre;
    }

    public double getDummyEnergy() {
        return energy;
    }

    public double getDummyDance() {
        return dance;
    }

    public double getDummyHot() {
        return hot;
    }

    public int getDummyYear() {
        return year;
    }
}