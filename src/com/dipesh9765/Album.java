package com.dipesh9765;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist ) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public Album() {
    }

    public boolean addSong(String title, double duration) {
        if (find(title) == null) {
            songs.add(new Song(title, duration));
//            System.out.println(title + " has been successfully added.");
            return true;
        } else {
//            System.out.println(title + " is already present in list");
            return false;
        }
    }

    public Song find(String title) {

        for (Song sn : songs)
            if (sn.getTitle().equals(title)) return sn;

        return null;

    }

    public boolean addSongInPlaylist(int songNumber, LinkedList<Song> songList) {
        int index = songNumber - 1;
        if (index > 0 && index < this.songs.size()) {
            songList.add(this.songs.get(index));
            return true;
        }
//        System.out.println("Album doesn't contain song: " + this.songs.get(index));
        return false;
    }

    public boolean addSongInPlayList(String title, LinkedList<Song> songList) {
        for (Song sn : this.songs) {
            if (sn.getTitle().equals(title)) {
                songList.add(sn);
                return true;
            }
        }
//        System.out.println("No such song present in Album");
        return false;
    }

}
