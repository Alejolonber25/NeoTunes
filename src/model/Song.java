package model;

import java.util.Timer;
import java.util.TimerTask;

public class Song extends Audio implements Reproducible, Comparable<Song>{
    private String album;
    private SongGender gender;
    private double price;
    private int numberSales;

    private boolean bought;
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
    public String getGender() {
        return gender.toString();
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
    public void addSale() {
        this.numberSales++;
    }

    @Override
    public void reproduction(int typeUser, String ad, int reproductions) {
        Reproducible.super.reproduction(typeUser, ad);

        Timer t = new Timer();
        if (typeUser == 0 && reproductions%2==0 && reproductions >0){

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

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    @Override
    public int compareTo(Song o) {
        if(o.getNumberReproductions()<getNumberReproductions()){
            return -1;
        }else if (o.getNumberReproductions()<getNumberReproductions()){
            return 0;
        }else {
            return 1;
        }
    }
}
