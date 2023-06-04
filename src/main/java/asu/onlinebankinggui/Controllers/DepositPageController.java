package asu.onlinebankinggui.Controllers;
import asu.onlinebankinggui.source.src.*;

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

        if (confirmation("Confirm Deposit ? ") == ButtonType.YES) {
            User user = new User("ziad", "x", "y");
            assert user.login("x", "y");
            assert user.isLoggedIn();
            assert user.useAccount(user.getAccountNums().get(0));

            if (user.deposit(depositAmount)) {
                changeScene("TransactionsPage.fxml");
            } else {
                // ToDo: Couldn't deposit, show error message
            }
        }

    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("AccountMenuPage.fxml");
    }

}
