package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.Artist;
import model.DataSource;

public class Controller {
    @FXML
    private TableView<Artist> artistTable;

    public void listArtists()
    {
        Task<ObservableList<Artist>> task=new GetAllArtistsTask();
        artistTable.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }


}


class GetAllArtistsTask extends Task<ObservableList<Artist>> {

    @Override
    protected ObservableList<Artist> call() throws Exception {
        return FXCollections.observableArrayList(DataSource.getInstance().queryArtists());
    }
}