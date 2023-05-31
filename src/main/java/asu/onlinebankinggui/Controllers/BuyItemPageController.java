package asu.onlinebankinggui.Controllers;

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
import static asu.onlinebankinggui.DataClasses.DataClassStub.getAvailableItems;
import static java.lang.Float.parseFloat;

public class BuyItemPageController implements Initializable {
    private ArrayList<ItemsData> itemsData;
    private ItemsData selectedItem;

    @FXML
    private ComboBox<String> items;
    @FXML
    private TextField price;
    @FXML
    private Label error;
    @FXML
    private Label currency;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currency.setText(account.getCurrency());
        itemsData = getAvailableItems();
        for (ItemsData itemsDatum : itemsData) {
            items.getItems().add(itemsDatum.itemName());
        }
    }

    @FXML
    protected void onItemSelection(){
        selectedItem = itemsData.get(items.getSelectionModel().getSelectedIndex());
        price.setText(String.valueOf(selectedItem.price()));
    }

    @FXML
    protected void onBuyItemButtonClicked() throws IOException {
        if(items.getSelectionModel().getSelectedItem() == null){
            error.setText("Please select an item to buy");
            error.setVisible(true);
            return;
        }

        error.setVisible(false);

        if (confirmation("Confirm Buy ? ") == ButtonType.YES) {
            // TODO call BuyItem() from Backend
            changeScene("MyInventoryPage.fxml");
        }

    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("AccountMenuPage.fxml");
    }

}
