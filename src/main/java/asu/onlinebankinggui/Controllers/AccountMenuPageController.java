package asu.onlinebankinggui.Controllers;

import asu.onlinebankinggui.DataClasses.AccountData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.changeScene;

public class AccountMenuPageController implements Initializable {
    private AccountData account;
    @FXML
    private Label number;
    @FXML
    private Label balance;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        account = ControllerUtility.account;
        number.setText("Number : " + account.getNumber());
        balance.setText("Balance : " + account.getBalance() + " " + account.getCurrency());
    }

    @FXML
    protected void onDepositButtonClick() throws IOException {
        changeScene("DepositPage.fxml");
    }

    @FXML
    protected void onWithdrawButtonClick() throws IOException {
        changeScene("WithdrawPage.fxml");
    }

    @FXML
    protected void onTransferButtonClick() throws IOException {
        // TODO add Transfer fxml
    }

    @FXML
    protected void onBuyItemButtonClick() throws IOException {
        // TODO add BuyItem fxml
    }

    @FXML
    protected void onPayBillButtonClick() throws IOException {
        // TODO add PayBill fxml
    }

    @FXML
    protected void onTransactionsButtonClick() throws IOException {
        changeScene("TransactionsPage.fxml");
    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("MyAccountsPage.fxml");
    }
}