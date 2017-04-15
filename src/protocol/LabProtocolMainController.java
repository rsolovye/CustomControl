package protocol;

import com.sun.javafx.scene.control.skin.LabeledText;
import cust.LabeledTextField;
import cust.ProtocolHeader;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import net.miginfocom.layout.AC;
import net.miginfocom.layout.LC;

import org.controlsfx.control.CheckComboBox;
import org.tbee.javafx.scene.layout.MigPane;
import protocol.fertilization.Fertilization;
import protocol.gamete.AltGametesController;
import protocol.gamete.GameteSourcesController;
import protocol.gamete.Gametes;
import protocol.header.ProtocolHeaderController;
import protocol.header.ProtocolHeaderPane;
import protocol.media.MediaFooter;
import protocol.pgd.PGD;
import protocol.precultivation.Precultivation;
import protocol.puncture.FolliclePunctureController;
import protocol.signatures.CheckPoints;
import protocol.spermiogram.Spermiogram;
import session.ControlledScreen;
import session.SessionController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static javafx.geometry.HPos.CENTER;

/**
 * Created by bobsol on 29.03.17.
 */
public class LabProtocolMainController extends ControlledScreen {
    @FXML
    Pane labProtocolMainBox;
    SessionController sessionController;

    private final ProtocolHeaderController PROTOCOL_HEADER = new ProtocolHeaderController();
    private final ProtocolHeaderPane PROTOCOL_HEADER_PANE = new ProtocolHeaderPane();
    private final Gametes GAMETES = new Gametes();
//    //private final ControlledScreen GAMETE_SOURCES = new GameteSourcesController();
//    private final ControlledScreen ALT_GAMETES = new AltGametesController();
//    private final ControlledScreen  FOLLICLE_PUNCTURE = new FolliclePunctureController();
//    private final ControlledScreen PRECULTIVATION = new Precultivation();
//    private final ControlledScreen FERTILIZATION = new Fertilization();
//    private final ControlledScreen PGD_INFO = new PGD();
//    private final ControlledScreen CHECK_POINTS = new CheckPoints();
//    private final ControlledScreen SPERMIOGRAM = new Spermiogram();
//    private final ControlledScreen MEDIA_FOOTER = new MediaFooter();

   // private ObservableList<TextField> protocol_header_controls = PROTOCOL_HEADER.getObservableTextFields();

    public LabProtocolMainController(SessionController sessionController) {
        loadFXML("lab_protocol_main.fxml", this);
        this.sessionController = sessionController;
        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(PROTOCOL_HEADER_PANE.getStack(), GAMETES.getStack());
labProtocolMainBox.setPadding(new Insets(5));
        labProtocolMainBox.getChildren().add(vbox);




    }

    public void saveData(){
       PROTOCOL_HEADER.passDataToMapper();
    }

    public void addToMig(MigPane migPane, String lable, Control control, int textWidth){
        migPane.add(new Label(lable), "split 2, flowy, align 50% 0%");
        migPane.add(control, "w " + textWidth + "!, align 50% 100%");
    }


    public void addToMig(MigPane migPane, String lable, int textWidth){
        migPane.add(new Label(lable), "split 2, flowy, align 50% 0%");
        TextField textField = new TextField();
        textField.setFont(Font.font("SanSerif", 13));
        migPane.add(textField, "w " + textWidth + "!, align 50% 0%");
    }

    public void addToMig(MigPane migPane, String lable, int textWidth, String extra){
        migPane.add(new Label(lable), "split 2, flowy, align 50% 0%,");
        TextField textField = new TextField();
        textField.setFont(Font.font("SanSerif", 13));
        migPane.add(textField, "w " + textWidth + "!, align 50% 0%," + extra);
    }

}
