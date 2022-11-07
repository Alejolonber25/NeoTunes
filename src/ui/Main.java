package ui;

import model.NeoTunes;
import model.PodcastCategory;
import model.SongGender;

import java.util.Date;
import java.util.Scanner;

public class Main {
    private final Scanner reader;
    private final NeoTunes controller;
    public Main(){
        reader = new Scanner(System.in);
        controller = new NeoTunes();
    }
    /**
     * main(String[] args)
     * @param args
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.cleanConsole();
        int option = 0;
        do{
            main.cleanConsole();
            option = main.getOptionShowMenu();
            main.cleanConsole();
            main.executeOption(option);
            System.out.print("Continue...");
            main.reader.nextLine();
            main.reader.nextLine();
        }while(option != 0);
        main.reader.close();
    }
    /**
     * getOptionShowMenu()
     * @return option int
     */
    public int getOptionShowMenu(){
        int option = 0;
        System.out.println("<<<<<  Menu >>>>>");
        System.out.println(
                """
                        1. Register produce user.
                        2. Register consumer user.
                        3. Register audio.
                        4. Create playlist.
                        5. Edit playlist.
                        0. Exit.""");
        option = reader.nextInt();
        return option;
    }
    /**
     * executeOption()
     * @param option int
     */
    public void executeOption(int option){

        switch (option) {
            case 1 -> uiRegisterArtistOrCreateContent();
            case 2 -> uiRegisterStandardOrPremiumUser();
            case 3 -> uiRegisterSongOrPodcast();
            case 4 -> uiCreatePlaylist();
            case 5 -> uiEditPlaylist();
            default -> {
            }
        }
    }
    /**
     * cleanConsole() void
     */
    public void cleanConsole(){
        System.out.print("\033[H\033[2J");
    }
    /**
     * uiRegisterArtistOrCreateContent() void
     */
    public void uiRegisterArtistOrCreateContent(){
        System.out.print("Type producer user \n1-Artist\n2-Content creator\nOption: ");
        int typeProducerUser = reader.nextInt();
        System.out.print("Nickname: ");
        String nickname = reader.next();
        System.out.print("Id: ");
        String id = reader.next();
        System.out.print("Name: ");
        String name = reader.next();
        System.out.print("Url: ");
        String url = reader.next();
        System.out.println(controller.addProducerUser(typeProducerUser, nickname, id, name, url));
    }
    /**
     * uiRegisterStandardOrPremiumUser() void
     */
    public void uiRegisterStandardOrPremiumUser(){
        System.out.print("Type consumer user\n1-Standard\n2-Premium\nOption: ");
        int typeConsumerUser = reader.nextInt();
        System.out.print("Nickname: ");
        String nickname = reader.next();
        System.out.print("Id: ");
        String id = reader.next();
        System.out.println(controller.addConsumerUser(typeConsumerUser, nickname, id));
    }
    /**
     * uiRegisterSongOrPodcast() void
     */
    public void uiRegisterSongOrPodcast(){
        System.out.print("Type audio\n1-Song\n2-Podcast\nOption: ");
        int typeAudio = reader.nextInt();
        System.out.print("Name: ");
        String name = reader.next();
        System.out.print("Duration: ");
        double duration = reader.nextDouble();
        System.out.print("Url: ");
        String url = reader.next();
        System.out.print("Id producer: ");
        String idProducer = reader.next();
        switch (typeAudio){
            case 1 -> {
                System.out.print("Album: ");
                String album = reader.next();
                System.out.print("Gender: ");
                String genderString = reader.next();
                SongGender gender = SongGender.valueOf(genderString.toUpperCase());
                System.out.print("Price: ");
                double price = reader.nextDouble();
                System.out.println(controller.registerSong(name, duration, url, album, gender, price, idProducer));
            }
            case 2 ->{
                System.out.print("Description: ");
                String description = reader.next();
                System.out.print("Category: ");
                String categoryString = reader.next();
                PodcastCategory category = PodcastCategory.valueOf(categoryString.toUpperCase());
                System.out.println(controller.registerPodcast(name, duration, url, description, category, idProducer));
            }
        }
    }
    /**
     * uiCreatePlaylist() void
     */
    public void uiCreatePlaylist(){
        System.out.print("Id consumer user: ");
        String id = reader.next();
        System.out.print("Name playlist: ");
        String name = reader.next();
        System.out.println(controller.createPlaylist(id, name));
    }
    /**
     * uiEditPlaylist() void
     */
    public void uiEditPlaylist(){
        System.out.print("Id consumer user: ");
        String id = reader.next();
        System.out.print("Name playlist: ");
        String namePlaylist = reader.next();
        System.out.print("Name audio: ");
        String nameAudio = reader.next();
        System.out.println(controller.editPlaylist(id, namePlaylist, nameAudio));
    }
}