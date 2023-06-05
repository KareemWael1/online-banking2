package asu.onlinebankinggui.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.*;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class TransferPageController implements Initializable{

    @FXML
    private TextField amount;
    @FXML
    private TextField destinationAccountNumber;
    @FXML
    private Label error;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        error.setVisible(false);
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
            if (user.transfer(transferAmount, parseInt(destinationAccountNumber.getText()))) {
                changeScene("TransactionsPage.fxml");
            } else {
                // TODO distinguish between invalid account number and insufficient amount
                error.setText("Error: check that you entered destination account number correctly\n" +
                        "and your balance can cover the transfer amount");
                error.setVisible(true);
            }

        }

    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("AccountMenuPage.fxml");
    }
}
