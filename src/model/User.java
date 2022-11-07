package model;

import java.util.Date;

public abstract class User {
    private String nickname;
    private String id;
    private Date vinculationDate;
    /**
     * User()
     * @param nickname String
     * @param id String
     * @param vinculationDate Date
     */
    public User(String nickname, String id, Date vinculationDate) {
        this.nickname = nickname;
        this.id = id;
        this.vinculationDate = vinculationDate;
    }
    /**
     * getNickname() String
     * @return nickname String
     */
    public String getNickname() {
        return nickname;
    }
    /**
     * setNickname() void
     * @param nickname String
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    /**
     * getId() String
     * @return id String
     */
    public String getId() {
        return id;
    }
    /**
     * setId() void
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * getVinculationDate() Date
     * @return vinculationDate Date
     */
    public Date getVinculationDate() {
        return vinculationDate;
    }
    /**
     * setVinculationDate void
     * @param vinculationDate Date
     */
    public void setVinculationDate(Date vinculationDate) {
        this.vinculationDate = vinculationDate;
    }
}
