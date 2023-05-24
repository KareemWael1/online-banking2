package asu.onlinebankinggui.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.*;

public class MainMenuPageController implements Initializable {
    String userName = "user";
    @FXML
    private Label welcomeText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO fetch user name from backend
        welcomeText.setText("Welcome, " + userName + "!");
    }

    @FXML
    protected void onMyAccountsButtonClick() throws IOException {
        changeScene("MyAccountsPage.fxml");
    }

    @FXML
    protected void onInventoryButtonClick() throws IOException {
        // TODO Add inventory fxml
    }

    @FXML
    protected void onBillsButtonClick() throws IOException {
        // TODO Add bills fxml
    }

    @FXML
    protected void onNotificationsButtonClick() throws IOException {
        // TODO Add notification fxml
    }

    @FXML
    protected void onLogoutButtonClick() throws IOException {
        // TODO Add logout()
    }
}
