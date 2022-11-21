package model;

import java.util.ArrayList;
import java.util.Date;

public class Artist extends ProducerUser {
    private ArrayList<Audio> songs;

    /**
     * Artist()
     * @param nickname String
     * @param id String
     * @param vinculationDate Date
     * @param name String
     * @param url String
     */
    public Artist(String nickname, String id, Date vinculationDate, String name, String url) {
        super(nickname, id, vinculationDate, name, url);
        songs = new ArrayList<>();
    }
    /**
     * getSongs()
     *
     * @return songs ArrayList<Song>
     */
    public ArrayList<Audio> getSongs() {
        return songs;
    }
    /**
     * setSongs() void
     * @param songs ArrayList<Song>
     */
    public void setSongs(ArrayList<Audio> songs) {
        this.songs = songs;
    }
}
