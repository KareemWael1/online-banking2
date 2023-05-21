package asu.onlinebankinggui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.ControllerUtility.changeScene;

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
    protected void onCreateAccountButtonClick() {
        // TODO: Call Account() from backend
    }

    @FXML
    protected void onCancelButtonClick() throws IOException {
        changeScene("MyAccountsPage.fxml");
    }
}
