package model;

import javafx.beans.property.SimpleStringProperty;

public class Album {
    private int id;
    private SimpleStringProperty name;
    private int artistId;

    public Album(int id, String name, int artistId) {
        this.id = id;
        this.name = new SimpleStringProperty(name);
        this.artistId = artistId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    @Override
    public String toString() {
        return name.get();
    }
}
