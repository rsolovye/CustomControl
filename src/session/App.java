package session;

import cust.CustomController;
import cust.ProtocolHeader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by micro on 17.03.2017.
 */
public class App extends Application

    {

        @Override
        public void start(Stage stage) throws Exception {


        SessionController sessionController  = new SessionController();

      //  sessionController.getChildren().
        stage.setScene(new Scene(sessionController));
        stage.setTitle("Session Controller");
        stage.setWidth(1000);
        stage.setHeight(1000);
        stage.show();
    }
    }
