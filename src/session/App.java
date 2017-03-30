package session;

import cust.CustomController;
import cust.ProtocolHeader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.scenicview.ScenicView;
import protocol.header.ProtocolHeaderController;

/**
 * Created by micro on 17.03.2017.
 */
public class App extends Application

    {

        @Override
        public void start(Stage stage) throws Exception {


        SessionController sessionController  = new SessionController();
        //    ScenicView.show(new Scene(sessionController));

        stage.setScene(new Scene(sessionController));
        stage.setTitle("Session Controller");
        stage.setWidth(1000);
        stage.setHeight(950);
        stage.show();
          //  ScenicView.show(new ProtocolHeaderController());
    }
    }
