package playList;

import java.util.ArrayList;

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



}
