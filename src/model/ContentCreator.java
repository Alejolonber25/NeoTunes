package model;

import java.util.ArrayList;
import java.util.Date;

public class ContentCreator extends ProducerUser {
    private ArrayList<Audio> podcasts;

    /**
     * ContentCreator()
     * @param nickname String
     * @param id String
     * @param vinculationDate Date
     * @param name String
     * @param url String
     */
    public ContentCreator(String nickname, String id, Date vinculationDate, String name, String url) {
        super(nickname, id, vinculationDate, name, url);
        podcasts = new ArrayList<>();
    }
    /**
     * getPodcasts() ArrayList<Podcast>
     *
     * @return podcasts ArrayList<Podcast>
     */
    public ArrayList<Audio> getPodcasts() {
        return podcasts;
    }
    /**
     * setPodcasts() void
     * @param podcasts ArrayList<Podcast>
     */
    public void setPodcasts(ArrayList<Audio> podcasts) {
        this.podcasts = podcasts;
    }
}
