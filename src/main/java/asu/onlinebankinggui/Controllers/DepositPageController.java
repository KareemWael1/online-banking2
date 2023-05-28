package asu.onlinebankinggui.Controllers;

import asu.onlinebankinggui.DataClasses.AccountData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.changeScene;
import static java.lang.Float.parseFloat;

public class DepositPageController implements Initializable {
    private AccountData account;

    @FXML
    private TextField amount;
    @FXML
    private Label error;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        account = ControllerUtility.account;
    }

    @FXML
    protected void onDepositButtonClick() throws IOException {
        if(amount.getText().isEmpty()){
            error.setText("Please enter a valid deposit amount");
            error.setVisible(true);
            return;
        }
        float depositAmount = parseFloat(amount.getText());
        if(depositAmount <= 0){
            error.setText("Please enter a valid deposit amount");
            error.setVisible(true);
            return;
        }

        error.setVisible(false);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm Deposit ? ", ButtonType.YES, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            // TODO call Deposit() from Backend
            changeScene("TransactionsPage.fxml");
        }

    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("AccountMenuPage.fxml");
    }

}
