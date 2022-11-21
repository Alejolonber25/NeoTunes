package model;

import javax.swing.text.AbstractDocument;
import java.util.*;

public class NeoTunes {
    private ArrayList<User> users;
    private ArrayList<Audio> audio;

    private ArrayList<String> ads;

    public NeoTunes(){
        users = new ArrayList<>();
        audio = new ArrayList<>();
        ads = new ArrayList<String>(3);
        ads.add("Nike - Just Do It.");
        ads.add("Coca-Cola - Open Happiness.");
        ads.add("M&Ms - Melts in Your Mouth, Not in Your Hands.");
    }
    /**
     * addProducerUser () String
     * @param typeProducerUser int
     * @param nickname String
     * @param id String
     * @param name String
     * @param url String
     * @return msj String
     */
    public String addProducerUser(int typeProducerUser, String nickname, String id, String name, String url){
        String msj = "Registered user";
        int pos = searchPositionUserByID(id);
        if(pos == -1){
            switch (typeProducerUser){
                case 1 -> users.add(new Artist(nickname, id, new Date() , name, url));
                case 2 -> users.add(new ContentCreator(nickname, id, new Date(), name, url));
                default -> msj = "Option of type user invalid";
            }
        }else{
            msj = "This user is already registered";
        }
        return msj;
    }
    /**
     * addConsumerUser() String
     * @param typeConsumerUser int
     * @param nickname String
     * @param id String
     * @return msj String
     */
    public String addConsumerUser(int typeConsumerUser, String nickname, String id){
        String msj = "Registered user";
        int pos = searchPositionUserByID(id);
        if(pos == -1){
            switch (typeConsumerUser){
                case 1 -> users.add(new StandardUser(nickname, id, new Date()));
                case 2 -> users.add(new PremiumUser(nickname, id, new Date()));
                default -> msj = "Option of type user invalid";
            }
        }else{
            msj = "This user is already registered";
        }
        return msj;
    }
    /**
     * registerSong() String
     * @param name String
     * @param duration double
     * @param url String
     * @param album String
     * @param gender SongGender
     * @param price double
     * @param idArtist String 
     * @return msj String
     */
    public String registerSong(String name, double duration, String url, String album, SongGender gender, double price, String idArtist){
        String msj = "Registered song";
        int posArtist = searchPositionUserByID(idArtist);
        if (posArtist != -1) {
            if (users.get(posArtist) instanceof Artist) {
                int posSong = searchPositionAudioByName(audio, name);
                if (posSong == -1){
                    Song song = new Song(name, duration, url, album, gender, price);
                    ((Artist) users.get(posArtist)).getSongs().add(song);
                    audio.add(song);
                }else{
                    msj = "Song is already in NeoTunes";
                }
            }else {
                msj = "User isn't a artist";
            }
        }else{
            msj = "User not found";
        }
        return msj;
    }
    /**
     * registerPodcast() String
     * @param name String
     * @param duration double
     * @param url String
     * @param description String
     * @param category PodcastCategory
     * @param idCreatorContent String
     * @return msj String
     */
    public String registerPodcast(String name, double duration, String url, String description, PodcastCategory category, String idCreatorContent){
        String msj = "Registered podcast";
        int posContentCreator = searchPositionUserByID(idCreatorContent);
        if (posContentCreator != -1) {
            if (users.get(posContentCreator) instanceof  ContentCreator){
                int posPodcast = searchPositionAudioByName(audio, name);
                if (posPodcast == -1){
                    Podcast podcast = new Podcast(name, duration, url, description, category);
                    ((ContentCreator) users.get(posContentCreator)).getPodcasts().add(podcast);
                    audio.add(podcast);
                }else{
                    msj = "Podcast is already in NeoTunes";
                }
            }else{
                msj = "User isn't a content creator";
            }
        }else{
            msj = "User not found";
        }
        return msj;
    }
    /**
     * createPlaylist() String
     * @param idConsumerUser String
     * @param name String
     * @return msj String
     */
    public String createPlaylist(String idConsumerUser, String name){
       String msj = "Registered playlist";
        int posConsumerUser = searchPositionUserByID(idConsumerUser);
        if (posConsumerUser != -1){
            if (users.get(posConsumerUser) instanceof ConsumerUser){
                PlayList playlist = new PlayList(name);
               if (users.get(posConsumerUser) instanceof StandardUser){
                   if ( ((StandardUser) users.get(posConsumerUser)).getPlaylists().size() <100 ){
                       ((ConsumerUser) users.get(posConsumerUser)).getPlaylists().add(playlist);
                   }else{
                       msj = "User can not create more playlists";
                   }
               }else{
                   ((ConsumerUser) users.get(posConsumerUser)).getPlaylists().add(playlist);
               }
            }else{
                msj = "User isn't a consumer user";
            }
        }else{
            msj = "User not found";
        }
        return msj;
    }
    /**
     * editPlaylist() String
     * @param idConsumerUser String
     * @param namePlaylist String
     * @param nameAudio String
     * @return msj String
     */
    public String editPlaylist(String idConsumerUser, String namePlaylist, String nameAudio){
        String msj = "Registered audio";
        int posAudio = searchPositionAudioByName(audio, nameAudio);
        if(posAudio != -1){
            int posConsumerUser = searchPositionUserByID(idConsumerUser);
            if (posConsumerUser != -1){
                if (users.get(posConsumerUser) instanceof ConsumerUser){
                    int posPlaylist = searchPositionPlaylistOfConsumerUserByName(idConsumerUser, namePlaylist);
                    if(posPlaylist != -1){
                        int posAudioInPlaylist = searchPositionAudioByName(((ConsumerUser) users.get(posConsumerUser)).getPlaylists().get(posPlaylist).getAudio(), nameAudio);
                        if (posAudioInPlaylist == -1){
                            ((ConsumerUser) users.get(posConsumerUser)).getPlaylists().get(posPlaylist).getAudio().add(audio.get(posAudio));
                        }else{
                            msj = "Audio is already in this playlist";
                        }
                    }else {
                        msj = "Playlist not found";
                    }
                }else{
                    msj = "User isn't a consumer user";
                }
            }else {
                msj = "User not found";
            }
        }else{
            msj = "Audio not found";
        }

        return msj;
    }
    /**
     * searchPositionUserByID() String
     * @param id String
     * @return msj String
     */
    public int searchPositionUserByID(String id){
        int pos = -1;
        boolean wasFound = false;
        for (int i = 0; i < users.size() && !wasFound; i++) {
            if (users.get(i) != null && users.get(i).getId().equalsIgnoreCase(id)){
                wasFound = true;
                pos = i;
            }

        }
        return pos;
    }
    /**
     * searchPositionAudioByName() String
     * @param audio ArrayList<Audio>
     * @param name String
     * @return msj String
     */
    public int searchPositionAudioByName(ArrayList<Audio> audio, String name){
        int pos = -1;
        boolean wasFound = false;
        for (int i = 0; i < audio.size() && !wasFound; i++) {
            if (audio.get(i) != null && audio.get(i).getName().equalsIgnoreCase(name)){
                wasFound = true;
                pos = i;
            }
        }
        return pos;
    }
    /**
     * searchPositionPlaylistOfConsumerUserByName() String
     * @param idConsumerUser String
     * @param name String
     * @return msj String
     */
    public int searchPositionPlaylistOfConsumerUserByName(String idConsumerUser, String name){
        int posPlaylist = -1;
        int posConsumerUser = searchPositionUserByID(idConsumerUser);
        if(posConsumerUser != -1 && users.get(posConsumerUser) instanceof ConsumerUser){
            boolean wasFound = false;
            for (int i = 0; i < ((ConsumerUser) users.get(posConsumerUser)).getPlaylists().size() && !wasFound; i++) {
                if (((ConsumerUser) users.get(posConsumerUser)).getPlaylists().get(i) != null && ((ConsumerUser) users.get(posConsumerUser)).getPlaylists().get(i).getName().equalsIgnoreCase(name)){
                    wasFound = true;
                    posPlaylist = i;
                }
            }
        }

        return posPlaylist;
    }
    public String sharePlaylist(String idConsumerUser, String namePlaylist){
        String msj = "";
        int posConsumerUser = searchPositionUserByID(idConsumerUser);
        if ( posConsumerUser != -1 ) {
            if ( users.get(posConsumerUser) instanceof ConsumerUser ) {
                int posPlaylist = searchPositionPlaylistOfConsumerUserByName(idConsumerUser, namePlaylist);
                if ( posPlaylist != -1 ) {
                   msj = ((ConsumerUser) users.get(posConsumerUser)).getPlaylists().get(posPlaylist).getString();
                } else {
                    msj = "Playlist not found";
                }
            } else {
                msj = "User isn't a consumer user";
            }
        } else {
            msj = "User not found";
        }

        return msj;
    }

    public String playAudio(String idConsumerUser, String namePlaylist, String nameAudio){
       String msj = "";
       int posConsumerUser = searchPositionUserByID(idConsumerUser);
       if (posConsumerUser != -1){
           if (users.get(posConsumerUser) instanceof ConsumerUser){
               // 1 - Standard | 0 - Premium
               int typeUser;
               if(users.get(posConsumerUser) instanceof StandardUser) { typeUser = 0; }  else { typeUser = 1; }
               int posPlaylist = searchPositionPlaylistOfConsumerUserByName(idConsumerUser, namePlaylist);
               if (posPlaylist != -1){
                   int posAudio = searchPositionAudioByName(((ConsumerUser) users.get(posConsumerUser)).getPlaylists().get(posPlaylist).getAudio(),nameAudio);
                   if (posAudio != -1){
                        if( ((ConsumerUser) users.get(posConsumerUser)).getPlaylists().get(posPlaylist).getAudio().get(posAudio) instanceof Song){
                            ( (Song) ((ConsumerUser) users.get(posConsumerUser)).getPlaylists().get(posPlaylist).getAudio().get(posAudio) ).reproduction(typeUser,ads.get( ((int) (Math.random() * ads.size())) ), ((ConsumerUser) users.get(posConsumerUser)).getTotalPodcastPlaying()+((ConsumerUser) users.get(posConsumerUser)).getTotalSongPlaying());
                            //Consumer
                            ((ConsumerUser) users.get(posConsumerUser)).addTotalSongPlaying();
                            int posProducer = searchPositionProducerUserByAudio(0,nameAudio);
                            int posSongInProducer = searchPositionAudioByName(  ((Artist) users.get(posProducer)).getSongs(),nameAudio );
                            ((Artist) users.get(posProducer)).getSongs().get(posSongInProducer).addReproduction();
                            ((Artist) users.get(posProducer)).addReproduction();
                        }else{
                            ( (Podcast) ((ConsumerUser) users.get(posConsumerUser)).getPlaylists().get(posPlaylist).getAudio().get(posAudio) ).reproduction(typeUser,ads.get( ((int) (Math.random() * ads.size())) ), 0);
                            //Consumer
                            ((ConsumerUser) users.get(posConsumerUser)).addTotalPodcastPlaying();
                            int posProducer = searchPositionProducerUserByAudio(1, nameAudio);
                            int posPodcastInProducer = searchPositionAudioByName(  ((ContentCreator) users.get(posProducer)).getPodcasts(),nameAudio );
                            ((ContentCreator) users.get(posProducer)).getPodcasts().get(posPodcastInProducer).addReproduction();
                            ((ContentCreator) users.get(posProducer)).addReproduction();
                        }
                        //Playlist
                      // ((ConsumerUser) users.get(posConsumerUser)).getPlaylists().get(posPlaylist).getAudio().get(posAudio).addReproduction();

                        //int posAudioInController = searchPositionAudioByName(audio, nameAudio);
                        // Controller
                        //audio.get(posAudioInController).addReproduction();

                   }else{
                       msj = "Audio not found";
                   }
               }else{
                   msj = "Playlist not found";
               }
           }else{
               msj = "User isn't consumer user";
           }
       } else {
           msj = "Consumer user not found";
       }
       return msj;
    }

    public int searchPositionProducerUserByAudio(int typeProducerUser, String nameAudio){
        int posProducer = -1;
        switch (typeProducerUser){
            case 0->{
                //Artist
                boolean wasFound = false;
                for (int i = 0; i < users.size(); i++) {
                    if( users.get(i) != null && users.get(i) instanceof Artist){
                        for (int j = 0; j < ((Artist) users.get(i)).getSongs().size() && !wasFound; j++) {
                            if ( ((Artist) users.get(i)).getSongs().get(j) != null && ((Artist) users.get(i)).getSongs().get(j).getName().equalsIgnoreCase(nameAudio) ) {
                                wasFound = true;
                                posProducer = i;
                                break;
                            }
                        }
                    }
                }

            }
            case 1->{
                //ContentProducer
                boolean wasFound = false;
                for (int i = 0; i < users.size(); i++) {
                    if( users.get(i) != null && users.get(i) instanceof ContentCreator){
                        for (int j = 0; j < ((ContentCreator) users.get(i)).getPodcasts().size() && !wasFound; j++) {
                            if ( ((ContentCreator) users.get(i)).getPodcasts().get(j) != null && ((ContentCreator) users.get(i)).getPodcasts().get(j).getName().equalsIgnoreCase(nameAudio) ) {
                                wasFound = true;
                                posProducer = i;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return posProducer;
    }

    public String buyAudio(String idConsumerUser, String namePlaylist, String nameAudio){
        String msj = "";
        int posConsumerUser = searchPositionUserByID(idConsumerUser);
        if (posConsumerUser != -1){
            if (users.get(posConsumerUser) instanceof ConsumerUser){
                int posPlaylist = searchPositionPlaylistOfConsumerUserByName(idConsumerUser, namePlaylist);
                if (posPlaylist != -1){
                    int posSong = searchPositionAudioByName(((ConsumerUser) users.get(posConsumerUser)).getPlaylists().get(posPlaylist).getAudio(),nameAudio);
                    if (posSong != -1){
                        if( ((ConsumerUser) users.get(posConsumerUser)).getPlaylists().get(posPlaylist).getAudio().get(posSong) instanceof Song){
                            if ( !((Song) ((ConsumerUser) users.get(posConsumerUser)).getPlaylists().get(posPlaylist).getAudio().get(posSong)).isBought() ){
                                msj = "Purchased song";
                                ((Song) ((ConsumerUser) users.get(posConsumerUser)).getPlaylists().get(posPlaylist).getAudio().get(posSong)).setBought(true);
                                int posSongInController = searchPositionAudioByName(audio,nameAudio);
                                ((Song) audio.get(posSongInController)).addSale();
                            }else{
                                msj = "Song already bought";
                            }
                        }else{
                            msj = "Audio isn't song";
                        }
                    }else{
                        msj = "Audio not found";
                    }
                }else{
                    msj = "Playlist not found";
                }
            }else{
                msj = "User isn't consumer user";
            }
        } else {
            msj = "Consumer user not found";
        }
        return msj;
    }

    public String generateReports(){
        StringBuilder msj = new StringBuilder();
        // a
        int countSongReproductions = 0;
        int countPodcastReproductions = 0;
        for (Audio value : audio) {
            if ( value != null ) {
                if ( value instanceof Song ) {
                    //Song
                    countSongReproductions += value.getNumberReproductions();
                    System.out.println(value.getNumberReproductions());

                } else {
                    countPodcastReproductions += value.getNumberReproductions();
                    //Podcast
                }
            }

        }
        msj.append("Songs: ").append(countSongReproductions);
        msj.append("\nPodcasts: ").append(countPodcastReproductions);

        //Gender
        for (int i = 0; i < users.size(); i++) {
            if ( users.get(i) != null & users.get(i) instanceof ConsumerUser ){
                String[] genders = {"ROCK","POP","TRAP","HOUSE"};
                int[] countReproductionsGenders = new int[genders.length];
                for (int j = 0; j < genders.length; j++) {
                    for (int k = 0; k < ((ConsumerUser)users.get(i)).getPlaylists().size(); k++) {
                     if(((ConsumerUser)users.get(i)).getPlaylists() != null)   {
                         for (int l = 0; l < ((ConsumerUser)users.get(i)).getPlaylists().get(k).getAudio().size(); l++) {
                             if(((ConsumerUser)users.get(i)).getPlaylists().get(k).getAudio().get(l) != null && ((ConsumerUser)users.get(i)).getPlaylists().get(k).getAudio().get(l) instanceof Song){
                                 if(((Song) ((ConsumerUser)users.get(i)).getPlaylists().get(k).getAudio().get(l)).getGender().equalsIgnoreCase(genders[j])){
                                    countReproductionsGenders[j] += ((ConsumerUser) users.get(i)).getPlaylists().get(k).getAudio().get(l).getNumberReproductions();
                                 }
                             }
                         }
                     }
                    }
                }
                int posMax = 0;
                for (int j = 1; j < genders.length; j++) {
                    if(countReproductionsGenders[j] > countReproductionsGenders[posMax]){
                        posMax = j;
                    }
                }
                if ( countReproductionsGenders[posMax] >0){
                    msj.append("\n ").append(users.get(i).getNickname());
                    msj.append("\n").append(genders[posMax]).append("\n").append(countReproductionsGenders[posMax]);
                }
            }

        }
        //Category

        for (int i = 0; i < users.size(); i++) {
            if ( users.get(i) != null & users.get(i) instanceof ConsumerUser ){

                String[] categories = {"POLITICS","ENTERTAINMENT","VIDEOGAMES","FASHION"};
                int[] countReproductionsCategories = new int[categories.length];
                for (int j = 0; j < categories.length; j++) {
                    for (int k = 0; k < ((ConsumerUser)users.get(i)).getPlaylists().size(); k++) {
                        if(((ConsumerUser)users.get(i)).getPlaylists() != null)   {
                            for (int l = 0; l < ((ConsumerUser)users.get(i)).getPlaylists().get(k).getAudio().size(); l++) {
                                if(((ConsumerUser)users.get(i)).getPlaylists().get(k).getAudio().get(l) != null && ((ConsumerUser)users.get(i)).getPlaylists().get(k).getAudio().get(l) instanceof Podcast){
                                    if(((Podcast) ((ConsumerUser)users.get(i)).getPlaylists().get(k).getAudio().get(l)).getCategory().equalsIgnoreCase(categories[j])){
                                        countReproductionsCategories[j] += ((ConsumerUser) users.get(i)).getPlaylists().get(k).getAudio().get(l).getNumberReproductions();
                                    }
                                }
                            }
                        }
                    }
                }
                int posMax = 0;
                for (int j = 1; j < categories.length; j++) {
                    if(countReproductionsCategories[j] > countReproductionsCategories[posMax]){
                        posMax = j;
                    }
                }
                if ( countReproductionsCategories[posMax] >0){
                    msj.append("\n Nickname: ").append(users.get(i).getNickname());
                    msj.append("\n Category: ").append(categories[posMax]).append("\n Reproductions: ").append(countReproductionsCategories[posMax]);
                }
            }

        }

        //Audio
        ArrayList<Podcast> podcastList = new ArrayList<>();
        for (Audio value : audio) {
            if ( value instanceof Podcast ) {
                podcastList.add(((Podcast)value));
            }
        }
        Collections.sort(podcastList);
        msj.append("\nTop Podcasts:\n");
        for (Podcast podcast : podcastList) {
            msj.append("\nName: ").append(podcast.getName());
            msj.append("\nReproductions: ").append(podcast.getNumberReproductions());
            msj.append("\nCategory: ").append(podcast.getCategory());
        }


        ArrayList<Song> songList = new ArrayList<>();
        for (Audio value : audio) {
            if ( value instanceof Song ) {
                songList.add(((Song)value));
            }
        }
        Collections.sort(songList);
        msj.append("\nTop Songs:\n");
        for (Song song : songList) {
            msj.append("\nName: ").append(song.getName());
            msj.append("\nReproductions: ").append(song.getNumberReproductions());
            msj.append("\nCategory: ").append(song.getGender());
        }


        return msj.toString();
    }
}
