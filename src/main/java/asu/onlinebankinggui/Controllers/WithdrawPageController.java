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

public class WithdrawPageController implements Initializable {
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
            error.setText("Please enter a valid withdraw amount");
            error.setVisible(true);
            return;
        }
        float withdrawAmount = parseFloat(amount.getText());
        if(withdrawAmount <= 0){
            error.setText("Please enter a valid withdraw amount");
            error.setVisible(true);
            return;
        }

        error.setVisible(false);

        if (confirmation("Confirm Withdraw ? ") == ButtonType.YES) {
            // TODO call Withdraw() from Backend
            changeScene("TransactionsPage.fxml");
        }

    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("AccountMenuPage.fxml");
    }

}
