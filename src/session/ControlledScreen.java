package session;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import services.DataMapper;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by micro on 19.03.2017.
 */
public class ControlledScreen extends Pane {
    public HashMap<String, String> dataMap = new HashMap<>();

    public void loadFXML(String fxmlName, Node pane){
        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(getClass().getResource(fxmlName));
        fxmlLoader.setRoot(pane);
        fxmlLoader.setController(pane);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }








}
