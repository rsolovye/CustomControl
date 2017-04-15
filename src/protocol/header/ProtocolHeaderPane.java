package protocol.header;

import javafx.collections.ListChangeListener;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import org.controlsfx.control.CheckComboBox;
import org.tbee.javafx.scene.layout.MigPane;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Stack;

public class ProtocolHeaderPane extends MigPane {

    public ProtocolHeaderPane(){
        super("insets 5 5 0 0");

        Locale.setDefault(new Locale("RU"));

 //FIRST ROW
        //DATE PICKER
        add(new Label("Дата Пункции"), "split 2, flowy, align 50% 0%");
        DatePicker punctureDatePicker = new DatePicker();
        punctureDatePicker.setPrefWidth(120);
        punctureDatePicker.setValue (LocalDate.now().plusDays(1));
        punctureDatePicker.setPrefHeight(20);
        add(punctureDatePicker, "");

        addToMig(this, "Время", 55);
        addToMig(this, "Номер Карты", 160);
        addToMig(this, "# Протокола", 45);
//DIAGNOSIS
        CheckComboBox<String> diagnosisCheckedBox = new CheckComboBox<>();
        diagnosisCheckedBox.getItems().add("97.0");
        diagnosisCheckedBox.getItems().add("97.1");
        diagnosisCheckedBox.getItems().add("97.2");
        diagnosisCheckedBox.getItems().add("97.4");
        diagnosisCheckedBox.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
            public void onChanged(ListChangeListener.Change<? extends String> c) {
                System.out.println(diagnosisCheckedBox.getCheckModel().getCheckedItems());
            }
        });
//DOCTOR
        ComboBox<String> punctureDoctorComboBox = new ComboBox();
        punctureDoctorComboBox.getItems().add("Геркулов Д.А.");
        punctureDoctorComboBox.getItems().add("Гвасалия Р.Г.");
        punctureDoctorComboBox.getItems().add("Шарфи Ю.Н.");
        punctureDoctorComboBox.getItems().add("Жарова М.В.");


        addToMig(this, "Врач", punctureDoctorComboBox, 150);
        addToMig(this, "Диагноз", diagnosisCheckedBox, 120);

        //  addToMig(mig, "ОМС", new CheckBox(""), 10);
//NOTES
        add(new Label("Примечания"), "newline, align 100% 50%");
        add(new TextField(), "growx, span");
//PATIENTS
        add(new Label("         ФИО\n пациентки"), "newline, align 100% 50%");
        TextField femaleNameTextField = new TextField();
        add(femaleNameTextField, "growx, span 3");
        add(new Label("ДР"), "split 2, align 50% 50%");
        add(new DatePicker(), "w 120!");
        add(new Label("Код"), "split 2, align 50% 50%");
        add(new TextField(), "w 82!, wrap");
        add(new Label("         ФИО\n пациента"), "newline, align 100% 50%");

        TextField maleNameTextField = new TextField();
        add(maleNameTextField, "growx, span 3");
        add(new Label("ДР"), "split 2, align 50% 50%");
        add(new DatePicker(), "w 120!");
        add(new Label("Код"), "split 2, align 50% 50%");
        add(new TextField(), "w 82!, wrap");

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

    public StackPane getStack(){
        StackPane stackPane = new StackPane();

        Rectangle background = new Rectangle(725, 170, Color.rgb(100, 100, 100, 0.6));
        background.setX(0);
        background.setY(0);
        background.setArcHeight(15);
        background.setArcWidth(15);
        //  background.setFill(Color.rgb(0, 0, 0, .55));
        background.setStrokeWidth(1.5);
        background.setStroke(Color.rgb(0, 0, 0, 0.8));
        stackPane.getChildren().add(background);
        stackPane.getChildren().add(this);
        return stackPane;

    }
}
