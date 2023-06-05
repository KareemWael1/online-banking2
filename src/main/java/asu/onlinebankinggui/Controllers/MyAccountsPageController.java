package asu.onlinebankinggui.Controllers;


import asu.onlinebankinggui.DataClasses.AccountData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.changeScene;
import static asu.onlinebankinggui.Controllers.ControllerUtility.user;

public class MyAccountsPageController implements Initializable{
    @FXML
    private TableView<AccountData> accounts;

    @FXML
    private TableColumn<AccountData, Integer> accountNumber;
    @FXML
    private TableColumn<AccountData, Double> Balance;
    @FXML
    private TableColumn<AccountData, Double> currency;
    @FXML
    private TableColumn<AccountData, String> type;

    @FXML
    private Label select;

    ObservableList<AccountData> accountsData;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accountsData = FXCollections.observableList(user.getAccountsData());
        accountNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        Balance.setCellValueFactory(new PropertyValueFactory<>("balance"));
        currency.setCellValueFactory(new PropertyValueFactory<>("currency"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));

        accounts.setItems(accountsData);
    }

    @FXML
    protected void onCreateAccountButtonClick() throws IOException {
        changeScene("CreateAccountPage.fxml");
    }

    @FXML
    protected void onSelectAccountButtonClick() throws IOException {
        AccountData selectedAccount = accounts.getSelectionModel().getSelectedItem();
        if(selectedAccount == null){
            select.setVisible(true);
            select.setText("Please select an account to open");
            return;
        }

        user.useAccount(selectedAccount.getNumber());
        changeScene("AccountMenuPage.fxml");
    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("MainMenuPage.fxml");
    }
}
