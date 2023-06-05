package asu.onlinebankinggui.Controllers;

import asu.onlinebankinggui.OnlineBankingSystem;
import asu.onlinebankinggui.source.src.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ControllerUtility {
    public static User user;

    public static void changeScene(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(OnlineBankingSystem.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage stage = OnlineBankingSystem.getStage();
        stage.setScene(scene);
        stage.show();
    }

    public static ButtonType confirmation(String text){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, text, ButtonType.YES, ButtonType.CANCEL);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
                Objects.requireNonNull(ControllerUtility.class.getResource("/asu/onlinebankinggui/css/main.css")).toExternalForm());
        dialogPane.getStyleClass().add("dialog-pane");
        alert.getDialogPane().lookupButton(ButtonType.YES).setId("yes");
        alert.getDialogPane().lookupButton(ButtonType.CANCEL).setId("cancel");
        Stage stage = (Stage) dialogPane.getScene().getWindow();
        stage.getIcons().add(new Image(Objects.requireNonNull(OnlineBankingSystem.class.getResourceAsStream("/asu/onlinebankinggui/images/BankIcon.png"))));
        alert.showAndWait();
        return alert.getResult();
    }
}
