package protocol.gamete;

import impl.org.controlsfx.skin.BreadCrumbBarSkin;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.StringConverter;
import jfxtras.scene.control.ListSpinner;
import org.controlsfx.control.CheckComboBox;
import org.tbee.javafx.scene.layout.MigPane;

import java.time.LocalDate;
import java.util.Locale;

public class Gametes extends MigPane {

    public Gametes(){
        super("insets 5 32 0 0");

        Locale.setDefault(new Locale("RU"));

 //FIRST ROW
        ListSpinner<String> femaleSourceSpinner = new ListSpinner<>(FXCollections.observableArrayList("Пациентка", "ДК-", "ДА-"));
        ListSpinner<String> femaleGameteTypeSpinner = new ListSpinner<>(FXCollections.observableArrayList("Нативные", "Крио"));
        ListSpinner<String> femaleGameteThawWitnessSpinner = new ListSpinner<>(FXCollections.observableArrayList("Лямина И.В.", "Мурза Г.В.", "Хандога А.О.", "Соловьев Р.С.", "Черноштан К.В."));
//        femaleSourceSpinner.setEditable(true);
//        femaleSourceSpinner.setStringConverter(new StringConverter<String>() {
//            @Override
//            public String toString(String object) {
//                return object;
//            }
//
//            @Override
//            public String fromString(String string) {
//                return string;
//            }
//        });

        add(new Label("Источник \nженских гамет"), "split 2, flowy, align 50% 0%");
        MigPane hbox = new MigPane("insets 0");
        hbox.add(new Label("+"), "h 20!");
        hbox.add(femaleSourceSpinner, "w 120!, align 50% 0%");
        add(hbox, "align 0% 0%, gapafter 15");

        add(new Label("\nТип"), "split 2, flowy, align 50% 0%");
        add(femaleGameteTypeSpinner, "w 120!, gapafter 15");

        //DATE PICKER
        add(new Label("\nДата Крио"), "split 2, flowy, align 50% 0%");
        DatePicker punctureDatePicker = new DatePicker();
        punctureDatePicker.setPrefWidth(120);
        add(punctureDatePicker, "gapafter 15");

        add(new Label("\nСвидетель"), "split 2, flowy, align 50% 0%");
        add(femaleGameteThawWitnessSpinner, "w 150!, gapafter 15");

        addToMig(this, "Кол-во \nфолликулов", 55);

        add(new MaleGametes(), "newline, span");
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
