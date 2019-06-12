package com.mwasilewski.todolist;

import com.mwasilewski.todolist.datamodel.ToDoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {
    private List<ToDoItem> todoItems;

    @FXML
    private ListView<String> toDoListView;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private Label deadlineLabel;

    public void initialize() {
        todoItems = new ArrayList<>();
        todoItems.add(new ToDoItem("Mail birthday card",
                "Buy a 30th birthday card for John", LocalDate.of(2016, Month.APRIL, 25)));
        todoItems.add(new ToDoItem("Doctor's appointment",
                "See Dr. Smith", LocalDate.of(2017, Month.APRIL, 25)));
        populateToDoList();
        toDoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.print("b");
                handleClickListView();
            }
        });
        toDoListView.getSelectionModel().selectFirst();

    }

    private void populateToDoList() {
        toDoListView.getItems().setAll(todoItems.stream().map(ToDoItem::getShortDescription).collect(Collectors.toList()));
    }

    public void handleClickListView() {
        descriptionArea.clear();
        System.out.println("a");
        if (toDoListView.getSelectionModel().getSelectedIndices().size() != 0) {
            ToDoItem item = todoItems.get(toDoListView.getSelectionModel().getSelectedIndices().get(0));
            StringBuilder builder=new StringBuilder();
            builder.append(item.getDetails());
            descriptionArea.appendText(builder.toString());
            deadlineLabel.setText(item.getDeadline().format(DateTimeFormatter.ofPattern("d-MMMM-y")));
        }
    }
}
