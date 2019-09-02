package model;

public class SongArtist {
    private String artistName;
    private String albumName;
    private int track;

    public SongArtist(String artistName, String albumName, int track) {
        this.artistName = artistName;
        this.albumName = albumName;
        this.track = track;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public int getTrack() {
        return track;
    }

    @Override
    public String toString() {
        return track+" "+albumName+" "+artistName;
    }
}
