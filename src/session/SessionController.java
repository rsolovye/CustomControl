package session;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import protocol.gamete.GameteSourcesController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import protocol.LabProtocolMainController;
import protocol.header.ProtocolHeaderController;
import protocol.puncture.FolliclePunctureController;

import java.util.HashMap;

/**
 * Created by micro on 18.03.2017.
 */
public class SessionController extends ControlledScreen{

        @FXML
    HBox sessionTopPane;
        @FXML
    AnchorPane mainPane;
        @FXML
    HBox sessionBottomPane;
   public HashMap<String, Node> views = new HashMap<>();
    @FXML
    Button testButton;
public SessionController () {
    loadFXML("session_view.fxml", this);
    mapScreens();

    mainPane.getChildren().add(views.get("LOGIN"));
    ((LogInController) views.get("LOGIN")).setSessionController(this);



    }
    public void goToProtocol(){
        mainPane.getChildren().remove(views.get("LOGIN"));

        mainPane.getChildren().add(views.get("LAB_PROTOCOL_MAIN"));

    }

    private void mapScreens(){
        views.put("LOGIN", new LogInController());

        views.put("LAB_PROTOCOL_MAIN", new LabProtocolMainController(this));

    }

    @FXML public void runTestButtonAction(){
        ((LabProtocolMainController)views.get("LAB_PROTOCOL_MAIN")).saveData();
    }
}

