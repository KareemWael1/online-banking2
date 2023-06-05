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
    private Label firstNameError;
    @FXML
    private Label lastNameError;
    @FXML
    private Label UsernameError;
    @FXML
    private Label passwordError;
    @FXML
    private Label signupError;
    @FXML
    private Hyperlink login;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameError.setVisible(false);
        lastNameError.setVisible(false);
        UsernameError.setVisible(false);
        passwordError.setVisible(false);
        signupError.setVisible(false);
        login.setVisited(false);
    }

    @FXML
    protected void onSignupButtonClick() throws IOException {
        boolean valid = true;
        String first = firstName.getText();
        String last = lastName.getText();
        String userName = username.getText();
        String pswd = password.getText();
        signupError.setVisible(false);
        login.setVisible(false);

        if(first.isEmpty()){
            firstNameError.setVisible(true);
            firstNameError.setText("First Name is empty");
            valid = false;
        }
        else if(!first.matches("[a-zA-Z]+")){
            firstNameError.setVisible(true);
            firstNameError.setText("First Name must contain only letters");
            valid = false;
        }
        else {
            firstNameError.setVisible(false);
        }

        if(last.isEmpty()){
            lastNameError.setVisible(true);
            lastNameError.setText("last Name is empty");
            valid = false;
        }
        else if(!last.matches("[a-zA-Z]+")){
            lastNameError.setVisible(true);
            lastNameError.setText("last Name must contain only letters");
            valid = false;
        }
        else {
            lastNameError.setVisible(false);
        }

        if(userName.isEmpty()){
            UsernameError.setVisible(true);
            UsernameError.setText("Username is empty");
            valid = false;
        }
        else {
            UsernameError.setVisible(false);
        }

        if(pswd.isEmpty()){
            passwordError.setVisible(true);
            passwordError.setText("Password is empty");
            valid = false;
        }
        else if(pswd.length() < 8){
            passwordError.setVisible(true);
            passwordError.setText("Password must contain at least 8 characters");
            valid = false;
        }
        else {
            passwordError.setVisible(false);
        }

        if (valid) {
            if (User.signUp(first, last, userName, pswd)){
                changeScene("LoginPage.fxml");
            } else {
                signupError.setVisible(true);
                login.setVisible(true);
            }
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
