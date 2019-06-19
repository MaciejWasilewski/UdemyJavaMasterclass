package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class Controller {
    @FXML
    private VBox mainScene;
    @FXML
    private TableView<Contact> tableViewContacts;
    @FXML
    private ContextMenu itemContextMenu;

    public void initialize() {
        ContactData data = ContactData.getInstance();

        ContextMenu itemContextMenu = new ContextMenu(new CheckMenuItem("Edit..."));
        itemContextMenu.getItems().get(0).setOnAction(event -> handleEditContact());
        itemContextMenu.getItems().add(new CheckMenuItem("Delete..."));
        itemContextMenu.getItems().get(1).setOnAction(event -> handleDeleteContact());
        tableViewContacts.setContextMenu(itemContextMenu);

        TableColumn<Contact, String> colfName = new TableColumn<>("First Name");
        TableColumn<Contact, String> collName = new TableColumn<>("Last Name");
        TableColumn<Contact, String> colPhone = new TableColumn<>("Phone Number");
        TableColumn<Contact, String> colNotes = new TableColumn<>("Notes");
        ArrayList<TableColumn<Contact, String>> columns = new ArrayList<>();

        columns.add(colfName);
        columns.add(collName);
        columns.add(colPhone);
        columns.add(colNotes);

        colfName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getFirstName()));
        collName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getLastName()));
        colPhone.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getPhoneNumber()));
        colNotes.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getNotes()));
        tableViewContacts.getColumns().setAll(columns);


//        ObservableList<Contact> dataList = FXCollections.observableArrayList(
//                new Contact("a", "b", "c", "d"));
//        data.setContacts(dataList);
        ObservableList<Contact> dataList = data.getContacts();


        tableViewContacts.setItems(dataList);

    }

    private void handleDeleteContact() {
        Contact c=tableViewContacts.getSelectionModel().getSelectedItem();
        if(c!=null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Contact");
            alert.setHeaderText("Delete contact " + c.getFirstName()+" "+c.getLastName() + "?");
            alert.setContentText("Are you sure?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                deleteContact(c);
            }

        }

    }

    void addContact(String fname, String lName, String phone, String notes) {
        tableViewContacts.getItems().add(new Contact(fname, lName, phone, notes));
    }

    void deleteContact(Contact e) {
        if(!tableViewContacts.getItems().remove(e))
        {
            System.out.println("Could not remove contact, because it is not in the table list.");
        }
    }


    public void handleNewContact(ActionEvent actionEvent) {
        AddContactController controller = new AddContactController();
        Dialog<ButtonType> dialog = buildDialogWindow(controller, "New contact", "addContact.fxml");
        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            //AddContactController controller=fxmlLoader.getController();
            controller.processResults();
        }

    }

    private Dialog<ButtonType> buildDialogWindow(DialogController controller, String title, String fxmlPath) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainScene.getScene().getWindow());
        dialog.setTitle(title);
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(fxmlPath));
        fxmlLoader.setController(controller);
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Could not load dialog.");
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        return dialog;

    }

    void handleEditContact() {
        EditContactController controller = new EditContactController();
        Dialog<ButtonType> dialog = buildDialogWindow(controller, "Edit contact", "addContact.fxml");
        controller.initializeTexts(tableViewContacts.getSelectionModel().getSelectedItem());

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            //AddContactController controller=fxmlLoader.getController();
            Contact c = tableViewContacts.getSelectionModel().getSelectedItem();
            if (c != null) {
                controller.setContact(c);
                controller.processResults();
                tableViewContacts.refresh();
            }
        }
//            System.out.println("prawy przycisk "
//                    +tableViewContacts.getSelectionModel().getSelectedItem().getFirstName());
    }
}
