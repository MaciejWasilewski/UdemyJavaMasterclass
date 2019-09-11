package com.example.mwasilewski;

import model.Artist;
import model.DataSource;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = DataSource.getInstance();

        dataSource.open();
        List<Artist> artists = null;
        try {
            artists = dataSource.queryArtists();
            System.out.println(artists);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!artists.isEmpty()) {
            try {
                System.out.println(dataSource.queryAlbumsFromArtist(artists.get(7)));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (true) {
            try {
                System.out.println(dataSource.queryAlbumsForArtist("Pink Ffloyd", 1));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            dataSource.querySongAlbumArtist("Go Your Own Way")
                    .forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(dataSource.getCount(DataSource.TAB_ARTISTS));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            dataSource.querySingInfoView("Go Your Own Way")
                    .forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dataSource.insertSong("Music", "Madonna", "Music", 1);

        dataSource.close();

        // write your code here
    }
}
