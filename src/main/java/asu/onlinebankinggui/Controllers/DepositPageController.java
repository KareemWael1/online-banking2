package asu.onlinebankinggui.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.*;
import static java.lang.Float.parseFloat;

public class DepositPageController implements Initializable{

    @FXML
    private TextField amount;
    @FXML
    private Label error;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        error.setVisible(false);
        floatOnly(amount);
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
            user.deposit(depositAmount);
            changeScene("TransactionsPage.fxml");
        }

    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("AccountMenuPage.fxml");
    }

}
