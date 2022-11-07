package model;

import java.util.ArrayList;
import java.util.Date;

public class NeoTunes {
    private ArrayList<User> users;
    private ArrayList<Audio> audio;

    public NeoTunes(){
        users = new ArrayList<>();
        audio = new ArrayList<>();
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
}
