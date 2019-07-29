package sample;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class Controller {
    private Task<ObservableList<String>> task;

    @FXML
    private ListView lView;

    public void initialize() {
        task = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                Thread.sleep(1000);
                ObservableList<String> employees=FXCollections.observableArrayList(
                        "Tim",
                        "Bill",
                        "Jack",
                        "Mary",
                        "Maciek");
                                return employees;
            }
        };
        lView.itemsProperty().bind(task.valueProperty());

    }

    @FXML
    void buttonPressed() {
        new Thread(task).start();
    }
}
