package asu.onlinebankinggui;

import asu.onlinebankinggui.source.src.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

import static asu.onlinebankinggui.ControllerUtility.changeScene;

public class TransactionPageController {

    @FXML
    private TableView<Transaction> transactions;

    @FXML
    private TableColumn<Transaction,Integer> id;
    @FXML
    private TableColumn<Transaction, Double> amount;
    @FXML
    private TableColumn<Transaction, String> destination;



    @FXML
    protected void onBackButtonClick() throws IOException {
        // TODO add fxml for AccountMenuPage
    }
}
