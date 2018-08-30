package com.mw;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class Main {
    public static LinkedList<Song> playlist = new LinkedList<Song>();
    public static ArrayList<Album> albums = new ArrayList<Album>();
    public static ListIterator<Song> listIterator = playlist.listIterator();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        albums.add(new Album("OK Computer"));
        albums.get(0).addSong(new Song("Airbag", 400));
        albums.get(0).addSong(new Song("Paranoid Android", 500));
        albums.add(new Album("Amnesiac"));
        albums.get(1).addSong(new Song("Pyramid Song", 100));
        albums.get(1).addSong(new Song("Knives out", 350));
        int option = printOptions();
        while (option != 0) {
            operatePlaylist(option);
            System.out.println(listIterator.hasNext());
            System.out.println(listIterator.hasPrevious());
            option = printOptions();
        }

        scanner.close();
    }

    public static int printOptions() {
        System.out.println("This is your options:\n" +
                "\t0 - quit\n" +
                "\t1 - list albums\n" +
                "\t2 - list playlist\n" +
                "\t3 - add song to playlist\n" +
                "\t4 - remove current song from album\n" +
                "\t5 - skip forward\n" +
                "\t6 - skip backward\n" +
                "\t7 - play");
        System.out.println("Provide option");
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Provide option");
        }
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public static void listAlbums() {
        StringBuilder temp = new StringBuilder("Available albums:\n");
        for (int i = 0; i < albums.size(); i++) {
            temp.append(i + 1).append(". ").append(albums.get(i)).append("\n");
        }
        System.out.println(temp.toString());
    }

    public static void listPlaylist() {
        StringBuilder temp = new StringBuilder("Playlist contains:\n");
        for (int i = 0; i < playlist.size(); i++) {
            temp.append(i + 1).append(". ").append(playlist.get(i)).append("\n");
        }
        System.out.println(temp);
    }

    public static void removeFromPlaylist() {

    }

    public static void addSongToPlaylist(int album_pos, int pos) {
        if (1 > album_pos || album_pos > albums.size() || 1 > pos || pos > albums.get(album_pos - 1).getSize()) {
            throw new IndexOutOfBoundsException("There is no such album or song");
        }
        listIterator.add(albums.get(album_pos - 1).returnSong(pos));
    }

    public static void operatePlaylist(int action) {

        switch (action) {
//            list all albums
            case 1: {
                listAlbums();
                break;
            }
//            list playlist
            case 2: {
                listPlaylist();
                break;
            }
//            add song from album to playlist
            case 3: {
                System.out.println("Provide number of album");
                int pos_album, pos_song;
                while (!scanner.hasNextInt()) {
                    scanner.nextLine();
                    System.out.println("Provide number of album");

                }
                pos_album = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Provide number of song");
                while (!scanner.hasNextInt()) {
                    scanner.nextLine();
                    System.out.println("Provide number of song");

                }
                pos_song = scanner.nextInt();
                scanner.nextLine();
                addSongToPlaylist(pos_album, pos_song);
                break;
            }
//            remove current song
            case 4: {
                if(listIterator.hasNext())
                listIterator.remove();
                break;
            }
//            go to next song
            case 5: {
                if (listIterator.hasNext()) {
                    listIterator.next();
                } else {
                    listIterator.previous();
                }
                break;
            }
//            go to previous song
            case 6: {
                if (listIterator.hasPrevious()) {
                    listIterator.previous();
                } else {

                }
                break;
            }
//            inform about currrent song
            case 7: {
                if (listIterator.hasNext()) {
                    System.out.println("Song playing currently:\n" + listIterator.next());
                } else {
                    System.out.println("Playlist has finished.");
                }

            }
        }
    }

}
