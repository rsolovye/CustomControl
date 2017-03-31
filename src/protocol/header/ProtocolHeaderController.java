package protocol.header;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.controlsfx.control.CheckComboBox;
import services.DataMapper;
import services.Mappable;
import session.ControlledScreen;

import java.util.ArrayList;
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

    private ArrayList<String> mappableControlIds = new ArrayList<>();

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

public ObservableList<TextField> getObservableTextFields(){
        ObservableList<TextField> list = FXCollections.observableArrayList(punctureDate, punctureTime, vrt_number, ivf_attempt, header_notes, femaleName, maleName, femaleDOB, maleDOB, femaleCode, maleCode);
        //, isOMS, diagnosisCheckedBox, punctureDoctorCheckComboBox);
        return list;
}
    public void passDataToMapper(){

    DataMapper.saveToDB(saveData(), getClass().getSimpleName());
    }

     private HashMap<String, String> saveData(){


         HashMap<String, String> dataMap = new HashMap<>();
         for (TextField tf : getObservableTextFields())
         {
             dataMap.put(tf.getId(), tf.getText());
         }
            // mapInput(this, dataMap);
        dataMap.put(isOMS.getId(), (isOMS.isSelected()) ? "1" : "0");


        return dataMap;
    }

    public  void  mapInput(Pane pane, HashMap<String, String> inputMap) {

        for (javafx.scene.Node n : pane.getChildren()) {
            String className = n.getClass().getSimpleName();

            if (n instanceof Pane)
                mapInput((Pane) n, inputMap);

            if (className.compareTo("TextField") == 0)
                inputMap.put(n.getId(), ((TextField) n).getText());

            if (className.compareTo("CheckBox") == 0)
                inputMap.put(n.getId(), ((CheckBox) n).isSelected() ? "1" : "0");


            if (className.compareTo("ComboBox") == 0){
                String selection = ((ComboBox<String>) n)
                        .getSelectionModel().getSelectedItem();
                inputMap.put(n.getId(), (selection == null) ? "" : selection);
            }
            if (className.compareTo("ListView") == 0) {
                String selection = ((ListView<String>) n)
                        .getSelectionModel()
                        .getSelectedItem();
                inputMap.put(n.getId(), (selection == null) ? "" : selection);
            }

            if (n.getClass().getTypeName().compareToIgnoreCase("CheckComboBox") == 0){

                for( String f : ((CheckComboBox<String>) n).getCheckModel().getCheckedItems()){
                    dataMap.put(f, "1");
                }
            }
        }
    }
@FXML private void reportInput(){

}

    public void setFemaleName(String femaleName){
        femaleNameTextField.setText(femaleName);
    }
}
