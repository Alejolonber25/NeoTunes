package model;

import java.util.Date;

public abstract class ProducerUser extends User {
    private String name;
    private String url;
    private int totalReproductions;
    private double totalTimePlayed;

    /**
     * ProduceUser()
     * @param nickname String
     * @param id String
     * @param vinculationDate Date
     * @param name String
     * @param url String
     */
    public ProducerUser(String nickname, String id, Date vinculationDate, String name, String url) {
        super(nickname, id, vinculationDate);
        this.name = name;
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
    /**
     * getTotalReproductions() int
     * @return totalReproductions int
     */
    public int getTotalReproductions() {
        return totalReproductions;
    }
    /**
     * setTotalReproductions() void
     * @param totalReproductions int
     */
    public void setTotalReproductions(int totalReproductions) {
        this.totalReproductions = totalReproductions;
    }
    /**
     * getTotalTimePlayed() double
     * @return totalTimePlayed double
     */
    public double getTotalTimePlayed() {
        return totalTimePlayed;
    }
    /**
     * setTotalTimePlayed() void
     * @param totalTimePlayed double
     */
    public void setTotalTimePlayed(double totalTimePlayed) {
        this.totalTimePlayed = totalTimePlayed;
    }

    public void addReproduction(){
        this.totalReproductions++;
    }
}
