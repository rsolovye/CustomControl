package session;

import cust.CustomController;
import cust.ProtocolHeader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.stage.StageStyle;
import protocol.header.ProtocolHeaderController;


public class App extends Application

    {

        @Override
        public void start(Stage stage) throws Exception {


        SessionController sessionController  = new SessionController();
        //    ScenicView.show(new Scene(sessionController));



        stage.setScene(new Scene(sessionController));
            // create a transparent stage
            stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Session Controller");
        stage.setWidth(1000);
        stage.setHeight(950);
        stage.show();
          //  ScenicView.show(new ProtocolHeaderController());
    }
    }
