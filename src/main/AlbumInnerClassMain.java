package main;

import songAlbumWithInnerClass.Album;
import playList.Song;

import java.util.*;

public class AlbumInnerClassMain {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList<Song> playlist = new LinkedList<>();
        play(playlist);
    }

    private static void printOptions() {
        StringBuilder builder = new StringBuilder();
        builder.append("1: Show available options\n");
        builder.append("2: add song to playlist\n");
        builder.append("3: list all Songs in play list\n");
        builder.append("4: next song\n");
        builder.append("5: previous song\n");
        builder.append("6: replay song\n");
        builder.append("7: remove current Song\n");
        builder.append("8: quit");
        System.out.println(builder.toString());
    }

    private static Album selectAlbum() {
        ArrayList<Album> albumList = albums();
        int index = 1;
        Album alb = null;
        for (Album album : albumList) {
            System.out.println(index + ": " + album.getAlbumName());
            index++;
        }
        int select = scan.nextInt() - 1;
        if (select >= 0 && select <= albumList.size()) {
            alb = albumList.get(select);
        } else {
            System.out.println("Incorrect Number was selected");
        }
        return alb;
    }

    private static boolean addSongToPlayList(LinkedList<Song> playlist) {
        System.out.println("Please select Album");
        boolean result = false;
        Album album = selectAlbum();
        if (album != null) {
            System.out.println("Please select \n 1:Add Song By Title\n 2:Add Song by Track Number");
            int select = scan.nextInt();
            switch (select) {
                case 1:
                    scan.nextLine();
                    String songTitle = scan.nextLine();
                    result = album.addSongToPlaylist(songTitle, playlist);
                    break;
                case 2:
                    album.listAllSongs();
                    System.out.println("Please select track number");
                    int index = scan.nextInt();
                    result = album.addSongToPlaylist(index, playlist);
                    break;
                default:
                    break;
            }

        } else {
            System.out.println("Song not added to playlist");
        }

        return result;

    }

    private static void listSongs(LinkedList<Song> playList) {
        if (playList.isEmpty()) {
            System.out.println("There is no songs in your playlist");
        } else {
            Iterator<Song> iterator = playList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }

    private static void play(LinkedList<Song> playList) {
        Song currentSong = null;
        boolean quit = false;
        ListIterator<Song> playListIterator = playList.listIterator();
        boolean forwoard = false;
        if (!playList.isEmpty()) {
            currentSong = playListIterator.next();
            forwoard = true;
        }

        int select = 0;
        printOptions();
        while (!quit) {
            if (currentSong != null) {
                System.out.println("Curently playing: " + currentSong.toString());
            }
            System.out.println("Please select option: ");
            select = scan.nextInt();
            switch (select) {
                case 1:
                    printOptions();
                    break;
                case 2:
                    if (addSongToPlayList(playList)) {
                        playListIterator = playList.listIterator();
                        currentSong = playListIterator.next();
                        forwoard = true;
                    }
                    break;
                case 3:
                    listSongs(playList);
                    break;
                case 4:
                    if (!forwoard) {
                        playListIterator.next();
                        forwoard = true;
                    }
                    if (playListIterator.hasNext()) {
                        currentSong = playListIterator.next();
                        System.out.println(currentSong);
                    } else {
                        System.out.println("At the end of play list");
                    }
                    break;
                case 5:
                    if (forwoard) {
                        playListIterator.previous();
                        forwoard = false;
                    }
                    if (playListIterator.hasPrevious()) {
                        currentSong = playListIterator.previous();
                        System.out.println(currentSong);
                    } else {
                        System.out.println("At the beginning of play list");
                    }
                    break;
                case 6:
                    if (!forwoard) {
                        System.out.println(playListIterator.next());
                        forwoard = true;
                    } else {
                        System.out.println(playListIterator.previous());
                        forwoard = false;
                    }
                    break;
                case 7:
                    if (!playList.isEmpty()) {
                        playListIterator.remove();
                        if (playListIterator.hasNext()) {
                            currentSong = playListIterator.next();
                        } else if (playListIterator.hasPrevious()) {
                            currentSong = playListIterator.previous();
                        }

                    }
                    if (playList.isEmpty()) {
                        currentSong = null;
                    }


                    break;
                case 8:
                    quit = true;
                    System.out.println("ending program");
                    break;
                default:
                    break;
            }
        }

    }


    private static ArrayList<Album> albums() {
        Album album1 = new Album("Random Access Memories", "DaftPunk");
        album1.addSong("The Game of Love", 5.21);
        album1.addSong("Giorgio By Moroder", 9.04);
        album1.addSong("Within", 3.48);
        album1.addSong("Instant Crush", 5.37);
        album1.addSong("Lose Yourself to Dance", 5.53);
        album1.addSong("Touch", 8.18);
        album1.addSong("Get Lucky", 6.07);
        album1.addSong("Beyond", 4.50);
        album1.addSong("Motherboard", 5.41);
        album1.addSong("Fragments of Time", 4.39);
        album1.addSong("Doin' It Right", 4.11);
        album1.addSong("Contact", 6.21);

        Album album2 = new Album("Meteora", "LinkinPark");
        album2.addSong("Foreword", 0.17);
        album2.addSong("Don't Stay", 3.07);
        album2.addSong("Somewhere I Belong", 3.33);
        album2.addSong("Lying from You", 2.55);
        album2.addSong("Hit the Floor", 2.44);
        album2.addSong("Easier to Run", 3.24);
        album2.addSong("Faint", 2.42);
        album2.addSong("Figure.09 ", 3.17);
        album2.addSong("Breaking the Habit", 3.16);
        album2.addSong("From the Inside", 2.53);
        album2.addSong("Nobody's Listening", 2.58);
        album2.addSong("Session", 2.23);
        album2.addSong("Numb", 3.05);

        ArrayList<Album> arrayList = new ArrayList<>();
        arrayList.add(album1);
        arrayList.add(album2);

        return arrayList;
    }

}
