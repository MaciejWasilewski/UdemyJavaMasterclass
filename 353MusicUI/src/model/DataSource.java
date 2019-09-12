package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

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
            "select " + TAB_SONGS + "." + COL_SONG_TRACK + ", " + TAB_ALBUMS + "." + COL_ALBUM_NAME + ", " + TAB_ARTISTS + "." + COL_ARTIST_NAME + " FROM " + TAB_SONGS + " INNER JOIN " + TAB_ALBUMS + " on " + TAB_SONGS + "." + COL_SONG_ALBUM + " = " + TAB_ALBUMS + "." + COL_ALBUM_ID + " inner join " + TAB_ARTISTS + " on " + TAB_ALBUMS + "." + COL_ALBUM_ARTIST + " = " + TAB_ARTISTS + "." + COL_ARTIST_ID + " where " + TAB_SONGS + "." + COL_SONG_TITLE + " = ? order by " + TAB_ARTISTS + "." + COL_ARTIST_NAME + ", " + TAB_ALBUMS + "." + COL_ALBUM_NAME + ", " + TAB_SONGS + "." + COL_SONG_TRACK + " COLLATE NOCASE ASC";

    public static final String TAB_ARTIST_SONG_VIEW = "artist_list";
    public static final String CREATE_VIEW =
            "CREATE VIEW  if not exists artist_list as " + "select artists.name as " + "artist, albums.name as album,"
                    + " songs.track as track, songs.title as song from " + "songs " + "inner join " + "albums on " +
                    "songs" + ".album=albums._id " + "inner join artists on albums.artist=artists._id " + "order by " + "artist, album, track;";

    public static final String QUERY_VIEW_SONG_INFO =
            "select artist, album, track " + "from artist_list " + "where " + "song = ? " + "order by artist,album, " + "track asc";
    public static final String INSERT_ARTIST = "insert into " + TAB_ALBUMS + " (" + COL_ARTIST_NAME + ") values(?)";
    public static final String INSERT_ALBUM =
            "insert into " + TAB_ALBUMS + " (" + COL_ALBUM_NAME + "," + COL_ALBUM_ARTIST + ") " + "values" + "(?,?)";
    public static final String INSERT_SONG =
            "insert into " + TAB_SONGS + " (" + COL_SONG_TRACK + "," + COL_SONG_TITLE + "," + COL_SONG_ALBUM + ") " + "values(?,?,?)";
    public static final String QUERY = "select %s from %s where %s=?";
    public static final String QUERY_ALBUM_ID = String.format(QUERY, COL_ALBUM_ID, TAB_ALBUMS, COL_ALBUM_NAME);
    public static final String QUERY_ARTIST_ID = String.format(QUERY, COL_ARTIST_ID, TAB_ARTISTS, COL_ARTIST_NAME);
    //private static PreparedStatement selectStatement;
    private Connection conn;
    private PreparedStatement statInsertArtist;
    private PreparedStatement statInsertAlbum;
    private PreparedStatement statInsertSong;
    private PreparedStatement statQueryArtist;
    private PreparedStatement statQueryAlbum;
    private PreparedStatement statQueryAlbumByArtistId;

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
            statInsertArtist = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            statInsertAlbum = conn.prepareStatement(INSERT_ALBUM, Statement.RETURN_GENERATED_KEYS);
            statInsertSong = conn.prepareStatement(INSERT_SONG);
            statQueryAlbum = conn.prepareStatement(QUERY_ALBUM_ID);
            statQueryArtist = conn.prepareStatement(QUERY_ARTIST_ID);
            statQueryAlbumByArtistId = conn.prepareStatement("SELECT * FROM " + TAB_ALBUMS + " where albums.artist=? "
                    + "ORDER BY " + COL_ALBUM_NAME + " ASC");

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
                statInsertSong.close();
                statInsertAlbum.close();
                statInsertArtist.close();
                statQueryAlbum.close();
                statQueryArtist.close();
                statQueryAlbumByArtistId.close();
            } catch (SQLException e) {
                System.out.println("Could not close connection.\n" + e.getMessage());
            }
        }
    }

    public List<Artist> queryArtists() throws SQLException {
        List<Artist> artists = new ArrayList<>();
        try (PreparedStatement statement =
                     conn.prepareStatement("SELECT * FROM " + TAB_ARTISTS + " ORDER BY name " + "ASC"); ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                artists.add(new Artist(new SimpleStringProperty(results.getString(COL_ARTIST_NAME)),
                        new SimpleIntegerProperty(results.getInt(COL_ARTIST_ID))));
            }
            return artists;
        }
    }

    public List<Album> queryAlbumsFromArtist(int idArtist) throws SQLException, InterruptedException {
        List<Album> albums = new ArrayList<>();

        statQueryAlbumByArtistId.setInt(1, idArtist);
        try (ResultSet results = statQueryAlbumByArtistId.executeQuery()) {
            while (results.next()) {
                Thread.sleep(1000);
                albums.add(new Album(results.getInt(COL_ALBUM_ID), results.getString(COL_ALBUM_NAME),
                        results.getInt(COL_ALBUM_ARTIST)));
            }
        }
        //        System.out.println(albums);
        return albums;
    }

    public List<Album> queryAlbumsFromArtist(Artist a) throws SQLException {

        List<Album> albums = new ArrayList<>();
        try (PreparedStatement statement =
                     conn.prepareStatement("SELECT * FROM " + TAB_ALBUMS + " where " + COL_ALBUM_ARTIST + "=?" +
                             "ORDER BY " + COL_ALBUM_NAME + " ASC")) {
            statement.setInt(1, a.getId().get());
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
        try (PreparedStatement statement =
                     conn.prepareStatement("SELECT " + albumName + " FROM " + TAB_ALBUMS + " " + "INNER JOIN " + TAB_ARTISTS + " ON " + albumArtist + "=" + artistId + " WHERE " + aName + "=? order " + "by " + albumName + " ASC")) {
            statement.setString(1, artistName);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    albums.add(result.getString(COL_ALBUM_NAME));
                }
            }
        }


        return albums;
    }

    //    public List<SongArtist> querySongAlbumArtist(String title) throws SQLException {
    //        List<SongArtist> out = new ArrayList<>();
    //        try (PreparedStatement statement = conn.prepareStatement(PS_QUERY_ARTIST_FOR_SONG)) {
    //            statement.setString(1, title);
    //            try (ResultSet results = statement.executeQuery()) {
    //                while (results.next()) {
    //                    out.add(new SongArtist(results.getString(3),
    //                            results.getString(2),
    //                            results.getInt(1)));
    //                }
    //            }
    //        }
    //        return out;
    //
    //
    //    }
    //
    //    public List<SongArtist> querySingInfoView(String title) throws SQLException {
    //        List<SongArtist> out = new ArrayList<>();
    //        try (PreparedStatement statement = conn.prepareStatement(QUERY_VIEW_SONG_INFO)) {
    //            statement.setString(1, title);
    //            try (ResultSet results = statement.executeQuery()) {
    //                while (results.next()) {
    //                    out.add(new SongArtist(results.getString("artist"),
    //                            results.getString("album"),
    //                            results.getInt("track")));
    //                }
    //            }
    //        }
    //        return out;
    //
    //
    //    }

    public int getCount(String table) throws SQLException {

        try (Statement statement = conn.createStatement(); ResultSet result = statement.executeQuery("select count(*)"
                + " from " + table)) {

            return result.getInt(1);
        }
    }

    private int insertArtist(String name) throws SQLException {
        int idQuery = queryIdByName(statQueryArtist, name);
        if (idQuery != -1) {
            return idQuery;
        }
        //        statQueryArtist.setString(1, name);
        //        ResultSet resultSet = statQueryArtist.executeQuery();
        //        if (resultSet.next()) {
        //            return resultSet.getInt(1);
        //
        //        }
        statInsertArtist.setString(1, name);
        int affectedRows = statInsertArtist.executeUpdate();
        if (affectedRows != 1) {
            throw new SQLException("Error when inserting artist into the database.");
        }
        ResultSet results = statInsertArtist.getGeneratedKeys();
        if (results.next()) {
            return results.getInt(1);
        }
        throw new SQLException("Error when getting _id of the new artist.");
    }

    private int insertAlbum(String name, int artistID) throws SQLException {
        int idQuery = queryIdByName(statQueryAlbum, name);
        if (idQuery != -1) {
            return idQuery;
        }
        //        statQueryAlbum.setString(1, name);
        //        ResultSet resultSet = statQueryAlbum.executeQuery();
        //        if (resultSet.next()) {
        //            return resultSet.getInt(1);
        //        }
        statInsertAlbum.setString(1, name);
        statInsertAlbum.setInt(2, artistID);
        int affectedRows = statInsertAlbum.executeUpdate();
        if (affectedRows != 1) {
            throw new SQLException("Error when inserting album into the database.");
        }
        ResultSet results = statInsertAlbum.getGeneratedKeys();
        if (results.next()) {
            return results.getInt(1);
        }
        throw new SQLException("Error when getting _id of the new album.");
    }

    public void insertSong(String title, String artist, String album, int track) {
        try {
            conn.setAutoCommit(false);
            int artistId = insertArtist(artist);
            int albumId = insertAlbum(album, artistId);
            statInsertSong.setInt(1, track);
            statInsertSong.setString(2, title);
            statInsertSong.setInt(3, albumId);
            int affectedRows = statInsertSong.executeUpdate();

            if (affectedRows == 1) {
                conn.commit();
            } else {
                throw new SQLException("The song insert failed!");
            }
        } catch (Exception e) {
            System.out.println("Insert song exception: " + e.getMessage());
            try {
                System.out.println("Performing rollback");
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println("Error when performing rollback!" + e2.getMessage());
            }
        } finally {
            System.out.println("Resetting conn to autocommit");
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private int queryIdByName(PreparedStatement statement, String name) throws SQLException {

        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else return -1;
    }
}