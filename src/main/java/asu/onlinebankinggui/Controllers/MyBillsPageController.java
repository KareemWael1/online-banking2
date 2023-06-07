package asu.onlinebankinggui.Controllers;

import asu.onlinebankinggui.DataClasses.BillsData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.changeScene;
import static asu.onlinebankinggui.DataClasses.DataClassStub.BillsStub;

public class MyBillsPageController implements Initializable {
    @FXML
    private TableView<BillsData> bills;

    @FXML
    private TableColumn<BillsData, String> bill;
    @FXML
    private TableColumn<BillsData, String> price;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO select default price for bills
        price.setText("Price (in " + "EGP" + ")");
        ObservableList<BillsData> billsData = FXCollections.observableList(BillsStub());
        bill.setCellValueFactory(new PropertyValueFactory<BillsData, String>("bill"));
        price.setCellValueFactory(new PropertyValueFactory<BillsData, String>("price"));

        bills.setItems(billsData);
    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("MainMenuPage.fxml");
    }
}
