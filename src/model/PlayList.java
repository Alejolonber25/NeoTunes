package model;

import java.util.ArrayList;

public class PlayList {
    private String name;
    private ArrayList<Audio> audio;
    private String code;
    private int[][] matrixCode;

    /*
    * 0 - without review
    * 1 - Songs
    * 2 - Podcasts
    * 3 - Songs and Podcasts
    * */
    private int typePlaylist = 0;

    /**
     * PlayList()
     * @param name String
     */
    public PlayList(String name) {
        this.name = name;
        this.matrixCode = new int[6][6];
        this.code = "";
        this.audio = new ArrayList<>();
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
    public String getCode() {
        return code;
    }
    /**
     * setCode() void
     * @param code int
     */
    public void setCode(String code) {
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

    public String getString(){
    StringBuilder msj = new StringBuilder();
    reviewMatrix();
    for (int[] ints : matrixCode) {
        for (int j = 0; j < matrixCode.length; j++) {
            msj.append(ints[j]).append(" ");
        }
        msj.append("\n");
    }
    if(!this.code.equals("")){
        msj.append(this.code);
    }else{
        msj.append("There´s no Audio, therefore this playlist cannot be shared");
    }

    return msj.toString();
    }
    public void reviewMatrix(){
        int typePlaylist = 0;
        int countSongs = 0;
        int countPodcasts = 0;
        for (Audio value : audio) {
            if (value != null) {
                if (value instanceof Song) {
                    countSongs++;
                } else if (value instanceof Podcast) {
                    countPodcasts++;
                }
            }
        }
        if(countSongs > 0 && countPodcasts == 0){
            typePlaylist = 1;
        } else if (countPodcasts > 0 && countSongs == 0){
            typePlaylist = 2;
        } else if (countSongs > 0 && countPodcasts >0) {
            typePlaylist = 3;
        }

        if(this.typePlaylist != typePlaylist){
            this.typePlaylist = typePlaylist;
            doRoute();
        }
    }

    public void doRoute(){
        StringBuilder code = new StringBuilder();
        switch (this.typePlaylist){
            case 1 -> {
                for (int i = 5; i > -1; i--) {
                    code.append(this.matrixCode[i][0]);
                }
                for (int i = 1; i < this.matrixCode.length; i++) {
                    code.append(this.matrixCode[i][i]);
                }
                for (int i = 4; i > -1; i--) {
                    code.append(this.matrixCode[i][5]);
                }
            }
            case 2 -> {
                for (int i = 0; i < this.matrixCode.length/2; i++) {
                    code.append(this.matrixCode[0][i]);
                }
                for (int i = 1; i < this.matrixCode.length; i++) {
                    code.append(this.matrixCode[i][2]);
                }
                for (int i = 5; i > 0; i--) {
                    code.append(this.matrixCode[i][3]);
                }
                for (int i = this.matrixCode.length/2; i < this.matrixCode.length; i++) {
                    code.append(this.matrixCode[0][i]);
                }
            }
            case 3 -> {
                for (int i = 5; i > -1; i--) {
                    for (int j = 5; j > -1; j--) {
                        if ((i+j)%2!=0 && (i+j)>1 ){
                            System.out.println(i+j);
                            code.append(this.matrixCode[i][j]);
                        }
                    }
                }
            }

        }
        setCode(code.toString());
    }
}
