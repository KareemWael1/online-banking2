package asu.onlinebankinggui.Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

        destinationAccountNumber.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    destinationAccountNumber.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        floatOnly(amount);
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
                error.setText("Error: check that you entered destination account number correctly " +
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
