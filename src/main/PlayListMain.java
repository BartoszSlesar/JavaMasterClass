package main;

import playList.Song;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class PlayListMain {
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

    private static void play(LinkedList<Song> playList) {
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        ListIterator<Song> playListIterator = playList.listIterator();
        boolean forwoard = true;
        int select = 0;
        printOptions();
        while (!quit) {
            System.out.println("Please select option: ");
            select = scan.nextInt();
            switch (select) {
                case 1:
                    printOptions();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
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

}
