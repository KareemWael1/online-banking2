package asu.onlinebankinggui.Controllers;
import asu.onlinebankinggui.source.src.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.changeScene;
import static asu.onlinebankinggui.Controllers.ControllerUtility.user;

public class LoginPageController implements Initializable {
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
    private Hyperlink signupInstead;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        incorrect.setVisible(false);
        emptyPassword.setVisible(false);
        emptyUsername.setVisible(false);
        signupInstead.setVisible(false);
    }

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
            user = User.getUser(username.getText());
            if (user == null || !user.login(username.getText(), password.getText())) {
                incorrect.setVisible(true);
                signupInstead.setVisible(true);
            } else {
                changeScene("MainMenuPage.fxml");
            }
        }

    }

    @FXML
    protected void onSignupInsteadClicked() throws IOException{
        changeScene("SignupPage.fxml");
    }

    @FXML
    protected void onCancelButtonClick() throws IOException {
        changeScene("WelcomePage.fxml");
    }
}
