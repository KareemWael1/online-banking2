package asu.onlinebankinggui.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.changeScene;
import static asu.onlinebankinggui.Controllers.ControllerUtility.user;

public class AccountMenuPageController implements Initializable {

    @FXML
    private Label number;
    @FXML
    private Label balance;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        number.setText("Number : " + user.getAccountNumber());
        balance.setText("Balance : " + user.getBalance() + " " + user.getCurrency());
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
        changeScene("TransferPage.fxml");
    }

    @FXML
    protected void onBuyItemButtonClick() throws IOException {
        changeScene("BuyItemPage.fxml");
    }

    @FXML
    protected void onPayBillButtonClick() throws IOException {
        changeScene("PayBillPage.fxml");    }

    @FXML
    protected void onTransactionsButtonClick() throws IOException {
        changeScene("TransactionsPage.fxml");
    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("MyAccountsPage.fxml");
    }
}
