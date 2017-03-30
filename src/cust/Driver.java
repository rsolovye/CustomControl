package cust;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by bobsol on 16.03.17.
 */
public class Driver extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        CustomController customController = new CustomController();
        ProtocolHeader protocolHeader = new ProtocolHeader();

        customController.setProtocolHeaderBoxFemaleName("АВДОТЬЯ");
        customController.setText("Hello!");

        stage.setScene(new Scene(customController));
        stage.setTitle("Custom Control");
        stage.setWidth(1000);
        stage.setHeight(800);
        stage.show();
    }
}
