package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import model.Album;
import model.Artist;
import model.DataSource;

import java.sql.SQLException;

public class Controller {
    @FXML
    private ProgressBar progBar;

    @FXML
    private TableView artistTable;

    @FXML
    void showAlbums() {
        int i = 0;
        try {
            if (!artistTable.getSelectionModel().isEmpty()) {

                i = ((Artist) artistTable.getSelectionModel().getSelectedItem()).getId().get();
                bindAlbumsAndRefresh(i);
            } else {
                System.out.println("No artist is selected!");
            }

        } catch (Exception e) {
            System.out.println("Couldn't show albums for artist " + i);
            e.printStackTrace();
        }
    }

    public void bindArtistAndRefresh() {
        Task<ObservableList<Artist>> task = new GetAllArtistsTask();
        artistTable.itemsProperty().bind(task.valueProperty());
        progBar.progressProperty().bind(task.progressProperty());
        progBar.setVisible(true);
        task.setOnSucceeded(e->progBar.setVisible(false));
        task.setOnFailed(e->progBar.setVisible(false));
        new Thread(task).start();
    }

    public void bindAlbumsAndRefresh(int artistID) {
        Task<ObservableList<Album>> task = new GetAlbumFromArtistTask(artistID);
        new Thread(task).start();
        artistTable.itemsProperty().bind(task.valueProperty());

    }

@FXML
    void showArtists() {

        bindArtistAndRefresh();
    }

}

class GetAlbumFromArtistTask extends Task<ObservableList<Album>> {
    private int idArtist;

    public GetAlbumFromArtistTask(int id) {
        idArtist = id;
    }

    @Override
    protected ObservableList<Album> call() throws Exception {
        ObservableList<Album> a=FXCollections
                .observableArrayList(DataSource
                        .getInstance()
                        .queryAlbumsFromArtist(idArtist));
        a.forEach(System.out::println);
        return a;
    }
}


class GetAllArtistsTask extends Task<ObservableList<Artist>> {

    @Override
    protected ObservableList<Artist> call() throws Exception {
        return FXCollections.observableArrayList(DataSource.getInstance().queryArtists());
    }
}