package model;

public abstract class Audio {
    private String name;
    private int numberReproductions;
    private double duration;
    private String url;

    /**
     * Audio()
     * @param name String
     * @param duration double
     * @param url String
     */
    public Audio(String name, double duration, String url) {
        this.name = name;
        this.duration = duration;
        this.url = url;
    }
    /**
     * getName() String
     * @return name String
     */
    public String getName() {
        return name;
    }
    /**
     * setName() void
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * getNumberReproductions() int
     * @return numberReproductions int
     */
    public int getNumberReproductions() {
        return numberReproductions;
    }
    /**
     * setNumberReproductions() void
     * @param numberReproductions int
     */
    public void setNumberReproductions(int numberReproductions) {
        this.numberReproductions = numberReproductions;
    }
    /**
     * getDuration() double
     * @return duration double
     */
    public double getDuration() {
        return duration;
    }
    /**
     * setDuration() void
     * @param duration double
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }
    /**
     * getUrl() String
     * @return url String
     */
    public String getUrl() {
        return url;
    }
    /**
     * setUrl() void
     * @param url String
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
