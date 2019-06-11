package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField nameField;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private CheckBox checkBox1;
    @FXML
    private Label ourLabel;
    @FXML
    void onButtonClicked(ActionEvent e) {
        if (e.getSource().equals(button1)) {
            System.out.println("Hello1! " + nameField.getText());
        } else if (e.getSource().equals(button2)) {
            System.out.println("Hello2! " + nameField.getText());

        }
        Runnable task=new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            ourLabel.setText("We did something!");
                        }
                    });

                } catch (InterruptedException event){
                    System.out.println(event.toString());
                }
            }
        };
        new Thread(task).start();
        if(checkBox1.isSelected())
        {
            nameField.clear();
            handleKeyReleased();
        }
    }

    @FXML
    void handleKeyReleased() {
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        button1.setDisable(disableButtons);
        button2.setDisable(disableButtons);
    }
}