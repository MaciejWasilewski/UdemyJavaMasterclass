package model;


import com.sun.jdi.request.ClassPrepareRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static DataSource instance = null;
    static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;

    public static final String TAB_ALBUMS = "albums";
    public static final String TAB_ARTISTS = "artists";
    public static final String TAB_SONGS = "songs";

    public static final String COL_ARTIST_ID = "_id";
    public static final String COL_ARTIST_NAME = "name";

    public static final String COL_ALBUM_ID = "_id";
    public static final String COL_ALBUM_NAME = "name";
    public static final String COL_ALBUM_ARTIST = "artist";

    public static final String COL_SONG_ID = "_id";
    public static final String COL_SONG_TITLE = "title";
    public static final String COL_SONG_ALBUM = "album";
    public static final String COL_SONG_TRACK = "track";
    //private static PreparedStatement selectStatement;
    private Connection conn;

    private DataSource() {
        if (instance != null) {
            throw new IllegalStateException("Cannot create new instance of singleton!");
        }
    }

    public synchronized static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();

        }
        return instance;

    }

    public boolean open() {
        try {
            instance.conn = DriverManager.getConnection(CONNECTION_STRING);

            return true;
        } catch (SQLException e) {
            System.out.println("Could not connect to database.\n" + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }


    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Could not close connection.\n" + e.getMessage());
            }
        }
    }

    public List<Artist> queryArtists() throws SQLException {

        List<Artist> artists = new ArrayList<>();
        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM " + TAB_ARTISTS);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                artists.add(new Artist(results.getString(COL_ARTIST_NAME), results.getInt(COL_ARTIST_ID)));

            }
            return artists;


        }
    }


    public List<Album> queryAlbumsFromArtist(Artist a) throws SQLException {
        List<Album> albums = new ArrayList<>();
        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM " + TAB_ALBUMS
                + " where " + COL_ALBUM_ARTIST + "=?" + "ORDER BY " + COL_ALBUM_NAME + " ASC")) {
            statement.setInt(1, a.getId());
            //statement.setString(2, COL_ALBUM_NAME);
            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    albums.add(new Album(results.getInt(COL_ALBUM_ID), results.getString(COL_ALBUM_NAME),
                            results.getInt(COL_ALBUM_ARTIST)));
                }
            }
        }
        return albums;

    }

    public List<String> queryAlbumsForArtist(String artistName, int sortOrder) throws SQLException {
        List<String> albums = new ArrayList<>();
        final String albumName=TAB_ALBUMS+"."+COL_ALBUM_NAME;
        final String aName=TAB_ARTISTS+"."+COL_ARTIST_NAME;
        final String albumArtist=TAB_ALBUMS+"."+COL_ALBUM_ARTIST;
        final String artistId=TAB_ARTISTS+"."+COL_ARTIST_ID;
        try (PreparedStatement statement = conn
                .prepareStatement("SELECT " + albumName + " FROM " + TAB_ALBUMS + " INNER JOIN " + TAB_ARTISTS + " ON " +
                        albumArtist+"="+artistId+" WHERE "+aName+"=? order by "+albumName+" ASC")) {
            statement.setString(1, artistName);
            try (ResultSet result = statement.executeQuery()) {
                while(result.next())
                {
                    albums.add(result.getString(COL_ALBUM_NAME));
                }
            }
        }

        return albums;
    }
}