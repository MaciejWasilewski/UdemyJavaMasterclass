package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 640));
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        ContactData data=ContactData.getInstance();
        data.loadContacts();
    }

    @Override
    public void stop() throws Exception {
        ContactData contactData=ContactData.getInstance();
        contactData.saveContacts();
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
