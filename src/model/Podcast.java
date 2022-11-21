package model;

import java.util.Timer;
import java.util.TimerTask;

public class Podcast extends Audio implements Reproducible, Comparable<Podcast>{

    private String description;
    private PodcastCategory category;

    /**
     * Podcast()
     * @param name String
     * @param duration double
     * @param url String
     * @param description String
     * @param category PodcastCategory
     */
    public Podcast(String name, double duration, String url, String description, PodcastCategory category) {
        super(name, duration, url);
        this.description = description;
        this.category = category;
    }
    /**
     * getDescription() String
     * @return description String
     */
    public String getDescription() {
        return description;
    }
    /**
     * setDescription() void
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * getCategory() PodcastCategory
     * @return category PodcastCategory
     */
    public String getCategory() {
        return category.toString();
    }
    /**
     * setCategory() void
     * @param category PodcastCategory
     */
    public void setCategory(PodcastCategory category) {
        this.category = category;
    }


    @Override
    public void reproduction(int typeUser, String ad, int reproductions) {
        Reproducible.super.reproduction(typeUser, ad);

        Timer t = new Timer();
        if (typeUser == 0){
            System.out.println(ad);
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.print("Audio is playing...");

                }
            }, 5000);

            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.print("\nAudio played");
                    t.cancel();
                }
            }, 15000);
        }else{
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.print("\nAudio played");
                    t.cancel();
                }
            }, 10000);
        }
    }

    @Override
    public int compareTo(Podcast o) {
        if(o.getNumberReproductions()<getNumberReproductions()){
            return -1;
        }else if (o.getNumberReproductions()<getNumberReproductions()){
            return 0;
        }else {
            return 1;
        }
    }
}
