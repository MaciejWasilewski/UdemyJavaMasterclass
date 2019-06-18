package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditContactController implements DialogController{
    @FXML
    private TextField fName;
    @FXML
    private TextField lName;
    @FXML
    private TextField phone;
    @FXML
    private TextField notes;
    private Contact contact;

    public void initializeTexts(Contact c)
    {
        fName.setText(c.getFirstName());
        lName.setText(c.getLastName());
        phone.setText(c.getPhoneNumber());
        notes.setText(c.getNotes());

    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public void processResults() {
        ContactData.getInstance().editContact(contact,fName.getText(), lName.getText(), phone.getText(), notes.getText());
    }
}
