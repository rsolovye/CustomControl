package protocol;

import cust.LabeledTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import org.tbee.javafx.scene.layout.fxml.MigPane;
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

import static javafx.geometry.HPos.CENTER;

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
   // labProtocolMainBox.getChildren().add(new LabeledTextField("test-label", 140));

    GridPane headerGrid = new GridPane();
   // headerGrid.setPadding(new Insets(1));
    headerGrid.setHgap(5); headerGrid.setVgap(5);
    headerGrid.setAlignment(Pos.CENTER);

    headerGrid.add(new LabeledTextField("Дата пункции", 100), 0, 0, 1, 1) ;
    headerGrid.add(new LabeledTextField("Время", 60), 1, 0, 1, 1);
        headerGrid.add(new LabeledTextField("Номер карты", 150), 2, 0, 1, 1);

        headerGrid.add(new LabeledTextField("Попытка", 50), 3, 0, 1, 1);

        headerGrid.add(new LabeledTextField("Примечания", 400), 0, 1, 4, 1);

        labProtocolMainBox.getChildren().add(headerGrid);
        MigPane mig = new MigPane();

        mig.add(new LabeledTextField("Дата пункции", 100));
        mig.add(new LabeledTextField("Время", 45));
        mig.add(new LabeledTextField("Номер карты", 133));
        mig.add(new LabeledTextField("№ Протокола", 45), "wrap");
        mig.add(new LabeledTextField("Дата пункции", 323), "span 4");


labProtocolMainBox.getChildren().add(mig);

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

    }

    public void saveData(){
       PROTOCOL_HEADER.passDataToMapper();
    }



}
