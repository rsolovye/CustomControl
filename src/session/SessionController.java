package session;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javafx.fxml.FXML;
import javafx.scene.Node;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import protocol.LabProtocolMainController;


import java.io.IOException;
import java.util.HashMap;


public class SessionController extends BorderPane{

   public HashMap<String, Node> views = new HashMap<>();

    HBox sessionTopBox;
    @FXML
        BorderPane sessionBorderPane;

    HBox sessionBottomBox;

    Button testButton;

public SessionController () {
    loadFXML("session_view.fxml", this);
    mapScreens();
    sessionBorderPane.setCenter(new LabProtocolMainController(this));
  //  sessionBorderPane.setCenter();
  //  ((LogInController) views.get("LOGIN")).setSessionController(this);



    }

    public void loadFXML(String fxmlName, Node pane) {
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


    public void goToProtocol(){
        sessionBorderPane.getChildren().remove(views.get("LOGIN"));
        sessionBorderPane.getChildren().add(views.get("LAB_PROTOCOL_MAIN"));

    }

    private void mapScreens(){
        views.put("LOGIN", new LogInController());

        views.put("LAB_PROTOCOL_MAIN", new LabProtocolMainController(this));

    }

    @FXML public void runTestButtonAction(){
        ((LabProtocolMainController)views.get("LAB_PROTOCOL_MAIN")).saveData();
    }
}

