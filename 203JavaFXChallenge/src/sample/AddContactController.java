package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddContactController implements DialogController {
    @FXML
    private TextField fName;
    @FXML
    private TextField lName;
    @FXML
    private TextField phone;
    @FXML
    private TextField notes;

    @Override
    public void processResults() {
        ContactData.getInstance().addContact(new Contact(fName.getText(),lName.getText(), phone.getText(),notes.getText()));
    }
}
