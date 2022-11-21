package model;

import java.util.ArrayList;
import java.util.Date;

public abstract class ConsumerUser extends User {
    private ArrayList<PlayList> playlists;
    private int totalSongPlaying;
    private int totalPodcastPlaying;
    private String favouritePodcastCategory;
    private String favouriteSongGender;
    private String favouriteArtist;
    private String favouriteContentCreator;

    /**
     * ConsumerUser
     * @param nickname String
     * @param id String
     * @param vinculationDate Date
     */
    public ConsumerUser(String nickname, String id, Date vinculationDate) {
        super(nickname, id, vinculationDate);
        playlists = new ArrayList<>();
    }
    /**
     * getPlaylists() ArrayList<PlayList>
     * @return playlists ArrayList<PlayList>
     */
    public ArrayList<PlayList> getPlaylists() {
        return playlists;
    }
    /**
     * setPlaylists() void
     * @param playlists ArrayList<PlayList>
     */
    public void setPlaylists(ArrayList<PlayList> playlists) {
        this.playlists = playlists;
    }
    /**
     * getTotalSongPlayingTime() double
     * @return totalSongPlayingTime double
     */

    /**
     * getFavouritePodcastCategory() String
     * @return favouritePodcastCategory String
     */
    public String getFavouritePodcastCategory() {
        return favouritePodcastCategory;
    }
    /**
     * setFavouritePodcastCategory() void
     * @param favouritePodcastCategory String
     */
    public void setFavouritePodcastCategory(String favouritePodcastCategory) {
        this.favouritePodcastCategory = favouritePodcastCategory;
    }
    /**
     * getFavouriteSongGender() String
     * @return favouriteSongGender String
     */
    public String getFavouriteSongGender() {
        return favouriteSongGender;
    }
    /**
     * setFavouriteSongGender() void
     * @param favouriteSongGender String
     */
    public void setFavouriteSongGender(String favouriteSongGender) {
        this.favouriteSongGender = favouriteSongGender;
    }
    /**
     * getFavouriteArtist() String
     * @return favouriteArtist String
     */
    public String getFavouriteArtist() {
        return favouriteArtist;
    }
    /**
     * setFavouriteArtist() void
     * @param favouriteArtist String
     */
    public void setFavouriteArtist(String favouriteArtist) {
        this.favouriteArtist = favouriteArtist;
    }
    /**
     * getFavouriteContentCreator() String
     * @return favouriteContentCreator String
     */
    public String getFavouriteContentCreator() {
        return favouriteContentCreator;
    }
    /**
     * setFavouriteContentCreator() void
     * @param favouriteContentCreator String
     */
    public void setFavouriteContentCreator(String favouriteContentCreator) {
        this.favouriteContentCreator = favouriteContentCreator;
    }

    public int getTotalSongPlaying() {
        return totalSongPlaying;
    }

    public void setTotalSongPlaying(int totalSongPlaying) {
        this.totalSongPlaying = totalSongPlaying;
    }

    public int getTotalPodcastPlaying() {
        return totalPodcastPlaying;
    }

    public void setTotalPodcastPlaying(int totalPodcastPlaying) {
        this.totalPodcastPlaying = totalPodcastPlaying;
    }

    public void addTotalPodcastPlaying() {
        this.totalPodcastPlaying++;
    }

    public void addTotalSongPlaying() {
        this.totalSongPlaying++;
    }
}
