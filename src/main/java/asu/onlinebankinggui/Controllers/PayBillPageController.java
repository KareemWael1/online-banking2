package asu.onlinebankinggui.Controllers;

import asu.onlinebankinggui.DataClasses.BillsData;
import asu.onlinebankinggui.DataClasses.ItemsData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.*;
import static asu.onlinebankinggui.DataClasses.DataClassStub.BillsStub;
import static asu.onlinebankinggui.DataClasses.DataClassStub.getAvailableItems;
import static java.lang.Float.parseFloat;

public class PayBillPageController implements Initializable {
    private ArrayList<BillsData> billsData;
    private BillsData selectedBill;

    @FXML
    private ComboBox<String> bills;
    @FXML
    private TextField price;
    @FXML
    private Label error;
    @FXML
    private Label currency;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currency.setText(account.getCurrency());
        billsData = BillsStub();
        for (BillsData billData : billsData) {
            bills.getItems().add(billData.bill());
        }
    }

    @FXML
    protected void onItemSelection(){
        selectedBill = billsData.get(bills.getSelectionModel().getSelectedIndex());
        price.setText(String.valueOf(selectedBill.price()));
    }

    @FXML
    protected void onPayBillButtonClicked() throws IOException {
        if(bills.getSelectionModel().getSelectedItem() == null){
            error.setText("Please select a bill to buy");
            error.setVisible(true);
            return;
        }

        error.setVisible(false);

        if (confirmation("Confirm Payment ? ") == ButtonType.YES) {
            // TODO call PayBill() from Backend
            changeScene("MyBillsPage.fxml");
        }

    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("AccountMenuPage.fxml");
    }

}
