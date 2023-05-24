package asu.onlinebankinggui.Controllers;

import asu.onlinebankinggui.StupDataClassses.InventoryData;
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
import java.util.ResourceBundle;

import static asu.onlinebankinggui.Controllers.ControllerUtility.changeScene;

public class MyInventoryPageController implements Initializable {
    @FXML
    private TableView<InventoryData> items;

    @FXML
    private TableColumn<InventoryData, String> itemName;
    @FXML
    private TableColumn<InventoryData, Integer> count;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<InventoryData> inventoryData = FXCollections.observableList(InventoryStub());
        itemName.setCellValueFactory(new PropertyValueFactory<InventoryData, String>("itemName"));
        count.setCellValueFactory(new PropertyValueFactory<InventoryData, Integer>("count"));

        items.setItems(inventoryData);
    }

    private ArrayList<InventoryData> InventoryStub(){
        ArrayList<InventoryData> returnValue = new ArrayList<>();
        returnValue.add(new InventoryData("xxx", 2));
        returnValue.add(new InventoryData("yyy", 1));
        returnValue.add(new InventoryData("zzz", 10));
        return returnValue;
    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("MainMenuPage.fxml");
    }
}
