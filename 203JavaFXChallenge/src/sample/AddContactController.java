package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class AddContactController implements DialogController {
    @FXML
    private TextArea fName;
    @FXML
    private TextArea lName;
    @FXML
    private TextArea phone;
    @FXML
    private TextArea notes;

    @Override
    public void processResults() {
        ContactData.getInstance().addContact(new Contact(fName.getText(),lName.getText(), phone.getText(),notes.getText()));
    }
}
