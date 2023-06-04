package asu.onlinebankinggui.Controllers;
import asu.onlinebankinggui.source.src.*;

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

        if (valid) {
            User user = User.getUser(username.getText());
            if (user == null) {
                // TODO: User doesn't exist
            } else {
                if (user.login(username.getText(), password.getText())) {
                    // TODO: Login successful

                } else {
                    // ToDo: Incorrect password

                }
            }
        }

    }

    @FXML
    protected void onCancelButtonClick() throws IOException {
        changeScene("WelcomePage.fxml");
    }
}
