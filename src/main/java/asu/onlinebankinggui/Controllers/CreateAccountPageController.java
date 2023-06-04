package asu.onlinebankinggui.Controllers;
import asu.onlinebankinggui.source.src.*;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.changeScene;

public class CreateAccountPageController implements Initializable {
    @FXML
    private ComboBox<String> types;
    @FXML
    private ComboBox<String> currencies;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        types.setItems(FXCollections.observableArrayList("Saving", "Checking"));
        currencies.setItems(FXCollections.observableArrayList("EGP", "USD"));
    }

    @FXML
    protected void onCreateAccountButtonClick() throws IOException {
        User user = new User("Ziad", "x", "y");
        assert user.login("x", "y");
        assert user.isLoggedIn();


        if (user.createAccount(types.getValue(), currencies.getValue())) {
            changeScene("MyAccountsPage.fxml");
        } else {
            // TODO: Show error message
        }
    }

    @FXML
    protected void onCancelButtonClick() throws IOException {
        changeScene("MyAccountsPage.fxml");
    }
}
