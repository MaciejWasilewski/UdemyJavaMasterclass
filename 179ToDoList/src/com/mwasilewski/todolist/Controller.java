package com.mwasilewski.todolist;

import com.mwasilewski.todolist.datamodel.ToDoData;
import com.mwasilewski.todolist.datamodel.ToDoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Optional;

public class Controller {
    //private List<ToDoItem> todoItems;

    @FXML
    private ListView<ToDoItem> toDoListView;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private Label deadlineLabel;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private ContextMenu listItemContextMenu;

    public void initialize() {
        listItemContextMenu = new ContextMenu();
        MenuItem deleteItemMenu = new MenuItem("Delete");
        deleteItemMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ToDoItem item = toDoListView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });

        listItemContextMenu.getItems().addAll(deleteItemMenu);
        //todoItems = new ArrayList<>();
//        todoItems.add(new ToDoItem("Mail birthday card",
//                "Buy a 30th birthday card for John", LocalDate.of(2016, Month.APRIL, 25)));
//        todoItems.add(new ToDoItem("Doctor's appointment",
//                "See Dr. Smith", LocalDate.of(2017, Month.APRIL, 25)));
        //todoItems = ToDoData.getInstance().getToDoItems();
        //ToDoData.getInstance().setToDoItems(todoItems);
        SortedList<ToDoItem> sortedList=new SortedList<>(ToDoData.getInstance().getToDoItems(), Comparator.comparing(ToDoItem::getDeadline));
        toDoListView.setItems(sortedList);
//        populateToDoList(ToDoData.getInstance().getToDoItems());
        toDoListView
                .getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<ToDoItem>() {
                                 @Override
                                 public void changed(ObservableValue<? extends ToDoItem> observable, ToDoItem oldValue, ToDoItem newValue) {
                                     handleClickListView();
                                 }
                             }
                );

        toDoListView.getSelectionModel().selectFirst();
        toDoListView.setCellFactory(new Callback<>() {
            @Override
            public ListCell<ToDoItem> call(ListView<ToDoItem> param) {
                ListCell<ToDoItem> cell = new ListCell<>() {

                    @Override
                    protected void updateItem(ToDoItem item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setText(null);
                        } else {
                            setText(item.getShortDescription());
                            if (item.getDeadline().equals(LocalDate.now())) {
                                setTextFill(Color.RED);
                            }
                            if (item.getDeadline().isBefore(LocalDate.now().plusDays(7))
                                    && item.getDeadline().isAfter(LocalDate.now())) {
                                setTextFill(Color.ORANGE);
                            }
                        }
                    }
                };
                cell.emptyProperty().addListener(
                        (obs, wasEmpty, isNowEmpty) -> {
                            if (isNowEmpty) {
                                cell.setContextMenu(null);
                            } else {
                                cell.setContextMenu(listItemContextMenu);
                            }
                        }
                );
                return cell;
            }
        });

    }

    @FXML
    public void showNewItemDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add new Item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("toDoItemDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            System.out.println(controller);
            controller.processResults();
            //populateToDoList(ToDoData.getInstance().getToDoItems());
            System.out.println("OK pressed");
        } else {
            System.out.println("Cancel pressed");
        }
    }

//    private void populateToDoList(List<ToDoItem> todoItems) {
//        toDoListView
//                .getItems()
//                .setAll(todoItems);
//    }

    void handleClickListView() {
        descriptionArea.clear();
//        System.out.println("a");
        if (toDoListView.getSelectionModel().getSelectedIndices().size() != 0) {
            ToDoItem item = ToDoData.getInstance().getToDoItems().get(toDoListView.getSelectionModel().getSelectedIndices().get(0));
            descriptionArea.appendText(item.getDetails());
            deadlineLabel.setText(item.getDeadline().format(DateTimeFormatter.ofPattern("d-MMMM-y")));
        }
    }

    void deleteItem(ToDoItem item) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete ToDo Item");
        alert.setHeaderText("Delete item " + item.getShortDescription() + "?");
        alert.setContentText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            ToDoData.getInstance().deleteItem(item);
        }
    }

    public void handleListKeyPressed(KeyEvent keyEvent) {
        ToDoItem item=toDoListView.getSelectionModel().getSelectedItem();
        if(item!=null && keyEvent.getCode().equals(KeyCode.DELETE))
        {
            ToDoData.getInstance().deleteItem(item);
        }
    }
}
