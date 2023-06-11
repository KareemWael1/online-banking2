package asu.onlinebankinggui.Controllers;

import asu.onlinebankinggui.DataClasses.BillData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.*;
import static asu.onlinebankinggui.source.src.Helpers.convert;

public class PayBillPageController implements Initializable {
    private List<BillData> billsData;
    private BillData selectedBill;

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
        currency.setText(user.getCurrency());
        List<BillData> allBills = user.getUnpaidBills();
        billsData = new ArrayList<>();
        for (BillData bill : allBills){
            if(!bill.isPaid()){
                billsData.add(bill);
            }
        }
        for (BillData billData : billsData) {
            bills.getItems().add(billData.name());
        }
        error.setVisible(false);
    }

    @FXML
    protected void onItemSelection(){
        selectedBill = billsData.get(bills.getSelectionModel().getSelectedIndex());
        price.setText(String.valueOf(selectedBill.price()));
        if(!currency.getText().equals("EGP")){
            price.setText(Float.toString(convert("EGP", currency.getText(), Float.parseFloat(price.getText()))));
        }
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
            if (user.buy(selectedBill.name())) {
                changeScene("MyBillsPage.fxml");
            } else {
                error.setText("Not enough funds");
                error.setVisible(true);
            }
        }
    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("AccountMenuPage.fxml");
    }

}
