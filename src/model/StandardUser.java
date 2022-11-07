package model;

import java.util.Date;

public class StandardUser extends ConsumerUser{
    private int songsToBuy;
    /**
     * StandardUser()
     * @param nickname String
     * @param id String
     * @param vinculationDate Date
     */
    public StandardUser(String nickname, String id, Date vinculationDate) {
        super(nickname, id, vinculationDate);
        this.songsToBuy = 100;
    }
    /**
     * getSongsToBuy() int
     * @return songsToBuy int
     */
    public int getSongsToBuy() {
        return songsToBuy;
    }
    /**
     * setSongsToBuy() void
     * @param songsToBuy int
     */
    public void setSongsToBuy(int songsToBuy) {
        this.songsToBuy = songsToBuy;
    }
}
