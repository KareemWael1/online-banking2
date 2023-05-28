package asu.onlinebankinggui.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import static asu.onlinebankinggui.Controllers.ControllerUtility.changeScene;

public class LoginPageController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label incorrect;
    @FXML
    private Label emptyUsername;
    @FXML
    private Label emptyPassword;

    @FXML
    protected void onLoginButtonClick() throws IOException{
        boolean valid = true;
        incorrect.setVisible(false);

        if(username.getText().isEmpty()){
            emptyUsername.setVisible(true);
            valid = false;
        }
        else{
            emptyUsername.setVisible(false);
        }
        if(password.getText().isEmpty()){
            emptyPassword.setVisible(true);
            valid = false;
        }
        else{
            emptyPassword.setVisible(false);
        }

        if(valid){
            // TODO: Call login() from backend
        }

    }

    @FXML
    protected void onCancelButtonClick() throws IOException {
        changeScene("WelcomePage.fxml");
    }
}
