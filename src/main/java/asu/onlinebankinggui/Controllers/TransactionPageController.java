package asu.onlinebankinggui.Controllers;

import asu.onlinebankinggui.DataClasses.AccountData;
import asu.onlinebankinggui.DataClasses.NotificationData;
import asu.onlinebankinggui.DataClasses.TransactionData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.changeScene;
import static asu.onlinebankinggui.DataClasses.DataClassStub.TransactionsStub;

public class TransactionPageController implements Initializable {

    @FXML
    private TableView<TransactionData> transactions;

    @FXML
    private TableColumn<TransactionData,Integer> id;
    @FXML
    private TableColumn<TransactionData, Double> amount;
    @FXML
    private TableColumn<TransactionData, String> currency;
    @FXML
    private TableColumn<TransactionData, String> type;
    @FXML
    private TableColumn<NotificationData, LocalDateTime> date;

    ObservableList<TransactionData> transactionData;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transactionData = FXCollections.observableList(TransactionsStub());
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        currency.setCellValueFactory(new PropertyValueFactory<>("currency"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        transactions.setItems(transactionData);
    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("AccountMenuPage.fxml");
    }

}
