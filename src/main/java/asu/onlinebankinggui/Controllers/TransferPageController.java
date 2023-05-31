package asu.onlinebankinggui.Controllers;

import asu.onlinebankinggui.DataClasses.AccountData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.changeScene;
import static asu.onlinebankinggui.Controllers.ControllerUtility.confirmation;
import static java.lang.Float.parseFloat;

public class TransferPageController implements Initializable {
    private AccountData account;

    @FXML
    private TextField amount;
    @FXML
    private TextField destinationAccountNumber;
    @FXML
    private Label error;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        account = ControllerUtility.account;
    }

    @FXML
    protected void onTransferButtonClick() throws IOException {
        if(destinationAccountNumber.getText().isEmpty()){
            error.setText("Please enter the destination account number");
            error.setVisible(true);
            return;
        }
        if(amount.getText().isEmpty()){
            error.setText("Please enter a valid transfer amount");
            error.setVisible(true);
            return;
        }
        float transferAmount = parseFloat(amount.getText());
        if(transferAmount <= 0){
            error.setText("Please enter a valid transfer amount");
            error.setVisible(true);
            return;
        }

        error.setVisible(false);

        if (confirmation("Confirm Transfer ? ") == ButtonType.YES) {
            // TODO call Transfer() from Backend
            changeScene("TransactionsPage.fxml");
        }

    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("AccountMenuPage.fxml");
    }
}
