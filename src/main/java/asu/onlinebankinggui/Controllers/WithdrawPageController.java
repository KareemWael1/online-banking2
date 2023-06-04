package asu.onlinebankinggui.Controllers;

import asu.onlinebankinggui.DataClasses.AccountData;
import asu.onlinebankinggui.source.src.User;
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

        if (withdrawAmount > account.getBalance()) {
            error.setText("Insufficient funds");
            error.setVisible(true);
            return;
        }

        error.setVisible(false);

        if (confirmation("Confirm Withdraw ? ") == ButtonType.YES) {
            User user = new User("ziad", "x", "y");
            assert user.login("x", "y");
            assert user.isLoggedIn();
            assert user.useAccount(user.getAccountNums().get(0));

            if (user.withdraw(withdrawAmount)) {
                changeScene("TransactionsPage.fxml");
            } else {
                // ToDo: Couldn't withdraw, show error message
            }
        }

    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("AccountMenuPage.fxml");
    }

}
