package univie.g02.t06.tmsd.dataset;

import java.util.ArrayList;

public class Song {
    private int songID;
    private String songName;
    private int listeners;
    private int playcount;
    private ArrayList<Tag> tags;

    Song(int songID, String songName, int listeners, int playcount, Tag tag) {
        this.songID = songID;
        this.songName = songName;
        this.listeners = listeners;
        this.playcount = playcount;
        tags = new ArrayList<>();
        tags.add(tag);
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

    public ArrayList<Tag> getTags() {
        return tags;
    }

    void addTag(Tag tag) {
        tags.add(tag);
    }
}