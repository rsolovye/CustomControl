package protocol.header;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.CheckListView;
import services.DataMapper;
import services.Mappable;
import session.ControlledScreen;

import javax.xml.soap.Text;
import java.awt.*;
import java.util.HashMap;

/**
 * Created by bobsol on 16.03.17.
 */
public class ProtocolHeaderController extends ControlledScreen implements Mappable{

    @FXML TextField femaleNameTextField;
@FXML
    CheckComboBox<String> diagnosisCheckedBox;
@FXML
    CheckComboBox<String> punctureDoctorCheckComboBox;
@FXML
    TextField punctureDate, punctureTime, vrt_number, ivf_attempt, header_notes, femaleName, maleName, femaleDOB, maleDOB, femaleCode, maleCode;
@FXML
    CheckBox isOMS;

    public ProtocolHeaderController() {
        loadFXML("protocol_header.fxml", this);
        diagnosisCheckedBox.getItems().add("97.0");
        diagnosisCheckedBox.getItems().add("97.1");
        diagnosisCheckedBox.getItems().add("97.2");
        diagnosisCheckedBox.getItems().add("97.4");
        diagnosisCheckedBox.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
            public void onChanged(ListChangeListener.Change<? extends String> c) {
                System.out.println(diagnosisCheckedBox.getCheckModel().getCheckedItems());
            }
        });

        punctureDoctorCheckComboBox.getItems().add("Геркулов Д.А.");
        punctureDoctorCheckComboBox.getItems().add("Гвасалия Р.Г.");
        punctureDoctorCheckComboBox.getItems().add("Шарфи Ю.Н.");
        punctureDoctorCheckComboBox.getItems().add("Жарова М.В.");
        punctureDoctorCheckComboBox.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
            public void onChanged(ListChangeListener.Change<? extends String> c) {
                System.out.println(punctureDoctorCheckComboBox.getCheckModel().getCheckedItems());
            }
        });
    }
    public void passDataToMapper(){
        DataMapper.saveToDB(saveData(), getClass().getSimpleName());
    }

     private HashMap<String, String> saveData(){
         HashMap<String, String> dataMap = new HashMap();
         dataMap.put(punctureDate.getId(), punctureDate.getText());
        return dataMap;
    }


    public void setFemaleName(String femaleName){
        femaleNameTextField.setText(femaleName);
    }
}
