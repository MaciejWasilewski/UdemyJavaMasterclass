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

    public static final String PS_QUERY_ARTIST_FOR_SONG =
            "select " + TAB_SONGS + "." + COL_SONG_TRACK + ", " + TAB_ALBUMS + "." + COL_ALBUM_NAME + ", "
                    + TAB_ARTISTS + "." + COL_ARTIST_NAME +
                    " FROM " + TAB_SONGS +
                    " INNER JOIN " + TAB_ALBUMS + " on " + TAB_SONGS + "." + COL_SONG_ALBUM + " = " + TAB_ALBUMS +
                    "." + COL_ALBUM_ID +
                    " inner join " + TAB_ARTISTS + " on " + TAB_ALBUMS + "." + COL_ALBUM_ARTIST + " = " + TAB_ARTISTS +
                    "." + COL_ARTIST_ID +
                    " where " + TAB_SONGS + "." + COL_SONG_TITLE + " = ? order by " + TAB_ARTISTS + "." + COL_ARTIST_NAME + ", " +
                    TAB_ALBUMS + "." + COL_ALBUM_NAME + ", " + TAB_SONGS + "." + COL_SONG_TRACK + " COLLATE NOCASE ASC";

    public static final String TAB_ARTIST_SONG_VIEW = "artist_list";
    public static final String CREATE_VIEW = "CREATE VIEW  if not exists artist_list as " +
            "select artists.name as artist, albums.name as album, songs.track as track, songs.title as song from " +
            "songs " +
            "inner join albums on songs.album=albums._id " +
            "inner join artists on albums.artist=artists._id " +
            "order by artist, album, track;";

    public static final String QUERY_VIEW_SONG_INFO = "select artist, album, track " +
            "from artist_list " +
            "where song = ? " +
            "order by artist,album, track asc";
    public static final String INSERT_ARTIST="insert into "+TAB_ALBUMS+" ("+COL_ARTIST_NAME+") values(?)";
    public static final String INSERT_ALBUM="insert into "+TAB_ARTISTS+" ("+COL_ALBUM_NAME+","+COL_ALBUM_ARTIST+") " +
            "values" +
            "(?,?)";
    public static final String INSERT_SONG=
            "insert into "+TAB_SONGS+" ("+COL_SONG_TRACK+","+COL_SONG_TITLE+","+COL_SONG_ALBUM+") values(?,?,?)";
    public static final String QUERY="select %s from %s where %s=?";
    public static final String QUERY_ALBUM_ID= String.format(QUERY, COL_ALBUM_ID, TAB_ALBUMS,COL_ALBUM_NAME);
    public static final String QUERY_ARTIST_ID= String.format(QUERY, COL_ARTIST_ID, TAB_ARTISTS,COL_ARTIST_NAME);
    //private static PreparedStatement selectStatement;
    private Connection conn;
    private PreparedStatement insertArtist;
    private PreparedStatement insertAlbum;
    private PreparedStatement insertSong;
    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;

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
            insertArtist=conn.prepareStatement(INSERT_ARTIST,Statement.RETURN_GENERATED_KEYS);
            insertAlbum=conn.prepareStatement(INSERT_ALBUM,Statement.RETURN_GENERATED_KEYS);
            insertSong=conn.prepareStatement(INSERT_SONG);
            queryAlbum=conn.prepareStatement(QUERY_ALBUM_ID);
            queryArtist=conn.prepareStatement(QUERY_ARTIST_ID);

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
                insertSong.close();
                insertAlbum.close();
                insertArtist.close();
                queryAlbum.close();
                queryArtist.close();
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
        final String albumName = TAB_ALBUMS + "." + COL_ALBUM_NAME;
        final String aName = TAB_ARTISTS + "." + COL_ARTIST_NAME;
        final String albumArtist = TAB_ALBUMS + "." + COL_ALBUM_ARTIST;
        final String artistId = TAB_ARTISTS + "." + COL_ARTIST_ID;
        try (PreparedStatement statement = conn
                .prepareStatement("SELECT " + albumName + " FROM " + TAB_ALBUMS + " INNER JOIN " + TAB_ARTISTS + " ON " +
                        albumArtist + "=" + artistId + " WHERE " + aName + "=? order by " + albumName + " ASC")) {
            statement.setString(1, artistName);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    albums.add(result.getString(COL_ALBUM_NAME));
                }
            }
        }


        return albums;
    }

    public List<SongArtist> querySongAlbumArtist(String title) throws SQLException {
        List<SongArtist> out = new ArrayList<>();
        try (PreparedStatement statement = conn.prepareStatement(PS_QUERY_ARTIST_FOR_SONG)) {
            statement.setString(1, title);
            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    out.add(new SongArtist(results.getString(3),
                            results.getString(2),
                            results.getInt(1)));
                }
            }
        }
        return out;


    }

    public List<SongArtist> querySingInfoView(String title) throws SQLException {
        List<SongArtist> out = new ArrayList<>();
        try (PreparedStatement statement = conn.prepareStatement(QUERY_VIEW_SONG_INFO)) {
            statement.setString(1, title);
            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    out.add(new SongArtist(results.getString("artist"),
                            results.getString("album"),
                            results.getInt("track")));
                }
            }
        }
        return out;


    }

    public int getCount(String table) throws SQLException {

        try (Statement statement = conn.createStatement();
             ResultSet result = statement.executeQuery("select count(*) from " + table)) {

            return result.getInt(1);
        }

    }


}