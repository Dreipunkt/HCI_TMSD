package univie.g02.t06.tmsd.dataset;

public class Song {
    private int songID;
    private String songName;
    private int listeners;
    private int playcount;
    private int tagID;
    private String tagName;
    private int tagWeight;

    Song(int songID, String songName, int listeners, int playcount, int tagID, String tagName, int tagWeight) {
        this.songID = songID;
        this.songName = songName;
        this.listeners = listeners;
        this.playcount = playcount;
        this.tagID = tagID;
        this.tagName = tagName;
        this.tagWeight = tagWeight;
    }

    public int getSongID() {
        return songID;
    }

    public String getSongName() {
        return songName;
    }

    public int getListeners() {
        return listeners;
    }

    public int getPlaycount() {
        return playcount;
    }

    public int getTagID() {
        return tagID;
    }

    public String getTagName() {
        return tagName;
    }

    public int getTagWeight() {
        return tagWeight;
    }
}