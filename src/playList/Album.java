package playList;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String albumName;
    private String band;
    private ArrayList<Song> songList;

    public Album(String albumName, String band) {
        this.albumName = albumName;
        this.band = band;
        this.songList = new ArrayList<>();
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getBand() {
        return band;
    }

    public boolean addSong(String title, double duration) {
        boolean added = false;
        if (title == null || title.equals("")) {
            System.out.println("Please add song title");
            return false;
        }
        Song song = findSong(title);
        if (song == null) {
            this.songList.add(new Song(title, duration));
            added = true;
        } else {
            System.out.println("Song already exist in Album");
        }
        return added;

    }

    private Song findSong(String title) {

        for (Song s : this.songList) {
            if (s.getTitle().equals(title)) {
                return s;
            }

        }
        return null;
    }

    public void listAllSongs() {
        int index = 1;
        System.out.println(albumName + ":");
        for (Song song : songList) {
            System.out.println("Track " + index + ": " + song.toString());
            index++;
        }
    }

    public boolean addSongToPlaylist(String songTitle, LinkedList<Song> playlist) {
        Song song = findSong(songTitle);
        if (song == null) {
            System.out.println(songTitle + " Do not exist in this album");
            return false;
        }
        playlist.addFirst(song);
        System.out.println("Song was added");
        return true;
    }

    public boolean addSongToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        boolean result = false;
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= songList.size())) {
            Song song = songList.get(index);
            playlist.addFirst(song);
            result = true;
        } else {
            System.out.println("Album do not have song with " + trackNumber + " track number");
        }

        return result;
    }


}
