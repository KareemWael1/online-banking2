package asu.onlinebankinggui.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.*;
import static java.lang.Float.parseFloat;

public class WithdrawPageController implements Initializable {

    @FXML
    private TextField amount;
    @FXML
    private Label error;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        error.setVisible(false);
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
            if (user.withdraw(withdrawAmount)) {
                changeScene("TransactionsPage.fxml");
            } else {
                error.setText("Insufficient funds");
                error.setVisible(true);
            }
        }

    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("AccountMenuPage.fxml");
    }

}
