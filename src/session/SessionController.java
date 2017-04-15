package session;

import impl.org.controlsfx.skin.BreadCrumbBarSkin;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javafx.fxml.FXML;
import javafx.scene.Node;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.tbee.javafx.scene.layout.MigPane;
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
    LabProtocolMainController labProtocolMainController = new LabProtocolMainController(this);




    MigPane stageClosePane = new MigPane("align 100% 0%");
    Button xCloseButton = new BreadCrumbBarSkin.BreadCrumbButton("x");
    stageClosePane.add(xCloseButton, "align 100% 0%");

    sessionBorderPane.setTop(stageClosePane);
    sessionBorderPane.setCenter(labProtocolMainController);
    sessionBorderPane.setLeft(new Rectangle(10, 400,Color.rgb(100, 100, 100, 0.0)));
    xCloseButton.setOnAction(event -> Platform.exit());
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

