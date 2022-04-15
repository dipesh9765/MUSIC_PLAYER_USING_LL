package com.dipesh9765;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Album1", "One-Direction");
        album.addSong("Perfect", 4.5);
        album.addSong("History", 2.5);
        album.addSong("Steal my girl", 3.5);
        albums.add(album);
        album = new Album("Album2", "Eminem");
        album.addSong("Godzilla", 4.5);
        album.addSong("Rap God", 2.5);
        album.addSong("Love the way you lie", 3.5);
        albums.add(album);
        LinkedList<Song> playList1 = new LinkedList<>();
        albums.get(0).addSongInPlayList("Perfect", playList1);
        albums.get(0).addSongInPlayList("History", playList1);
        albums.get(1).addSongInPlayList("Steal my girl", playList1);
        albums.get(1).addSongInPlayList("Godzilla", playList1);
        albums.get(1).addSongInPlayList("Rap God", playList1);

        play(playList1);
    }

    public static void play(LinkedList<Song> playList) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0)
            System.out.println("This playlist have no songs");
        else {
            System.out.println("Now playing :" + listIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = sc.nextByte();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist Stopped......");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext())
                        System.out.println("Now Playing : " + listIterator.next().toString());
                    else {
                        System.out.println("Playlist Ended");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious())
                            listIterator.previous();
                        forward = false;
                    }

                    if (listIterator.hasPrevious()) {
                        System.out.println("Now Playing : " + listIterator.previous().toString());
                    } else {
                        System.out.println("we are at First song");
                        forward = false;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing  " + listIterator.previous().toString());
                            forward = false;
                        } else System.out.println("We are at the start ");

                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("now playing : " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("we have reached at end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing : " + listIterator.next().toString());
                        } else {
                            if (listIterator.hasPrevious()) {
                                System.out.println("Now playing :" + listIterator.previous().toString());

                            }
                        }
                    }

            }
        }
    }

    public static void printMenu() {
        System.out.println("Available options : \n");
        System.out.println("0- to quit \n" +
                "1- to play next song\n" +
                "2- to play previous song\n" +
                "3- to replay current song\n" +
                "4- list of all  song\n" +
                "5- print all available option\n" +
                "6- delete current song\n");

    }

    public static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("---------------------");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("---------------------");
    }
}

