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

public class SignupPageController implements Initializable {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label signupError;
    @FXML
    private Hyperlink login;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        signupError.setVisible(false);
        login.setVisible(false);
    }

    @FXML
    protected void onSignupButtonClick() throws IOException {
        String first = firstName.getText();
        String last = lastName.getText();
        String userName = username.getText();
        String pswd = password.getText();
        signupError.setVisible(false);
        login.setVisible(false);

        if(first.isEmpty()){
            signupError.setVisible(true);
            signupError.setText("Please fill all the required data");
            return;
        }
        else if(!first.matches("[a-zA-Z]+")){
            signupError.setVisible(true);
            signupError.setText("First and Last Name must contain only letters");
            return;
        }

        if(last.isEmpty()){
            signupError.setVisible(true);
            signupError.setText("Please fill all the required data");
            return;
        }
        else if(!last.matches("[a-zA-Z]+")){
            signupError.setVisible(true);
            signupError.setText("First and Last Name must contain only letters");
            return;
        }

        if(userName.isEmpty()){
            signupError.setVisible(true);
            signupError.setText("Please fill all the required data");
            return;
        }

        if(pswd.isEmpty()){
            signupError.setVisible(true);
            signupError.setText("Please fill all the required data");
            return;
        }
        else if(pswd.length() < 8){
            signupError.setVisible(true);
            signupError.setText("Password must contain at least 8 characters");
            return;
        }

        if (User.signUp(first, last, userName, pswd)){
            changeScene("LoginPage.fxml");
        } else {
            signupError.setVisible(true);
            signupError.setText("Username already exist :");
            login.setVisible(true);
        }
    }

    @FXML
    protected void onCancelButtonClick() throws IOException {
        changeScene("WelcomePage.fxml");
    }

    @FXML
    protected void onLoginHyperLinkClicked() throws IOException{
        changeScene("LoginPage.fxml");
    }
}
