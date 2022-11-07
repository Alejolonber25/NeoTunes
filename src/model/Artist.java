package model;

import java.util.ArrayList;
import java.util.Date;

public class Artist extends ProducerUser {
    private ArrayList<Song> songs;

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
     * @return songs ArrayList<Song>
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }
    /**
     * setSongs() void
     * @param songs ArrayList<Song>
     */
    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
