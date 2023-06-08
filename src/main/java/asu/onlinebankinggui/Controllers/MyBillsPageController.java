package asu.onlinebankinggui.Controllers;

import asu.onlinebankinggui.DataClasses.BillData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.changeScene;
import static asu.onlinebankinggui.Controllers.ControllerUtility.user;

public class MyBillsPageController implements Initializable {
    @FXML
    private TableView<BillData> bills;

    @FXML
    private TableColumn<BillData, String> bill;
    @FXML
    private TableColumn<BillData, String> price;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        price.setText("Price (in " + "EGP" + ")");
        List<BillData> allBills = user.getUnpaidBills();
        List<BillData> unpaidBills = new ArrayList<>();
        for(BillData bill : allBills){
            if(!bill.getIsPaid()){
                unpaidBills.add(bill);
            }
        }
        ObservableList<BillData> billsData = FXCollections.observableList(unpaidBills);
        bill.setCellValueFactory(new PropertyValueFactory<>("name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        bills.setItems(billsData);
    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("MainMenuPage.fxml");
    }
}
