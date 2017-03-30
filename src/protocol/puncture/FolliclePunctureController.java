package protocol.puncture;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import session.ControlledScreen;

/**
 * Created by bobsol on 29.03.17.
 */
public class FolliclePunctureController extends ControlledScreen {

    public FolliclePunctureController(){
        loadFXML("follicle_puncture.fxml", this);
        System.out.println(getClass().getSimpleName() + " loaded");
    }
}
