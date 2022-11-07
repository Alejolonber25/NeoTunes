package model;

import java.util.ArrayList;

public class PlayList {
    private String name;
    private ArrayList<Audio> audio;
    private int code;
    private int[][] matrixCode;

    /**
     * PlayList()
     * @param name String
     */
    public PlayList(String name) {
        this.name = name;
        this.matrixCode = new int[6][6];
        audio = new ArrayList<>();
        for (int i = 0; i < matrixCode.length; i++) {
            for (int j = 0; j < matrixCode[0].length; j++) {
                matrixCode[i][j] = (int) Math.floor(Math.random()*10);
            }
        }
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
     * getAudio() ArrayList<Audio>
     * @return audio ArrayList<Audio>
     */
    public ArrayList<Audio> getAudio() {
        return audio;
    }
    /**
     * setAudio() void
     * @param audio ArrayList<audio>
     */
    public void setAudio(ArrayList<Audio> audio) {
        this.audio = audio;
    }
    /**
     * getCode() int
     * @return code int
     */
    public int getCode() {
        return code;
    }
    /**
     * setCode() void
     * @param code int
     */
    public void setCode(int code) {
        this.code = code;
    }
    /**
     * getMatrixCode() int[][]
     * @return matrixcode int[][]
     */
    public int[][] getMatrixCode() {
        return matrixCode;
    }
    /**
     * setMatrixCode() void
     * @param matrixCode int[][]
     */
    public void setMatrixCode(int[][] matrixCode) {
        this.matrixCode = matrixCode;
    }
}
