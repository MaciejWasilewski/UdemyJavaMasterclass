package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

public class Controller {
    @FXML
    private WebView webView;
    @FXML
    GridPane gridPane;
    @FXML
    private Label labelMainWindow;
    @FXML
    private Button button4;
    @FXML
    private Button buttonOpen;

    public void initialize() {
        button4.setEffect(new DropShadow());
        buttonOpen.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> handleButtonOpenClick());
    }

    public void handleMouseEnterLabel(MouseEvent mouseEvent) {
        labelMainWindow.setScaleY(2.0);
        labelMainWindow.setScaleX(2.0);
    }

    public void handleMouseExitLabel(MouseEvent mouseEvent) {
        labelMainWindow.setScaleY(1.0);
        labelMainWindow.setScaleX(1.0);
    }

    public void handleButtonOpenClick() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save application file");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"));
        //File file=();
        Optional<File> file = Optional.ofNullable(chooser.showSaveDialog(gridPane.getScene().getWindow()));
        file.ifPresentOrElse(f -> System.out.println(f.getAbsolutePath()), () -> System.out.println("No path!"));
    }

    @FXML
    private void handleLinkClicked() {
//        try {
//            Desktop.getDesktop().browse(new URI("https://www.javafx.com"));
//
//
//        } catch (IOException | URISyntaxException e) {
//            e.printStackTrace();
//        }
        webView.getEngine().load("https://www.onet.pl");
    }
}
