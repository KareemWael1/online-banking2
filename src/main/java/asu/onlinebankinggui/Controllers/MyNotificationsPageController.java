package asu.onlinebankinggui.Controllers;

import asu.onlinebankinggui.DataClasses.NotificationData;
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
import static asu.onlinebankinggui.DataClasses.DataClassStub.NotificationStub;

public class MyNotificationsPageController implements Initializable {
    @FXML
    private TableView<NotificationData> notifications;

    @FXML
    private TableColumn<NotificationData, String> message;
    @FXML
    private TableColumn<NotificationData, LocalDateTime> dateReceived;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<NotificationData> notificationData = FXCollections.observableList(NotificationStub());
        message.setCellValueFactory(new PropertyValueFactory<>("message"));
        dateReceived.setCellValueFactory(new PropertyValueFactory<>("dateSent"));

        notifications.setItems(notificationData);
    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        changeScene("MainMenuPage.fxml");
    }
}
