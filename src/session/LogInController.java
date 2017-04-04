package session;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by micro on 18.03.2017.
 */
public class LogInController extends ControlledScreen {
@FXML
    TextField userNameTextField;
    @FXML
    TextField passwordTextField;
    @FXML
    Label UserNameMsgLable;
    private SessionController sessionController;

    public LogInController(){
        loadFXML("login_view.fxml", this);

    }

    @FXML protected void submitLogIn(){

        System.out.print("LogIn attempted! ");
        System.out.print("UserName: " + userNameTextField.getText());
        System.out.println(" Password: " + passwordTextField.getText());
        authenticateUser( userNameTextField.getText(),  passwordTextField.getText());
    }

    public void setSessionController(SessionController sessionController){
        this.sessionController = sessionController;
    }
    private void authenticateUser(String name, String password){
        if (password.compareTo(getUserPassword(name)) == 0)  {
            sessionController.goToProtocol();
        }
        else {
            UserNameMsgLable.setText("FAIL");
        }
    }

    private String getUserPassword(String name){
        return (name.compareTo("") == 0) ? "123" : "";
    }
}
