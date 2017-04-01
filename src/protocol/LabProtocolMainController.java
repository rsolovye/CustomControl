package protocol;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import protocol.fertilization.Fertilization;
import protocol.gamete.AltGametesController;
import protocol.gamete.GameteSourcesController;
import protocol.header.ProtocolHeaderController;
import protocol.media.MediaFooter;
import protocol.pgd.PGD;
import protocol.precultivation.Precultivation;
import protocol.puncture.FolliclePunctureController;
import protocol.signatures.CheckPoints;
import protocol.spermiogram.Spermiogram;
import session.ControlledScreen;
import session.SessionController;

/**
 * Created by bobsol on 29.03.17.
 */
public class LabProtocolMainController extends ControlledScreen {
    @FXML
    VBox labProtocolMainBox;
    SessionController sessionController;

    private final ProtocolHeaderController PROTOCOL_HEADER = new ProtocolHeaderController();
    //private final ControlledScreen GAMETE_SOURCES = new GameteSourcesController();
    private final ControlledScreen ALT_GAMETES = new AltGametesController();
    private final ControlledScreen  FOLLICLE_PUNCTURE = new FolliclePunctureController();
    private final ControlledScreen PRECULTIVATION = new Precultivation();
    private final ControlledScreen FERTILIZATION = new Fertilization();
    private final ControlledScreen PGD_INFO = new PGD();
    private final ControlledScreen CHECK_POINTS = new CheckPoints();
    private final ControlledScreen SPERMIOGRAM = new Spermiogram();
    private final ControlledScreen MEDIA_FOOTER = new MediaFooter();

   // private ObservableList<TextField> protocol_header_controls = PROTOCOL_HEADER.getObservableTextFields();

    public LabProtocolMainController(SessionController sessionController) {
        loadFXML("lab_protocol_main.fxml", this);
        this.sessionController = sessionController;

        labProtocolMainBox.getChildren().add(PROTOCOL_HEADER);


      ///  labProtocolMainBox.getChildren().add(GAMETE_SOURCES);

    labProtocolMainBox.getChildren().add(ALT_GAMETES);


//        HBox puncture_pgd_box = new HBox();
//        puncture_pgd_box.getChildren().addAll(FOLLICLE_PUNCTURE, PGD_INFO);
//        labProtocolMainBox.getChildren().add(puncture_pgd_box);
//
//        HBox fertilization_precultivation = new HBox();
//        fertilization_precultivation.getChildren().addAll(FERTILIZATION, PRECULTIVATION);
//        labProtocolMainBox.getChildren().add(fertilization_precultivation);
//
//        labProtocolMainBox.getChildren().add(CHECK_POINTS);
//        labProtocolMainBox.getChildren().add(SPERMIOGRAM);
//        labProtocolMainBox.getChildren().add(MEDIA_FOOTER);
        labProtocolMainBox.getChildren().add(testGridRowCombo());
    }

    public void saveData(){
       PROTOCOL_HEADER.passDataToMapper();
    }

public Node testGridRowCombo(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5));
      // grid.setHgap(10);
    //    grid.setVgap(20);
        grid.setAlignment((Pos.BASELINE_CENTER));

    TextField textField = new TextField();
    textField.setPrefHeight(15.0);
    textField.setPrefWidth(80);

    Label typeLabel1 = new Label("Тип");
    typeLabel1.setPrefHeight(12);
    typeLabel1.setPrefWidth(textField.getPrefWidth());
    typeLabel1.setAlignment(Pos.CENTER);
    typeLabel1.setFont(Font.font ("Georgia", FontWeight.BOLD,11.0));




    grid.add(typeLabel1,1,1);
    grid.add(textField,1,2);

    return grid;
    }

}
