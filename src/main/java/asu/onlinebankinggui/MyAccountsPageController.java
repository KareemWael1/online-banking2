package asu.onlinebankinggui;


import asu.onlinebankinggui.source.src.Account;
import asu.onlinebankinggui.source.src.User;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.ControllerUtility.changeScene;

public class MyAccountsPageController implements Initializable{
    @FXML
    private TableView<Account> accounts;

    @FXML
    private TableColumn<Account, Integer> accountNumber;
    @FXML
    private TableColumn<Account, Double> Balance;
    @FXML
    private TableColumn<Account, String> type;

    @FXML
    private Label select;

    ObservableList<Account> accountsData;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accountsData = getAccountsStub();
        accountNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        Balance.setCellValueFactory(new PropertyValueFactory<>("balance"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));

        accounts.setItems(getAccountsStub());
    }

    public ObservableList<Account> getAccountsStub(){
        ArrayList<Account> accountsArray = new ArrayList<>();
        accountsArray.add(new Account(new User("Kareem", "Kimo", "123"), "Saving"));
        accountsArray.add(new Account(new User("Kareem", "Kimo", "123"), "Checking"));
        return FXCollections.observableList(accountsArray);
    }

    @FXML
    protected void onCreateAccountButtonClick() throws IOException {
        changeScene("CreateAccountPage.fxml");
    }

    @FXML
    protected void onDeleteAccountButtonClick() throws IOException {
        Account deletedAccount = accounts.getSelectionModel().getSelectedItem();
        if(deletedAccount == null){
            select.setVisible(true);
            select.setText("Please select an account to delete");
            return;
        }
        // TODO call destructor of Account to delete deletedAccount
        changeScene("MyAccountsPage.fxml");
    }

    @FXML
    protected void onOpenAccountButtonClick() throws IOException {
        Account openedAccount = accounts.getSelectionModel().getSelectedItem();
        if(openedAccount == null){
            select.setVisible(true);
            select.setText("Please select an account to open");
            return;
        }
        // TODO add fxml for AccountMenuPage
    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("MainMenuPage.fxml");
    }
}
