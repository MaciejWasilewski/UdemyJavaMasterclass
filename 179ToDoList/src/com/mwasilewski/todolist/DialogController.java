package com.mwasilewski.todolist;

import com.mwasilewski.todolist.datamodel.ToDoData;
import com.mwasilewski.todolist.datamodel.ToDoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {
    @FXML
    TextField shortDesc;
    @FXML
    TextArea details;
    @FXML
    DatePicker deadlinePicker;

    public void processResults()
    {
        String shortDescription=shortDesc.getText();
        String detailsText=details.getText();
        LocalDate deadline=deadlinePicker.getValue();

        ToDoData.getInstance().addToDoItem(new ToDoItem(shortDescription,detailsText,deadline));
        System.out.println(ToDoData.getInstance().getToDoItems().toString());
    }
}
