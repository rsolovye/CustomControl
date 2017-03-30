package cust;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by bobsol on 16.03.17.
 */
public class ProtocolHeader extends VBox {

    @FXML TextField femaleNameTextField;

    public ProtocolHeader() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "protocol_header.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setFemaleName(String femaleName){
        femaleNameTextField.setText(femaleName);
    }
}
