package protocol;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import protocol.fertilization.Fertilization;
import protocol.gamete.GameteSourcesController;
import protocol.header.ProtocolHeaderController;
import protocol.media.MediaFooter;
import protocol.pgd.PGD;
import protocol.precultivation.Precultivation;
import protocol.puncture.FolliclePunctureController;
import protocol.signatures.CheckPoints;
import protocol.spermiogram.Spermiogram;
import services.Mappable;
import session.ControlledScreen;
import session.SessionController;

import java.util.HashMap;

/**
 * Created by bobsol on 29.03.17.
 */
public class LabProtocolMainController extends ControlledScreen {
    @FXML
    VBox labProtocolMainBox;
    SessionController sessionController;

    private final ProtocolHeaderController PROTOCOL_HEADER = new ProtocolHeaderController();
    private final ControlledScreen GAMETE_SOURCES = new GameteSourcesController();
    private final ControlledScreen  FOLLICLE_PUNCTURE = new FolliclePunctureController();
    private final ControlledScreen PRECULTIVATION = new Precultivation();
    private final ControlledScreen FERTILIZATION = new Fertilization();
    private final ControlledScreen PGD_INFO = new PGD();
    private final ControlledScreen CHECK_POINTS = new CheckPoints();
    private final ControlledScreen SPERMIOGRAM = new Spermiogram();
    private final ControlledScreen MEDIA_FOOTER = new MediaFooter();

    public LabProtocolMainController(SessionController sessionController) {
        loadFXML("lab_protocol_main.fxml", this);
        this.sessionController = sessionController;

        labProtocolMainBox.getChildren().add(PROTOCOL_HEADER);
        labProtocolMainBox.getChildren().add(GAMETE_SOURCES);
        HBox puncture_pgd_box = new HBox();
        puncture_pgd_box.getChildren().addAll(FOLLICLE_PUNCTURE, PGD_INFO);
        labProtocolMainBox.getChildren().add(puncture_pgd_box);

        HBox fertilization_precultivation = new HBox();
        fertilization_precultivation.getChildren().addAll(FERTILIZATION, PRECULTIVATION);
        labProtocolMainBox.getChildren().add(fertilization_precultivation);

        labProtocolMainBox.getChildren().add(CHECK_POINTS);
        labProtocolMainBox.getChildren().add(SPERMIOGRAM);
        labProtocolMainBox.getChildren().add(MEDIA_FOOTER);

    }

    public void saveData(){
       PROTOCOL_HEADER.passDataToMapper();
    }



}
