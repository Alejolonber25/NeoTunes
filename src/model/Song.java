package model;

public class Song extends Audio {
    private String album;
    private SongGender gender;
    private double price;
    private int numberSales;
    /**
     * Song()
     * @param name String
     * @param duration double
     * @param url String
     * @param album String
     * @param gender SongGender
     * @param price double
     */
    public Song(String name, double duration, String url, String album, SongGender gender, double price) {
        super(name, duration, url);
        this.album = album;
        this.gender = gender;
        this.price = price;
    }
    /**
     * getAlbum() String
     * @return album String
     */
    public String getAlbum() {
        return album;
    }
    /**
     * setAlbum() void
     * @param album String
     */
    public void setAlbum(String album) {
        this.album = album;
    }
    /**
     * SongGender() SongGender
     * @return gender SongGender
     */
    public SongGender getGender() {
        return gender;
    }
    /**
     * setGender() void
     * @param gender SongGender
     */
    public void setGender(SongGender gender) {
        this.gender = gender;
    }
    /**
     * getPrice() double
     * @return price double
     */
    public double getPrice() {
        return price;
    }
    /**
     * setPrice() void
     * @param price double
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * getNumberSales() int
     * @return numberSales int
     */
    public int getNumberSales() {
        return numberSales;
    }
    /**
     * setNumberSales() void
     * @param numberSales int
     */
    public void setNumberSales(int numberSales) {
        this.numberSales = numberSales;
    }
}
