package asu.onlinebankinggui.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.changeScene;
import static asu.onlinebankinggui.Controllers.ControllerUtility.user;

public class CreateAccountPageController implements Initializable {
    @FXML
    private ComboBox<String> types;
    @FXML
    private ComboBox<String> currencies;
    @FXML
    private Label accountTypeMissing;
    @FXML
    private Label currencyMissing;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        types.setItems(FXCollections.observableArrayList("Saving", "Checking"));
        currencies.setItems(FXCollections.observableArrayList("EGP", "USD"));
        accountTypeMissing.setVisible(false);
        currencyMissing.setVisible(false);
    }

    @FXML
    protected void onCreateAccountButtonClick() throws IOException {
        boolean valid = true;
        accountTypeMissing.setVisible(false);
        currencyMissing.setVisible(false);

        if(types.getValue() == null){
            accountTypeMissing.setVisible(true);
            valid = false;
        }
        if(currencies.getValue() == null){
            currencyMissing.setVisible(true);
            valid = false;
        }

        if(valid){
            user.createAccount(types.getValue(), currencies.getValue());
            changeScene("MyAccountsPage.fxml");
        }
    }

    @FXML
    protected void onCancelButtonClick() throws IOException {
        changeScene("MyAccountsPage.fxml");
    }
}
