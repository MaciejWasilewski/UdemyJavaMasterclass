package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    public Button clickMe;

    public void initialize() {
        clickMe.addEventFilter(MouseEvent.MOUSE_CLICKED,
                        (event)-> System.out.println("I have been clicked!"));
        clickMe.addEventFilter(MouseEvent.MOUSE_ENTERED,
                (event)-> System.out.println("I have been entered!"));
//        clickMe.addEventFilter(MouseEvent.MOUSE_MOVED,
//                (event)-> System.out.println("Mouse moved above me!"));

    }
}
