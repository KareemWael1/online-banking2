package asu.onlinebankinggui.Controllers;

import asu.onlinebankinggui.DataClasses.ItemData;
import asu.onlinebankinggui.source.src.Shop;
import asu.onlinebankinggui.source.src.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.*;

public class BuyItemPageController implements Initializable {
    private List<ItemData> itemsData;
    private ItemData selectedItem;

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
        currency.setText(user.getCurrency());
        // TODO: Items here should be all items from shop not user's items
        itemsData = Shop.getAllItemsData();
        for (ItemData itemsDatum : itemsData) {
            items.getItems().add(itemsDatum.itemName());
        }
        error.setVisible(false);
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
            if (user.buy(selectedItem.getItemName())) {
                changeScene("MyInventoryPage.fxml");
            } else {
                // ToDo: Buy Unsuccessful

            }
        }

    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("AccountMenuPage.fxml");
    }

}
