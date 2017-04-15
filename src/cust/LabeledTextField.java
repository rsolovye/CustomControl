package cust;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import net.miginfocom.layout.LC;
import org.tbee.javafx.scene.layout.MigPane;


/**
 * Created by bob on 4/2/17.
 */
public class LabeledTextField extends MigPane {
    TextField textField = new TextField();
    Label label = new Label();
        public LabeledTextField(String labelText,  int width){
           MigPane lRoot = new MigPane("insets 0", "", "");

            Label label = new Label(labelText);
            label.setStyle("-fx-font-size: 11;\n" +
                    "-fx-font-family: \"Century Gothic\";\n" +
                    "-fx-font-weight: Bold;\n" +
                    "-fx-text-fill: rgb(0, 0, 5);" +
                    "");

            label.setPrefHeight(14);
            label.setMaxHeight(label.getPrefHeight());

            textField.setAlignment(Pos.TOP_CENTER);

            lRoot.add(label, "align 50% 100%, wrap");
            lRoot.add(textField, "w " + width + "!, h 20!, align 50% 0%");
            getChildren().addAll(lRoot);
            setPadding(new Insets(0));
            LC lc = new LC();
            lc.pack();

            setLayoutConstraints(lc);
        }


    public LabeledTextField(String labelText,  String flow){
        MigPane lRoot = new MigPane("insets 0, " + flow, "", "");

        Label label = new Label(labelText);
        //   label.setAlignment(Pos.CENTER);
        label.setStyle("-fx-font-size: 11;\n" +
                "-fx-font-family: \"Century Gothic\";\n" +
                "-fx-font-weight: Bold;\n" +
                "-fx-text-fill: rgb(0, 0, 5);" +
                "");

        //   label.setAlignment(Pos.BASELINE_CENTER);

        //StackPane labeledPane = new StackPane();

        //labeledPane.getChildren().add(label);
        label.setPrefHeight(14);
        label.setMaxHeight(label.getPrefHeight());

        textField.setAlignment(Pos.TOP_CENTER);

        lRoot.add(label, "align 50% 100%");
        lRoot.add(textField, "h 24!, align 50% 0%");

///            setPrefWidth((label.getWidth() > width)? label.getWidth() : width);
        //          setMaxWidth((label.getWidth() > width)? label.getWidth() : width);

        getChildren().addAll(lRoot);
        LC lc = new LC();
        lc.pack();

        setLayoutConstraints(lc);
    }
        public String getText(){
            return textField.getText();
        }

}
