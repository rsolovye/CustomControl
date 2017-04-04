package cust;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Created by bob on 4/2/17.
 */
public class LabeledTextField extends VBox {
    TextField textField = new TextField();

        public LabeledTextField(String labelText,  int width){
            Label label = new Label(labelText);

            label.setPrefSize(width, 18)    ;
            label.setStyle("-fx-font-size: 13;\n" +
                    "-fx-font-family: \"CTC Splash Rounded\";\n" +
                    "-fx-font-weight: 200;\n" +
                    "-fx-text-fill: rgb(0, 0, 5);" +
                    "");

            label.setAlignment(Pos.BASELINE_CENTER);

            StackPane labeledPane = new StackPane();

            labeledPane.getChildren().add(label);


            textField.setPrefSize(width, 24);
            textField.setAlignment(Pos.CENTER);
            /*textField.setStyle("    -fx-background-color: rgb(0, 0, 55), -fx-text-box-border, -fx-control-inner-background;\n" +
                    "    -fx-background-insets: -0.4, 1, 2;\n" +
                    "    -fx-background-radius: 3.4, 2, 2;\n");*/

            StackPane textPane = new StackPane();
            textPane.getChildren().add(textField);
            setPrefWidth(width);
            setMaxWidth(getPrefWidth());

            getChildren().addAll(labeledPane, textPane);

        }

        public String getText(){
            return textField.getText();
        }

}
