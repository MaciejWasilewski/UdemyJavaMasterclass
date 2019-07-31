package sample;

import javafx.concurrent.Worker;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

public class Controller {
    @FXML
    private Label pgLabel;
    @FXML
    private ProgressBar pgBar;


    private EmployeeService loadNamesService;
    @FXML
    private ListView<String> lView;

    public void initialize() {
        pgBar.setVisible(false);
        pgLabel.setVisible(false);
        loadNamesService = new EmployeeService();
        lView.itemsProperty().bind(loadNamesService.valueProperty());
        pgBar.progressProperty().bind(loadNamesService.progressProperty());
        pgLabel.textProperty().bind(loadNamesService.messageProperty());
//        loadNamesService.setOnRunning(event -> {
//            pgBar.setVisible(true);
//            pgLabel.setVisible(true);
//        });
//        loadNamesService.setOnSucceeded(event -> {
//            pgBar.setVisible(false);
//            pgLabel.setVisible(false);
//        });
        pgBar.visibleProperty().bind(loadNamesService.runningProperty());
        pgLabel.visibleProperty().bind(loadNamesService.runningProperty());
    }

    @FXML
    void buttonPressed() {
        if (loadNamesService.getState().equals(Worker.State.SUCCEEDED)) {
            loadNamesService.reset();
            loadNamesService.start();
        } else if (loadNamesService.getState().equals(Worker.State.READY)) {
            loadNamesService.start();
        }

    }

}
