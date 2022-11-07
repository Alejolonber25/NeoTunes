package model;

public class Podcast extends Audio {

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
    public PodcastCategory getCategory() {
        return category;
    }
    /**
     * setCategory() void
     * @param category PodcastCategory
     */
    public void setCategory(PodcastCategory category) {
        this.category = category;
    }
}
