package univie.g02.t06.tmsd.subsetdata;


public class SubsetSong {
    String track_id;
    String title;
    String song_id;
    String release;
    String artist_id;
    String artist_mbid;
    String artist_name;
    double duration;
    double artist_familiarity;
    double artist_hotttnesss;
    int year;
    String genre;

    public SubsetSong(String track_id, String title, String song_id, String release,
                      String artist_id, String artist_mbid, String artist_name, double duration,
                      double artist_familiarity, double artist_hotttnesss, int year, String genre) {
        this.track_id = track_id;
        this.title = title;
        this.song_id = song_id;
        this.release = release;
        this.artist_id = artist_id;
        this.artist_mbid = artist_mbid;
        this.artist_name = artist_name;
        this.duration = duration;
        this.artist_familiarity = artist_familiarity;
        this.artist_hotttnesss = artist_hotttnesss;
        this.year = year;
        this.genre = genre;
    }

    public String getTrackId() {
        return track_id;
    }

    public String getTitle() {
        return title;
    }

    public String getSongId() {
        return song_id;
    }

    public String getRelease() {
        return release;
    }

    public String getArtistId(){
        return artist_id;
    }

    public String getArtistMBId(){
        return artist_mbid;
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

    public String getSubsetArtistTitle() {
        return artist_name + " - " + title;
    }

}
