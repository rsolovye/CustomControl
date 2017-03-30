package cust;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by bobsol on 16.03.17.
 */
public class MenuBox extends VBox {

    @FXML ProtocolHeader protocolHeaderBox;
    @FXML SplitPane left;
    public MenuBox(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "menu_box.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

}
