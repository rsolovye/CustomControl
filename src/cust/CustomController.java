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
public class CustomController extends VBox {

    @FXML
    private TextField textField;

    @FXML ProtocolHeader protocolHeaderBox;

    public CustomController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "custom_control.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


    public String getText() {
        return textProperty().get();
    }

    public void setText(String value) {
        textProperty().set(value);
    }
    public void setProtocolHeaderBoxFemaleName(String s) {
        protocolHeaderBox.setFemaleName(s);
    }

    public StringProperty textProperty() {
        return textField.textProperty();
    }

    @FXML
    protected void doSomething() {
        System.out.println("The button was clicked! setting femaleNameTextField to the textField value");
        setProtocolHeaderBoxFemaleName(getText());
    }
}
