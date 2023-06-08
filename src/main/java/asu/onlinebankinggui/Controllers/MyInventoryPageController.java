package asu.onlinebankinggui.Controllers;

import asu.onlinebankinggui.DataClasses.InventoryData;
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
import static asu.onlinebankinggui.Controllers.ControllerUtility.user;

public class MyInventoryPageController implements Initializable {
    @FXML
    private TableView<InventoryData> items;

    @FXML
    private TableColumn<InventoryData, String> itemName;
    @FXML
    private TableColumn<InventoryData, Integer> count;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<InventoryData> inventoryData = FXCollections.observableList(user.getInventoryData());
        itemName.setCellValueFactory(new PropertyValueFactory<>("item"));
        count.setCellValueFactory(new PropertyValueFactory<>("count"));

        items.setItems(inventoryData);
    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("MainMenuPage.fxml");
    }
}
