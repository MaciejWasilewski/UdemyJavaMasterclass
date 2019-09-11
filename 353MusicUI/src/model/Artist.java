package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Artist {
    private SimpleStringProperty name;
    private SimpleIntegerProperty id;

    public Artist(SimpleStringProperty name, SimpleIntegerProperty id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name.get();
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public SimpleIntegerProperty getId() {
        return id;
    }

    public void setId(SimpleIntegerProperty id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name.get();
    }
}
